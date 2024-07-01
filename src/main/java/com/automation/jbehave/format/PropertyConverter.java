package com.automation.jbehave.format;

import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.reporters.HtmlOutput;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class PropertyConverter extends HtmlOutput {

    private Keywords keywords;
    private static Environment properties;

    PropertyConverter(PrintStream output, Keywords keywords, Environment properties) {
        super(output, keywords);
        this.keywords = keywords;
        this.properties = properties;
        changeALine();
    }

    /**
     * Converts a Examples Table Row having properties p:
     *
     * @param tableRow The Examples Row Map of keys values
     * @return The converted string representing the table/step with converted values.
     */
    @Override
    public void example(Map<String, String> tableRow) {
        print(format("example", "\n{0} {1}\n", keywords.examplesTableRow(), PropertyConverterHelper.convertExampleMap(properties, tableRow)));
    }

    @Override
    public void beforeExamples(List<String> steps, ExamplesTable table) {
        super.beforeExamples(steps, convertTable(table));
    }

    @Override
    public void successful(String step) {
        super.successful(convert(step));
    }

    @Override
    public void failed(String step, Throwable storyFailure) {
        super.failed(convert(step), storyFailure);
    }

    @Override
    public void notPerformed(String step) {
        super.notPerformed(convert(step));
    }

    @Override
    public void pending(String step) {
        super.pending(convert(step));
    }

    public void ignorable(String step) {
        super.ignorable(convert(step));
    }

    private void changeALine() {
        super.overwritePattern("failed",
                "<div class=\"step failed\">{0} <span class=\"keyword failed\">({1})</span><br/><span class=\"message failed\">{2}</span>" +
                        "<br/><a color=\"black\" target=\"jb_scn_shot\" href=\"../screenshots/failed-scenario-{3}.png\"><img src=\"images/failing_screenshot.png\" alt=\"failing screenshot\"/></a></div>\n");
    }

    /**
     * Converts a Examples Table or a Step with examples
     * Converts a Step with properties with the default p:tag. This is a post processor action
     *
     * @param convertible The String representing the Examples Table at Scenario or Step level or the Step itself.
     * @return The converted string representing the table/step with converted values.
     */
    public static String convert(String convertible) {
        return PropertyConverterHelper.convert(properties, convertible);
    }

    /**
     * Converts the Examples Table object values with the real parameter values.
     *
     * @param table The table to be converted
     * @return The converted table with real parameter values.
     */
    private ExamplesTable convertTable(ExamplesTable table) {
        String tableAsString = table.asString();
        tableAsString = convert(tableAsString);
        return new ExamplesTable(tableAsString);
    }
}