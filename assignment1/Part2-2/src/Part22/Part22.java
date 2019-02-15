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
public class Part22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        Hand Hand1 = deck.dealHand(13).sort();
        Hand Hand2 = deck.dealHand(13).sort();
        Hand Hand3 = deck.dealHand(13).sort();
        Hand Hand4 = deck.dealHand(13).sort();
        System.out.println("\nHand1 is: " + Hand1);
        System.out.println("\nHand2 is: " + Hand2);
        System.out.println("\nHand3 is: " + Hand3);
        System.out.println("\nHand4 is: " + Hand4);
    }

}
