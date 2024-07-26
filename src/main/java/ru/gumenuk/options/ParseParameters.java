package ru.gumenuk.options;

public class ParseParameters {


    private SortDataType dataType;
    private String outputFileName = "out.txt";
    private String inputFileName;

    public SortDataType getDataType() {
        return dataType;
    }

    public void setDataType(SortDataType dataType) {
        this.dataType = SortDataType.STRING;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }


}
