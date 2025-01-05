package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Random;
/**
 * Characterクラスを継承したクラス
 * 相手の操作をまとめたクラス
 */
public class Opponent extends Character{
    Player player;
    Random random;
    Random random2;
    /**
     * コンストラクタ　チップ、プレイヤーのインスタンス、ランダムクラスのインスタンスを用意
     * @param tip　チップ
     * @param player　プレイヤーのインスタンス
     */
    public Opponent(int tip, Player player){
        super(tip);
        this.player = player;
        random = new Random();
        random2 = new Random();
    }
    /**
     * fold メソッド
     * 相手がフォールドする時に使うメソッド
     */
    @Override
    public void fold(){
        System.out.println("相手がフォールドしました");
            player.tip = player.tip + pots;
            System.out.println("自分のチップ" + player.tip);
            System.out.println("相手のチップ" + tip);
            pots = 0;
            System.exit(0);
    }
    /**
     * decideAction メソッド
     * 相手の行動をまとめたメソッド
     */
    public void decideAction(){
        int num = random.nextInt(3) + 1;
        switch(num){
            case 1: // betする
            int num2 = random2.nextInt(30) + potsList.get(potsList.size() - 1);
            bet(num2);
            System.out.println("ベットしました");
            break;
            case 2: // コールする
            call();
            break;
            case 3: // フォールドする
            fold();
            break;
            default:
            System.out.println("1 ~ 3の中から選んでください");
            break;
          }
    }
}
