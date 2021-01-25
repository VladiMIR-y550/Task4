public enum Players {
    PLAYER1 ("X"), PLAYER2 ("O");

    private final String mark;
    Players(String mark) {
        this.mark = mark;
    }
    public String getMark() {
        return mark;
    }
}
