package com.fabrizio;

import java.util.Scanner;

public class Console {

    public Console(){

    }

    public void playGame(){
        //    TODO: Game Loop in here
        //        // create the playing deck
      StandardDeck playDeck = new StandardDeck();
       playDeck.BlackJackDeck();
//       // shuffle the deck
           playDeck.shuffle();

        int playerMoney = 100;
        Scanner scanner = new Scanner(System.in);
//        todo: take the player bet and keep the loop going as long as they have funds
        while(playerMoney > 0){
            System.out.println("Your Current $ Balance:" + playerMoney +", Please place your bets!");
            int inputBet = scanner.nextInt();
            if(inputBet > playerMoney){
                System.out.println("Insufficient Funds!");
                break;
            }

            // Then start the deal by drawing two cards
////        TODO: create a player hand and one for the dealer
           StandardDeck playersHand = new StandardDeck();
           StandardDeck dealersHand = new StandardDeck();

           // players hand two cards
            playersHand.draw(playDeck);
            playersHand.draw(playDeck);
            // dealer gets two cards
            dealersHand.draw(playDeck);
            dealersHand.draw(playDeck);
//        System.out.println(playDeck);

        }
        System.out.println("Game Over! You are out of Funds!");
    }



}
