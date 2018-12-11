/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.LinkedList;

/**
 *
 * @author rouport
 * Singleton class which holds the active decks, I am still not sure if I like
 * this design. I wanted somewhere to host the decks but was having trouble
 * getting them to live on the wargame class. Instead I have another singleton
 * class which holds the active decks. Currently is hard coded for three but
 * could also expand to linked list of linked lists to support multiple players.
 */
public class ActiveDecks {
    
    private final LinkedList<Card> player1;
    private final LinkedList<Card> player2;
    private final LinkedList<Card> spoils;
    
    private ActiveDecks() {
        this.player1 = new LinkedList();
        this.player2 = new LinkedList();
        this.spoils = new LinkedList();
    }
    
    public static ActiveDecks getInstance() {
        return PlayersHolder.INSTANCE;
    }
    
    private static class PlayersHolder {

        private static final ActiveDecks INSTANCE = new ActiveDecks();
    }
    
    public LinkedList<Card> getPlayer1(){
        return this.player1;
    }
    
    public LinkedList<Card> getPlayer2(){
        return this.player2;
    }
    
    public LinkedList<Card> getSpoils(){
        return this.spoils;
    }
}
