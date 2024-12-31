package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Random;

public class Opponent extends Character{
    Player player;
    Random random;
    Random random2;
    public Opponent(int tip, Player player){
        super(tip);
        this.player = player;
        random = new Random();
        random2 = new Random();
    }
    @Override
    public void fold(){
        System.out.println("相手がフォールドしました");
            player.tip = player.tip + pots;
            System.out.println("自分のチップ" + player.tip);
            System.out.println("相手のチップ" + tip);
            pots = 0;
            System.exit(0);
    }
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
