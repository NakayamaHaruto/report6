package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Collections;

public class Character {
    int tip;
    static int pots;
    static ArrayList<Integer> potsList; //全員のポットを保存しとくためのリスト
    // ArrayList<String> playercards;
    ArrayList<String> handcard; // 2枚受け取るカードの配列
    public Character() {
        this.pots = 0; // 初期値として0を設定
        this.tip = 100; // 初期値として100を設定
        handcard = new ArrayList<>();
        potsList = new ArrayList<>();
    }
    public Character(int tip){       
        this.tip = tip;
        handcard = new ArrayList<>();
        potsList = new ArrayList<>();
    }
    public int getTip(){
        return tip;
    }
    
    public ArrayList<String> drawcards(int count){ // 手札からcount枚カードを引いてそのカードを手札から消す
        for (int i = 0; i < count; i++){
            handcard.add(PlayingCards.drawcard());
        }
        return handcard;
    }
    public void bet(int amountWagered){
        if (tip > 0){
            tip = tip - amountWagered;
            potsList.add(amountWagered);
            pots = pots + amountWagered;
            System.out.println(amountWagered + "をベットしました");
        }else{
            System.out.println("チップがありません");
        }
    }
    public void call(){
        if (potsList.size() != 0){
            int max = Collections.max(potsList);
            int callAmount = max - pots;
            if (tip > callAmount){
                tip = tip - callAmount;
                potsList.add(callAmount);
                System.out.println(callAmount + "をコールしました");
            } else{
                System.out.println("コール留守のに必要なチップがありません");
            } 
        } else{
            System.out.println("現在のベットはありません");
        }
    }
}
