/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.LinkedList;
import java.util.Collections;
import java.util.ListIterator;

/**
 *
 * @author rouport
 * Singleton class which creates our dealer for the game, the dealer also
 * initializes the deck, useful for different deck manipulations for easy testing
 */
public class Dealer {
    private LinkedList<Card> deck;
    private Dealer() {
        makeDeck();
    }
    
    public static Dealer getInstance() {
        return DealerHolder.INSTANCE;
    }
    
    private static class DealerHolder {

        private static final Dealer INSTANCE = new Dealer();
    }
    
    private void makeDeck(){
        this.deck = new LinkedList();
        Suit suit = null;
        for(int i = 0; i < 4; i++){
            switch (i) {
            case 0:  suit = Suit.SPADES;
                     break;
            case 1:  suit = Suit.CLUBS;
                     break;
            case 2:  suit = Suit.DIAMONDS;
                     break;
            case 3:  suit = Suit.HEARTS;
                     break;
            }
            for(int k = 0; k < 13; k++){
                this.deck.add(new Card(suit, k));
            }
        }        
    }
    
    public void shuffle(){
        Collections.shuffle(this.deck);
    }
    
    public void deal(LinkedList player1, LinkedList player2){
        ListIterator<Card> iterator = this.deck.listIterator();
        while(iterator.hasNext()){
            player1.add(iterator.next());
            player2.add(iterator.next());
        }
    }
    
    //testing purposes
    public void printDeck(){
        this.deck.forEach((card) -> {
            System.out.println(card.toString());
        });
    }
}
