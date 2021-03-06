package cn.tx.sboot.config;

import cn.tx.sboot.interceptor.MyInterceptor;
import cn.tx.sboot.view.TxViewResolver;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@EnableWebMvc//加上@EnableWebMvc这个注解，springBoot对SpringMVC的自动配置将会完全失效
public class WebConfig implements WebMvcConfigurer {

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")//拦截所有
                                                    .excludePathPatterns("/hello");//排除的拦截
    }

    //添加静态资源映射目录,直接访问：http://localhost:8080/res/hello01.html，会访问到static_resource目录下的hello01.html文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("classpath:/static_resource/");
    }

    //添加视图,直接访问：http://localhost:8080/tx_index，会访问到templates目录下的index.html文件，使用了thymeleaf模板
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/tx_index").setViewName("index");
    }

    //添加消息转换器,springMVC的配置方式，需要@EnableWebMvc注解
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //1.需要定义一个converters转换消息的对象
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        //2.添加fastJson配置信息：
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        //3.处理中文乱码问题
//        List<MediaType> fastMediaType = new ArrayList<>();
//        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
//        //4.在converters中添加配置信息：
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaType);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastJsonHttpMessageConverter);
//    }

    //使用bean的方式配置FastJson消息转换器，springBoot的自动配置方式，不需要@EnableWebMvc注解
//    @Bean
//    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
//        //1.需要定义一个converters转换消息的对象
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        //2.添加fastJson配置信息：
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        //3.处理中文乱码问题
//        List<MediaType> fastMediaType = new ArrayList<>();
//        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
//        //4.在converters中添加配置信息：
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaType);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        return fastJsonHttpMessageConverter;
//    }

    //使用bean的方式配置FastJson消息转换器，springBoot的另一种自动配置方式，不需要@EnableWebMvc注解
    @Bean
    public HttpMessageConverters customConverter(){
        //1.需要定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2.添加fastJson配置信息：
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3.处理中文乱码问题
        List<MediaType> fastMediaType = new ArrayList<>();
        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在converters中添加配置信息：
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaType);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }

    //注册配置视图解析器
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver(new TxViewResolver());
//        registry.order(Integer.MIN_VALUE+10);//通过order值改变视图解析器的加载顺序
//    }

    //使用bean的方式配置视图解析器
    @Bean
    public TxViewResolver txViewResolver(){
        return new TxViewResolver();
    }


}
