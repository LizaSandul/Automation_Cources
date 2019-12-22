import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string ");
        String originString = input.nextLine();

        String stringReverce = stringReverce(originString);
        System.out.println("Reverce string: " + stringReverce);
        String[] words = stringToWords(originString);
        System.out.println("All words: ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        String changedSpaces = changeSpaces(originString);
        System.out.println("String with *: " + changedSpaces);
        String upperCaseString = upperCaseString(originString);
        System.out.println("String upper case: " + upperCaseString);
        String subString = subString(originString, 5, 10);
        System.out.println("Substing: " + subString);
    }

    private static String stringReverce(String originString) {
        StringBuilder sb = new StringBuilder();
        sb.append(originString);
        String reverceString = sb.reverse().toString();

        return reverceString;
    }

    private static String[] stringToWords(String originString) {
        String[] words = originString.replaceAll("\\s{2,}", " ").split("\\s");
        return words;
    }

    private static String changeSpaces(String originString) {
        String changedString = originString.replace(' ', '*');
        return changedString;
    }

    private static String upperCaseString(String originString) {
        String upperCaseString = originString.toUpperCase();
        return upperCaseString;
    }

    private static String subString(String originString, int from, int to) {
        String subString = originString.substring(from, to);
        return subString;
    }
}
