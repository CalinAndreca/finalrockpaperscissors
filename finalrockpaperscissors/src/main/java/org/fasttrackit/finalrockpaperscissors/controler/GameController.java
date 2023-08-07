package org.fasttrackit.finalrockpaperscissors.controler;

import org.fasttrackit.finalrockpaperscissors.model.PlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/play")
    public GameResult playGame(@RequestBody PlayerRequest playerRequest) {
        String playerName = playerRequest.getPlayerName();
        Move playerMove = playerRequest.getPlayerMove();
        return gameService.play(playerName, playerMove);
    }

    @PostMapping("/reset")
    public String resetScore(@RequestParam String playerName) {
        gameService.resetScore(playerName);
        return "Score reset for player: " + playerName;
    }

}
