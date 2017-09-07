package cn.gzyinyuan.yy.modules.mall.shops.controller;

import cn.gzyinyuan.yy.modules.mall.shops.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商铺
 * @Author @DT人 【jky1988@qq.com】
 * @Date 2017/9/7 23:01
 */
@RestController
@RequestMapping("mall/shops")
public class ShopsController {

    @Autowired
    private ShopsService shopsService;
}
