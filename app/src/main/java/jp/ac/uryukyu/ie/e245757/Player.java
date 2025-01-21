package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Characterクラスを継承したクラス
 * プレイヤーの操作をまとめたクラス
 */
public class Player extends Character {
    public Opponent opponent;
    Scanner scanner;
    ArrayList<String> actions;
    /**
     * コンストラクタ　チップ、相手のインスタンス、行動を入れるリスト、スキャナークラスのインスタンスを用意
     * @param tip　チップ
     * @param opponent　相手のインスタンス
     */
    public Player(int tip, Opponent opponent) {
        super(tip);
        this.opponent = opponent;
        actions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    /**
     * addAction メソッド
     * プレイヤーの行動をリストに入れる
     */
    public void addAction() {
        actions.add("ベット");
        actions.add("フォールド");
        actions.add("チェック");
        actions.add("コール");
    }
    /**
     * fold メソッド
     * プレイヤーがフォールドする時に使うメソッド
     */
    @Override
    public void fold() {
        System.out.println("フォールドしました");
            opponent.tip = opponent.tip + pots;
            System.out.println("自分のチップ" + tip);
            System.out.println("相手のチップ" + opponent.tip);
            pots = 0;
            System.exit(0);
    }
    /**
     * firstComand メソッド
     * プレイヤーが最初に行う行動をまとめたメソッド
     */
    public void firstComand() {
        addAction();
        System.out.println("1 ~ 2までの数字の中から選んでください");
        for (int i = 0; i < 2; i ++) {
            System.out.println(i + 1 + ":" + actions.get(i));
        }
        int num = scanner.nextInt();
        switch(num) {
            case 1: // betする
            System.out.println("いくらのチップをかけますか");
            System.out.println("自分のチップ:" + tip);
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
    /**
     * secondComand メソッド
     * 相手が行動した後にプレイヤーが行う行動をまとめたメソッド
     */
    public void secondComand() {
        addAction();
        System.out.println("1 ~ 3までの数字の中から選んでください");
        for (int i = 0; i < 3; i ++) {
            System.out.println(i + 1 + ":" + actions.get(i));
        }
        int num = scanner.nextInt();
        switch(num) {
            case 1: // betする
            System.out.println("いくらのチップをかけますか");
            System.out.println("自分のチップ" + tip);
            int num2 = scanner.nextInt();
            bet(num2);
            break;
            case 2: // フォールドする
            fold();
            break;
            case 3: // チェックする
            bet(0);
            System.out.println("チェックしました");
            default:
            System.out.println("1 ~ 3の中から選んでください");
            break;
          }
    }
    /**
     * callAction メソッド
     * プレイヤーがコールをする時に使うメソッド
     */
    public void callAction() {
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