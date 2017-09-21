package cn.gzyinyuan.yy.modules.mall.assort.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 商品分类
 * Created by jky1988@qq.com on 2017-09-21.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssortEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long assortId;
	//分类名称
	private String name;
	//商品分类图片路径
	private String imgUrl;
	//状态：是否可用
	private String status;

}
