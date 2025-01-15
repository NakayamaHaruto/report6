package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Collections;
/**
 * カードについてのクラス
 */
public class PlayingCards {
    private static ArrayList<String> cards;
    /**
     * card メソッド
     * 52枚のカードを用意する
     * 手札を全てのインストラクタで共有させる
     */
    public static void card(){
        cards = new ArrayList<>(); // 52枚のトランプが入っている配列
        String[] marks = {"♠︎", "♣︎", "❤︎", "♦︎"};
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
    /**
     * shuffle メソッド
     * 52枚のカードのトランプをシャッフルする
     * staticを使ってインスタンス化しなくても使えるようにする
     * Collectionsクラスのshuffleメソッドを使った
     */
    public static void shuffle(){
        Collections.shuffle(cards);
    }
    /**
     * drawcard メソッド
     * カードを手札の中から1枚引いてそのカードを消す
     * @return 手札の中から消したカードを除いた手札
     */
    public static String drawcard(){
        return cards.remove(0);
    }
    /**
     * getCards メソッド
     * @return　手札を返す
     */
    public ArrayList<String> getCards() {
        return cards;
    }
    /**
     * printCards メソッド
     * 手札の中身を表示する
     */
    public void printCards() {
        for (String card : cards) {
            System.out.println(card);
        }
    }
}
