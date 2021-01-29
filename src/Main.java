import action.CanAction;
import character.Cat;
import character.Human;
import character.Robot;
import obstacles.Barrier;
import obstacles.Obstacle;
import obstacles.Treadmill;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Obstacle> obstacles = getObstacles();
        List<CanAction> characters = getCharacters();

        for (Obstacle obstacle : obstacles) {
            for (int i = 0; i < characters.size(); i++) {
                CanAction character = characters.get(i);
                if (character.isStop()){
                    character.canNotAction();
                    continue;
                }
                boolean isStop =  !obstacle.performAction(character);
                character.setStop(isStop);
            }
        }
    }


    private static List<CanAction> getCharacters() {
        List<CanAction> list = new ArrayList<>(3);
        list.add(new Cat(200, 22000));
        list.add(new Human(50, 130000));
        list.add(new Robot(50000));
        return list;
    }

    private static List<Obstacle> getObstacles() {
        List<Obstacle> list = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            int tmp = i % 2;
            switch (tmp) {
                case 0 -> list.add(new Barrier(10 * i));
                case 1 -> list.add(new Treadmill(2000 * i));
            }
        }
        return list;
    }
}
