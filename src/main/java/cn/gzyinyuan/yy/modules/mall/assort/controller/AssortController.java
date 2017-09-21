package cn.gzyinyuan.yy.modules.mall.assort.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.gzyinyuan.yy.modules.mall.assort.entity.AssortEntity;
import cn.gzyinyuan.yy.modules.mall.assort.service.AssortService;
import cn.gzyinyuan.yy.common.utils.PageUtils;
import cn.gzyinyuan.yy.common.utils.Query;
import cn.gzyinyuan.yy.common.utils.R;




/**
 * 商品分类
 * Created by jky1988@qq.com on 2017-09-21.
 */
@RestController
@RequestMapping("assort")
public class AssortController {
	@Autowired
	private AssortService assortService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("assort:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AssortEntity> assortList = assortService.queryList(query);
		int total = assortService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(assortList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{assortId}")
	@RequiresPermissions("assort:info")
	public R info(@PathVariable("assortId") Long assortId){
		AssortEntity assort = assortService.queryObject(assortId);
		
		return R.ok().put("assort", assort);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("assort:save")
	public R save(@RequestBody AssortEntity assort){
		assortService.save(assort);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("assort:update")
	public R update(@RequestBody AssortEntity assort){
		assortService.update(assort);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("assort:delete")
	public R delete(@RequestBody Long[] assortIds){
		assortService.deleteBatch(assortIds);
		
		return R.ok();
	}
	
}
