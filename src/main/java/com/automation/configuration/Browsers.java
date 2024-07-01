package com.automation.configuration;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie");

    private final String name;

    Browsers(String name) {
        this.name = name;
    }

    public static Browsers of(String name) {
        for (Browsers browser : Browsers.values()) {
            if (browser.getName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        throw new IllegalArgumentException("Browser Name '" + name + "' not found");
    }

    public String getName() {
        return name;
    }
}
