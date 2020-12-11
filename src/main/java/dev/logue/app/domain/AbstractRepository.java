package dev.logue.app.domain;

import dev.logue.app.domain.valueobjects.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * Repository base class.
 *
 * <p>This class returns only undefined errors. Implementation should be done in a derived class.
 *
 * @author logue
 * @param <T> Entity
 * @since 1.0.0
 * @version 1.1.3
 */
@Repository
public abstract class AbstractRepository<T extends EntityInterface>
    implements RepositoryInterface<T> {

  /** {@inheritDoc} */
  @Override
  public List<T> entries() {
    throw new UnsupportedOperationException("entries() does not implemented.");
  }

  /** {@inheritDoc} */
  @Override
  public Long count() {
    throw new UnsupportedOperationException("count() does not implemented.");
  }

  /**
   * Get an entity from an ID.
   *
   * @param id ID
   * @return Entity.
   */
  public Optional<T> get(@Nonnull Id id) {
    throw new UnsupportedOperationException("get() does not implemented.");
  }

  /** {@inheritDoc} */
  @Override
  public Optional<T> get(@Nullable T entity) {
    if (Objects.isNull(entity)) {
      return Optional.empty();
    }
    if (has(entity.getId()).equals(false)) {
      throw new EntityNotFoundException();
    }
    return get(entity.getId());
  }

  /**
   * Check the existence of the entity from the ID.
   *
   * @param id ID
   * @return exist or not
   */
  public Boolean has(@Nonnull Id id) {
    throw new UnsupportedOperationException("has() does not implemented.");
  }

  /** {@inheritDoc} */
  @Override
  public Boolean has(@Nonnull T entity) {
    return has(entity.getId());
  }

  /** {@inheritDoc} */
  @Override
  public Long set(@Nonnull T entity) {
    throw new UnsupportedOperationException("set() does not implemented.");
  }

  /** {@inheritDoc} */
  public Date lastModified() {
    throw new UnsupportedOperationException("lastModified() does not implemented.");
  }

  /**
   * Delete the entity with the specified ID.
   *
   * @param id ID
   * @return Success or failure of deletion
   * @throws javax.persistence.EntityNotFoundException エンティティが見つからない.
   * @throws java.lang.UnsupportedOperationException 処理が実装されていない.
   */
  public Boolean delete(@Nonnull Id id) {
    throw new UnsupportedOperationException("delete() does not implemented.");
  }

  /** {@inheritDoc} */
  @Override
  public Boolean delete(@Nonnull T entity) {
    if (has(entity.getId()).equals(false)) {
      throw new EntityNotFoundException();
    }
    return delete(entity.getId());
  }
}
