package com.fabrizio;

public class Main {

    public static void main(String[] args) {
	   // create a welcome message
        System.out.print("Welcome to the Interactive Game of Blackjack!");

        // create the playing deck
        StandardDeck playDeck = new StandardDeck();
        playDeck.BlackJackDeck();
        // shuffle the deck
        playDeck.shuffle();

        System.out.println(playDeck);

    }
}
