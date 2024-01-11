package MainLens;

import MainLens.GeometricalOptics.Platform;

public class VelocityThread extends Thread{
    Visualizer v;
    boolean go;
    int x = 1;
    public VelocityThread(Visualizer v){
        super("Velocity Thread");
        this.v = v;
        this.go = true;
        this.setPriority(Thread.MAX_PRIORITY);
        start();
    }

    @Override
    public void run() {
        if(v.p.getObject().getDistance()<0)
            x = -1;
        else if(v.p.getObject().getDistance()>0)
            x = 1;

        while(go){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                go = false;
            }
            if(v.p.getObject().getDistance()==0){
                v.p.setObjectDistance(x*(v.p.getObject().getDistance()+1));
                continue;
            }
            if(Math.abs(v.p.getObject().getDistance())>v.scaleX)
                x = (-1)*x;

            v.p.setObjectDistance((v.p.getObject().getDistance())+(x*(v.p.getObject().getVelocity()/100)));
            v.p.updateImgVelo();
            v.calculationPanel.setDetails();
            v.velImg.setTextFieldText(""+v.p.getImage().getVelocity());
        }
    }
}

class VelRun implements Runnable {
    Visualizer v;
    int x;
    VelRun(Visualizer v){
        this.v = v;
        if(v.p.getObject().getDistance()<0)
            x = -1;
        else if(v.p.getObject().getDistance()>0)
            x = 1;
    }
    @Override
    public void run() {
        if(v.p.getObject().getDistance()==0){
            v.p.setObjectDistance(x*(v.p.getObject().getDistance()+1));
            return;
        }
        if(v.p.getObject().getDistance()>v.scaleX) x = -1;
        if(v.p.getObject().getDistance()<(-v.scaleX)) x = 1;



        v.p.setObjectDistance((v.p.getObject().getDistance())+(x*(v.p.getObject().getVelocity()/16)));
        v.p.updateImgVelo();
        v.calculationPanel.setDetails();
        v.velImg.setTextFieldText(""+v.p.getImage().getVelocity());
    }
}
