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

  public static final String SECRET = "e92dd7c0f9294bf2273af7114d80a466a89a76969423eccab98d7bae2434a6098e9e7d486ad7505f05e224c57b652d572d9ec5b6f4a8260b264c38339d6866e7";
  public static final long EXPIRATION_TIME = 60_000; // 1 min
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/user";
}
