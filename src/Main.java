import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        printAllSevenPrimePalindroms("pi.txt",9);

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
        StringBuilder reverse = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString().equals(s);
    }

    public static boolean isPrim(long n) {
        for (int i = 2; i <= n / 2 + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printAllSevenPrimePalindroms(String fileName, int length){
        String s = readFile(fileName);
        String possiblePalindrom;
        int counter = 0;
        for (int i = 0; i < s.length()-length; i++) {
            possiblePalindrom=s.substring(i,i+length);
            if(isPalindrom(possiblePalindrom)){
                if (isPrim(toLong(possiblePalindrom))){
                    counter++;
                    System.out.println(counter + ".) Nachkomma-Stelle: "+(i-1)+",  Prim-Palindrom:  "+possiblePalindrom);
                }
            }
        }
    }

}