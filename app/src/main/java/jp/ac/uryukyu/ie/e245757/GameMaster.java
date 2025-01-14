package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Characterクラスを継承したクラス
 * プレイヤーと相手の行動をまとめてゲームの進行を進めるクラス
 */
public class GameMaster extends Character{
    Player player;
    Opponent opponent;
    ArrayList<String> fieldCards;
    Scanner scanner;
    /**
     * コンストラクタ　プレイヤーのインスタンス、相手のインスタンス、フィールドに出てるカードのリスト、
     * スキャナークラスのインスタンスを用意
     * @param player
     * @param opponent
     */
    public GameMaster(Player player, Opponent opponent){
        this.player = player;
        this.opponent = opponent;
        fieldCards = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    /**
     * flop メソッド
     * フロップするメソッド
     */
    public void flop(){
        final int flop = 3; // フロップの時の枚数
        for (int i = 0; i < flop; i ++){
            fieldCards.add(PlayingCards.drawcard());
        }
        System.out.println("=====フロップ=====");
        System.out.println("フィールドカード:" + fieldCards);
        System.out.println("自分のstarting hand:" + player.handcard);
    }
    /**
     * turn メソッド
     * ターンするメソッド
     */
    public void turn(){
        fieldCards.add(PlayingCards.drawcard());
        System.out.println("=====ターン=====");
        System.out.println("フィールドカード:" + fieldCards);
        System.out.println("自分のstarting hand:" + player.handcard);
    }
    /**
     * river メソッド
     * リバーするメソッド
     */
    public void river(){
        fieldCards.add(PlayingCards.drawcard());
        System.out.println("=====リバー=====");
        System.out.println("フィールドカード:" + fieldCards);
    }
    /**
     * information メソッド
     * ポット状況とプレイヤーのチップと相手のチップを表示するメソッド
     */
    public void information(){ // ポットやチップを表示
        // System.out.println(potsList);
        System.out.println("現在のポット" + pots);
        System.out.println("自分のチップ" + player.tip);
        System.out.println("相手のチップ" + opponent.tip);
    }
    /**
     * actionComand メソッド
     * 行動を少しまとめたもの
     */
    public void actionComand(){
        player.secondComand();
        opponent.decideAction();
        information();
    }
    /**
     * startGame メソッド
     * ゲームの進行をまとめたメソッド
     */
    public void startGame(){
        final int firstcords = 2; // 最初に配られるカードの枚数
        PlayingCards.card();
        PlayingCards.shuffle(); // カードをシャッフル
        System.out.println("自分のstarting hand:" + player.drawcards(firstcords));
        System.out.println("相手のstarting hand:" + opponent.drawcards(firstcords));
        player.firstComand();
        opponent.decideAction();
        information();
        flop();
        actionComand();
        turn();
        actionComand();
        river();
        System.out.println("自分の手札" + player.handcard + fieldCards);
        System.out.println("相手の手札" + opponent.handcard + fieldCards);
        information();
    } 
}
