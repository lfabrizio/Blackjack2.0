package com.fabrizio;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck {
//    TODO: create instance variable from card class
    private ArrayList<Card> cards;

//    todo: constructor for new standard deck
    public StandardDeck() {
        this.cards = new ArrayList<Card>();
    }


//        TODO: Method to populate a full Deck- unique to the game Blackjack - deck 13 values and 4 suits
        public void BlackJackDeck(){
            for(Suit suitCard : Suit.values()){
                for(Value numberCard : Value.values()){
                    // add in a new card suit and a new card value into our created arrayList
                    this.cards.add(new Card(suitCard, numberCard));

                }
            }
        }

        //method to shuffle
        public void shuffle() {
            Collections.shuffle(cards);
         }


        //method to remove a card (use i)
        public void removeCard(int i){
        this.cards.remove(i);
        }

        //method to get a card
        public Card getACard(int i){
        return this.cards.get(i);
        }

        // method that will draw from the deck
         public void draw(StandardDeck takeCard) {
        this.cards.add(takeCard.getACard(0));
        takeCard.removeCard(0);
    }


    //loop through -- toString method
    public String toString(){
        String cardOutput = "";
        for(Card eachCard : this.cards){
            cardOutput += "\n " + eachCard.toString();
        }
        return cardOutput;
    }
}