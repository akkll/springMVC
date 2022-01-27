package com.zyq.mvc.config;

import com.zyq.mvc.controller.ExceptionController;
import com.zyq.mvc.interceptor.TestInterCeptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @ClassName WebConfig
 * @Author MagicBOOK
 * @Date 2022-01-25 20:08
 * @Version 1.0
 */
//代替spring MVC的配置文件
//1.扫描组件  2.视图解析器 3.view-controller   4.default-servlet-handler
//5.mvc注解驱动   6.文件上传解析器   7.异常处理  8.拦截器

@Configuration
//1.扫描组件
@ComponentScan("com.zyq.mvc.controller")
//5.mvc的注解驱动
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//        Properties prop = new Properties();
//        prop.setProperty("exceptionMappings", )
//    }

    //    8.拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        TestInterCeptor testInterCeptor = new TestInterCeptor();
        InterceptorRegistration registration = registry.addInterceptor(testInterCeptor);
//        选择拦截哪些路径，所有路径都拦截
        registration.addPathPatterns("/**");
//        选择放过哪些路径，这里选择的是主页
        registration.excludePathPatterns("/");
    }

//    3.设置视图控制器, view-controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
    }

    //    4.设置默认的Servlet可用
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


//    6.文件上传解析器
    @Bean
    public MultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

//    2.视图解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
