package dev.logue.app.application.controllers;

import javax.annotation.Nullable;
import org.springframework.context.annotation.Scope;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Controller
 *
 * @author logue
 * @version 1.0.1
 */
@RestController
@RequestMapping("/api")
@Scope("request")
public class ApiController {
  /**
   * CSRF End point.
   *
   * @param token CSRF token
   * @return CSRF json array
   */
  @GetMapping("")
  public CsrfToken csrfAction(@Nullable CsrfToken token) {
    return token;
  }
}
