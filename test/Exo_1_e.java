import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo_1_e {
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
    public void testSearchNonExistentNode() {
        Node result = arb.searchKey("z");
        assertNull(result);
    }

    @Test
    public void testTreeStructure() {
        Node root = arb.getRoot();
        assertEquals("h", root.getKey());

        assertEquals("d", root.getChildLeft().getKey());
        assertEquals("b", root.getChildLeft().getChildLeft().getKey());
        assertEquals("a", root.getChildLeft().getChildLeft().getChildLeft().getKey());
        assertNull(root.getChildLeft().getChildLeft().getChildLeft().getChildLeft());
        assertNull(root.getChildLeft().getChildLeft().getChildLeft().getChildRight());
        assertEquals("c", root.getChildLeft().getChildLeft().getChildRight().getKey());
        assertNull(root.getChildLeft().getChildLeft().getChildRight().getChildLeft());
        assertNull(root.getChildLeft().getChildLeft().getChildRight().getChildRight());
        assertEquals("e", root.getChildLeft().getChildRight().getKey());
        assertNull(root.getChildLeft().getChildRight().getChildLeft());
        assertEquals("f", root.getChildLeft().getChildRight().getChildRight().getKey());
        assertNull(root.getChildLeft().getChildRight().getChildRight().getChildLeft());
        assertEquals("g", root.getChildLeft().getChildRight().getChildRight().getChildRight().getKey());
        assertNull(root.getChildLeft().getChildRight().getChildRight().getChildRight().getChildLeft());
        assertNull(root.getChildLeft().getChildRight().getChildRight().getChildRight().getChildRight());

        assertEquals("i", root.getChildRight().getKey());
        assertNull(root.getChildRight().getChildLeft());
        assertEquals("j", root.getChildRight().getChildRight().getKey());
        assertNull(root.getChildRight().getChildRight().getChildLeft());
        assertNull(root.getChildRight().getChildRight().getChildRight());
    }
}