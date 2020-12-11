package dev.logue.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Application Test.
 *
 * @author logue
 * @version 1.0.0
 * @since 0.0.1
 */
@SpringBootTest
public class ApplicationTests {
  /** Check Bootstrapper. */
  @Test
  public void main() {
    Bootstrapper.main(new String[] {});
  }
}
