package dev.logue.app.components.activejdbc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.connection_config.DBConfiguration;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ActiveJDBC Handler.
 *
 * @author logue
 * @version 1.0.0
 */
@Slf4j
public class ActiveJdbcHandleInspector implements HandlerInterceptor {
  /**
   * Load ActiveJDBC configure.
   *
   * @throws org.javalite.activejdbc.InitException Instrumentation not executed.
   */
  public ActiveJdbcHandleInspector() {
    log.info("💿 ActiveJDBC: Initialize.");
    DBConfiguration.loadConfiguration("/database.properties");
  }

  /**
   * {@inheritDoc}
   *
   * @return Always return true
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    // Open Database connection
    Base.open();
    return true;
  }

  /** {@inheritDoc} */
  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {

    // Close Database connection
    Base.close();
  }
}
