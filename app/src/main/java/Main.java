import jp.ac.uryukyu.ie.e245757.*;

public class Main {
    public static void main(String[] args) {
        
        // PlayingCards deck = new PlayingCards(); // インスタンスを作成
        // deck.printCards();
        Player player = new Player(100, null);
        Opponent opponent = new Opponent(100, player);
        player.opponent = opponent;
        
        GameMaster gameMaster = new GameMaster(player, opponent);
        gameMaster.startGame();
        // deck.printCards();
    }
}