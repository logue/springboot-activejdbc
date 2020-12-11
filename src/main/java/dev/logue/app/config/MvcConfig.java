package dev.logue.app.config;

import dev.logue.app.components.activejdbc.ActiveJdbcHandleInspector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC Configure.
 *
 * @author logue
 * @since 1.0.0
 * @version 1.0.0
 */
@Configuration
@Slf4j
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
  /** {@inheritDoc} */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    log.info("🔧 MVC Configure: Regist interceptor.");
    // Load ActiveJDBC
    registry
        .addInterceptor(new ActiveJdbcHandleInspector())
        .addPathPatterns("/**") // Include Pattern
        .excludePathPatterns("/css/**", "/js/**", "/img/**"); // Exclude Pattern
  }

  /**
   * {@inheritDoc}
   *
   * <p>Static content settings.
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    log.info("🔧 MVC Configure: Add resource handler.");
    // Make content in the resources/public directory accessible directly from the outside
    registry.addResourceHandler("/**").addResourceLocations("classpath:public/");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Setting the view to call (fill in the contents that do not need to be written in the
   * controller).
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    log.info("🔧 MVC Configure: View configure.");

    // registry.addRedirectViewController("/", "index.html");
  }

  /** {@inheritDoc} */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // log.info("⚡CORS Configure");
    // registry.addMapping("/api/**").allowedOrigins("http://localhost:8081").allowedMethods("*");
  }
}
