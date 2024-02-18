package com.betrybe.museumfinder.exception;

public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException() {
    super("Coordenadas inválidas.");
  }

  public InvalidCoordinateException(String message) {
    super(message);
  }

}