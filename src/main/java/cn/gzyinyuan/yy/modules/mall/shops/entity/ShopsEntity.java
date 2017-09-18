package cn.gzyinyuan.yy.modules.mall.shops.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 商铺实体
 * @Author @DT人 【jky1988@qq.com】
 * @Date 2017/9/7 22:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopsEntity {
    /**
     * 商铺Id
     */
    private Long shosId;
    /**
     * 掌柜Id(用户Id)
     */
    private Long userId;
    /**
     * 商铺名称
     */
    private String name;
    /**
     * 创建时间
     */
    private LocalDate createAt;
}
