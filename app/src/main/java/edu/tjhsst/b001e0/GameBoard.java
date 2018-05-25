package edu.tjhsst.b001e0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        createLookUp();
    }

    private void createLookUp() {
        parentLookUp = new HashMap<Integer, Set<Integer>>();
        Set<Integer> temp = new HashSet<Integer>();
        temp.add(1);
        temp.add(2);
        parentLookUp.put(0, temp);
        temp = new HashSet<Integer>();
        temp.add(3);
        temp.add(4);
        parentLookUp.put(1, temp);
        temp = new HashSet<Integer>();
        temp.add(4);
        temp.add(5);
        parentLookUp.put(2, temp);
        temp = new HashSet<Integer>();
        temp.add(6);
        temp.add(7);
        parentLookUp.put(3, temp);
        temp = new HashSet<Integer>();
        temp.add(7);
        temp.add(8);
        parentLookUp.put(4, temp);
        temp = new HashSet<Integer>();
        temp.add(8);
        temp.add(9);
        parentLookUp.put(5, temp);
        temp = new HashSet<Integer>();
        temp.add(10);
        temp.add(11);
        parentLookUp.put(6, temp);
        temp = new HashSet<Integer>();
        temp.add(11);
        temp.add(12);
        parentLookUp.put(7, temp);
        temp = new HashSet<Integer>();
        temp.add(12);
        temp.add(13);
        parentLookUp.put(8, temp);
        temp = new HashSet<Integer>();
        temp.add(13);
        temp.add(14);
        parentLookUp.put(9, temp);temp = new HashSet<Integer>();
        temp.add(15);
        temp.add(16);
        parentLookUp.put(10, temp);
        temp = new HashSet<Integer>();
        temp.add(16);
        temp.add(17);
        parentLookUp.put(11, temp);temp = new HashSet<Integer>();
        temp.add(17);
        temp.add(18);
        parentLookUp.put(12, temp);
        temp = new HashSet<Integer>();
        temp.add(18);
        temp.add(19);
        parentLookUp.put(13, temp);
        temp = new HashSet<Integer>();
        temp.add(19);
        temp.add(20);
        parentLookUp.put(14, temp);
        temp = new HashSet<Integer>();
        temp.add(15);
        temp.add(16);
        parentLookUp.put(21, temp);
        temp = new HashSet<Integer>();
        temp.add(16);
        temp.add(17);
        parentLookUp.put(22, temp);
        temp = new HashSet<Integer>();
        temp.add(17);
        temp.add(18);
        parentLookUp.put(23, temp);
        temp = new HashSet<Integer>();
        temp.add(18);
        temp.add(19);
        parentLookUp.put(24, temp);
        temp = new HashSet<Integer>();
        temp.add(19);
        temp.add(20);
        parentLookUp.put(25, temp);
        temp = new HashSet<Integer>();
        temp.add(21);
        temp.add(22);
        parentLookUp.put(26, temp);
        temp = new HashSet<Integer>();
        temp.add(22);
        temp.add(23);
        parentLookUp.put(27, temp);
        temp = new HashSet<Integer>();
        temp.add(23);
        temp.add(24);
        parentLookUp.put(28, temp);
        temp = new HashSet<Integer>();
        temp.add(24);
        temp.add(25);
        parentLookUp.put(29, temp);
        temp = new HashSet<Integer>();
        temp.add(26);
        temp.add(27);
        parentLookUp.put(30, temp);
        temp = new HashSet<Integer>();
        temp.add(27);
        temp.add(28);
        parentLookUp.put(31, temp);
        temp = new HashSet<Integer>();
        temp.add(28);
        temp.add(29);
        parentLookUp.put(32, temp);
        temp = new HashSet<Integer>();
        temp.add(30);
        temp.add(31);
        parentLookUp.put(33, temp);
        temp = new HashSet<Integer>();
        temp.add(31);
        temp.add(32);
        parentLookUp.put(34, temp);
        temp = new HashSet<Integer>();
        temp.add(33);
        temp.add(34);
        parentLookUp.put(35, temp);
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
