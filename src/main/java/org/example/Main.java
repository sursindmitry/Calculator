package org.example;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Input:");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    try {
      System.out.println(calc(input));
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

  }

  public static String calc(String input) throws Exception {
    String[] parts = input.split(" ");
    if (parts.length == 1) {
      throw new Exception("throws Exception //т.к. строка не является математической операцией");
    }
    if (parts.length > 3) {
      throw new Exception("throws Exception");
    }
    if (parts.length != 3) {
      throw new Exception(
          "throws Exception //т.к. формат математической операции не удовлетворяет заданию " +
              "- два операнда и один оператор (+, -, /, *)"
      );
    }

    return String.valueOf(getResult(parts));
  }

  private static int getResult(String[] parts) throws Exception {
    int num1 = Integer.parseInt(parts[0]);
    int num2 = Integer.parseInt(parts[2]);
    if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
      throw new Exception("Принимаются только числа от 1 до 10 включительно, не более.");
    }

    return switch (parts[1]) {
      case "+" -> num1 + num2;
      case "-" -> num1 - num2;
      case "*" -> num1 * num2;
      case "/" -> num1 / num2;
      default -> throw new IllegalArgumentException("Недопустимое значение оператора: " + parts[1]);
    };
  }
}