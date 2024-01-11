package MainLens;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class VelocityTask extends TimerTask {
    Visualizer v;
    int x = 1;
    Timer timer = new Timer();
    VelocityTask(Visualizer v){
        this.v = v;
        if(v.p.getObject().getDistance()<0)
            x = -1;
        else if(v.p.getObject().getDistance()>0)
            x = 1;
        timer.schedule(this,0,100);
    }
    @Override
    public void run() {
        if(v.p.getObject().getDistance()==0){
            v.p.setObjectDistance(x*(v.p.getObject().getDistance()+1));
            return;
        }
        if(Math.abs(v.p.getObject().getDistance())>v.scaleX)
            x = (-1)*x;

        v.p.setObjectDistance((v.p.getObject().getDistance())+(x*(v.p.getObject().getVelocity()/10)));
        v.p.updateImgVelo();
        v.calculationPanel.setDetails();
        v.velImg.setTextFieldText(""+v.p.getImage().getVelocity());
    }
}

class VelocityRun{
    public Timer timer;
    public VelocityRun(Visualizer v){
        timer = new Timer();
        timer.schedule(new VelocityTask(v),0,100);
    }
}
