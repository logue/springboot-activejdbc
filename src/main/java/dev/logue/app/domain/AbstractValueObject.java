package dev.logue.app.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import javax.annotation.Nullable;
import lombok.EqualsAndHashCode;

/**
 * Base ValueObject class.
 *
 * @author logue
 * @param <T> Primitive type
 * @since 1.0.0
 * @version 1.1.3
 */
@EqualsAndHashCode
public abstract class AbstractValueObject<T> extends Object {
  /** Primitive value. */
  @Nullable @JsonValue private final T value;

  /**
   * Constructor.
   *
   * @param value Primitive value
   */
  protected AbstractValueObject(@Nullable T value) {
    if (validate(value).equals(false)) {
      throw new IllegalArgumentException();
    }
    this.value = value;
  }

  /**
   * Get value.
   *
   * @return Primitive value
   */
  @Nullable
  public final T value() {
    return value;
  }

  /**
   * Validate.
   *
   * @param value Target value
   * @return Success or failure of validation
   */
  public Boolean validate(T value) {
    return true;
  }

  /**
   * Check value and type.
   *
   * @param compare ValueObject to compare
   * @return True if equal
   */
  public final Boolean sameValueAs(AbstractValueObject<T> compare) {
    return compare != null && this.value.equals(compare.value());
  }

  /**
   * Stringification.
   *
   * @return Value of executing toString()
   */
  public final String toString() {
    return value().toString();
  }
}
