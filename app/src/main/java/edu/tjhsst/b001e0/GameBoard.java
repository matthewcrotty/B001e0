package edu.tjhsst.b001e0;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dylan on 5/23/2018.
 */

public class GameBoard{
    private int[] gameMatrix;
    private Map<Integer, Set<Integer>> parentLookUp;
    private ArrayList<Card> hand1;
    private ArrayList<Card> hand2;
    private boolean hand1Turn;

    private GameBoard(){
        gameMatrix = new int[36];
        for(int x = 0; x < 5; x++) {
            hand1.add(new Card((int)(Math.random() * 7)));
            hand2.add(new Card((int)(Math.random() * 7)));
        }
        hand1 = drawCard((hand1));
        hand1Turn = true;
    }

    private void createLookUp() {

    }

    private ArrayList<Card> drawCard(ArrayList<Card> hand) {
        hand.add(new Card((int)(Math.random() * 7)));
        return hand;
    }

    private void switchTurns() {
        if(hand1Turn) {
            hand1Turn = false;
            hand2 = drawCard(hand2);
        }
        else {
            hand1Turn = true;
            hand1 = drawCard(hand1);
        }
    }

    private boolean isValidMove(int card, int pos) {

        return false;
    }

    private void makeMove(int card, int pos) {
        if(isValidMove(card, pos)) {
            gameMatrix[pos] = card;
        }
    }

    public int[] getGameMatrix() {
        return gameMatrix;
    }

    public ArrayList<Card> getHand1() {
        return hand1;
    }

    public ArrayList<Card> getHand2() {
        return hand2;
    }

    public boolean isHand1Turn() {
        return hand1Turn;
    }
}
