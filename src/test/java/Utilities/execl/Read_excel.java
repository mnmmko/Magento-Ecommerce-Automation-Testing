package Utilities.execl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Read_excel {
    public static String [][]read_sheet(String sheetName) throws IOException, InvalidFormatException {
        File myfile=new File(".\\Data\\user.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(myfile);
        XSSFSheet mysheetwork=wb.getSheet(sheetName);
        int rows=mysheetwork.getPhysicalNumberOfRows();
        int columns=mysheetwork.getRow(0).getLastCellNum();
        String [][]myarray=new String[rows-1][columns];
        for(int i=1;i<rows;i++){
            for (int k=0;k<columns;k++){
                XSSFRow row=mysheetwork.getRow(i);
                myarray[i-1][k]=row.getCell(k).toString();
            }
        }
        return myarray;
    }
}
