import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntToBinaryTest {

    @Test
    void intToBinaryTest1() {
        String s = NumberTransform.intToBinary(3);
        assertEquals("00000000000000000000000000000011", s);
    }
    @Test
    void intToBinaryTest2(){
        String s = NumberTransform.intToBinary(-213);
        assertEquals("11111111111111111111111100101011", s);
    }
    @Test
    void intToBinaryTest3(){
        String s = NumberTransform.intToBinary(66);
        assertEquals("00000000000000000000000001000010", s);
    }
    @Test
    void intToBinaryTest4(){
        String s = NumberTransform.intToBinary(2414151);
        assertEquals("00000000001001001101011001000111", s);
    }
    @Test
    void intToBinaryTest5(){
        String s = NumberTransform.intToBinary(-66);
        assertEquals("11111111111111111111111110111110", s);
    }
    @Test
    void intToBinaryTest6(){
        String s = NumberTransform.intToBinary(-1);
        assertEquals("11111111111111111111111111111111", s);
    }
    @Test
    void intToBinaryTest7(){
        String s = NumberTransform.intToBinary(2147483647);
        assertEquals("01111111111111111111111111111111", s);
    }
    @Test
    void intToBinaryTest8(){
        String s = NumberTransform.intToBinary(-2147483648);
        assertEquals("10000000000000000000000000000000", s);
    }


}