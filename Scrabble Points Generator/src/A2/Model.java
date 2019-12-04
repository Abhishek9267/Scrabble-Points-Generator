/**
 * Owen Brown
 * COMP 1011
 * Assignment 2
 * December 2019
 *      This is the model class for the Scrabble Generator program
 */

package A2;

import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {

    int points = 0;

    //arrays
    int[] letterPointsArray = new int[] {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    char[] letterArray = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    int[] lettersLeftArray = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 8, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};

    ArrayList<String> history = new ArrayList<String>();

    //have to include this temp array to update the letters to properly validate them
    int[] lettersLeftArrayTEMP = lettersLeftArray;

    //variable that checks if there are enough remaining letters
    boolean check = false;

    /**
     * getPoints accessor method
     * @return points
     */
    protected String getPoints() {
        return Integer.toString(points);
    }

    /**
     * getLetterLeft accessor method
     * @return lettersLeftArray
     */
    protected int[] getLettersLeft() {
        return lettersLeftArray;
    }

    /**
     * getHistory accessor method
     * @return the history array as a string
     */
    protected String getHistory(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < history.size(); i++) {
            sb.append(history.get(i));

            if(i != history.size() - 1) {
                sb.append(",  ");
            }
        }
        return sb.toString();
    }

    /**
     * validate method - returns true if the word is valid, otherwise false
     * @param input - the user inputted word
     * @return if the word is valid or not
     */
    protected boolean validate(String input) {

        //update the temp array and the check variable for each new letter
        lettersLeftArrayTEMP = lettersLeftArray.clone();

        //check if the word is between 1 and 8 letters and contains at least one vowel and has not been submitted already
        if ((input.length() > 1 && input.length() <= 8) && !history.contains(input) &&
                (input.contains("a") || input.contains("e") || input.contains("i") || input.contains("o") || input.contains("u") || input.contains("y"))) {
            //loop through the user inputted string
            for (int i = 0; i < input.length(); i++) {
                check = false;
                //loop through all letters
                for (int j = 0; j < letterArray.length; j++) {
                    //found a match so check if there are enough letters left in play
                    if (input.charAt(i) == letterArray[j] && lettersLeftArrayTEMP[j] > 0) {
                        lettersLeftArrayTEMP[j]--;
                        check = true;
                    }
                }
                //if this is reached then there is not enough letters left
                if (check == false) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Not enough " + input.charAt(i) + "'s left ");
                    alert.show();

                    return check;
                }
            }
            //if it makes it here then the word is good
            return true;
        } else {
            //input is blank
            if(input.length() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Input field is blank. ");
                alert.show();
            }
            //input is only 1 letter
            else if (input.length() == 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Word is too short. ");
                alert.show();
            }
            //input is more than 8 letters
            else if (input.length() > 8) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Word is too long. ");
                alert.show();
            }
            //input has already been entered
            else if (history.contains(input)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Word has already been entered. ");
                alert.show();
            }
            //input has no vowels
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Word contains no vowels. ");
                alert.show();
            }
            //word did not pass validation
            return false;
        }
    }

    /**
     * addWord method - adds the points from the word to the users total and removes the letters from play
     * @param input - the user inputted string
     */
    protected void addWord(String input) {
        //add the word to the history array
        history.add(input);

        //input string loop
        for(int i = 0; i < input.length(); i++) {
            //letter array loop
            for(int j = 0; j < letterArray.length; j++) {
                //found the index
                if(input.charAt(i) == letterArray[j]) {
                    //add points
                    points += letterPointsArray[j];
                    //take away letter
                    lettersLeftArray[j]--;
                }
            }
        }
    }

    /**
     * checkIfGameOver method - alerts the user when the game is over
     */
    protected void checkIfGameOver() {
        int sum = Arrays.stream(lettersLeftArray).sum();
        //not enough letters left
        if (sum <= 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Not enough letters remaining to form a word. ");
            alert.show();
        }
        //no vowels left
        else if(lettersLeftArray[0] == 0 && lettersLeftArray[4] == 0 && lettersLeftArray[8] == 0 && lettersLeftArray[14] == 0 && lettersLeftArray[20] == 0 && lettersLeftArray[24] == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No vowels remaining.");
            alert.show();
        }

    }
}
