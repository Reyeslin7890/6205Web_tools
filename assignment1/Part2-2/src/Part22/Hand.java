package Part22;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Reyes
 */
import java.util.Collections;
import java.util.Vector;

public class Hand {
   
    public void add(Card card) {
        hand.add(card);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (Card card : hand) {
            if (first) {
                first = false;
            } else {
                str.append(" ");
            }
            str.append(card);
        }
        return str.toString();
    }

    public Hand sort() {
        Collections.sort(hand);
        return this;
    }

    private Vector<Card> hand = new Vector<>(); 
}
