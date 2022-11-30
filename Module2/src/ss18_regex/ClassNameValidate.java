package ss18_regex;

public class ClassNameValidate {
    private static final String CLASSNAME_REGEX = "^[CAP][0-9]{4}[GHIKLM][0-1]$";

    public static boolean validate(String regex) {
        return regex.matches(CLASSNAME_REGEX);
    }

    public static void main(String[] args) {
        String str1 = "M0318G";
        String str2 = "C0722G1";
        System.out.println(validate(str1));
        System.out.println(validate(str2));
    }
}
