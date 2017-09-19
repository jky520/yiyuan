package cn.gzyinyuan.yy.modules.mall.shops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.gzyinyuan.yy.modules.mall.shops.dao.ShopsDao;
import cn.gzyinyuan.yy.modules.mall.shops.entity.ShopsEntity;
import cn.gzyinyuan.yy.modules.mall.shops.service.ShopsService;



@Service("shopsService")
public class ShopsServiceImpl implements ShopsService {

	@Autowired
	private ShopsDao shopsDao;

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
	
}
