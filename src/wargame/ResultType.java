/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

/**
 *
 * @author rouport
 * 
 * Standard enum class of different evaluation outcome to again avoid magic
 * constant
 */
public enum ResultType {
    PLAYER1WINS, PLAYER2WINS, PLAYER1WINSGAME, PLAYER2WINSGAME,
    TIE, TIEGAME
}
