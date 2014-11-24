package com.tdedu.bu.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import java.util.HashMap;




import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beust.jcommander.internal.Maps;
import com.tdedu.bu.dao.PasswordDao;
import com.tdedu.bu.dao.UserInformationDao;
import com.tdedu.bu.domain.Password;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.web.Page;
import com.tdedu.bu.web.Base64;
import com.tdedu.bu.web.Md5;


@Component("userService")
public class UserInformationService {
	@Autowired
	private UserInformationDao userInformationDao;


	public UserInformationDao getUserInformationDao() {
		return userInformationDao;
	}
	public void setUserInformationDao(UserInformationDao userInformationDao) {
		this.userInformationDao = userInformationDao;
	}


	Date curDate = null;
	Md5 md5=null;
	Base64 base64=null;

	@Autowired
	private PasswordDao passwordDao;
	


	public void save(UserInformation userInfromation) throws Exception{

		userInformationDao.insert(userInfromation);
		
	}
	public UserInformation findById(String userId){
		return userInformationDao.get(userId);
	}
	//密码和用户的保存必须保证在同一事务中
	public void save(UserInformation userInfromation,Password password) throws Exception{
	
		final DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		curDate = new Date();
		md5=new Md5();
		base64=new Base64();
		password.setStartDate(curDate);
		password.setEndDate(new DateTime(curDate).plusYears(10)
				.toDate());
		userInfromation.setId(UUID.randomUUID().toString());
		//先md5和base64进行加密
		byte [] encrypted = md5.getDigest(password.getPassword().getBytes());
	    password.setPassword(base64.encode(encrypted));
		password.setUserId(userInfromation.getId());
		userInformationDao.insert(userInfromation);
		passwordDao.insert(password);
	}

	
	public void save(String path) throws IOException {

		FileInputStream exportInputStream = new FileInputStream(new File(path));
		Workbook exportwb = new XSSFWorkbook(exportInputStream);
		Sheet curSheet = null;
		Row curRow = null;
		Cell curCell = null;
		UserInformation userInfo = null;
		Password password = null;
		Date curDate = null;
		final DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");

		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < exportwb.getNumberOfSheets(); numSheet++) {
			curSheet = exportwb.getSheetAt(numSheet);
			if (curSheet == null) {
				continue;
			}

			// 循环行Row
			for (int rowNum = 1; rowNum <= curSheet.getLastRowNum(); rowNum++) {
				curRow = curSheet.getRow(rowNum);
				if (curRow == null) {
					continue;
				}
				// 循环列Cell
				userInfo = new UserInformation();
				userInfo.setId(UUID.randomUUID().toString());
				password = new Password();
				password.setUserId(userInfo.getId());
				curCell = curRow.getCell(0);
				if (curCell != null) {
					password.setUserName(getValue(curCell));
				}
				curCell = curRow.getCell(1);
				if (curCell != null) {
					userInfo.setFullName(getValue(curCell));
				}

				curCell = curRow.getCell(2);
				if (curCell != null) {
					password.setPassword(getValue(curCell));
				}

				curCell = curRow.getCell(3);
				if (curCell != null) {
					userInfo.setGender(getValue(curCell));
				}

				curCell = curRow.getCell(4);
				if (curCell != null) {

					userInfo.setBirthday(fmt.parseLocalDateTime(getValue(curCell))
							.toDate());
				}

				curCell = curRow.getCell(5);
				if (curCell != null) {
					userInfo.setHometown(getValue(curCell));
				}

				curCell = curRow.getCell(6);
				if (curCell != null) {
					userInfo.setLivePlace(getValue(curCell));
				}

				curCell = curRow.getCell(7);
				if (curCell != null) {
					userInfo.setPhone(getValue(curCell));
				}

				curCell = curRow.getCell(8);
				if (curCell != null) {
					userInfo.setTelphone(getValue(curCell));
				}

				curCell = curRow.getCell(9);
				if (curCell != null) {
					userInfo.setEmail(getValue(curCell));
				}

				curCell = curRow.getCell(10);
				if (curCell != null) {
					userInfo.setQq(getValue(curCell));
				}

				curCell = curRow.getCell(11);
				if (curCell != null) {
					userInfo.setWeixin(getValue(curCell));
				}

				curCell = curRow.getCell(12);
				if (curCell != null) {
					userInfo.setOtherContent(getValue(curCell));
				}

				curCell = curRow.getCell(13);
				if (curCell != null) {
					userInfo.setCardType(getValue(curCell));
				}

				curCell = curRow.getCell(14);
				if (curCell != null) {
					userInfo.setCardNo(getValue(curCell));
				}

				curCell = curRow.getCell(15);
				if (curCell != null) {
					userInfo.setNationality(getValue(curCell));
				}

				curCell = curRow.getCell(16);
				if (curCell != null) {
					userInfo.setPoliticalAddiliation(getValue(curCell));
				}

				curCell = curRow.getCell(17);
				if (curCell != null) {
					userInfo.setPhoto(getValue(curCell));
				}

				curCell = curRow.getCell(18);
				if (curCell != null) {
					userInfo.setUserStatus(Integer.parseInt(getValue(curCell)));
				}

				curDate = new Date();
				userInfo.setCreateDate(curDate);
				password.setStartDate(curDate);
				password.setEndDate(new DateTime(curDate).plusYears(10)
						.toDate());
				try {
					save(userInfo, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
	private String getValue(Cell curCell) {
		if (curCell.getCellType() == curCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(curCell.getBooleanCellValue());
			// 返回数值类型的值
		} else if (curCell.getCellType() == curCell.CELL_TYPE_NUMERIC) {
			if (HSSFDateUtil.isCellDateFormatted(curCell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf
						.format(HSSFDateUtil.getJavaDate(curCell
								.getNumericCellValue())).toString();
			}

			return String.valueOf(curCell.getNumericCellValue()).split("\\.")[0];
		}

		else {
			// 返回字符串类型的值
			return String.valueOf(curCell.getStringCellValue());
		}

	}

public List<UserInformation> listUser(Page page){
	Map map=Maps.newHashMap();
	map.put("page", page);
	return userInformationDao.find(map);
}


	/*
	 * 修改用户状态,比如删除
	 */
	public void updateUserStatus(String[] ids,Integer userStatus){
		Map<String,Object> mapUserStatus=new HashMap<String,Object>();
		mapUserStatus.put("ids", ids);
		mapUserStatus.put("categoryStatus", userStatus);
		userInformationDao.updateState(mapUserStatus);
	}

}

