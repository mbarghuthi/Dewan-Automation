package com.automation.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.automation"})
@PropertySource("classpath:data/test-data.properties")
public class ProjectConfiguration {

    @Value("${browser.name}")
    private String browserName;

    @Bean
    public WebDriverProvider webDriverProvider() {
        return new WebDriverProvider() {
            private WebDriver driver;

            @Override
            public WebDriver get() {
                if (driver == null) {
                    switch (Browsers.of(browserName)) {
                        case CHROME:
                            WebDriverManager.chromedriver().setup();
                            driver = new ChromeDriver();
                            break;
                        case FIREFOX:
                            WebDriverManager.firefoxdriver().setup();
                            driver = new FirefoxDriver();
                            break;
                        case IE:
                            WebDriverManager.iedriver().setup();
                            driver = new InternetExplorerDriver();
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid browser name: " + browserName);
                    }
                }
                return driver;
            }

            @Override
            public void initialize() {
                get();
            }

            @Override
            public boolean saveScreenshotTo(String path) {
                // Add your implementation to save screenshot if needed
                return false;
            }

            @Override
            public void end() {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                }
            }
        };
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public WebDriverScreenshotOnFailure screenshotOnFailureDriver() {
        return new WebDriverScreenshotOnFailure(webDriverProvider());
    }
}
