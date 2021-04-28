package game1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private final GameService gameService;

    public GameController(GameService game) {
        this.gameService = game;
    }

    @PostMapping("/game/start")
    public GameAnswerDTO start() {
        return gameService.start();
    }

    @PostMapping("/game/move")
    public GameAnswerDTO move(@RequestBody GameMoveDTO moveDTO) {
        return gameService.move(moveDTO);
    }

}
