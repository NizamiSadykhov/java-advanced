package obstacles;

import action.CanAction;
import action.CanJump;

public class Barrier extends Obstacle{
    private int height;

    public Barrier(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean performAction(CanAction actor) {
        if (actor instanceof CanJump){
           return ((CanJump)actor).jump(getHeight());
        }
        return false;
    }
}
