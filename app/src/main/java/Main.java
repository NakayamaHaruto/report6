import jp.ac.uryukyu.ie.e245757.*;

public class Main {
    public static void main(String[] args) {
        PlayingCards.shuffle(); // カードをシャッフル
        PlayingCards deck = new PlayingCards(); // インスタンスを作成
        deck.printCards();
        Player aiu = new Player(0);
        System.out.println("自分のstarting hand:" + aiu.drawcards(2));
        Opponent eo = new Opponent(0);
        System.out.println("相手のstarting hand:" + eo.drawcards(2));
        // deck.printCards();

    }
}
