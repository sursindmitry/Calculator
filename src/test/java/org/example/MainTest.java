package org.example;

import static org.example.Main.calc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void testAddition() throws Exception {
    assertEquals("5", calc("2 + 3"));
  }

  @Test
  void testSubtraction() throws Exception {
    assertEquals("0", calc("2 - 2"));
  }

  @Test
  void testMultiplication() throws Exception {
    assertEquals("6", calc("2 * 3"));
  }

  @Test
  void testDivision() throws Exception {
    assertEquals("2", calc("6 / 3"));
  }

  @Test
  void testInvalidOperand() {
    assertThrows(Exception.class, () -> calc("0 - 100"));
  }

  @Test
  void testInvalidOperator() {
    assertThrows(IllegalArgumentException.class, () -> calc("2 ? 3"));
  }

  @Test
  void testInvalidFormat() {
    assertThrows(Exception.class, () -> calc("2 +"));
    assertThrows(Exception.class, () -> calc("1"));
    assertThrows(Exception.class, () -> calc("1 + 1 + 1"));
  }
}