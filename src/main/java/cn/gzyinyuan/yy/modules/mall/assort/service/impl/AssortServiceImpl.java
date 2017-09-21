package cn.gzyinyuan.yy.modules.mall.assort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.gzyinyuan.yy.modules.mall.assort.dao.AssortDao;
import cn.gzyinyuan.yy.modules.mall.assort.entity.AssortEntity;
import cn.gzyinyuan.yy.modules.mall.assort.service.AssortService;



@Service("assortService")
public class AssortServiceImpl implements AssortService {
	@Autowired
	private AssortDao assortDao;
	
	@Override
	public AssortEntity queryObject(Long assortId){
		return assortDao.queryObject(assortId);
	}
	
	@Override
	public List<AssortEntity> queryList(Map<String, Object> map){
		return assortDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return assortDao.queryTotal(map);
	}
	
	@Override
	public void save(AssortEntity assort){
		assortDao.save(assort);
	}
	
	@Override
	public void update(AssortEntity assort){
		assortDao.update(assort);
	}
	
	@Override
	public void delete(Long assortId){
		assortDao.delete(assortId);
	}
	
	@Override
	public void deleteBatch(Long[] assortIds){
		assortDao.deleteBatch(assortIds);
	}
	
}
