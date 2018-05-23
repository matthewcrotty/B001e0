package edu.tjhsst.b001e0;

import java.util.ArrayList;

/**
 * Created by Dylan on 5/23/2018.
 */

public class GameBoard{
    private int[] gameMatrix;
    private ArrayList<Card> hand1;
    private ArrayList<Card> hand2;

    private GameBoard(){
        gameMatrix = new int[36];
        for(int x = 0; x < 5; x++) {
            hand1.add(new Card((int)(Math.random() * 7)));
            hand2.add(new Card((int)(Math.random() * 7)));
        }
    }
}
