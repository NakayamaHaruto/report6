package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMaster extends Character{
    Player player;
    Opponent opponent;
    ArrayList<String> fieldCards;
    Scanner scanner;
    
    public GameMaster(Player player, Opponent opponent){
        this.player = player;
        this.opponent = opponent;
        fieldCards = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void flop(){
        final int flop = 3; // フロップの時の枚数
        for (int i = 0; i < flop; i ++){
            fieldCards.add(PlayingCards.drawcard());
        }
        System.out.println("フロップしました");
        System.out.println("フィールドカード:" + fieldCards);
        System.out.println("自分のstarting hand:" + player.handcard);
    }
    public void turn(){
        fieldCards.add(PlayingCards.drawcard());
        System.out.println("ターンしました");
        System.out.println("フィールドカード:" + fieldCards);
        System.out.println("自分のstarting hand:" + player.handcard);
    }
    public void river(){
        fieldCards.add(PlayingCards.drawcard());
        System.out.println("リバーしました");
        System.out.println("フィールドカード:" + fieldCards);
    }
    public void information(){ // ポットやチップを表示
        // System.out.println(potsList);
        System.out.println("現在のポット" + pots);
        System.out.println("自分のチップ" + player.tip);
        System.out.println("相手のチップ" + opponent.tip);
    }
    public void actionComand(){
        player.secondComand();
        opponent.decideAction();
        player.callAction();
        information();
    }
    
    public void startGame(){
        final int firstcords = 2; // 最初に配られるカードの枚数
        PlayingCards.shuffle(); // カードをシャッフル
        System.out.println("自分のstarting hand:" + player.drawcards(firstcords));
        System.out.println("相手のstarting hand:" + opponent.drawcards(firstcords));
        player.firstComand();
        opponent.decideAction();
        player.callAction();
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
