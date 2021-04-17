/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.constant;

/**
 *
 * @author Jose
 */
public class SecurityConstants {

  public static final String SECRET = "ARIA_KAKI_THALY_JOSE";
  public static final long EXPIRATION_TIME = 60_000; // 1 min
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/user";
}
