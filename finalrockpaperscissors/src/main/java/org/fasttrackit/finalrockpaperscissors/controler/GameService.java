package org.fasttrackit.finalrockpaperscissors.controler;

import org.fasttrackit.finalrockpaperscissors.model.PlayerScore;
import org.fasttrackit.finalrockpaperscissors.model.PlayerScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    @Autowired
    private PlayerScoreRepository playerScoreRepository;
    private static final int WINS_FOR_MEDIUM = 50;
    private static final int WINS_FOR_HARD = 100;

    public String play(String playerName, Move playerMove) {
        Move computerMove = generateComputerMove();
        Move result = determineWinner(playerMove, computerMove);

        PlayerScore playerScore = new PlayerScore();
        playerScore.setPlayerName(playerName);

        if (result == null) {
            playerScore.setScore(0);
        } else if (result == playerMove) {
            playerScore.setScore(1);
        } else {
            playerScore.setScore(-1);
        }

        // Calculate and update the ranking points
        int previousRankingPoints = 0;
        PlayerScore existingPlayerScore = playerScoreRepository.findByPlayerName(playerName);
        if (existingPlayerScore != null) {
            previousRankingPoints = existingPlayerScore.getRankingPoints();
        }
        int updatedRankingPoints = previousRankingPoints + playerScore.getScore();
        playerScore.setRankingPoints(updatedRankingPoints);

        // Update the level based on the number of wins
        String level = "Easy";
        if (updatedRankingPoints >= WINS_FOR_MEDIUM && updatedRankingPoints < WINS_FOR_HARD) {
            level = "Medium";
        } else if (updatedRankingPoints >= WINS_FOR_HARD) {
            level = "Hard";
        }
        playerScore.setLevel(level);

        playerScoreRepository.save(playerScore);

        // Return game result
        if (result == null) {
            return "It's a tie!";
        } else if (result == playerMove) {
            return playerName + " wins!";
        } else {
            return "Computer wins!";
        }
    }

    public void resetScore(String playerName) {
        PlayerScore playerScore = playerScoreRepository.findByPlayerName(playerName);
        if (playerScore != null) {
            playerScore.setScore(0);
            playerScore.setRankingPoints(0);
            playerScore.setLevel("Easy"); // Reset the level as well
            playerScoreRepository.save(playerScore);
        }
    }

    private Move generateComputerMove() {
        // Implement a random move generator for the computer
        Random random = new Random();
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }

    private Move determineWinner(Move playerMove, Move computerMove) {
        // Implement the game logic to determine the winner
        if (playerMove == computerMove) {
            return null; // It's a tie
        } else if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
                (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
                (playerMove == Move.SCISSORS && computerMove == Move.PAPER)) {
            return playerMove; // Player wins
        } else {
            return computerMove; // Computer wins
        }
    }


}