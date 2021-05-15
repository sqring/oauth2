package com.sqring.auth.server.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName TokenConfig.java
 * @Description
 * @createTime 2021年05月15日
 */
@Configuration
public class TokenConfig {

    /**
     * Redis 管理令牌
     * 1. 启动 redis 服务器
     * 2. 添加 redis 相关依赖
     * 3. 添加redis 依赖后, 容器就会有 RedisConnectionFactory 实例
     */
    //@Autowired
    //RedisConnectionFactory redisConnectionFactory;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public TokenStore tokenStore() {
        // redis管理token
        //return new RedisTokenStore(redisConnectionFactory);

        // jdbc 管理token
        return new JdbcTokenStore(dataSource());
    }

    /**
     * JDBC 管理令牌
     * 1. 创建相关数据表
     * 2. 添加 jdbc 相关依赖
     * 3. 配置数据源信息
     */


}