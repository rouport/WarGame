/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

/**
 *
 * @author rouport
 * Basic result class I made to pass around information between front end and
 * backend
 */
public class ResultDTO {
    public ResultType result;
    public final Card card1;
    public final Card card2;
    public final int player1CardCount;
    public final int player2CardCount;
    public ResultDTO(ResultType result, Card card1, Card card2, 
            int player1CardCount, int player2CardCount){
        this.result = result;
        this.card1 = card1;
        this.card2 = card2;
        this.player1CardCount = player1CardCount;
        this.player2CardCount = player2CardCount;
    }
}
