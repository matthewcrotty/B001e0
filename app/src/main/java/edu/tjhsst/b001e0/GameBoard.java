package edu.tjhsst.b001e0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dylan on 5/23/2018.
 */

public class GameBoard{
    private int[] gameMatrix;
    private Map<Integer, Set<Integer>> parentLookUp;
    private Map<Integer, Set<Integer>> childLookUp;
    private ArrayList<Card> hand1;
    private ArrayList<Card> hand2;
    private boolean hand1Turn;

    private GameBoard(){
        gameMatrix = new int[36];
        for(int x = 0; x < gameMatrix.length; x++) {
            gameMatrix[x] = -1;
        }
        for(int x = 0; x < 5; x++) {
            hand1 = drawCard(hand1);
            hand2 = drawCard(hand2);
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

        childLookUp = new HashMap<Integer, Set<Integer>>();
        temp = new HashSet<Integer>();
        temp.add(0);
        childLookUp.put(1, temp);
        temp = new HashSet<Integer>();
        temp.add(0);
        childLookUp.put(2, temp);
        temp = new HashSet<Integer>();
        temp.add(1);
        childLookUp.put(3, temp);
        temp = new HashSet<Integer>();
        temp.add(1);
        temp.add(2);
        childLookUp.put(4, temp);
        temp = new HashSet<Integer>();
        temp.add(2);
        childLookUp.put(5, temp);
        temp = new HashSet<Integer>();
        temp.add(3);
        childLookUp.put(6, temp);
        temp = new HashSet<Integer>();
        temp.add(3);
        temp.add(4);
        childLookUp.put(7, temp);
        temp = new HashSet<Integer>();
        temp.add(4);
        temp.add(5);
        childLookUp.put(8, temp);
        temp = new HashSet<Integer>();
        temp.add(5);
        childLookUp.put(9, temp);
        temp = new HashSet<Integer>();
        temp.add(6);
        childLookUp.put(10, temp);
        temp = new HashSet<Integer>();
        temp.add(6);
        temp.add(7);
        childLookUp.put(11, temp);
        temp = new HashSet<Integer>();
        temp.add(7);
        temp.add(8);
        childLookUp.put(12, temp);
        temp = new HashSet<Integer>();
        temp.add(8);
        temp.add(9);
        childLookUp.put(13, temp);
        temp = new HashSet<Integer>();
        temp.add(9);
        childLookUp.put(14, temp);
        temp = new HashSet<Integer>();
        temp.add(10);
        temp.add(21);
        childLookUp.put(15, temp);
        temp = new HashSet<Integer>();
        temp.add(10);
        temp.add(11);
        temp.add(21);
        temp.add(22);
        childLookUp.put(16, temp);
        temp = new HashSet<Integer>();
        temp.add(11);
        temp.add(12);
        temp.add(22);
        temp.add(23);
        childLookUp.put(17, temp);
        temp = new HashSet<Integer>();
        temp.add(12);
        temp.add(13);
        temp.add(23);
        temp.add(24);
        childLookUp.put(18, temp);
        temp = new HashSet<Integer>();
        temp.add(13);
        temp.add(14);
        temp.add(24);
        temp.add(25);
        childLookUp.put(19, temp);
        temp = new HashSet<Integer>();
        temp.add(14);
        temp.add(25);
        childLookUp.put(20, temp);
        temp = new HashSet<Integer>();
        temp.add(26);
        childLookUp.put(21, temp);
        temp = new HashSet<Integer>();
        temp.add(26);
        temp.add(27);
        childLookUp.put(22, temp);
        temp = new HashSet<Integer>();
        temp.add(27);
        temp.add(28);
        childLookUp.put(23, temp);
        temp = new HashSet<Integer>();
        temp.add(28);
        temp.add(29);
        childLookUp.put(24, temp);
        temp = new HashSet<Integer>();
        temp.add(29);
        childLookUp.put(25, temp);
        temp = new HashSet<Integer>();
        temp.add(30);
        childLookUp.put(26, temp);
        temp = new HashSet<Integer>();
        temp.add(30);
        temp.add(31);
        childLookUp.put(27, temp);
        temp = new HashSet<Integer>();
        temp.add(31);
        temp.add(32);
        childLookUp.put(28, temp);
        temp = new HashSet<Integer>();
        temp.add(32);
        childLookUp.put(29, temp);
        temp = new HashSet<Integer>();
        temp.add(33);
        childLookUp.put(30, temp);
        temp = new HashSet<Integer>();
        temp.add(33);
        temp.add(34);
        childLookUp.put(31, temp);
        temp = new HashSet<Integer>();
        temp.add(34);
        childLookUp.put(32, temp);
        temp = new HashSet<Integer>();
        temp.add(35);
        childLookUp.put(33, temp);
        temp = new HashSet<Integer>();
        temp.add(35);
        childLookUp.put(34, temp);
    }

    private ArrayList<Card> drawCard(ArrayList<Card> hand) {
        int card = (int)(Math.random() * 7 + 1);
        if(card == 1) {
            card = 0;
        }
        hand.add(new Card(card));
        return hand;
    }

    private void playNot(int pos) {
        if(gameMatrix[pos] == 1) {
            gameMatrix[pos] = 8;
        }
        else {
            gameMatrix[pos] = 1;
        }
        Set<Integer> children = childLookUp.get(pos);
        for(Integer index : children){
            validityHelper(index);
        }
    }

    private void validityHelper(int index) {
        boolean works = true;
        Set<Integer> parents = parentLookUp.get(index);
        for(Integer parent : parents) {
            if(gameMatrix[parent] == -1) {
                works = false;
            }
        }
        if(works) {
            if(!isValidMove(gameMatrix[index], index)) {
                gameMatrix[index] = -1;
            }
        }
        if(childLookUp.containsKey(index)) {
            Set<Integer> children = childLookUp.get(index);
            for(Integer child : children) {
                validityHelper(child);
            }
        }
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
        Set<Integer> parents = parentLookUp.get(pos);
        Set<Integer> parentCards = new HashSet<>();
        for(Integer parent : parents){
            parentCards.add(gameMatrix[parent]);
        }
        if(card == 2) {
            if (parentCards.size() == 2) {
                if ((parentCards.contains(3) && parentCards.contains(5)) || (parentCards.contains(5) && parentCards.contains(7)) || (parentCards.contains(7) && parentCards.contains(3)) || (parentCards.contains(8) && parentCards.contains(1))) {
                    return false;
                }
                return true;
            }
            else {
                if (parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7)) {
                    return false;
                }
                if (pos < 18) {
                    if (parentCards.contains(1)) {
                        return false;
                    }
                    return true;
                }
                else {
                    if (parentCards.contains(8)) {
                        return false;
                    }
                    return true;
                }
            }
        }
        if(card == 3) {
            if (parentCards.size() == 2) {
                if ((parentCards.contains(3) && parentCards.contains(5)) || (parentCards.contains(5) && parentCards.contains(7)) || (parentCards.contains(7) && parentCards.contains(3)) || (parentCards.contains(8) && parentCards.contains(1))) {
                    return true;
                }
                return false;
            }
            else {
                if (parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7)) {
                    return true;
                }
                if (pos < 18) {
                    if (parentCards.contains(1)) {
                        return true;
                    }
                    return false;
                }
                else {
                    if (parentCards.contains(8)) {
                        return true;
                    }
                    return false;
                }
            }
        }
        if(card == 4) {
            if(parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7)) {
                return false;
            }
            if(pos < 18) {
                if(parentCards.contains(1)) {
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                if(parentCards.contains(8)) {
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        if(card == 5) {
            if(parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7)) {
                return true;
            }
            if(pos < 18) {
                if(parentCards.contains(1)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                if(parentCards.contains(8)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        if(card == 6) {
            if(parentCards.size() == 2) {
                if((parentCards.contains(3) && (parentCards.contains(5) || parentCards.contains(7))) || (parentCards.contains(5) && (parentCards.contains(7) || parentCards.contains(3))) || (parentCards.contains(7) && (parentCards.contains(3) || parentCards.contains(5)))) {
                    return true;
                }
                if((parentCards.contains(2) && (parentCards.contains(4) || parentCards.contains(6))) || (parentCards.contains(4) && (parentCards.contains(6) || parentCards.contains(2))) || (parentCards.contains(6) && (parentCards.contains(2) || parentCards.contains(4)))) {
                    return true;
                }
                if(pos < 18) {
                    if(parentCards.contains(1) && (parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7))) {
                        return true;
                    }
                    if(parentCards.contains(8) && (parentCards.contains(2) || parentCards.contains(4) || parentCards.contains(6))) {
                        return true;
                    }
                }
                else {
                    if(parentCards.contains(1) && (parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7))) {
                        return true;
                    }
                    if(parentCards.contains(8) && (parentCards.contains(2) || parentCards.contains(4) || parentCards.contains(6))) {
                        return true;
                    }
                }
                return false;
            }
            else {
                return true;
            }
        }
        if(card == 7) {
            if(parentCards.size() == 2) {
                if((parentCards.contains(3) && (parentCards.contains(5) || parentCards.contains(7))) || (parentCards.contains(5) && (parentCards.contains(7) || parentCards.contains(3))) || (parentCards.contains(7) && (parentCards.contains(3) || parentCards.contains(5)))) {
                    return false;
                }
                if((parentCards.contains(2) && (parentCards.contains(4) || parentCards.contains(6))) || (parentCards.contains(4) && (parentCards.contains(6) || parentCards.contains(2))) || (parentCards.contains(6) && (parentCards.contains(2) || parentCards.contains(4)))) {
                    return false;
                }
                if(pos < 18) {
                    if(parentCards.contains(1) && (parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7))) {
                        return false;
                    }
                    if(parentCards.contains(8) && (parentCards.contains(2) || parentCards.contains(4) || parentCards.contains(6))) {
                        return false;
                    }
                }
                else {
                    if(parentCards.contains(1) && (parentCards.contains(3) || parentCards.contains(5) || parentCards.contains(7))) {
                        return false;
                    }
                    if(parentCards.contains(8) && (parentCards.contains(2) || parentCards.contains(4) || parentCards.contains(6))) {
                        return false;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    private void makeMove(int card, int pos) {
        if(isValidMove(card, pos)) {
            gameMatrix[pos] = card;
        }
    }

    private boolean gameOver() {
        return gameMatrix[0] != -1 && gameMatrix[35] != -1;
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
