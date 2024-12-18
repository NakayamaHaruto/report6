package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;

public class Character {
    int tip;
    // ArrayList<String> playercards;
    ArrayList<String> handcard; // 2枚受け取るカードの配列
    public Character() {
        this.tip = 0; // 初期値として0を設定
        handcard = new ArrayList<>();
    }
    public Character(int tip){       
        this.tip = tip;
        handcard = new ArrayList<>();
    }
    
    public ArrayList<String> drawcards(int count){ // 手札からcount枚カードを引いてそのカードを手札から消す
        for (int i = 0; i < count; i++){
            handcard.add(PlayingCards.drawcard());
        }
        return handcard;
    }
}
