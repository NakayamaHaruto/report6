import jp.ac.uryukyu.ie.e245757.*;
/**
 * Mainクラス
 * mainメソッドがあるクラス
 */
public class Main {
    public static void main(String[] args) {
        Player player = new Player(100, null);
        Opponent opponent = new Opponent(100, player);
        player.opponent = opponent;
        
        GameMaster gameMaster = new GameMaster(player, opponent);
        gameMaster.startGame();
    }
}