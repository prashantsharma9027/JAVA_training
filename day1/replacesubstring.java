package day1;
public class replacesubstring {
    // replace a substring in a string with another string
    public static void main(String[] args) {
        String s = "hello world prashant";
        String s2 = "prashant";
        String s3 = "sharma";
        s = s.replace(s2, s3);
        System.out.println(s);
    }
}
