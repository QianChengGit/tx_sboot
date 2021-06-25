package cn.tx.sboot;

import org.hibernate.validator.constraints.Email;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "config")//注入配置文件属性值
@Validated//开启验证注解
public class Config {
    @NotNull//验证不为null
    private String host;
    @Email//验证是否是合法email
    private String email;
    @Max(8080)//验证最大值不超过8080
    private int pro;
    private List<String> name = new ArrayList<>();

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPro() {
        return pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Config{" +
                "host='" + host + '\'' +
                ", email='" + email + '\'' +
                ", pro=" + pro +
                ", name=" + name +
                '}';
    }
}
