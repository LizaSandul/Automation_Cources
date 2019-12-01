import java.util.ArrayList;
import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        ArrayList <String> tryLetters = new ArrayList<String>();
        String tempStringName ;
        int number = 0;
        boolean guess = false;
        Scanner input = new Scanner(System.in);

        String name = "Liza Sandul";
        name= name.toUpperCase();
        System.out.println("Guess who?");

        try {
            do {
                System.out.println("Enter letter or name");
                String letter = input.next().toUpperCase();
                if (letter.length() != 1) {
                    if (name.equals(letter)){
                        System.out.println("You right. Congratulations!");
                        guess=true;
                    }
                    else {
                        System.out.println("You missed, Try again");
                    }
                }
                else {
                    if (checkLetter(letter, tryLetters)) {
                        System.out.println("You have already entered this letter. Try another");
                    }
                    else{
                        if (name.contains(letter)) {
                            System.out.println("It's right letter");
                            insertLetter(letter, tryLetters, number);
                            tempStringName = highlightLetters(name, tryLetters);
                            System.out.println(tempStringName);
                            if (nameGuessed(name,tryLetters)){
                                System.out.println("You guessed all letters in name. Congratulations!");
                                guess = true;
                            }
                        }
                        else{
                            System.out.println("This letter not contains in name. Try again.");
                        }
                    }
                }
            } while (guess == false);
        }
        catch (Exception e){
            System.out.println("Check your input");
        }
    }

    public static void insertLetter(String letter, ArrayList <String> allLetters, int number){
        allLetters.add(letter);
        number++;
    }

    public static boolean checkLetter(String letter,  ArrayList<String> allLetters){
        for (int i=0; i< allLetters.size(); i++){
            if (letter.equals(allLetters.get(i)))
                return true;
        }
        return  false;
    }

    public static String highlightLetters(String name,  ArrayList <String> allLetters){
        String tempString = name.replaceAll( "[a-zA-Z]","*");
        char [] stringArray = tempString.toCharArray();
        for (int j=0; j < name.length(); j++){
            for (int i=0; i < allLetters.size(); i++){
                if (name.contains(allLetters.get(i))) {
                    int indexString = name.indexOf(allLetters.get(i));
                    char [] lettersArray = allLetters.get(i).toCharArray();
                    stringArray[indexString] = lettersArray[0];
                    char [] nameArray = name.toCharArray();
                    nameArray[indexString] = ' ';
                    name = String.copyValueOf(nameArray);
                }
            }
        }
        tempString = String.copyValueOf(stringArray);
        return tempString;
    }

    public static boolean nameGuessed (String name, ArrayList <String> allLetters){
        String nameGuess= highlightLetters(name, allLetters);
        if (nameGuess.contains("*"))
            return false;
        else
            return true;
    }
}
