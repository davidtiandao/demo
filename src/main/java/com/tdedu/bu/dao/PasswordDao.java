package com.tdedu.bu.dao;

import com.tdedu.bu.domain.Password;

public interface PasswordDao extends BaseDao<Password> {
	public Password findByPwd(Password password);
	public void updatePwd(Password password);
	public Password findByPwdAndId(Password password);
}
