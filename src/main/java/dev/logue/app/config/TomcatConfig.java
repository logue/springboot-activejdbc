package dev.logue.app.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * Tomcat Override.
 *
 * @author logue
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class TomcatConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
  /**
   * Request Body is not allowed for PUT and DELETE by default in embedded Tomcat, so allow it.
   *
   * @return TomcatServletWebServerFactory
   */
  @Override
  public void customize(TomcatServletWebServerFactory factory) {
    factory.addConnectorCustomizers(
        new TomcatConnectorCustomizer() {
          @Override
          public void customize(Connector connector) {
            connector.setParseBodyMethods("POST,PUT,DELETE");
          }
        });
  }
}
