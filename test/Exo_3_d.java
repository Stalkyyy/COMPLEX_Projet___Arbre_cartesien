import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.logging.Logger;

public class Exo_3_d {
    private static final Logger logger = Logger.getLogger(Exo_3_d.class.getName());
    private CartesianTree arb;

    @Before
    public void setup() {
        arb = new CartesianTree();

        Node h = new Node("h", 1);
        Node d = new Node("d", 2);
        Node b = new Node("b", 3);
        Node a = new Node("a", 5);
        Node e = new Node("e", 6);
        Node f = new Node("f", 7);
        Node c = new Node("c", 8);
        Node g = new Node("g", 9);
        Node i = new Node("i", 10);
        Node j = new Node("j", 12);

        h.setChildLeft(d);
        h.setChildRight(i);
        d.setChildLeft(b);
        d.setChildRight(e);
        b.setChildLeft(a);
        b.setChildRight(c);
        e.setChildRight(f);
        f.setChildRight(g);
        i.setChildRight(j);
        
        arb.setRoot(h);
    }

    @Test
    public void testInsert_1() {
        CartesianTree arb_test = new CartesianTree();

        arb_test.insert(new Node("a", 5));
        arb_test.insert(new Node("b", 3));
        arb_test.insert(new Node("c", 8));
        arb_test.insert(new Node("d", 2));
        arb_test.insert(new Node("e", 6));
        arb_test.insert(new Node("f", 7));
        arb_test.insert(new Node("g", 9));
        arb_test.insert(new Node("h", 1));
        arb_test.insert(new Node("i", 10));
        arb_test.insert(new Node("j", 12));

        logger.info("\nArbre d'insertion 1 :\n" + arb_test.toString());
        assertTrue(arb.equals(arb_test));
    }

    @Test
    public void testInsert_2() {
        CartesianTree arb_test = new CartesianTree();

        arb_test.insert(new Node("h", 1));
        arb_test.insert(new Node("g", 9));
        arb_test.insert(new Node("a", 5));
        arb_test.insert(new Node("b", 3));
        arb_test.insert(new Node("d", 2));
        arb_test.insert(new Node("f", 7));
        arb_test.insert(new Node("c", 8));
        arb_test.insert(new Node("j", 12));
        arb_test.insert(new Node("i", 10));
        arb_test.insert(new Node("e", 6));

        logger.info("\nArbre d'insertion 2 :\n" + arb_test.toString());
        assertTrue(arb.equals(arb_test));
    }

    @Test
    public void testInsert_3() {
        CartesianTree arb_test = new CartesianTree();

        arb_test.insert(new Node("e", 6));
        arb_test.insert(new Node("h", 1));
        arb_test.insert(new Node("b", 3));
        arb_test.insert(new Node("d", 2));
        arb_test.insert(new Node("c", 8));
        arb_test.insert(new Node("f", 7));
        arb_test.insert(new Node("g", 9));
        arb_test.insert(new Node("j", 12));
        arb_test.insert(new Node("a", 5));
        arb_test.insert(new Node("i", 10));

        logger.info("\nArbre d'insertion 3 :\n" + arb_test.toString());
        assertTrue(arb.equals(arb_test));
    }
}
