package game1;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;

@Service
public class GameService {
    HashSet<Integer> set; // TODO private final можно инкапсулировать в какой-нибудь класс типа "игровое поле"
    //TODO и туда добавить методы "попал?" и конструктор который создаёт его
    int i;
    GameAnswerDTO ans = new GameAnswerDTO();

    public GameAnswerDTO start() {
        ShipGenerator game = new ShipGenerator(); // TODO фуу надо получить через конструктор как в GameController
        set = game.generate();
        i = 0;
        ans.answer = "Для победы нужно 3 попадания!";
        return ans;
    }

    public GameAnswerDTO move(GameMoveDTO moveDTO) {
        int num;

        i++;
        num = moveDTO.number;
        if (set.contains(num)) {
            set.remove(num);
            if (set.isEmpty()) {
                ans.answer = "Победа! Ходов: " + i;
            } else {
                ans.answer = "Попал =) Оууу еа!";
            }
        } else {
            ans.answer = "Промазал! =(";
        }
        return ans;
    }
}
