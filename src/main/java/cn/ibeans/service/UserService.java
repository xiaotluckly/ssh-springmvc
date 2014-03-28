package cn.ibeans.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.ibeans.dao.UserDao;
import cn.ibeans.web.model.User;

@Component
public class UserService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=false)
	public void saveUser(User user){
		userDao.saveOrUpdate(user);
		logger.debug(user.getUsername()+",保存成功！");
	}
	
	public User queryUser(int id){
		return userDao.findById(id);
	}
}
