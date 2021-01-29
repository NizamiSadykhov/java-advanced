package character;

import action.CanJump;
import action.CanRun;

public class Human implements CanJump, CanRun {
    private static final String HUMAN_JUMP = "Человек перепрыгнул";
    private static final String HUMAN_NOT_JUMP = "Человек не перепрыгнул";
    private static final String HUMAN_RUN = "Человек побежал";
    private static final String HUMAN_NOT_RUN = "Человек не побежал";
    private static final String HUMAN_NOT_ACTION = "Человек стоит";

    private int jumpHeightLimit;
    private int runningDistanceLimit;
    private boolean isStop;

    public Human(int jumpHeightLimit, int runningDistanceLimit) {
        this.jumpHeightLimit = jumpHeightLimit;
        this.runningDistanceLimit = runningDistanceLimit;
    }

    @Override
    public void canNotAction() {
        System.out.println(HUMAN_NOT_ACTION);
    }

    @Override
    public boolean isStop() {
        return isStop;
    }

    @Override
    public void setStop(boolean isStop) {
        this.isStop = isStop;
    }

    @Override
    public boolean jump(int height) {
        boolean isJump = jumpHeightLimit > height;
        String msg = isJump ? HUMAN_JUMP : HUMAN_NOT_JUMP;
        System.out.println(msg);
        return jumpHeightLimit > height;
    }

    @Override
    public boolean run(int distance) {
        boolean isRun = runningDistanceLimit > distance;
        String msg = isRun ? HUMAN_RUN : HUMAN_NOT_RUN;
        System.out.println(msg);
        return runningDistanceLimit > distance;
    }
}
