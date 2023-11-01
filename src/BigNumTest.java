import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BigNumTest {

    @Test
    public void addTest() {
        BigNumArithmetic bn = new BigNumArithmetic();
        //create 2 LLists to be added
        LList a = new LList();
        LList b = new LList();
        //append values to LLists
        a.append(9);
        a.append(9);
        b.append(1);

        assertEquals("100", bn.toString(bn.add(a, b)));

        a.clear();
        b.clear();

        a.append(9);
        a.append(9);
        a.append(9);

        b.append(1);
        assertEquals("1000", bn.toString(bn.add(a,b)));

        a.clear();
        b.clear();
        a.append(4);
        a.append(3);
        a.append(2);
        a.append(1);

        b.append(0);
        b.append(0);



        assertEquals("1234", bn.toString(bn.add(a,b)));

        a.clear();
        b.clear();
        a.append(0);
        assertEquals("0",bn.toString(bn.add(a,b)));
    }
}