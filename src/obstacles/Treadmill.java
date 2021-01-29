package obstacles;

import action.CanAction;
import action.CanRun;

public class Treadmill extends Obstacle{
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean performAction(CanAction actor) {
        if (actor instanceof CanRun){
            return ((CanRun) actor).run(getDistance());
        }
        return false;
    }
}
