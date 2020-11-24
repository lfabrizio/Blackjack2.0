package com.fabrizio;

public class Player implements RetrieveInformation{
     private int casinoIdNumber;
     double playerMoney;
     private String name;
     private int score;


     public Player(int casinoIdNumber, String playerName){
          this.casinoIdNumber = casinoIdNumber;
          this.name = playerName;
     }

     public void leaveTable(){
          System.out.println("I've had enough gambling for today! See Ya Next time!");
     }


     public int getCasinoIdNumber() {
          return casinoIdNumber;
     }

     public double getPlayerMoney() {
          return playerMoney;
     }

     public String getName() {
          return this.name;
     }

     public int getScore() {
          return score;
     }
}
