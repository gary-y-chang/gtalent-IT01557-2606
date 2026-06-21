package phase01basic.oop.lesson08;

public enum GameType implements Playable {
    RPG, FPS, RPG_STRATEGY;

    @Override
    public void play() {
        // 所有列舉值執行相同的邏輯，可搭配 name() 區分
        System.out.println("正在啟動遊戲類型: " + this.name());
    }
}
