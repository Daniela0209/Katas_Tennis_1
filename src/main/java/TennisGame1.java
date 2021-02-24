public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String namePlayer2;
    private String namePlayer1;

    public TennisGame1(String namePlayer2, String namePlayer1) {
        this.namePlayer2 = namePlayer2;
        this.namePlayer1 = namePlayer1;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score)
        {
            return getPointsAll(player1Score);
        }
        else if (player1Score >=4 || player2Score >=4)
        {
            int temporalResult = player1Score - player2Score;
            if (temporalResult==1) score ="Advantage player1";
            else if (temporalResult ==-1) score ="Advantage player2";
            else if (temporalResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else {
            return Score.nameFromPoints(player1Score) + "-" + Score.nameFromPoints(player2Score);
        }
        return score;
    }

    private String getPointsAll(int player1Score) {
        switch (player1Score)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getScoreByPoints(int points) {
        return Score.nameFromPoints(points);
    }

    enum Score {
        Love, Fifteen, Thirty, Forty;

        public static String nameFromPoints(int points) {
            return values()[points].name();
        }
    }
}