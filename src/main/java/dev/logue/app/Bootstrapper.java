package dev.logue.app;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Application Bootstrap.
 *
 * @author logue
 * @since 1.0.0
 * @version 1.1.5
 */
@Slf4j
@SpringBootApplication
@Configuration
@EnableConfigurationProperties
public class Bootstrapper {
  /** Application name. */
  @Value("${spring.application.name}")
  private String appName;

  /**
   * Initialize application.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    // 処理時間計測
    Stopwatch processTime = Stopwatch.createStarted();
    log.info(
        "🏁 Initializing application... / ☕ Java Version: {}", System.getProperty("java.version"));
    // 実行
    SpringApplication.run(Bootstrapper.class, args);
    // 時間計測終了
    processTime.stop();
    log.info("🏁 Finish initialize application. ⏱ Process time: {}.", processTime);
  }
}
