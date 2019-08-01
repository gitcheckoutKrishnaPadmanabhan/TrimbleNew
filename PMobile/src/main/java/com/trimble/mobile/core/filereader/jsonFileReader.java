package com.trimble.mobile.core.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.trimble.mobile.core.testData.TestData;

public class jsonFileReader {
    private String dsnNumber;
    private String testDataPath;
    private List<TestData> testDataList;

    public String getTestDataPath() {
        return testDataPath;
    }

    public void setTestDataPath(String testDataPath) {
        this.testDataPath = testDataPath;
    }

    public String getDsnNumber() {
        return dsnNumber;
    }

    public void setDsnNumber(String dsnNumber) {
        this.dsnNumber = dsnNumber;
    }


    public jsonFileReader() {
        initialize();
        testDataList = getTestData();
    }

    private void initialize() {
        PropertyFileReader handler = new PropertyFileReader(
                "configurations/configuration.properties");
        setDsnNumber(handler.getproperty("DSN_NUMBER"));
        setTestDataPath(handler.getproperty("TESTDATA_PATH"));
    }

    private List<TestData> getTestData() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+getTestDataPath()));
            TestData[] testData = gson.fromJson(bufferedReader, TestData[].class);
            return Arrays.asList(testData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + getTestDataPath());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ignore) {
            }
        }
    }

    public final TestData gettestDataByName() {
        return testDataList.stream().filter(x -> x.dsnnumber.equalsIgnoreCase(getDsnNumber())).findAny().get();
    }
}
