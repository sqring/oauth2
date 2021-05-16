package com.sqring.auth.server.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

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

    // JWT 签名秘钥
    private static final String SIGNING_KEY = "zhouwenfang-key";

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 对称加密进行签名令牌，资源服务器也要采用此密钥来进行解密,来校验令牌合法性
//        converter.setSigningKey(SIGNING_KEY);
        // 采用非对称加密jwt
        // 第1个参数就是密钥证书文件，第2个参数 密钥库口令, 私钥进行签名
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(
                new ClassPathResource("oauth2.jks"), "oauth2".toCharArray());
        converter.setKeyPair(factory.getKeyPair("oauth2"));
        return converter;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * JDBC 管理令牌
     * 1. 创建相关数据表
     * 2. 添加 jdbc 相关依赖
     * 3. 配置数据源信息
     */
    @Bean
    public TokenStore tokenStore() {
        // redis管理token
        //return new RedisTokenStore(redisConnectionFactory);

        // jdbc 管理token
        return new JdbcTokenStore(dataSource());
    }

}