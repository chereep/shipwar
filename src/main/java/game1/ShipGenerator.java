package game1;

import org.springframework.stereotype.Service;

import java.util.HashSet;
@Service
// TODO сделать сервисом и заинжектить в GameService
class ShipGenerator {

    public HashSet<Integer> generate() {
        int pole;
        HashSet<Integer> set = new HashSet<>();

        pole = (int) (Math.random() * 10);
        if (pole >= 9) { // TODO чё за костыль мб сразу в диапозоне генерировать?
            pole--;
        }
        set.add(pole);
        set.add(pole+1);
        set.add(pole+2);
        return set;
    }
}
