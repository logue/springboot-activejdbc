package dev.logue.app.domain.valueobjects;

import dev.logue.app.domain.AbstractValueObject;

/**
 * ID ValueObject.
 *
 * @author logue
 * @since 1.0.0
 * @version 1.0.1
 */
public class Id extends AbstractValueObject<Long> {
  /**
   * When specified as a Long type.
   *
   * @param value Long value
   */
  public Id(Long value) {
    super(value);
  }

  /**
   * When specified as a Integer type
   *
   * @param value Integer value
   */
  public Id(Integer value) {
    super(Long.valueOf(value));
  }

  /**
   * When specified as a String type.
   *
   * @param value String value
   */
  public Id(String value) {
    super(Long.valueOf(value));
  }

  /** {@inheritDoc} */
  @Override
  public Boolean validate(Long value) {
    // Negative values are not allowed
    return value >= 1;
  }
}
