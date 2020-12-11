package dev.logue.app.domain.valueobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ID ValueObject Test.
 *
 * @author logue
 * @version 1.0.0
 * @since 0.0.1
 */
public class IdTest {
  /** Exception when not positive */
  @Test
  public void checkNotPositive() {
    Long test = -10L;
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Id(test));
  }

  /** OK when it is a positive number. */
  @Test
  public void checkPositive() {
    Long test = 10L;
    new Id(test);
  }

  /** Value match test. */
  @Test
  public void checkEquals() {
    Long test = 10L;
    Id id = new Id(test);
    assertEquals(test, id.value());
  }

  /** Value mismatch test. */
  @Test
  public void checkNotEquals() {
    Long test = 10L;
    Id id = new Id(12L);
    assertNotEquals(test, id.value());
  }

  /** Object match test. */
  @Test
  public void checkObjectMatch() {
    Id test1 = new Id(10L);
    Id test2 = new Id(10L);
    assertTrue(test1.equals(test2));
  }

  /** Object mismatch test. */
  @Test
  public void checkObjectMismatch() {
    Id test1 = new Id(10L);
    Id test2 = new Id(11L);
    assertFalse(test1.equals(test2));
  }
}
