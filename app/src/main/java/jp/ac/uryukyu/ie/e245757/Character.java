package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Collections;
/**
 * サブクラスのPlayerクラスとOpponentクラスに共通してるものを書いてるクラス
 */
public class Character {
    int tip;
    static int pots;
    static ArrayList<Integer> potsList; //全員のポットを保存しとくためのリスト
    // ArrayList<String> playercards;
    ArrayList<String> handcard; // 2枚受け取るカードの配列
    /**
     * コンストラクタ　ポット、チップ、手札をいれるリスト、ポットの履歴が見れるリストを用意
     * ここではチップの初期値を100に設定
     */
    public Character() {
        this.pots = 0; // 初期値として0を設定
        this.tip = 100; // 初期値として100を設定
        handcard = new ArrayList<>();
        potsList = new ArrayList<>();
    }
    /**
     * コンストラクタ　ポット、チップ、手札をいれるリスト、ポットの履歴が見れるリストを用意
     * @param tip　チップ
     */
    public Character(int tip){       
        this.tip = tip;
        handcard = new ArrayList<>();
        potsList = new ArrayList<>();
    }
    /**
     * getTip メソッド
     * @return　チップを返す
     */
    public int getTip(){
        return tip;
    }
    /**
     * drawcards メソッド
     * 手札からcount枚カードを引いてそのカードを手札から消す
     * @param count カードを引く枚数
     * @return　引いたカードのリスト
     */
    public ArrayList<String> drawcards(int count){
        for (int i = 0; i < count; i++){
            handcard.add(PlayingCards.drawcard());
        }
        return handcard;
    }
    /**
     * bet メソッド
     * ベットするメソッド
     * @param amountWagered　ベットする金額
     */
    public void bet(int amountWagered){
        if (tip < amountWagered){ // ベットする金額が足りない時
            System.out.println("チップがありません---");
            fold();
        }
        else { // ベットできる時
            tip = tip - amountWagered;
            potsList.add(amountWagered);
            pots = pots + amountWagered;
            System.out.println(amountWagered + "をベットしました");
        }
    }
    /**
     * call メソッド
     * 相手がレイズした時を除いた時にコールするメソッド
     * opponentが使うコール
     */
    public void call(){
        if (potsList.size() != 0){
            int callAmount = potsList.get(potsList.size() - 1);
            if (tip < callAmount) { // コールするための金額がない時
                System.out.println("コールするのに必要なチップがありません");
                fold();
            } else { // コールできる時
                tip = tip - callAmount;
                potsList.add(callAmount);
                pots = pots + callAmount;
                System.out.println("コールしました");
            }
        } else{
            System.out.println("現在のベットはありません");
        }
    }
    /**
     * raiseCall メソッド
     * 相手がレイズした時にコールするメソッド
     * playerが使うコール
     */
    public void raiseCall(){
        if (potsList.size() >= 2){
            if (potsList.get(potsList.size() - 1) > potsList.get(potsList.size() - 2)){
                int callAmount = potsList.get(potsList.size() - 1) - potsList.get(potsList.size() - 2);
                if (tip < callAmount) { // コールできない時
                    System.out.println("コールするのに必要なチップがありません");
                    fold();
                } else { // コールできる時
                    tip = tip - callAmount;
                    potsList.add(callAmount);
                    pots = pots + callAmount;
                    System.out.println("コールしました");
                }
            }   
        } else{
            System.out.println("現在のベットはありません");
        }
    }
    /**
     * fold メソッド
     * フォールドする時に使うメソッド
     * メソッドを強制終了する
     */
    public void fold(){
        System.out.println("フォールドしました");
        pots = 0;
            System.exit(0);
    }
    /**
     * check メソッド
     * チェックする時に使うメソッド
     */
    public void check(){
        bet(0);
        System.out.println("チェックしました");
    }
}
