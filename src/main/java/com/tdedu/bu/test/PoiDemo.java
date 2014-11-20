package com.tdedu.bu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import com.tdedu.bu.domain.Password;
import com.tdedu.bu.domain.UserInformation;

public class PoiDemo {
	
@SuppressWarnings("deprecation")
@Test	
public void exportAccount() throws IOException{
		
		FileInputStream exportInputStream=new FileInputStream(new File("E:/account.xlsx"));
		Workbook exportwb=new XSSFWorkbook(exportInputStream);
		Sheet curSheet=null;
		Row curRow=null;
		Cell curCell=null;
		UserInformation userInfo=null;
		Password password=null;
		Date curDate=null;
		 final DateTimeFormatter fmt =
		DateTimeFormat.forPattern("yyyy-MM-dd");
		
		  // 循环工作表Sheet
        for (int numSheet = 0; numSheet < exportwb.getNumberOfSheets(); numSheet++) {
        	curSheet= exportwb.getSheetAt(numSheet);
            if (curSheet == null) {
                continue;
            }
            
         // 循环行Row
            for (int rowNum = 1; rowNum <= curSheet.getLastRowNum(); rowNum++) {
            	curRow= curSheet.getRow(rowNum);
                if (curRow == null) {
                    continue;
                }
           // 循环列Cell
                userInfo=new UserInformation();  
                userInfo.setId(UUID.randomUUID().toString());
                password=new Password();
                password.setUserId(userInfo.getId());
                curCell=curRow.getCell(0);
                if (curCell != null) {
                	userInfo.setFullName(getValue(curCell));
                }
                
               
                curCell=curRow.getCell(1);
                if (curCell != null) {
                	 password.setPassword(getValue(curCell));
                }
               
                curCell=curRow.getCell(2);
                if (curCell != null) {
                	userInfo.setGender(getValue(curCell));
                }
                
                curCell=curRow.getCell(3);
                if (curCell != null) {
                	
                	userInfo.setBirthday(fmt.parseDateTime(getValue(curCell)).toDate());
                }
                
                curCell=curRow.getCell(4);
                if (curCell != null) {
                	userInfo.setHometown(getValue(curCell));
                }
            	
            	  curCell=curRow.getCell(5);
                  if (curCell != null) {
                	  userInfo.setLivePlace(getValue(curCell) );
                  }
            	
            	  curCell=curRow.getCell(6);
                  if (curCell != null) {
                	  userInfo.setPhone(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(7);
                  if (curCell != null) {
                	  userInfo.setTelphone(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(8);
                  if (curCell != null) {
                	  userInfo.setEmail( getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(9);
                  if (curCell != null) {
                		userInfo.setQq( getValue(curCell));
                  }
            
            	  curCell=curRow.getCell(10);
                  if (curCell != null) {
                	  userInfo.setWeixin(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(11);
                  if (curCell != null) {
                	  userInfo.setOtherContent(getValue(curCell) );
                  }
            	
            	  curCell=curRow.getCell(12);
                  if (curCell != null) {
                	  userInfo.setCardType(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(13);
                  if (curCell != null) {
                	  userInfo.setCardNo(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(14);
                  if (curCell != null) {
                	  userInfo.setNationality(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(15);
                  if (curCell != null) {
                	  userInfo.setPoliticalAddiliation(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(16);
                  if (curCell != null) {
                	  userInfo.setPhoto(getValue(curCell));
                  }
            	
            	  curCell=curRow.getCell(17);
                  if (curCell != null) {
                	  userInfo.setUserStatus(Integer.parseInt(getValue(curCell).split("\\.")[0]));
                  }
             
            	
            	curDate=new Date();
            	password.setStartDate(curDate);
            	password.setEndDate(new DateTime(curDate).plusYears(10).toDate());
            int i2=10;
       
            
        }
            
        }
	}
	
	   private String getValue(Cell curCell) {
	        if (curCell.getCellType() == curCell.CELL_TYPE_BOOLEAN) {
	            // 返回布尔类型的值
	            return String.valueOf(curCell.getBooleanCellValue());
	         // 返回数值类型的值
	        } else if (curCell.getCellType() == curCell.CELL_TYPE_NUMERIC) {
	        	if(HSSFDateUtil.isCellDateFormatted(curCell)){
		        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					return sdf.format(HSSFDateUtil.getJavaDate(curCell.getNumericCellValue())).toString();
	        	}
	            
	            return String.valueOf(curCell.getNumericCellValue());
	        } 
	  
	        
	        else {
	            // 返回字符串类型的值
	            return String.valueOf(curCell.getStringCellValue());
	        }
	   }
}

