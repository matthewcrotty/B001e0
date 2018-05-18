package edu.tjhsst.b001e0;

import android.media.Image;

/**
 * Created by Dylan on 5/18/2018.
 */

public class Card {
    private int type;
    private int input1;
    private int input2;
    private boolean inPlay;
    private Image cardDisplay;
    private Image[] imageArray;
    private int output;

    public Card(int card, int firstInput, int secondInput) {
        type = card;
        input1 = firstInput;
        input2 = secondInput;
        inPlay = true;

        if(card == 3 || card == 5 || card ==7) {
            output = 1;
        }
        else {
            output = 0;
        }
        for(int i = 0; i < 8; i++) {
            if(card == i) {
                cardDisplay = imageArray[i];
            }
        }
    }

    public Card(int card) {
        type = card;
        inPlay = false;


        for(int i = 0; i < 8; i++) {
            if(card == i) {
                cardDisplay = imageArray[i];
            }
        }
    }
}
