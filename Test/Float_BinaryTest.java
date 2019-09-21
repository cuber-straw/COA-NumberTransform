import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Float_BinaryTest {
    @Test
    void binaryFloat_to_float_Test1(){
        float actual = NumberTransform.binaryFloat_to_Float("01001101110111000010000000000000");
        assertEquals((float)461635584.0, actual);
    }
    @Test
    void binaryFloat_to_float_Test2(){
        float actual = NumberTransform.binaryFloat_to_Float("00111110101100010010011011101001");
        assertEquals((float)0.346, actual);
    }
    @Test
    void binaryFloat_to_float_Test3(){
        float actual = NumberTransform.binaryFloat_to_Float("00110111110011011000010101011001");
        assertEquals((float)0.0000245, actual);
    }
    @Test
    void binaryFloat_to_float_Test4(){
        float actual = NumberTransform.binaryFloat_to_Float("00110001000010001100000001110011");
        assertEquals((float)0.00000000199, actual);
    }
    @Test
    void binaryFloat_to_float_Test5(){
        float actual = NumberTransform.binaryFloat_to_Float("01011000001001010010111001001001");
        assertEquals((float)726472864274652.0, actual);
    }
    @Test
    void binaryFloat_to_float_Test6(){
        float actual = NumberTransform.binaryFloat_to_Float("00101111001111100011011100101100");
        assertEquals((float)0.000000000173, actual);
    }


}
