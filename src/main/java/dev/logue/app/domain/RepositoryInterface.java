package dev.logue.app.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.springframework.stereotype.Repository;

/**
 * Base repository interface.
 *
 * @author logue
 * @param <T> Entity
 * @since 1.0.0
 * @version 1.1.3
 */
@Repository
public interface RepositoryInterface<T extends EntityInterface> {
  /**
   * Get all stored entities in List.
   *
   * @return Entity array
   */
  List<T> entries();

  /**
   * Number of all stored entities.
   *
   * @return Number of entities
   */
  Long count();

  /**
   * Get a single entity conditionally.
   *
   * @param entity conditions
   * @return Single entity
   */
  Optional<T> get(@Nonnull T entity);

  /**
   * Confirmation of existence of entity.
   *
   * @param entity Entity to check
   * @return True if it exists
   */
  Boolean has(@Nonnull T entity);

  /**
   * Save entity.
   *
   * @param entity Entity to save
   * @return The ID of the saved entity. If it cannot be saved, null is returned.
   */
  Long set(@Nonnull T entity);

  /**
   * Delete entity.
   *
   * @param entity Entity to delete
   * @return Success or failure of deletion
   */
  Boolean delete(@Nonnull T entity);

  /**
   * Get the error message that occurred.
   *
   * @return An associative array of errors (a pair of the key name where the error occurred and the
   *     error message)
   */
  Map<String, String> getErrors();

  /**
   * Get the last modified date of the persistence destination.
   *
   * @return Last modified date
   */
  Date lastModified();
}
