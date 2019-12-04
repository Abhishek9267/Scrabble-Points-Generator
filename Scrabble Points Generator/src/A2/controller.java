/**
 * Owen Brown
 * COMP 1011
 * Assignment 2
 * December 2019
 *      This is the controller class for the Scrabble Generator program
 */

package A2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class controller {

    @FXML
    Label points;
    @FXML
    TextField input;
    @FXML
    TextArea output;
    @FXML
    Label NumA, NumB, NumC, NumD, NumE, NumF, NumG, NumH, NumI, NumJ, NumK, NumL, NumM, NumN, NumO, NumP, NumQ, NumR, NumS, NumT, NumU, NumV, NumW, NumX, NumY, NumZ ;

    Model m = new Model();

    //                                   0  1  2  3  4   5  6  7  8  9 10  11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
    //                                   a  b  c  d  e   f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
    int[] lettersStartArray = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 8, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
    int[] lettersLeftArray = lettersStartArray;


    @FXML
    /**
     * initialize method - starts the game and sets variable defaults
     */
    public void initialize() {
        points.setText("0");
        updateLetters();
    }

    @FXML
    /**
     * submit method - executes the program when submit button is clicked
     */
    public void submit(ActionEvent ae) {

        String a = input.getText();
        a = a.toLowerCase();

        if(m.validate(a)) {

            m.addWord(a);
            output.setText(m.getHistory());
            points.setText(m.getPoints());

            lettersLeftArray = m.getLettersLeft();
            updateLetters();

            input.clear();

            m.checkIfGameOver();

        } else {
            System.out.println("issue");
        }
    }

    /**
     * updateLetters method - updates the GUI to the current letters left in play
     */
    private void updateLetters() {
        NumA.setText(Integer.toString(lettersLeftArray[0]));
        NumB.setText(Integer.toString(lettersLeftArray[1]));
        NumC.setText(Integer.toString(lettersLeftArray[2]));
        NumD.setText(Integer.toString(lettersLeftArray[3]));
        NumE.setText(Integer.toString(lettersLeftArray[4]));
        NumF.setText(Integer.toString(lettersLeftArray[5]));
        NumG.setText(Integer.toString(lettersLeftArray[6]));
        NumH.setText(Integer.toString(lettersLeftArray[7]));
        NumI.setText(Integer.toString(lettersLeftArray[8]));
        NumJ.setText(Integer.toString(lettersLeftArray[9]));
        NumK.setText(Integer.toString(lettersLeftArray[10]));
        NumL.setText(Integer.toString(lettersLeftArray[11]));
        NumM.setText(Integer.toString(lettersLeftArray[12]));
        NumN.setText(Integer.toString(lettersLeftArray[13]));
        NumO.setText(Integer.toString(lettersLeftArray[14]));
        NumP.setText(Integer.toString(lettersLeftArray[15]));
        NumQ.setText(Integer.toString(lettersLeftArray[16]));
        NumR.setText(Integer.toString(lettersLeftArray[17]));
        NumS.setText(Integer.toString(lettersLeftArray[18]));
        NumT.setText(Integer.toString(lettersLeftArray[19]));
        NumU.setText(Integer.toString(lettersLeftArray[20]));
        NumV.setText(Integer.toString(lettersLeftArray[21]));
        NumW.setText(Integer.toString(lettersLeftArray[22]));
        NumX.setText(Integer.toString(lettersLeftArray[23]));
        NumY.setText(Integer.toString(lettersLeftArray[24]));
        NumZ.setText(Integer.toString(lettersLeftArray[25]));
    }


}
