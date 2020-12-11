package dev.logue.app.components.activejdbc;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.javalite.activejdbc.Base;
import org.springframework.stereotype.Component;

/**
 * Transaction implementation class for Active JDBC.
 *
 * @author logue
 * @version 1.0.0
 */
@Aspect
@Component
@Slf4j
public class ActiveJdbcTransactional {
  /**
   * Begin Transaction.
   *
   * @param joinPoint interrupt
   */
  @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
  public void open(JoinPoint joinPoint) {
    log.info("💿 ActiveJDBC: Bigin Transaction");
    Base.openTransaction();
  }

  /**
   * End Transaction.
   *
   * @param joinPoint interrupt
   */
  @AfterReturning("@annotation(org.springframework.transaction.annotation.Transactional)")
  public void commit(JoinPoint joinPoint) {
    log.info("💿 ActiveJDBC: Commit Transaction");
    Base.commitTransaction();
  }

  /**
   * Rollback.
   *
   * @param e Exception
   */
  @AfterThrowing(
      value = "@annotation(org.springframework.transaction.annotation.Transactional)",
      throwing = "e")
  public void rollback(Throwable e) {
    log.error("💿 ActiveJDBC: ❌Error. Transaction has been rolled back.{}", e.getMessage());
    Base.rollbackTransaction();
  }
}
