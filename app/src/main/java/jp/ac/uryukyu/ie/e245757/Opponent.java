package jp.ac.uryukyu.ie.e245757;

import java.util.Random;
/**
 * Characterクラスを継承したクラス
 * 相手の操作をまとめたクラス
 */
public class Opponent extends Character {
    Player player;
    Random random;
    /**
     * コンストラクタ　チップ、プレイヤーのインスタンス、ランダムクラスのインスタンスを用意
     * @param tip　チップ
     * @param player　プレイヤーのインスタンス
     */
    public Opponent(int tip, Player player) {
        super(tip);
        this.player = player;
        random = new Random();
    }
    /**
     * fold メソッド
     * 相手がフォールドする時に使うメソッド
     */
    @Override
    public void fold() {
        System.out.println("相手がフォールドしました");
        player.tip = player.tip + pots;
        System.out.println("自分のチップ" + player.tip);
        System.out.println("相手のチップ" + tip);
        System.exit(0);
    }
    /**
     * decideAction メソッド
     * 相手の行動をまとめたメソッド
     */
    public void decideAction() {
        int num2;
        int num = random.nextInt(3) + 1; // 1 ~ 3の数字をランダムに生成
        switch(num){
            case 1: // betする
            int max = tip; // num2の取りうる最大値
            int min = potsList.get(potsList.size() - 1) + 1; // num2の取りうる最小値
            if (min >= max) {
                System.out.println("レイズできないのでコールします");
                call();
            } else {
                do {
                    num2 = random.nextInt(max - min + 1) + min;
                } while (min > num2 || num2 > max);
                System.out.println("ベットしました");
                bet(num2);
                player.callAction();
            }
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
