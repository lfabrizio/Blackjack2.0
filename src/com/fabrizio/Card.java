package com.fabrizio;

    public class Card {
        private int value;
        private String suit;

        public Card(int value, String suit) {
            this.value = value;
            this.suit = suit;
        }

        public String toString() {
            String output = "";
            switch(value) {
                case 0:
                    output = "JK";
                    break;
                case 1:
                    output = "AC";
                    break;
                case 11:
                    output = "JACK";
                    break;
                case 12:
                    output = "QUEEN";
                    break;
                case 13:
                    output = "KING";
                    break;
                default:
                    output = value == 10 ? Integer.toString(value) : " " + value;
            }
            return output;
        }
    }

