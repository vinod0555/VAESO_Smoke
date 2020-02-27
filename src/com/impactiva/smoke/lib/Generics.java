package com.impactiva.smoke.lib;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Generics {
	public String[][] getExcelData(String xlFilePath, String sheetName) throws Exception
    {
		
		{
			String[][] tabArray = null;
			try{
            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
            Sheet sheet = workbook.getSheet(sheetName);

                int rows = sheet.getRows();
                int columns = sheet.getColumns();

                tabArray = new String[rows-1][columns];

                for(int i=1; i<rows; i++)
                {
                    for(int j=0; j<columns; j++)
                    {
                        tabArray[i-1][j] = sheet.getCell(j, i).getContents();
                    }

                }


            /*int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell(tableName);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();
            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            tabArray=new String[endRow-startRow][endCol-startCol-1];
            ci=0;
            for (int i=startRow+1;i<=endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                 tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                }
            }*/

			}
			catch (Exception e)    {
				System.out.println(e.getStackTrace());
	            System.out.println("Error in getTableArray()");
	        }
	        return(tabArray);
           }
	}
}