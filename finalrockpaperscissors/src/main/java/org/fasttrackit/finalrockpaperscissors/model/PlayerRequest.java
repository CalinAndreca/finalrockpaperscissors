package org.fasttrackit.finalrockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.fasttrackit.finalrockpaperscissors.controler.Move;
@AllArgsConstructor
@Getter
@Setter
public class PlayerRequest {
    private String playerName;
    private Move playerMove;


}
