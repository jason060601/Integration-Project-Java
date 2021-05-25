import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
// <Jason Exantus>
// Hangman - a simple command line implementation of hangman
// The user inputs a char at a time. If the char is in the word (WORD),
// you get the letter. If you guess every letter, you win. 
// If you guess incorrectly too many times, you lose.
 
// Primitive Data Types
// byte - Stores whole numbers from -128 to 127
// short -  Stores whole numbers from -32,768 to 32,767
// int - Stores whole numbers from -2,147,483,648 to 2,147,483,647
// long - Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
// float - Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
// double - Stores fractional numbers. Sufficient for storing 15 decimal digits
// boolean - Stores true or false values
// char - Stores a single character/letter or ASCII values
 
public class Main {
 
    private final String WORD = "Test Word";
    private final int INCORRECT_GUESS_LIMIT = 6;
    
    // Holds the values for guessed chars in word
    private char[] wordProgress = new char[WORD.length()];
    
    private List<String> wordBank = new ArrayList<String>();
    private boolean isRunning = true;
    private int incorrectGuesses = 0;
    
    private double randomDouble = 0.0;
    
    // Variable: a holder for data held in memory
    // Scope: Defines where a variable or method can be accessed from within the program
    
    public static void main(String[] args) {
        System.out.println("Greetings! Starting game...");
        new Main();
        
    }
    
    public Main() {
        RunGameLoop();
    }
    
    public void RunGameLoop() {
        Scanner scanner = new Scanner(System.in);
        while(isRunning) {
            System.out.println("Please input a single character");
            String nextLine = scanner.nextLine();
            if(nextLine.length() == 1) {
                char input = nextLine.charAt(0);
                processInput(input);
                wordBank.add(nextLine);
            } else {
                System.out.println("Please only input one character");
                continue;
            }
        }
        
        scanner.close();
    }
 
    /**
     * Handles game logic after user specifies input
     * @param input
     */
    private void processInput(char input) {
        if(charIsInWordBank(input)) {
            System.out.println("You've already guessed that!");
        } else {
            if(inputIsInWord(input)) {
                int index = WORD.indexOf(input);
                wordProgress[index] = input;
                System.out.println("You've guessed a character!");
            } else {
                incorrectGuesses++;
                System.out.println("That character is not in the word!");
            }
            checkForGameOver();
        }
    }
 
    /**
     * @param Input
     * @return True or False depending on if the input is in the word bank
     */
    private boolean charIsInWordBank(char c) {
        for(String x : wordBank) {
            if(x == c + "")
                return true;
        }
        return false;
    }
    
    /**
     * Checks if the given input is in the word
     * @param input User in
     * @return
     */
    private boolean inputIsInWord(char input) {
        return WORD.indexOf(input) != -1;
    }
    
    private void checkForGameOver() {
        //TODO check for too many incorrect answers
        //TODO check if player guessed entire word
    }
}