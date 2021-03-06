package com.sqring.auth.server.service;


import com.sqring.auth.web.entities.SysUser;
import com.sqring.auth.web.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通过手机号获取用户信息和权限资源
 * @Auther: www.zhouwenfang.com
 */
@Component("mobileUserDetailsService") // 一定不要少了
public class MobileUserDetailsService extends AbstractUserDetailsService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserService sysUserService;

    @Override
    SysUser findSysUser(String mobile){
        logger.info("请求认证的手机号：" + mobile);
        return sysUserService.findByMobile(mobile);
    }
}
