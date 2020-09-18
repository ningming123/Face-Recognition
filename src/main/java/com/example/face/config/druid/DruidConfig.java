package com.example.face.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

/**
 * @deprecated 连接池配置
 * @author Nm
 *
 */
@Configuration
public class DruidConfig {
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String passWord;


    @Bean
    // 将所有前缀为spring.datasource下的配置项都加载DataSource中
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean<Servlet> druidServlet() {
        // 进行 druid 监控的配置处理
        ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/**");
        // 白名单
        srb.addInitParameter("allow", "");
        // 黑名单
        srb.addInitParameter("deny", "");
        // 用户名
        srb.addInitParameter("loginUsername", userName);
        // 密码
        srb.addInitParameter("loginPassword", passWord);
        // 是否可以重置数据源
        srb.addInitParameter("resetEnable", "false");
        return srb;
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new WebStatFilter());
        // 所有请求进行监控处理
        frb.addUrlPatterns("/*");
        // 排除名单
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return frb;
    }

}
