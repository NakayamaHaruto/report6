package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Collections;

public class PlayingCards {

    private static ArrayList<String> cards;
    static { // 手札を全てのインストラクタで共有させる
        cards = new ArrayList<>(); // 52枚のトランプが入っている配列
        String[] marks = {"♠︎", "♣︎", "❤️", "♦️"};
        int[] figures = new int[13];
        for (int i = 1; i <= 13; i ++){
            figures[i - 1] = i;
        }
        for (int i = 0; i < marks.length; i ++){
            for (int j = 0; j < figures.length; j ++){
                String card =  marks[i] + figures[j]; // トランプ1枚
                cards.add(card);
            }
        }
    }
    public static void shuffle(){ // 52枚のトランプをシャッフルする
        Collections.shuffle(cards);
    }
    public static String drawcard(){ //　カードを手札の中から1枚引いてそのカードを消す
        return cards.remove(0);
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public void printCards() { // 手札の中身を表示する
        for (String card : cards) {
            System.out.println(card);
        }
    }
}
