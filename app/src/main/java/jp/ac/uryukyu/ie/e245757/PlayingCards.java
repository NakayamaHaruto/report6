package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;

public class PlayingCards {
    private ArrayList<String> cards;
    public PlayingCards(){
        cards = new ArrayList<>();
        String[] marks = {"♠︎", "♣︎", "❤️", "♦️"};
        int[] figures = new int[13];
        for (int i = 1; i <= 13; i ++){
            figures[i - 1] = i;
        }
        for (int i = 0; i < marks.length; i ++){
            for (int j = 0; j < figures.length; j ++){
                String card =  marks[i] + figures[j];
                cards.add(card);
            }
        }
    }
    public void printCards() {
        for (String card : cards) {
            System.out.println(card);
        }
    }
}
