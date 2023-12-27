package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount("Planilha1");
        int colCount = xl.getCellCount("Planilha1", 1);

        String apiData[][] = new String[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                apiData[i - 1][j] = xl.getCellData("Planilha1", i, j);
            }
        }
        return apiData;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount("Planilha1");

        String apiData[] = new String[rowNum];

        for (int i = 1; i <= rowNum; i++) {
            apiData[i - 1] = xl.getCellData("Planilha1", i, 1);
        }
        return apiData;
    }
}
