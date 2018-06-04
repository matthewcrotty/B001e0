package edu.tjhsst.b001e0;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Dylan on 5/18/2018.
 */

public class Card{
    private int type;
    private int input1;
    private int input2;
    private boolean inPlay;
    private String pictureName;
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
        if(card == 0) {
            pictureName = "not";
        }
        else if(card == 1) {
            pictureName = "initial_binary.png";
        }
        else if(card == 2) {
            pictureName = "and0";
        }
        else if(card == 3) {
            pictureName = "and1";
        }
        else if(card == 4) {
            pictureName = "or0";
        }
        else if(card == 5) {
            pictureName = "or1";
        }
        else if(card == 6) {
            pictureName = "xor0";
        }
        else if(card == 7) {
            pictureName = "xor1";
        }
    }

    public Card(int card) {
        type = card;
        inPlay = false;

        if(card == 0) {
            pictureName = "not";
        }
        else if(card == 1) {
            pictureName = "initial_binary.png";
        }
        else if(card == 2) {
            pictureName = "and0";
        }
        else if(card == 3) {
            pictureName = "and1";
        }
        else if(card == 4) {
            pictureName = "or0";
        }
        else if(card == 5) {
            pictureName = "or1";
        }
        else if(card == 6) {
            pictureName = "xor0";
        }
        else if(card == 7) {
            pictureName = "xor1";
        }

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getInput1() {
        return input1;
    }

    public void setInput1(int input1) {
        this.input1 = input1;
    }

    public int getInput2() {
        return input2;
    }

    public void setInput2(int input2) {
        this.input2 = input2;
    }

    public boolean isInPlay() {
        return inPlay;
    }

    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}
