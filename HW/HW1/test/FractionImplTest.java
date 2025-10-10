import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("FractionImpl JUnit5 Tests")
class FractionImplTest {

  @Test
  void constructor_normalizesAndReduces() {
    Fraction f1 = new FractionImpl(4, 2);
    assertEquals(2, f1.getNumerator());
    assertEquals(1, f1.getDenominator());
    assertEquals("2 / 1", f1.toString());

    Fraction f2 = new FractionImpl(-6, -9);
    assertEquals(2, f2.getNumerator());

    assertEquals(3, f2.getDenominator());
    assertEquals("2 / 3", f2.toString());

    Fraction f3 = new FractionImpl(0, 5);
    assertEquals(0, f3.getNumerator());
    assertEquals(1, f3.getDenominator());
    assertEquals("0 / 1", f3.toString());
  }

  @Test
  void constructor_rejectsNonPositiveDenominator() {
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 0));
  }

  @Test
  void setters_preserveInvariantAndReduce() {
    Fraction f = new FractionImpl(3, 9);
    assertEquals("1 / 3", f.toString());

    f.setNumerator(-2);
    assertEquals(-2, f.getNumerator());
    assertEquals(3, f.getDenominator());
    assertEquals("-2 / 3", f.toString());

    f.setDenominator(6);
    assertEquals("-1 / 3", f.toString());

    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(-10));
  }

  @Test
  void toDouble_basic() {
    Fraction f = new FractionImpl(1, 4);
    assertEquals(0.25, f.toDouble(), 1e-12);

    Fraction g = new FractionImpl(-1, 2);
    assertEquals(-0.5, g.toDouble(), 1e-12);
  }

  @Test
  void toString_simplestFormAndSign() {
    assertEquals("2 / 1", new FractionImpl(10, 5).toString());
    assertEquals("-1 / 2", new FractionImpl(-2, 4).toString());
    assertEquals("-1 / 2", new FractionImpl(2, -4).toString());
    assertEquals("0 / 1", new FractionImpl(0, 7).toString());
  }

  @Test
  void reciprocal_typicalAndZero() {
    Fraction f = new FractionImpl(2, 3);
    assertEquals("3 / 2", f.reciprocal().toString());

    Fraction g = new FractionImpl(-4, 5);
    assertEquals("-5 / 4", g.reciprocal().toString());

    Fraction z = new FractionImpl(0, 3);
    assertThrows(ArithmeticException.class, z::reciprocal);
  }

  @Test
  void add_commonAndDifferentDenoms() {
    Fraction a = new FractionImpl(1, 3);
    Fraction b = new FractionImpl(1, 6);
    assertEquals("1 / 2", a.add(b).toString());

    Fraction c = new FractionImpl(-1, 2);
    Fraction d = new FractionImpl(1, 3);
    assertEquals("-1 / 6", c.add(d).toString());

    Fraction e = new FractionImpl(0, 5);
    assertEquals("1 / 3", e.add(new FractionImpl(1, 3)).toString());
  }

  @Test
  void add_overflowProtection() {
    Fraction big1 = new FractionImpl(Integer.MAX_VALUE, 1);
    Fraction small = new FractionImpl(1, 1);
    assertThrows(ArithmeticException.class, () -> big1.add(small));
  }

  @Test
  void compareTo_various() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(2, 3);
    Fraction c = new FractionImpl(3, 6);

    assertTrue(a.compareTo(b) < 0);
    assertEquals(0, a.compareTo(c));
    assertTrue(b.compareTo(a) > 0);

    Fraction neg = new FractionImpl(-1, 4);
    assertTrue(neg.compareTo(a) < 0);
  }

  @Test
  void equalsAndHashCode_consistentWithCanonicalForm() {
    Fraction x = new FractionImpl(2, 4);
    Fraction y = new FractionImpl(1, 2);
    assertEquals(x, y);
    assertEquals(x.hashCode(), y.hashCode());
  }
}