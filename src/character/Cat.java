package character;

import action.CanJump;
import action.CanRun;

public class Cat implements CanRun, CanJump {
    private static final String CAT_JUMP = "Кот перепрыгнул";
    private static final String CAT_NOT_JUMP = "Кот не перепрыгнул";
    private static final String CAT_RUN = "Кот пробежал";
    private static final String CAT_NOT_RUN = "Кот не пробежал";
    private static final String CAT_NOT_ACTION = "Кот стоит";


    private int jumpHeightLimit;
    private int runningDistanceLimit;
    private boolean isStop;

    public Cat(int jumpHeightLimit, int runningDistanceLimit) {
        this.jumpHeightLimit = jumpHeightLimit;
        this.runningDistanceLimit = runningDistanceLimit;
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
    public void canNotAction() {
        System.out.println(CAT_NOT_ACTION);
    }

    @Override
    public boolean jump(int height) {
        boolean isJump = jumpHeightLimit > height;
        String msg = isJump ? CAT_JUMP : CAT_NOT_JUMP;
        System.out.println(msg);
        return jumpHeightLimit > height;
    }

    @Override
    public boolean run(int distance) {
        boolean isRun = runningDistanceLimit > distance;
        String msg = isRun ? CAT_RUN : CAT_NOT_RUN;
        System.out.println(msg);
        return runningDistanceLimit > distance;
    }
}
