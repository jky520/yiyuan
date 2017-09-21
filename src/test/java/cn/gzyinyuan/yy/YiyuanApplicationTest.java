package cn.gzyinyuan.yy;

import cn.gzyinyuan.yy.modules.mall.shops.entity.ShopsEntity;
import cn.gzyinyuan.yy.modules.mall.shops.service.ShopsService;
import cn.gzyinyuan.yy.modules.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DT人 on 2017/9/19 11:45.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YiyuanApplicationTest {
    @Autowired
    private ShopsService shopsService;

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testList() {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(shopsService.queryList(map));
    }

    @Test
    public void testUserLoad() {
        System.out.println(sysUserService.queryObject(1l));
    }

    @Test
    public void testLoad() {
        System.out.println(shopsService.queryObject(1l));
    }

    @Test
    public void addShops() {
        //ShopsEntity shopsEntity = ShopsEntity.builder().s
    }
}
