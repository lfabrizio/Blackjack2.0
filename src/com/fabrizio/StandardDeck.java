package com.fabrizio;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck{
        //instance variable from card class--Done
    private ArrayList<Card> cards;

    public StandardDeck() {
        this.cards = new ArrayList<Card>();
    }

//        TODO: Method to populate a full Deck- unique to the game Blackjack - deck 13 values and 4 suits
            //Done
        public void BlackJackDeck(){
            for(Suit suitCard : Suit.values()){
                for(Value numberCard : Value.values()){
                    // add in a new card suit and a new card value into our created arrayList
                    this.cards.add(new Card(suitCard, numberCard));

                }
            }
        }

//    TODO: Shuffle cards with collections
        //Done
        @Override
        public void shuffle() {
            Collections.shuffle(cards);
         }

//         todo: switch statement to return value of cards
        public int valueOfCards(){
        int valueInTotal = 0;
        int aces = 0;

        for(Card perCard : this.cards){
            switch(perCard.getValue()) {
                case TWO:
                    valueInTotal += 2;
                    break;
                case THREE:
                    valueInTotal += 3;
                    break;
                case FOUR:
                    valueInTotal += 4;
                    break;
                case FIVE:
                    valueInTotal += 5;
                    break;
                case SIX:
                    valueInTotal += 6;
                    break;
                case SEVEN:
                    valueInTotal += 7;
                    break;
                case EIGHT:
                    valueInTotal += 8;
                    break;
                case NINE:
                    valueInTotal += 9;
                    break;
                case TEN:
                    valueInTotal += 10;
                    break;
                case JACK:
                    valueInTotal += 10;
                    break;
                case QUEEN:
                    valueInTotal += 10;
                    break;
                case KING:
                    valueInTotal += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;
            }
        }
            for(int i = 0; i < aces;i++){
                if(valueInTotal > 10){
                    valueInTotal += 1;
                }
                else{
                    valueInTotal +=11;
                }
    }
            return valueInTotal;
}


        //method to remove a card (use i)
        public void removeCard(int i){
        this.cards.remove(i);
        }

        //method to get a card
        public Card getACard(int i){
        return this.cards.get(i);
        }

        // method to add a card back to the deck
          public void addCard(Card addACard){
        this.cards.add(addACard);
           }

        // method that will draw from the deck. index zero
         public void draw(StandardDeck takeCard) {
        this.cards.add(takeCard.getACard(0));
        takeCard.removeCard(0);
         }

//         todo: a method to see how many cards are in the deck
    public int deckCount(){
        return this.cards.size();
    }

//     todo: re-stack the deck
    public void reStackDeck(StandardDeck stack){
        int currentDeckSize = this.cards.size();
        for(int i = 0; i < currentDeckSize; i++){
            stack.addCard(this.getACard(i));
        }
        for(int i = 0; i < currentDeckSize; i++){
            this.removeCard(0);
        }
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