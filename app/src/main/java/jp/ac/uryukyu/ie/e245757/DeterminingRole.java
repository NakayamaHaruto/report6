package jp.ac.uryukyu.ie.e245757;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 役判定について書かれているクラス
 */
public class DeterminingRole {
    Player player;
    Opponent opponent;
    ArrayList<String> numberCards;
    ArrayList<String> markCards;
    Map<String, Integer> numCountMap;
    Map<String,Integer> markCountMap;
    Map<String, Integer> StringRoleMap;
    ArrayList<Map.Entry<String,Integer>> numTransformation; // Set型のデータをArrayList型に変換用

    public DeterminingRole(Player player, Opponent opponent) {
        this.player = player;
        this.opponent = opponent;
        numberCards = new ArrayList<>();
        markCards = new ArrayList<>();
        numCountMap = new HashMap<>();
        markCountMap = new HashMap<>();
        StringRoleMap = new HashMap<>();
        numTransformation = new ArrayList<>(numCountMap.entrySet()); // Mapのエントリをリストに変換
    }
    /*
     * 役の強さを保存したい
     * カードの数字が被っている同士でメソッド作る
     * ストレートのメソッド
     * メソッドがtrueの時役名を返して順位を受け取るようにする
     * カードを保存しているリストが上書きされそう
     * playerとoppnentで分けれるようにしたい
     */

    /**
     * strengthRole メソッド
     * 役の強さを順位を返すメソッド
     * @param role　役の名前
     * @return　役の強さの順位
     */
    public int strengthRole(String role) {
        StringRoleMap.put("Royai Flush", 1);
        StringRoleMap.put("Straight Flush", 2);
        StringRoleMap.put("ForofaKind", 3);
        StringRoleMap.put("Full House", 4);
        StringRoleMap.put("Flush", 5);
        StringRoleMap.put("Straight", 6);
        StringRoleMap.put("Three of a Kind", 7);
        StringRoleMap.put("TwoPair", 8);
        StringRoleMap.put("OnePair", 9);
        StringRoleMap.put("NoPair", 10);
        return StringRoleMap.get("role");
    }
    /**
     * numbersOnly メソッド
     * カードの数字の部分だけリストに入れる
     * @param list　カードが入っているリスト
     */
    public void numbersOnly(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            numberCards.add(list.get(i).substring(1));
        }
    }
    /**
     * duplicationCardDecision メソッド
     * カードの数字の重複によって役が完成するものを判定するメソッド
     * @param list カードが入っているリスト
     * @param numDuplication　1番重複している数字の枚数
     * @param numDuplication2　2番目に重複している数字の枚数
     * @return　役が正しいかどうか
     */
    public boolean duplicationCardDecision(ArrayList<String> list, int numDuplication, int numDuplication2) {
        numbersOnly(list);
        for (String element : numberCards) { // 数字の出現回数を調べる
            int count = numCountMap.getOrDefault(element, 0);
            numCountMap.put(element, count + 1);
        }
        // numTransformation.sort(Comparator.comparing(Map.Entry :: getValue, Comparator.reverseOrder())); // 値を降順で比較
        Map.Entry<String, Integer> maxEntry = null;
        Map.Entry<String, Integer> secondMaxEntry = null;
        for (Map.Entry<String, Integer> entry : numCountMap.entrySet()) { // 値の最大値と2番目の最大値を取得
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                secondMaxEntry = maxEntry; //　2番目の最大値
                maxEntry = entry; // 最大値
            }else if (secondMaxEntry == null || entry.getValue() > secondMaxEntry.getValue()) { // 2番目の最大値を更新
                secondMaxEntry = entry;
            }
        }
        if (maxEntry != null && secondMaxEntry != null && maxEntry.getValue() == numDuplication && secondMaxEntry.getValue() == numDuplication2) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * fullHouseDecision メソッド
     * フルハウスかどうかを判定するメソッド
     * @param list　カードが入っているリスト
     * @return　フルハウスになっているかどうか
     */
    public boolean fullHouseDecision(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i ++) { // カードのマークの部分だけリストに入れる
            markCards.add(list.get(i).substring(0,1));
        }
        for (String element : markCards) { // マークの出現回数を調べる
            int count = markCountMap.getOrDefault(element, 0);
            markCountMap.put(element, count + 1);
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : markCountMap.entrySet()) { // 最大値を取得
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        if (maxEntry != null && maxEntry.getValue() >= 5) { // 同じマークが5個以上ある時
            return true;
        } else {
            return false;
        }
    }
    /**
     * straightDecision メソッド
     * ストレートか判定するメソッド
     * @param list カードが入っているリスト
     * @return　ストレートになっているかどうか
     */
    public boolean straightDecision(ArrayList<String> list) {
        numbersOnly(list);
        for (int i = 0; i < list.size(); i ++) { // バブルソートで並び替える
            for (int j = i + 1; j < list.size(); j ++) {
                int aiu = Integer.parseInt(list.get(i));
                int eo = Integer.parseInt(list.get(j));
                if (aiu > eo) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        ArrayList<Integer> numList = new ArrayList<>(); // int型に変更したものが入る
        for (String str : list) { // リストの中身をint型に変更
            numList.add(Integer.parseInt(str));
        }
        for (int i = 4; i < numList.size() ; i ++) { // 連続する5つの整数の最初と最後の差は必ず4になる
            if (numList.get(i) - numList.get(i - 4) == 4) {
                return true;
            }
        }
        return false;
    }
}
