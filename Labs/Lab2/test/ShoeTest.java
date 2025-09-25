import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoeTest {
  private Shoe nikeSneaker;
  private Shoe adidasDress;

  @BeforeEach
  void setUp() {
    nikeSneaker = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.NIKE, 9.5);
    adidasDress = new Shoe(Kind.DRESS, Color.WHITE, Brand.ADIDAS, 8.0);
  }

  @Test
  void testConstructorAndGetters() {
    assertEquals(Kind.SNEAKER, nikeSneaker.getKind());
    assertEquals(Color.BLACK,  nikeSneaker.getColor());
    assertEquals(Brand.NIKE,   nikeSneaker.getBrand());
    assertEquals(9.5,          nikeSneaker.getSize());
  }

  @Test
  void testToString() {
    String s = nikeSneaker.toString();
    assertTrue(s.contains("Nike"));
    assertTrue(s.contains("sneaker"));
  }

  @Test
  void testInvalidNikeDress() {
    IllegalArgumentException ex = assertThrows(
        IllegalArgumentException.class,
        () -> new Shoe(Kind.DRESS, Color.RED, Brand.NIKE, 10.0)
    );
    assertTrue(ex.getMessage().toLowerCase().contains("nike"));
  }
}