package com.fabrizio;

import java.util.Scanner;

public class Console {

    public Console(){
    }

    public static void welcome(String gameChoice){
        System.out.print("Welcome to " + gameChoice);
        System.out.println("\n");
    }

    public static void playGame() {
        // Game Loop begins
        Console.welcome("Blackjack");
        StandardDeck playersHand = new StandardDeck();
        StandardDeck dealersHand = new StandardDeck();

//        // create the playing deck
        StandardDeck playDeck = new StandardDeck();
        playDeck.BlackJackDeck();
//        // shuffle the deck
        playDeck.shuffle();
//        System.out.println(playDeck);

        int playersMoneyBalance = 500;
        Scanner scanner = new Scanner(System.in);

        while(playersMoneyBalance > 0) {
            Console.welcome("Vegas BlackJack!");
            System.out.print("You have a $ balance of " + playersMoneyBalance + ".... Place your bet!");
            int playersWager = scanner.nextInt();
            int doubleDown = playersWager * 2;
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
                System.out.print("***PLAYER ONES HAND***  ");
                System.out.print(playersHand.toString());
                System.out.println("Your Hand is Currently -- " + playersHand.valueOfCards());

                // and then the dealers hand only one get card due to second card must be hidden
                System.out.println("\n");
                System.out.print("***DEALERS HAND***\n");

                System.out.println("Dealer has " + dealersHand.getACard(0).toString() + "***HIDDEN***");

//               Player options
                System.out.println("\n");
                System.out.print("Player one, action is to you.\n");
                System.out.println("--HIT(1) or STAND(2)--");
                System.out.println("-- Double Down(3)--");
                int optionsResponse = scanner.nextInt();
                if (optionsResponse == 1) {
                    playersHand.draw(playDeck);
                    System.out.println("Your card---" + playersHand.getACard(playersHand.deckCount() - 1).toString());
//                    If the player busts
                    if (playersHand.valueOfCards() > 21) {
                        System.out.println("BUST! You Lose!");
                        playersMoneyBalance -= playersWager;
                        roundIsOver = true;
                        break;
                    }
                }
              // Double Down
                if(optionsResponse == 3){
                    playersMoneyBalance -= playersWager;
                    playersHand.draw(playDeck);
                    System.out.println("Double Down Card is " + playersHand.getACard(playersHand.deckCount() - 1).toString());
                    System.out.println("Your Hand is now -- " + playersHand.valueOfCards());
                    break;
                }
//                Stand Option
                if (optionsResponse == 2) {
                    break;
                }
            }
            // Show the Dealers Hidden Card, as Well as Full hand
            System.out.println("***Dealers Hand*** " + dealersHand.toString());
            if (dealersHand.valueOfCards() > playersHand.valueOfCards() && roundIsOver == false) {
                System.out.println("***Dealer Wins***");
                playersMoneyBalance -= playersWager;
                roundIsOver = true;
            }
//            what if dealer keeps drawing from deck?
            while (dealersHand.valueOfCards() < 17 && roundIsOver == false) {
                dealersHand.draw(playDeck);
                System.out.println("Dealers card is a :" + dealersHand.getACard(dealersHand.deckCount() - 1).toString());
            }
//            Display Dealers Hand in Totality
            System.out.println("***Dealers Hand*** - " + dealersHand.valueOfCards());
            //        Did The Dealer Bust or did they win?
            if((dealersHand.valueOfCards() > 21) && roundIsOver == false){
                System.out.println("***DEALER BUSTS , YOU WIN!***");
                playersMoneyBalance += playersWager;
                roundIsOver = true;
            }
//                Determine if there is a push
            if((playersHand.valueOfCards() == dealersHand.valueOfCards()) && roundIsOver == false){
                System.out.println("***PUSH!***");
                roundIsOver = true;
            }

            if ((playersHand.valueOfCards() > dealersHand.valueOfCards() && roundIsOver == false)) {
                System.out.println("***YOU WIN!!***");
                playersMoneyBalance += playersWager;
                roundIsOver = true;
            }
            else if(roundIsOver == false){
                System.out.println("***YOU LOST THE HAND!***");
                playersMoneyBalance -= playersWager;
                roundIsOver = true;
            }
//            TODO: Move all cards from players hand and dealers hand back into the deck
            playersHand.reStackDeck(playDeck);
            dealersHand.reStackDeck(playDeck);
            System.out.println("***Hand is Over!***");
        }
        System.out.println("Game Over! Deposit more money to play again!");
//        todo: Will add a deposit vs leave table
//           System.out.print("--Deposit Money(1) or Leave Table(2)--");

    }
    }

//    todo: Would like to create a method to deposit more money



