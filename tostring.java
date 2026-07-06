public class tostring {

    private static final char[] DIGITS =
        "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String toStrings(int value, int radix) {

        if (radix < 2 || radix > 36)
            radix = 10;

        if (value == 0)
            return "0";

        boolean negative = value < 0;

        long v = value;
        if (negative)
            v = -v;

        char[] buf = new char[33];
        int pos = 32;

        while (v > 0) {
            buf[pos--] = DIGITS[(int)(v % radix)];
            v /= radix;
        }

        if (negative)
            buf[pos--] = '-';

        return new String(buf, pos + 1, 32 - pos);
    }

    public static void main(String[] args) {
        System.out.println("\033c\033[47;31m\n");
        System.out.println(toStrings(123456789,10));
        System.out.println(toStrings(255,16));
        System.out.println(toStrings(255,2));
        System.out.println(toStrings(-255,16));

    }
}