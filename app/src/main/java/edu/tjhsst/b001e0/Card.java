package edu.tjhsst.b001e0;

/**
 * Created by Dylan on 5/18/2018.
 */

public class Card {
    private int type;
    private int input1;
    private int input2;
    private boolean inPlay;
    private ImageIcon image;
    private ImageIcon[] imageArray;
    private int[] outputTable [[0],[0],[]];
    private int output;

    public Card(int card, int firstInput, int secondInput) {
        type = card;
        input1 = firstInput;
        input2 = secondInput;
        inPlay = true;


        for(int i = 0; i < 8; i++) {
            if(card == i) {
                image = imageArray[i];
                output = outputTable[i][firstInput+secondInput];
            }
        }
    }

    public Card(int card) {
        type = card;
        inPlay = false;


        for(int i = 0; i < 8; i++) {
            if(card == i) {
                image = imageArray[i];
            }
        }
    }
}
