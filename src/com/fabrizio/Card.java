package com.fabrizio;

    public class Card {
        private Suit suit;
        private Value value;
       // private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

        public Card(Suit suit, Value value){
            this.value=value;
            this.suit=suit;
        }



        @Override
        public String toString() {
            return "Card{" +
                    "suit=" + suit +
                    ", value=" + value +
                    '}';
        }
        // needed for switch statement implementation
        public Value getValue(){
            return this.value;
        }
    }


