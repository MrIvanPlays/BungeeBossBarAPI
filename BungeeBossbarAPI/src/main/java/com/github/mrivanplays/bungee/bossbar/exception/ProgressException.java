package com.github.mrivanplays.bungee.bossbar.exception;

import com.github.mrivanplays.bungee.bossbar.util.FromVersion;

/** Just a simple runtime exception creation */
@FromVersion("1.1.0")
public class ProgressException extends RuntimeException {

  public ProgressException(String message) {
    super(message);
  }
}
