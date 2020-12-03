package com.fabrizio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


    public class Rigged implements Deck{
        private ArrayList<Card> markedCards;

        public Rigged() {
            this.markedCards = new ArrayList<Card>();
        }

        public void riggedDeck(){

        }

        @Override
        public void shuffle() {
            Collections.shuffle(markedCards);
        }
//

//
//        @Override
//        public Card draw() {
//
//        }
    }

