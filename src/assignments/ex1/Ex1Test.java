package assignments.ex1;

import org.junit.Test;

import static assignments.ex1.Ex1.int2Number;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        public void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        public void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        public void int2NumberTest() {
            assertEquals("15b10", int2Number(15, 10));
            assertEquals("11b2", int2Number(3, 2));
            assertEquals("222b8", int2Number(146, 8));
            assertEquals("Fb16", int2Number(15, 16));
            assertEquals("", int2Number(-2, 10));
            assertEquals("", int2Number(5, 17));
            assertEquals("0", int2Number(0, 2));
        }
        @Test
        public void maxIndexTest() {
            // implement this test
        }

        // Add additional test functions - test as much as you can.
    }
