package phase01basic.oop.lesson10;

import java.util.Iterator;

// 1. 宣告類別實作 Iterable 介面
public class Team implements Iterable<String> {
    private String[] players = {"Player A", "Player B", "Player C"};

    // 2. 必須實作 iterator() 方法，回傳一個 Iterator 工具
    @Override
    public Iterator<String> iterator() {
        return new TeamIterator();
    }

    // 3. 用內部類別實作 Iterator 介面，負責保存巡覽狀態
    private class TeamIterator implements Iterator<String> {
        private int index = 0; // 記錄目前的游標位置

        @Override
        public boolean hasNext() {
            return index < players.length;
        }

        @Override
        public String next() {
            return players[index++];
        }
    }

    public static void main(String[] args) {
        Team myTeam = new Team();
        
        // 成功！自定義類別現在可以直接用 for-each 巡覽了
        for (String player : myTeam) {
            System.out.println(player);
        }
    }
}

