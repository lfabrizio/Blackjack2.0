package com.fabrizio;

public class Player {
     private int casinoIdNumber;
     double playerMoney;
     private String playerName;
     private int score;

     public Player(){}

     public Player(int casinoIdNumber, String playerName){
          this.casinoIdNumber = casinoIdNumber;
          this.playerName = playerName;
     }


     public int getCasinoIdNumber() {
          return casinoIdNumber;
     }

     public double getPlayerMoney() {
          return playerMoney;
     }

     public String getPlayerName() {
          return playerName;
     }

     public int getScore() {
          return score;
     }
}
