import java.util.HashMap;
import java.util.Map;

public class NumberTransform {

    /**
     * 将十进制整数(DEC.Integer)转换成二进制补码(BIN.Integer)
     * @param s 十进制整数的字符串表示
     * @return String 二进制补码
     */
    public static String decInt_to_binInt(String s){
        int rawInt = Integer.parseInt(s);
        StringBuilder sb = new StringBuilder();
        if (rawInt>=0){

            // 若为正数，调用Integer.toBinaryString()产生的字符串没有32位
            sb.append(0);
            for (int i=30; i>=0; i--){
                int t = rawInt/(int)Math.pow(2, i);
                sb.append(t);
                if (t == 1){
                    rawInt -= Math.pow(2, i);
                }
            }
            return sb.toString();
        }
        else {

            // 负数就直接可以调用Integer.toBinaryString()，返回32位字符串
            return Integer.toBinaryString(rawInt);
        }
    }


    /**
     * 将二进制补码(BIN.Integer)转换成十进制整数(DEC.Integer)
     * @param s 二进制补码
     * @return int 十进制整数
     */
    public static String binInt_to_decInt(String s){
        if (s.charAt(0) == '0'){
            return Integer.valueOf(s, 2).toString();
        }
        else {
            s = qu_fan(s);
            return Integer.toString(-Integer.valueOf(s, 2)-1);
        }
    }

    /**
     *
     * @param s 二进制补码
     * @return String 取反加的二进制编码，不加一，先转换成整数后再减一
     */
    private static String qu_fan(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<32; i++){
            if (s.charAt(i)=='0'){
                sb.append('1');
            }
            else {
                sb.append('0');
            }
        }
        return sb.toString();
    }


    /**
     * 将BIN.Float转换为DEC.Float
     * @param code (String)待转换的浮点数的32位二进制码
     * @return float 转换后的十进制浮点数
     */
    public String binaryDec_To_floatDec(String code){

        // 先按一般情况算着
        char sign = code.charAt(0);
        String exponentStr = code.substring(1, 9);
        String significantStr = code.substring(9, 32);
        int exponent = -127;
        for (int i=0; i<8; i++){
            if (exponentStr.charAt(i) == '1'){
                exponent += Math.pow(2, 7-i);
            }
        }
        float significant = 1.0f;
        for (int i=0; i<23; i++){
            if (significantStr.charAt(i) == '1'){
                significant += (float)Math.pow(2, -1-i);
            }
        }

        // 考虑一些特殊情况
        // 1. 当输入串全是为0时，不能按normal情况讨论
        if (code.equals("00000000000000000000000000000000")){
            return Float.toString(0.0f);
        } else if (code.equals("10000000000000000000000000000000")){
            return Float.toString(0.0f);
        } else if (code.equals("01111111100000000000000000000000")){
            return Float.toString(Float.POSITIVE_INFINITY);
        } else if (code.equals("11111111100000000000000000000000")){
            return Float.toString(Float.NEGATIVE_INFINITY);
        } else if (exponentStr.equals("11111111")){
            return Float.toString(Float.NaN);
        } else if (exponentStr.equals("00000000")){
            exponent = -126;
            significant -= 1.0f;
        }

        return Float.toString((float)(Math.pow(-1, Integer.parseInt(String.valueOf(sign)))*significant*Math.pow(2, exponent)));
    }


    /**
     * 将DEC.Float转换为BIN.Float
     * @param s 待转换的浮点数
     * @return (String)转换后的32位二进制码
     */
    public static String floatToBinary(String s){
        Float f = Float.parseFloat(s);
        // f上溢出时，对其赋值为最大值
        if (f>Float.MAX_VALUE){
            f = Float.MAX_VALUE;
        }
        int temp = Float.floatToIntBits(f);
        return decInt_to_binInt(Integer.toString(temp));
    }

    /**
     * 将DEC.Int转换为BCD
     * @param s
     * @return
     */
    public static String decInt_to_BCD(String s){
        int num = Integer.parseInt(s);
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0000");
        map.put(1, "0001");
        map.put(2, "0010");
        map.put(3, "0011");
        map.put(4, "0100");
        map.put(5, "0101");
        map.put(6, "0110");
        map.put(7, "0111");
        map.put(8, "1000");
        map.put(9, "1001");

        boolean positive = true;
        if (num<0){
            positive = false;
            num = -num;
        }
        int[] a = new int[7];
        for (int i=0; i<7; i++){
            a[i] = num/(int)Math.pow(10, 6-i);
            num -= a[i]*Math.pow(10, 6-i);
        }
        StringBuilder sb = new StringBuilder();
        if (positive){
            sb.append("1100");
        }
        else {
            sb.append("1101");
        }
        for (int i=0; i<7; i++){
            sb.append(map.get(a[i]));
        }
        return sb.toString();
    }

    /**
     * 将BCD转换为BIN.Int
     * @param bcd
     * @return
     */
    public static String BCD_to_decInt(String bcd){
        Map<String, Integer> map = new HashMap<>();
        map.put("0000", 0);
        map.put("0001", 1);
        map.put("0010", 2);
        map.put("0011", 3);
        map.put("0100", 4);
        map.put("0101", 5);
        map.put("0110", 6);
        map.put("0111", 7);
        map.put("1000", 8);
        map.put("1001", 9);

        int[] a = new int[7];
        int num = 0;
        for (int i=0; i<7; i++){
            a[i] = map.get(bcd.substring(4*i+4, 4*i+8));
            num += a[i]*Math.pow(10, 6-i);
        }
        if (bcd.substring(0, 4).equals("1100")){
            return Integer.toString(num);
        }
        else {
            return Integer.toString(-num);
        }
    }
}
