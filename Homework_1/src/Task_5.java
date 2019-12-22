import java.util.ArrayList;
import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        ArrayList<Character> tryLetters = new ArrayList<Character>();
        ArrayList<Character> tryWord = new ArrayList<Character>();
        int number = 0;
        int numberWord = 0;
        boolean guess = false;
        Scanner input = new Scanner(System.in);

        String name = "Liza Sandul";
        name = name.toUpperCase();
        String tempName = name.replaceAll("[a-zA-Z]", "*");
        System.out.println("Guess who?");

        try {
            do {
                System.out.println("Enter letter or name");
                String letter = input.nextLine().toUpperCase();
                if (letter.length() > 1) {
                    if (name.equals(letter)) {
                        System.out.println("You right. Congratulations!");
                        guess = true;
                    } else {
                        if (checkWord(name, letter)) {
                            insertLetter(letter, tryWord, numberWord);
                            tempName = highlightWord(name, tempName, tryWord);
                            System.out.println(tempName);
                            numberWord = 0;
                            System.out.println("Right word");
                            if (nameGuessed(name, tempName, tryLetters)) {
                                System.out.println("You guessed all letters in name. Congratulations!");
                                guess = true;
                            }
                        } else {
                            System.out.println("Wrong word");
                        }
                    }
                } else {
                    if (checkLetter(letter, tryLetters)) {
                        System.out.println("You have already entered this letter. Try another");
                    } else {
                        if (name.contains(letter)) {
                            System.out.println("It's right letter");
                            insertLetter(letter, tryLetters, number);
                            tempName = highlightLetters(name, tempName, tryLetters);
                            System.out.println(tempName);
                            if (nameGuessed(name, tempName, tryLetters)) {
                                System.out.println("You guessed all letters in name. Congratulations!");
                                guess = true;
                            }
                        } else {
                            System.out.println("This letter not contains in name. Try again.");
                        }

                    }
                }
            } while (guess == false);
        } catch (Exception e) {
            System.out.println("Check your input");
        }
    }

    private static void insertLetter(String letter, ArrayList<Character> allLetters, int number) {
        for (int i = 0; i < letter.length(); i++) {
            char stringArray = letter.charAt(i);
            allLetters.add(stringArray);
            number++;
        }
    }

    private static boolean checkLetter(String letter, ArrayList<Character> allLetters) {
        for (int i = 0; i < allLetters.size(); i++) {
            if (letter.equals(allLetters.get(i).toString()))
                return true;
        }
        return false;
    }

    private static boolean checkWord(String name, String letter) {
        name = " " + name + " ";
        letter = " " + letter + " ";
        if (name.contains(letter)) {
            return true;
        }
        return false;
    }

    private static String highlightWord(String name, String tempName, ArrayList<Character> allLetters) {
        char[] stringArray = tempName.toCharArray();
        for (int i = 0; i < allLetters.size(); i++) {
            String temp = allLetters.get(i).toString();
            if (name.contains(temp)) {
                int indexString = name.indexOf(allLetters.get(i));
                stringArray[indexString] = allLetters.get(i);
                char[] nameArray = name.toCharArray();
                nameArray[indexString] = ' ';
                name = String.copyValueOf(nameArray);
            }
        }
        tempName = String.copyValueOf(stringArray);
        return tempName;
    }

    private static String highlightLetters(String name, String tempName, ArrayList<Character> allLetters) {
        char[] stringArray = tempName.toCharArray();
        for (int j = 0; j < name.length(); j++) {
            for (int i = 0; i < allLetters.size(); i++) {
                String temp = allLetters.get(i).toString();
                if (name.contains(temp)) {
                    int indexString = name.indexOf(allLetters.get(i));
                    stringArray[indexString] = allLetters.get(i);
                    char[] nameArray = name.toCharArray();
                    nameArray[indexString] = ' ';
                    name = String.copyValueOf(nameArray);
                }
            }
        }
        tempName = String.copyValueOf(stringArray);
        return tempName;
    }

    private static boolean nameGuessed(String name, String tempName, ArrayList<Character> allLetters) {
        String nameGuess = highlightLetters(name, tempName, allLetters);
        if (nameGuess.contains("*"))
            return false;
        else
            return true;
    }
}
