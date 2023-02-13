import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrom("lagerregal"));
        System.out.println(isPrim(toLong("13")));
    }
public static long toLong(String s){return Long.parseLong(s);}

    public static String readFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (Exception e) {
            System.err.printf("ERROR: can't read file: \"%s\"\n",
                    Paths.get(fileName).toAbsolutePath());
            System.exit(1);
        }
        return "";
    }

    public static boolean isPalindrom(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        if (reverse.equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrim(long n) {
        for (int i = 2; i <= n / 2 + 1; i++) {
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }


}