package cn.tx.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//扫描cn.tx.datasource包下的所有mapper接口，会自动过滤其他类，并将扫描到的mapper接口注册到SpringIOC容器中。
@MapperScan("cn.tx.datasource")
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
