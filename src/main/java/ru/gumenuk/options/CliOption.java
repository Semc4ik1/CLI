package ru.gumenuk.options;

public enum CliOption {

    INPUT("i", "input", "Input file names"),
    OUTPUT("o", "output", "Output file names"),
    STRING(null, "string", "String data type"),
    INTEGER(null, "integer", "Integer data type"),
    DOUBLE(null, "double", "Double data type");

    private final String shortOption;
    private final String longOption;
    private final String description;

    CliOption(String shortOption, String longOption, String description) {
        this.shortOption = shortOption;
        this.longOption = longOption;
        this.description = description;
    }

    public String getShortOption() {
        return shortOption;
    }

    public String getLongOption() {
        return longOption;
    }

    public String getDescription() {
        return description;
    }


}
