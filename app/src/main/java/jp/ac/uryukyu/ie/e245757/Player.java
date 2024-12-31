package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character{
    public Opponent opponent;
    Scanner scanner;
    ArrayList<String> actions;
    public Player(int tip, Opponent opponent) {
        super(tip);
        this.opponent = opponent;
        actions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addAction(){
        actions.add("ベット");
        actions.add("フォールド");
        actions.add("チェック");
        actions.add("コール");
    }
    @Override
    public void fold(){
        System.out.println("フォールドしました");
            opponent.tip = opponent.tip + pots;
            System.out.println("自分のチップ" + tip);
            System.out.println("相手のチップ" + opponent.tip);
            pots = 0;
            System.exit(0);
    }
    public void firstComand(){
        addAction();
        System.out.println("1 ~ 2までの数字の中から選んでください");
        for (int i = 0; i < 2; i ++){
            System.out.println(i + 1 + ":" + actions.get(i));
        }
        int num = scanner.nextInt();
        switch(num){
            case 1: // betする
            System.out.println("いくらのチップをかけますか");
            int num2 = scanner.nextInt();
            bet(num2);
            break;
            case 2: // フォールドする
            fold();
            break;
            default:
            System.out.println("1 ~ 2の中から選んでください");
            break;
          }
    }
    public void secondComand(){
        addAction();
        System.out.println("1 ~ 3までの数字の中から選んでください");
        for (int i = 0; i < 3; i ++){
            System.out.println(i + 1 + ":" + actions.get(i));
        }
        int num = scanner.nextInt();
        switch(num){
            case 1: // betする
            System.out.println("いくらのチップをかけますか");
            int num2 = scanner.nextInt();
            bet(num2);
            break;
            case 2: // フォールドする
            fold();
            break;
            case 3: // チェックする
            System.out.println("チェックしました");
            default:
            System.out.println("1 ~ 3の中から選んでください");
            break;
          }
    }
    public void callAction(){
        System.out.println("相手がレイズしました");
        System.out.println("1 ~ 2までの数字の中から選んでください");
        System.out.println("1: コールします");
        System.out.println("2: フォールドします");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                raiseCall();
                break;
            case 2:
                fold();
                break;
            default:
                System.out.println("1 ~ 2の中から選んでください");
                break;
        }
    }
}
