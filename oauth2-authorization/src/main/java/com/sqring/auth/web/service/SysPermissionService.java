package com.sqring.auth.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqring.auth.web.entities.SysPermission;

import java.util.List;

/**
 * @Auther:  www.zhouwenfang.com
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * @param userId 用户id
     * @return 用户所拥有的权限
     */
    List<SysPermission> findByUserId(Long userId);

}
