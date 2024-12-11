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
        public void number2Int(){
            assertEquals(15, Ex1.number2Int("15bA"));
            assertEquals(15, Ex1.number2Int("15"));
            assertEquals(2, Ex1.number2Int("10b2"));
            assertEquals(1798, Ex1.number2Int("706bG"));
            assertEquals(153, Ex1.number2Int("231b8"));
            assertEquals(1, Ex1.number2Int("1b2"));
            assertEquals(-1, Ex1.number2Int("G1b2"));
            assertEquals(1, Ex1.number2Int("1"));
            assertEquals(-1, Ex1.number2Int(null));
        }

        @Test
        public void maxIndexTest() {
            // implement this test
            String[] arr1 = {"10", "1b2", "FAbG", "100bA"};
            assertEquals(2, Ex1.maxIndex(arr1));

            String[] arr = {"1b2", "10b2", "11b2", "100b2"};
            assertEquals(3, Ex1.maxIndex(arr));

        }
        @Test
        public void equals(){
            assertTrue(Ex1.equals("15", "15bA"));
            assertTrue(Ex1.equals("1010b2", "10bA"));
            assertTrue(Ex1.equals("A0b16", "160"));

            assertFalse(Ex1.equals("10", "19bG"));
            assertFalse(Ex1.equals("123bG", "123"));
            assertFalse(Ex1.equals("20b8", "16b10"));
         }
       }
