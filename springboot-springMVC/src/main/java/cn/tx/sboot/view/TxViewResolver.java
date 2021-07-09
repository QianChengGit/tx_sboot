package cn.tx.sboot.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//自定义视图解析器
public class TxViewResolver implements ViewResolver, Ordered {
    //视图解析器的加载顺序
    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        System.out.println("解析式图："+viewName);
        return new HelloView();
    }
}
