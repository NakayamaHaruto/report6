package jp.ac.uryukyu.ie.e245757;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CharacterTest {
    Player player = new Player(100,null);
    Opponent opponent = new Opponent(100, player);
    @Test
    void bet() {
        player.bet(10);
        assertEquals(90,player.tip);
    }
    @Test
    void call() {
        player.bet(10);
        opponent.call();
        assertEquals(90, opponent.tip);
    }
}
