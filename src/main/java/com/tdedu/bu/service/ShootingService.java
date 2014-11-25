package com.tdedu.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tdedu.bu.dao.ShootingDao;
import com.tdedu.bu.domain.Shooting;

@Component("shootingService")
public class ShootingService {
	@Autowired
	private ShootingDao shootingDao;
	
	public void saveShooting(Shooting shooting) throws Exception {
		shootingDao.insert(shooting);		
	}

	public void deleteShooting(String[] shootingIds) throws Exception {
		shootingDao.delete(shootingIds);
		
	}

	public void updateShooting(Shooting shooting) throws Exception {
		shootingDao.update(shooting);
		
	}

}
