package dev.logue.app.domain;

import dev.logue.app.domain.valueobjects.Id;

/**
 * Interface of entity.
 *
 * @author logue
 * @since 1.0.0
 * @version 1.1.1
 */
public interface EntityInterface extends Cloneable {
  /**
   * Get ID from entity.
   *
   * @return ID
   */
  Id getId();

  /**
   * Compare entity identities.
   *
   * @param that Any object to compare
   * @return Comparison result
   */
  boolean equals(Object that);

  /**
   * Entity hash code.
   *
   * @return Hash code
   */
  int hashCode();

  /**
   * Stringification.
   *
   * @return String
   */
  String toString();
}
