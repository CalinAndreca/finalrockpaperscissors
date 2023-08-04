package org.fasttrackit.finalrockpaperscissors.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@RequiredArgsConstructor
public class PlayerScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String playerName;
    @Column
    private int score;
    @Column
    private int rankingPoints;
    @Column
    private String level;
//public PlayerScore() {

   // }

}
