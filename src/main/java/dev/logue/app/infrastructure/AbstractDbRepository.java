package dev.logue.app.infrastructure;

import com.google.common.collect.Lists;
import dev.logue.app.domain.AbstractRepository;
import dev.logue.app.domain.EntityInterface;
import dev.logue.app.domain.valueobjects.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.javalite.activejdbc.Model;
import org.javalite.validation.Errors;

/**
 * DB repository abstraction class (wrapper of ActiveJDBC model).
 *
 * <p>Due to the specifications of ActiveJDBC, the implementation should be entered in the derived
 * class with reference to the sample code.
 *
 * <p>Execute <code>mvn process-classes</code> when ClassNotFoundException and InitException occur.
 *
 * @author logue
 * @param <T> Entity
 * @param <M> Model
 * @see org.javalite.activejdbc.Model
 * @see org.javalite.activejdbc.InitException
 * @since 1.0.0
 * @version 1.1.4
 */
@Slf4j
public abstract class AbstractDbRepository<T extends EntityInterface, M extends Model>
    extends AbstractRepository<T> {

  /** Errors of ActiveJDBC. */
  protected Errors errors;

  /**
   * {@inheritDoc}
   *
   * <p>Example (Insert [ModelClass] to ActiveJDBC model):
   *
   * <pre>{@code
   * return toEntity([ModelClass].findAll()
   * }</pre>
   *
   * @throws org.javalite.activejdbc.InitException Instrumentation not executed.
   */
  @Override
  public List<T> entries() {
    throw new UnsupportedOperationException("entries() does not implemented.");
  }

  /**
   * Get some stored entities in List.
   *
   * <p>Example (Insert [ModelClass] to any ActiveJDBC model):
   *
   * <pre>{@code
   * return toEntity([ModelClass].findAll().limit(limit).offset(offset));
   * }</pre>
   *
   * @param limit Maximum number.
   * @param offset pages.
   * @return Entity array.
   * @throws org.javalite.activejdbc.InitException Instrumentation not executed.
   */
  public List<T> entries(Integer limit, Integer offset) {
    throw new UnsupportedOperationException("entries() does not implemented.");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Example (Insert [ModelClass] to any ActiveJDBC model):
   *
   * <pre>{@code
   * return [ModelClass].count();
   * }</pre>
   *
   * @throws org.javalite.activejdbc.InitException Instrumentation not executed.
   */
  @Override
  public Long count() {
    throw new UnsupportedOperationException(
        "count() does not implemented. insert `[Model].count()`.");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Example (Insert [ModelClass] to any ActiveJDBC model):
   *
   * <pre>{@code
   * [ModelClass] model = [ModelClass].findById(id.value());
   * if (model == null) {
   *   throw new EntityNotFoundException();
   * }
   * return toEntity(model);
   * }</pre>
   *
   * @throws org.javalite.activejdbc.InitException Instrumentation not executed.
   */
  @Override
  public Optional<T> get(@Nonnull Id id) {
    throw new UnsupportedOperationException(
        "get() does not implemented. insert `[Model].findById(id.value())`.");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Example (Insert [ModelClass] to any ActiveJDBC model):
   *
   * <pre>{@code
   * return [ModelClass].findById(id.value()).exists()
   * }</pre>
   *
   * @throws org.javalite.activejdbc.InitException Instrumentation not executed.
   */
  @Override
  public Boolean has(@Nonnull Id id) {
    throw new UnsupportedOperationException("has() does not implemented.");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Example (Insert [ModelClass] to any ActiveJDBC model):
   *
   * <pre>{@code
   * [ModelClass] model = [ModelClass].findById(id.value());
   * if (model == null) {
   *   model = new [ModelClass]();
   * }
   * model.set("key", [VO].value());
   * ...
   * if (model.save()) {
   *   errors = model.errors();
   * }
   * return model.delete();
   * }</pre>
   */
  @Override
  public Long set(@Nonnull T entity) {
    throw new UnsupportedOperationException("set() does not implementend.");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Example (Insert [ModelClass] to any ActiveJDBC model):
   *
   * <pre>{@code
   * [ModelClass] model = [ModelClass].findById(id.value());
   * if (model == null) {
   *   throw new EntityNotFoundException();
   * }
   * return model.delete();
   * }</pre>
   *
   * @throws org.javalite.activejdbc.InitException Instrumentation not executed.
   */
  @Override
  public Boolean delete(@Nonnull Id id) {
    throw new UnsupportedOperationException("delete() does not implemented.");
  }

  /**
   * {@inheritDoc}
   *
   * <p>Example (Insert [ModelClass] to any ActiveJDBC model):
   *
   * <pre>{@code
   * return [ModelClass].findAll().orderBy("updated_at desc").limit(1).get(0).getDate("updated_at");
   * }</pre>
   */
  @Override
  public Date lastModified() {
    throw new UnsupportedOperationException("lastModified() does not implemented.");
  }

  /** {@inheritDoc} */
  public final Errors getErrors() {
    return this.errors;
  }

  /**
   * Convert ActiveJDBC Model to Entity
   *
   * <pre>{@code
   * return new [EntityClass](
   *   new Id(model.getLong("id"),
   *   ...
   * );
   * }</pre>
   *
   * @param model ActiveJDBC Model
   * @return Entity
   */
  protected abstract Optional<T> toEntity(M model);

  /**
   * Convert ActiveJDBC Model array to Entity array
   *
   * @param models Model array
   * @return Entity array
   */
  protected final List<T> toEntity(List<M> models) {
    List<Optional<T>> ret = Lists.newArrayList();
    for (M m : models) {
      if (Objects.isNull(m)) {
        continue;
      }
      ret.add(toEntity(m));
    }
    log.debug("Entities：{}", ret.size());

    return ret.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
  }
}
