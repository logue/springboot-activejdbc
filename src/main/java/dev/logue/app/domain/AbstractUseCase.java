package dev.logue.app.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.springframework.stereotype.Service;

/**
 * Base UseCase class.
 *
 * @author logue
 * @since 1.0.0
 * @version 1.1.5
 */
@Service
public abstract class AbstractUseCase {
  /**
   * Convert date type to RFC1123 format string.
   *
   * @param date Date (Usually the date of Active JDBC)
   * @return RFC1123 format date string
   */
  protected static String convertRfc1123(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    return sdf.format(date);
  }
}
