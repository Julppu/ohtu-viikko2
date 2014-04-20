package ohtu;

public class TennisGame {
    
    private int scorePlayer1;
    private int scorePlayer2;
    private String player1;
    private String player2;

    public TennisGame(String player1, String player2) {
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 0) {
            if (scorePlayer1 < 4)
                return getScoreString(scorePlayer1) + "-" + getScoreString(4);
            else
                return "Deuce";
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            if (minusResult == 1)
                return "Advantage " + player1;
            else if (minusResult == -1)
                return "Advantage " + player2;
            else if (minusResult >= 2)
                return "Win for " + player1;
            else
                return "Win for " + player2;
        } else 
            return getScoreString(scorePlayer1) + "-" + getScoreString(scorePlayer2);
    }
    
    public String getScoreString(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            case 4:
                return  "All";
        }
        return null;
    }
}