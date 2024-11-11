import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.logging.Logger;

public class Exo_4_d {
    private static final Logger logger = Logger.getLogger(Exo_4_d.class.getName());
    private CartesianTree arb, arb_without_A, arb_without_AJ, arb_without_AJH;

    @Before
    public void setup() {
        arb = new CartesianTree();
        arb_without_A = new CartesianTree();
        arb_without_AJ = new CartesianTree();
        arb_without_AJH = new CartesianTree();

        arb.insert(new Node("a", 5));

        arb.insert(new Node("b", 3));
        arb_without_A.insert(new Node("b", 3));
        arb_without_AJ.insert(new Node("b", 3));
        arb_without_AJH.insert(new Node("b", 3));

        arb.insert(new Node("c", 8));
        arb_without_A.insert(new Node("c", 8));
        arb_without_AJ.insert(new Node("c", 8));
        arb_without_AJH.insert(new Node("c", 8));

        arb.insert(new Node("d", 2));
        arb_without_A.insert(new Node("d", 2));
        arb_without_AJ.insert(new Node("d", 2));
        arb_without_AJH.insert(new Node("d", 2));

        arb.insert(new Node("e", 6));
        arb_without_A.insert(new Node("e", 6));
        arb_without_AJ.insert(new Node("e", 6));
        arb_without_AJH.insert(new Node("e", 6));

        arb.insert(new Node("f", 7));
        arb_without_A.insert(new Node("f", 7));
        arb_without_AJ.insert(new Node("f", 7));
        arb_without_AJH.insert(new Node("f", 7));

        arb.insert(new Node("g", 9));
        arb_without_A.insert(new Node("g", 9));
        arb_without_AJ.insert(new Node("g", 9));
        arb_without_AJH.insert(new Node("g", 9));
        
        arb.insert(new Node("h", 1));
        arb_without_A.insert(new Node("h", 1));
        arb_without_AJ.insert(new Node("h", 1));

        arb.insert(new Node("i", 10));
        arb_without_A.insert(new Node("i", 10));
        arb_without_AJ.insert(new Node("i", 10));
        arb_without_AJH.insert(new Node("i", 10));

        arb.insert(new Node("j", 12));
        arb_without_A.insert(new Node("j", 12));
    }

    @Test
    public void testDelete_A() {
        arb.delete("a");
        logger.info("\nArbre sans 'a' :\n" + arb.toString());
        assertTrue(arb.equals(arb_without_A));
    }

    @Test
    public void testDelete_AJ() {
        arb.delete("a");
        arb.delete("j");

        logger.info("\nArbre sans 'a' et 'j' :\n" + arb.toString());
        assertTrue(arb.equals(arb_without_AJ));
    }

    @Test
    public void testDelete_AJH() {
        arb.delete("a");
        arb.delete("j");
        arb.delete("h");

        logger.info("\nArbre sans 'a', 'j' et 'h' :\n" + arb.toString());
        assertTrue(arb.equals(arb_without_AJH));
    }
}
