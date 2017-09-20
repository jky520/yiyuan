package cn.gzyinyuan.yy.modules.mall.shops.service.impl;

import cn.gzyinyuan.yy.modules.sys.dao.SysUserDao;
import cn.gzyinyuan.yy.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.gzyinyuan.yy.modules.mall.shops.dao.ShopsDao;
import cn.gzyinyuan.yy.modules.mall.shops.entity.ShopsEntity;
import cn.gzyinyuan.yy.modules.mall.shops.service.ShopsService;



@Service("shopsService")
public class ShopsServiceImpl implements ShopsService {

	@Autowired
	private ShopsDao shopsDao;

	@Autowired
	private SysUserDao userDao;

	public ShopsEntity queryObject(Long shopsId){
		return shopsDao.queryObject(shopsId);
	}

	public List<ShopsEntity> queryList(Map<String, Object> map){
		return shopsDao.queryList(map);
	}

	public int queryTotal(Map<String, Object> map){
		return shopsDao.queryTotal(map);
	}
	
	public void save(ShopsEntity shops){
		shopsDao.save(shops);
	}
	
	public void update(ShopsEntity shops){
		shopsDao.update(shops);
	}
	
	public void delete(Long shopsId){
		shopsDao.delete(shopsId);
	}
	
	public void deleteBatch(Long[] shopsIds){
		shopsDao.deleteBatch(shopsIds);
	}

	public String getUserById(Long userId) {
		SysUserEntity userEntity = userDao.queryObject(userId);
		String userName = null;
		if(userEntity != null) {
			userName = userEntity.getUsername();
		}
		return userName;
	}

	public List<Map<String, Object>> getUsers() {
		return userDao.queryList(new HashMap<String, Object>())
					.stream()
					.map(x -> {
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("id",x.getUserId());
						map.put("name",x.getUsername());
						return map;
					}).collect(Collectors.toList());
	}
}
