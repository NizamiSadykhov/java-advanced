package character;

import action.CanRun;

public class Robot implements CanRun {
    private static final String ROBOT_RUN = "Робот проехал";
    private static final String ROBOT_NOT_RUN = "Робот не проехал";
    private static final String ROBOT_NOT_ACTION = "Робот стоит";


    private int runningDistanceLimit;
    private boolean isStop;

    public Robot(int runningDistanceLimit) {
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
        System.out.println(ROBOT_NOT_ACTION);
    }

    @Override
    public boolean run(int distance) {
        boolean isRun = runningDistanceLimit > distance;
        String msg = isRun ? ROBOT_RUN : ROBOT_NOT_RUN;
        System.out.println(msg);
        return runningDistanceLimit > distance;
    }
}
