/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;



/**
 *
 * @author rouport
 * Standard card class, cards have a number (does not correspond to actual face
 * value) as well a suit. The two are used to construct a path which holds a
 * path to the image
 */
public class Card {
    private final Suit suit;
    private final int number;
    private final String imagePath;
    public Card(Suit suit, int number){
        this.suit = suit;
        this.number = number;
        this.imagePath = makePath(suit, number);
    }
    
    public Card(){
        this.suit = null;
        this.number = 0;
        this.imagePath = "/resources/blue_back.PNG";
    }
    
    private String makePath(Suit suit, int number){
        String path = "/resources/";
        switch (number) {
            case 0:  path += "2";
                     break;
            case 1:  path += "3";
                     break;
            case 2:  path += "4";
                     break;
            case 3:  path += "5";
                     break;
            case 4:  path += "6";
                     break;
            case 5:  path += "7";
                     break;
            case 6:  path += "8";
                     break;
            case 7:  path += "9";
                     break;
            case 8:  path += "10";
                     break;
            case 9:  path += "J";
                     break;
            case 10: path += "Q";
                     break;
            case 11: path += "K";
                     break;
            case 12: path += "A";
                     break;
        }
        
        switch (suit)  {
            case SPADES:
                path += "S";
                break;
            case HEARTS:
                path += "H";
                break;
            case DIAMONDS:
                path += "D";
                break;
            case CLUBS:
                path += "C";
                break;
        }
        path += ".png";
        return path;
    }
    
    public Suit getSuit(){
        return this.suit;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public String getImagePath(){
        return this.imagePath;
    }
    
    //for testing purposes
    @Override
    public String toString(){
        return (this.number + this.imagePath);
    }
    
}
