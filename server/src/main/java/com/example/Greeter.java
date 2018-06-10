package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
   * Greeting comment.
   * @param someone Your name.
   * @return Greeting.
   */
  final public String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
