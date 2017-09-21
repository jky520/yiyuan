package cn.gzyinyuan.yy.modules.mall.assort.service;

import cn.gzyinyuan.yy.modules.mall.assort.entity.AssortEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品分类
 * 
 * Created by jky1988@qq.com on 2017-09-21 12:41:38.
 */
public interface AssortService {
	
	AssortEntity queryObject(Long assortId);
	
	List<AssortEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AssortEntity assort);
	
	void update(AssortEntity assort);
	
	void delete(Long assortId);
	
	void deleteBatch(Long[] assortIds);
}
