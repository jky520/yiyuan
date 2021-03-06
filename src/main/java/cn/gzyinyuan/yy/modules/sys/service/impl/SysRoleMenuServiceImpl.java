package cn.gzyinyuan.yy.modules.sys.service.impl;

import cn.gzyinyuan.yy.modules.sys.dao.SysRoleMenuDao;
import cn.gzyinyuan.yy.modules.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * Created by DT人 on 2017/9/7 14:08.
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Transactional
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        //先删除角色与菜单关系
        sysRoleMenuDao.delete(roleId);

        if(menuIdList.size() == 0){
            return ;
        }

        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("roleId", roleId);
        map.put("menuIdList", menuIdList);
        sysRoleMenuDao.save(map);
    }

    public List<Long> queryMenuIdList(Long roleId) {
        return sysRoleMenuDao.queryMenuIdList(roleId);
    }
}
