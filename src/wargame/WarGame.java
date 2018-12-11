/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.LinkedList;
import static wargame.ResultType.*;

/**
 *
 * @author rouport
 * This class is was hosts the actual game and makes all the necessary comparisons
 * of cards and declares a winner an loser of each game and round. Also serves
 * as entry point of program
 */
public class WarGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initalizeGame();
        GameBoard board = new GameBoard();
        board.setVisible(true);
    }
    
    //Creates our dealer and player 1 and player 2 and deals out to both
    public static void initalizeGame(){
        Dealer dealer = Dealer.getInstance();
        ActiveDecks players = ActiveDecks.getInstance();
        dealer.shuffle();
        LinkedList<Card> player1 = players.getPlayer1();
        LinkedList<Card> player2 = players.getPlayer2();
        dealer.deal(player1, player2);     
    }
    
    //handles 1 single flip event
    public static synchronized ResultDTO flip(){
        ActiveDecks players = ActiveDecks.getInstance();
        LinkedList<Card> player1 = players.getPlayer1();
        LinkedList<Card> player2 = players.getPlayer2();
        LinkedList<Card> spoils = players.getSpoils();
        //first check to see if either player is out of cards
        ResultType result = evaluateGame(player1, player2);
        if(result != null){
            spoils.clear();
            return new ResultDTO(result,null,null, 
                    player1.size(), player2.size());
        }
        //get cards and compare which rank is higher
        Card player1Card = player1.pop();
        Card player2Card = player2.pop();
        if(player1Card.getNumber() > player2Card.getNumber()){
            player1.add(player1Card);
            player1.add(player2Card);
            player1.addAll(spoils);
            spoils.clear();
            return new ResultDTO(PLAYER1WINS,player1Card,player2Card, 
                    player1.size(), player2.size());
        }
        else if(player1Card.getNumber() < player2Card.getNumber()){
            player2.add(player2Card);
            player2.add(player1Card);
            player2.addAll(spoils);
            spoils.clear();
            return new ResultDTO(PLAYER2WINS,player1Card,player2Card, 
            player1.size(), player2.size());
        }
        //if no one wins, then the tie functoin is called and the cards are added
        //to the spoils
        spoils.add(player1Card);
        spoils.add(player2Card);
        result = tie(player1, player2, spoils);
        return new ResultDTO(result,player1Card,player2Card,
                player1.size(), player2.size());
    }
    
    //Currently set to add three cards to spoils from both players as 1 was not 
    //enough
    public static ResultType tie(LinkedList<Card> player1, 
            LinkedList<Card> player2, LinkedList<Card> spoils){
        for(int i = 0; i < 3; i++){
            ResultType result = evaluateGame(player1, player2);
            if(result != null){
                return result;
            }
            spoils.add(player1.pop());
            spoils.add(player2.pop());
        }
        return TIE;
    }
    
    //Checks if both or 1 player is out of cards and returns the appropriate message
    public static ResultType evaluateGame(LinkedList<Card> player1, 
            LinkedList<Card> player2){
        if(player1.isEmpty() && player2.isEmpty()){
            return TIEGAME;
        }
        else if(player2.isEmpty()){
            return PLAYER1WINSGAME;
        }
        else if(player1.isEmpty()){
            return PLAYER2WINSGAME;
        }
        return null;
    }
    
    //resets the game
    public static synchronized void reset(){
        Dealer dealer = Dealer.getInstance();
        ActiveDecks players = ActiveDecks.getInstance();
        dealer.shuffle();
        LinkedList<Card> player1 = players.getPlayer1();
        LinkedList<Card> player2 = players.getPlayer2();
        player1.clear();
        player2.clear();
        dealer.deal(player1, player2);
    }
}
