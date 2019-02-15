package Part22;

import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Reyes
 */
public class Card implements Comparable<Card> {

    private Suit suit;
    private Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public enum Suit {
        C, D, H, S
    }

    public enum Rank {
        Two("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
        EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K"), ACE("1");

        private final String num;

        private Rank(String num) {
            this.num = num;
        }

        public String getnum() {
            return num;
        }
    }

    @Override
    public int compareTo(Card card) {
        if (suit.equals(card.suit)) { // First compare suits
            if (rank.equals(card.rank)) { // So check face values
                return 0; // They are equal
            }
            return rank.compareTo(card.rank) < 0 ? -1 : 1;
        } else { // Suits are different
            return suit.compareTo(card.suit) < 0 ? -1 : 1; // Sequence is C<D<H<S
        }        
    }

    @Override
    public String toString() {
        return rank.getnum() + suit;
    }
}
