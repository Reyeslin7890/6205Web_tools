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
import Part22.Card.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class CardDeck {

    public CardDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        Random selectcard = new Random();
        while (deck.size() != 0) {
            shuffledeck.add(deck.remove(selectcard.nextInt(deck.size())));
        }
    }

    public Hand dealHand(int numCards) {
        Hand hand = new Hand();
        for (int i = 0; i < numCards; ++i) {
            hand.add(shuffledeck.remove());
        }
        return hand;
    }

    private LinkedList<Card> deck = new LinkedList<>();
    private LinkedList<Card> shuffledeck = new LinkedList<>();
}
