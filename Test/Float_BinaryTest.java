import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Float_BinaryTest {
    @Test
    void binaryFloat_to_float_Test1(){
        float actual = NumberTransform.binaryFloat_to_Float("01001101110111000010000000000000");
        assertEquals(461635584.0f, actual);
    }
    @Test
    void binaryFloat_to_float_Test2(){
        float actual = NumberTransform.binaryFloat_to_Float("00111110101100010010011011101001");
        assertEquals(0.346f, actual);
    }
    @Test
    void binaryFloat_to_float_Test3(){
        float actual = NumberTransform.binaryFloat_to_Float("00110111110011011000010101011001");
        assertEquals(0.0000245f, actual);
    }
    @Test
    void binaryFloat_to_float_Test4(){
        float actual = NumberTransform.binaryFloat_to_Float("00110001000010001100000001110011");
        assertEquals(0.00000000199f, actual);
    }
    @Test
    void binaryFloat_to_float_Test5(){
        float actual = NumberTransform.binaryFloat_to_Float("01011000001001010010111001001001");
        assertEquals(726472864274652.0f, actual);
    }
    @Test
    void binaryFloat_to_float_Test6(){
        float actual = NumberTransform.binaryFloat_to_Float("00101111001111100011011100101100");
        assertEquals(0.000000000173f, actual);
    }
    @Test
    void binaryFloat_to_float_Test7(){
        float actual = NumberTransform.binaryFloat_to_Float("11000000101000000000000000000000");
        assertEquals(-5f, actual);
    }
    @Test
    void binaryFloat_to_float_Test8(){
        float actual = NumberTransform.binaryFloat_to_Float("10110010011001000111111000000101");
        assertEquals(-0.0000000133f, actual);
    }

    @Test
    void float_to_binary_test1(){
        String actual = NumberTransform.float_To_Binary(461635584.0f);
        assertEquals("01001101110111000010000000000000", actual);
    }
    @Test
    void float_to_binary_test2(){
        String actual = NumberTransform.float_To_Binary(0.346f);
        assertEquals("00111110101100010010011011101001", actual);
    }
    @Test
    void float_to_binary_test3(){
        String actual = NumberTransform.float_To_Binary(.0000245f);
        assertEquals("00110111110011011000010101011001", actual);
    }
    @Test
    void float_to_binary_test4(){
        String actual = NumberTransform.float_To_Binary(0.00000000199f);
        assertEquals("00110001000010001100000001110011", actual);
    }
    @Test
    void float_to_binary_test5(){
        String actual = NumberTransform.float_To_Binary(726472864274652.0f);
        assertEquals("01011000001001010010111001001001", actual);
    }
    @Test
    void float_to_binary_test6(){
        String actual = NumberTransform.float_To_Binary(-5f);
        assertEquals("11000000101000000000000000000000", actual);
    }
    @Test
    void float_to_binary_test7(){
        String actual = NumberTransform.float_To_Binary((float)0.000000000173);
        assertEquals("00101111001111100011011100101100", actual);
    }
    @Test
    void float_to_binary_test8(){
        String actual = NumberTransform.float_To_Binary(-0.0000000133f);
        assertEquals("10110010011001000111111000000101", actual);
    }

}
