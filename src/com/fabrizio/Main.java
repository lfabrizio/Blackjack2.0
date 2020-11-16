package com.fabrizio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	   // create a welcome message
       Console.welcome("Vegas BlackJack");
//        // create the playing deck
        StandardDeck playDeck = new StandardDeck();
        playDeck.BlackJackDeck();
//        // shuffle the deck
        playDeck.shuffle();
        System.out.println(playDeck);
////        TODO: create a player hand and one for the dealer
        StandardDeck playersHand = new StandardDeck();
        StandardDeck dealersHand = new StandardDeck();

        int playersMoneyBalance = 100;
        Scanner scanner = new Scanner(System.in);

        while(playersMoneyBalance > 0) {
            System.out.print("You have a $ balance of " + playersMoneyBalance + "Place your bet!");
            int playersWager = scanner.nextInt();
            if (playersWager > playersMoneyBalance) {
                System.out.print("Insufficient Funds!");
                break;
            }
            // boolean needed
            boolean roundIsOver = false;

            //Time to Deal
            playersHand.draw(playDeck);
            playersHand.draw(playDeck);
            // ... and for dealer
            dealersHand.draw(playDeck);
            dealersHand.draw(playDeck);

            // Loop to present the hands
            while (true) {
                System.out.print("***Player Ones Hand***  : ");
                System.out.print(playersHand.toString());
                System.out.println("Your Hand is Currently -- " + playersHand.valueOfCards());

                // and then the dealers hand only one get card due to second card must be hidden
                System.out.println("Dealer has --" + dealersHand.getACard(0).toString() + "***HIDDEN***");

//                Todo: Player options
                System.out.println("HIT(1) or STAND(2)");
                int optionsResponse = scanner.nextInt();
                if (optionsResponse == 1) {
                    playersHand.draw(playDeck);
                    System.out.println("Your card---" + playersHand.getACard(playersHand.deckCount() - 1).toString());
//                    todo: if statement for if the player busts
                    if (playersHand.valueOfCards() > 21) {
                        System.out.println("BUST! You Lose!");
                        playersMoneyBalance -= playersWager;
                        roundIsOver = true;
                        break;
                    }
                }
//                todo: need to implement stand
                if (optionsResponse == 2) {
                    break;
                }
            }
            // Show the Dealers Hidden Card, as Well as Full hand
            System.out.println("***Dealers Hand***-- " + dealersHand.toString());
            if (dealersHand.valueOfCards() > playersHand.valueOfCards() && roundIsOver == false) {
                System.out.println("***Dealer Wins!***");
                playersMoneyBalance -= playersWager;
                roundIsOver = true;
            }
//            Todo: what if dealer keeps drawing from deck?
            while (dealersHand.valueOfCards() < 17 && roundIsOver == false) {
                dealersHand.draw(playDeck);
                System.out.println("Dealers card is a :" + dealersHand.getACard(dealersHand.deckCount() - 1).toString());
            }
//                Todo: Display Dealers Hand in Totality
            System.out.println("***Dealers Hand*** - " + dealersHand.valueOfCards());
            //        Todo: Did The Dealer Bust or did they win?
                if((dealersHand.valueOfCards() > 21) && roundIsOver == false){
                    System.out.println("***DEALER BUSTS , YOU WIN!***");
                    playersMoneyBalance += playersWager;
                    roundIsOver = true;
                }
//                TODO: Determine if there is a push
            if((playersHand.valueOfCards() == dealersHand.valueOfCards()) && roundIsOver == false){
                System.out.println("***PUSH!***");
                roundIsOver = true;
            }

            if ((playersHand.valueOfCards() > dealersHand.valueOfCards() && roundIsOver == false)) {
                System.out.println("***YOU WIN!!***");
                playersMoneyBalance += playersWager;
                roundIsOver = true;
            }
        }
            System.out.println("Game Over! Deposit more money to play again!");
        }


    }

