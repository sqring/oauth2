package com.sqring.auth.web.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqring.auth.web.entities.SysPermission;
import com.sqring.auth.web.mapper.SysPermissionMapper;
import com.sqring.auth.web.service.SysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: www.zhouwenfang.com
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Override
    public List<SysPermission> findByUserId(Long userId) {
        if(userId == null) {
            return null;
        }
        List<SysPermission> list = baseMapper.findByUserId(userId);
        //用户无任何权限时，list会有一个 `null` 空的SysPermission 对象，把那个null移除
        list.remove(null);
        return list;
    }
}
