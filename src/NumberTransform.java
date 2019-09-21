public class NumberTransform {

    /**
     * 将十进制整数转换成二进制补码
     * @param rawInt 十进制整数
     * @return String 二进制补码
     */
    public static String intToBinary(int rawInt){
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
     * 将二进制补码转换成十进制整数
     * @param s 二进制补码
     * @return int 十进制整数
     */
    public static int binaryToInt(String s){
        if (s.charAt(0) == '0'){
            return Integer.valueOf(s, 2);
        }
        else {
            s = qu_fan(s);
            return -Integer.valueOf(s, 2)-1;
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
//        // 取反加一的操作，但是对于MIN_VALUE过不了用例
//        int jing_wei = 1;
//        for (int i=31; i>=0; i--){
//            int t = jing_wei + Integer.parseInt(String.valueOf(sb.charAt(i)));
//            if (t == 2){
//                sb.setCharAt(i, '0');
//                jing_wei = 1;
//            }
//            else if (t == 1){
//                sb.setCharAt(i, '1');
//                jing_wei = 0;
//            }
//            else {
//                sb.setCharAt(i, '0');
//                jing_wei = 0;
//            }
//        }
        return sb.toString();
    }

    public float binaryFloat_to_Float(){
        return 0;
    }
    public String floatToBinary(){
        return "";
    }

    public static void main(String[] args) {
    }
}
