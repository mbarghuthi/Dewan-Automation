# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

JBehave BDD automation framework for the **Dewan** document/process management system (Arabic UI). Tests run against three system instances: **UOP**, **JPPMC**, and **JIC**.

## Build & Test Commands

```bash
# Run all tests
mvn clean test

# Run with custom report output directory (used by Jenkins)
mvn test -DreportDirectory="%WORKSPACE%\reports"

# Compile only
mvn compile
```

**Selecting which stories to run** is done by editing `AllStoriesTest.java` — change the pattern string passed to `storyPaths()`:
- `*JPPMC*` — JPPMC stories only (current default)
- `*UOP*` — UOP stories only
- `*JIC*` — JIC stories only
- `*` — all stories
- `TC_003_UOP.story` — single story by exact name

**Java 9+ note**: The `java9plus-opens` Maven profile activates automatically on Java 9+ and passes `--add-opens java.base/java.lang=ALL-UNNAMED` to surefire. Jenkins runs JDK 8 and is unaffected.

## Architecture

### Execution Flow

```
AllStoriesTest (JUnitStories)
  → AbstractStoryConfiguration   (JBehave config, Spring wiring)
    → ProjectConfiguration       (Spring @Configuration, WebDriver bean)
      → ExecutionLifecycle       (@BeforeStory / @AfterStory / @AfterScenario)
        → WebDriverProvider      (lazy Chrome/Firefox/IE initialization)
        → PageFactory            (binds @FindBy fields on all @PageObject beans)
      → CannedSteps / CustomSteps (step definitions, Spring-injected)
        → CannedPage / CustomPage (page objects, WebElement fields)
          → AbstractPage          (reflection-based element lookup + waits)
      → StateManager             (cross-step data store)
      → ConsoleLogger            (JBehave reporter → ExtentReports HTML)
```

### Story → Step → Page Object Chain

Steps are matched by exact string pattern. Element names in steps are **Java field names** on the page object, resolved at runtime via reflection in `AbstractPage.getElementWithWait()`.

```gherkin
# Story file
When [Input] Set 'Subject Field' value to 'random'
And [Action] I get value from 'Generalization Get Serial Number' and save it as 'MyKey'
```
```java
// CannedSteps — matches step, calls page
cannedPage.enterText("Subject Field", "random");
// AbstractPage — finds field "subjectField" on CannedPage via reflection, waits 30s
```

Field names use camelCase; step names use Title Case with spaces — the lookup lowercases both and strips spaces to match.

### Property System (`p:` prefix)

Any step argument prefixed with `p:` is resolved via `PropertyParameterConverter` against `src/main/resources/data/test-data.properties`. This covers URLs, credentials, dropdown values, and status strings.

```gherkin
Given [Navigation] I navigate to 'p:dewanJPPMC'
# → http://172.16.30.83:5555/JPPMC_EndUser/login.aspx
```

### Special Step Tokens

| Token | Behavior |
|-------|----------|
| `random` | Generates `Auto[nanotime]`, saves to StateManager |
| `date` | Uses `LocalDate.now()`, saves to StateManager |
| `nanotime` | Uses `System.nanoTime()` as string |
| `statemanager[key]` | Retrieves value previously saved to StateManager |

### StateManager

`StateManager` is a Spring `@Component` holding a `HashMap<String, Object>`. Use `put(key, value)` / `get(key)` to share data across steps within a test run. Cleared between stories via `resetStateBeforeScenario`.

### Page Objects

- `@PageObject` (custom annotation) marks a class for automatic `PageFactory.initElements()` at story start.
- `CannedPage` — generic elements shared across all stories (login fields, common buttons, task lists, generalization grids).
- `CustomPage` — application-specific elements and interactions.
- `AbstractPage` provides: `getElementWithWait()` (30s visibility wait), `waitForLoad()` (waits for spinner/`#nprogress` to clear), `selectByVisibleText()`, scroll utilities.

### Reports

Three report types are generated per run:
1. **ExtentReports HTML** → `reports/[timestamp]/Dewan-Automation-Report.html`
2. **JBehave HTML/XML** → `target/jbehave/`
3. **Surefire XML** → `target/surefire-reports/`

Screenshots on failure are saved to `reports/[timestamp]/Screenshots/`.

## Key Files

| File | Purpose |
|------|---------|
| `src/test/java/AllStoriesTest.java` | Entry point — controls which stories run |
| `src/main/java/.../configuration/AbstractStoryConfiguration.java` | JBehave + Spring wiring, embedder controls |
| `src/main/java/.../configuration/ProjectConfiguration.java` | Spring `@Configuration`, WebDriver and screenshot beans |
| `src/main/java/.../steps/CannedSteps.java` | 50+ generic step definitions |
| `src/main/java/.../steps/CustomSteps.java` | Business-logic steps (save/assert values, column uniqueness) |
| `src/main/java/.../pages/CannedPage.java` | Generic `@FindBy` element library |
| `src/main/java/.../pages/AbstractPage.java` | Reflection element lookup + wait utilities |
| `src/main/java/.../state/StateManager.java` | Cross-step key/value store |
| `src/main/resources/data/test-data.properties` | All URLs, credentials, test data values |
| `src/test/resources/stories/` | JBehave `.story` files (one per test case) |
| `Jenkinsfile` | CI pipeline (checkout → clean → test → archive reports) |

## Jenkins Pipeline

The `Jenkinsfile` runs on a Windows agent with Maven and JDK 8 tools named `Maven` and `JDK8`. Stages: Checkout → `mvn clean` → delete/recreate reports dir → `mvn test` → archive artifacts. Post-build publishes surefire XML and the ExtentReports HTML.
