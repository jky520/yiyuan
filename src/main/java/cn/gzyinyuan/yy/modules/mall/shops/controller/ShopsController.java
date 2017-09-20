package cn.gzyinyuan.yy.modules.mall.shops.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.gzyinyuan.yy.modules.mall.shops.entity.ShopsEntity;
import cn.gzyinyuan.yy.modules.mall.shops.service.ShopsService;
import cn.gzyinyuan.yy.common.utils.PageUtils;
import cn.gzyinyuan.yy.common.utils.Query;
import cn.gzyinyuan.yy.common.utils.R;




/**
 * 商铺表
 * Created by jky1988@qq.com on 2017-09-18.
 */
@RestController
@RequestMapping("shops")
public class ShopsController {
    @Autowired
    private ShopsService shopsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shops:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<ShopsEntity> shopsList = shopsService.queryList(query);
        int total = shopsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(shopsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{shopsId}")
    @RequiresPermissions("shops:info")
    public R info(@PathVariable("shopsId") Long shopsId){
        ShopsEntity shops = shopsService.queryObject(shopsId);

        return R.ok().put("shops", shops);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shops:save")
    public R save(@RequestBody ShopsEntity shops){
        shopsService.save(shops);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shops:update")
    public R update(@RequestBody ShopsEntity shops){
        shopsService.update(shops);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shops:delete")
    public R delete(@RequestBody Long[] shopsIds){
        shopsService.deleteBatch(shopsIds);

        return R.ok();
    }

    /**
     * 根据用户Id获得用户名
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/getUserNameById/{uid}")
    public R getUserNameById(@PathVariable("uid") Long userId) {
        return R.ok().put("username",shopsService.getUserById(userId));
    }
}