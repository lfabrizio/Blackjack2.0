package com.fabrizio;

public class Player {
     private int casinoIdNumber;
     double playerMoney;
     private String playerName;
     private int score;


     public Player(int casinoIdNumber, String playerName){
          this.casinoIdNumber = casinoIdNumber;
          this.playerName = playerName;
     }

     public void leaveTable(){
          System.out.println("I've has enough gambling for today! See Ya Next time!");
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
