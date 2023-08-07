package org.fasttrackit.finalrockpaperscissors.controler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameResult {
    private String result; // "Player wins!", "Computer wins!", or "It's a tie!"
    private Move computerMove; // The computer's move

    public GameResult(String result, Move computerMove) {
        this.result = result;
        this.computerMove = computerMove;
    }
}
