package cn.gzyinyuan.yy.modules.mall.shops.service;

import cn.gzyinyuan.yy.modules.mall.shops.entity.ShopsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商铺表
 * 
 * Created by jky1988@qq.com on 2017-09-18 16:52:19.
 */
public interface ShopsService {
	
	ShopsEntity queryObject(Long shopsId);
	
	List<ShopsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ShopsEntity shops);
	
	void update(ShopsEntity shops);
	
	void delete(Long shopsId);
	
	void deleteBatch(Long[] shopsIds);
}
