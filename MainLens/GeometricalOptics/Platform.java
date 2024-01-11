package MainLens.GeometricalOptics;
import MainLens.GeometricalOptics.Lens.Lens;
import MainLens.GeometricalOptics.Specimen.ImageSpecimen;
import MainLens.GeometricalOptics.Specimen.ObjectSpecimen;

import java.text.DecimalFormat;

class InfiniteValueException extends Exception{
    @Override
    public String toString() {
        return super.toString()+ "Value is Infinite";
    }
}
public class Platform {
    Lens lens;
    ObjectSpecimen object;
    ImageSpecimen image;
    double magnificationFactor;
    double power;

    DecimalFormat df=new DecimalFormat("#.##");

    public Platform(ObjectSpecimen object, Lens lens){
        object.setDistance(Double.parseDouble(df.format(object.getDistance())));
        object.setHeight(Double.parseDouble(df.format(object.getHeight())));
        this.object = object;
        this.lens = lens;
        double u = object.getDistance();
        double f = lens.getF();
        double v = calculateV(u,f);
        this.magnificationFactor = v/u;
        double h2 = magnificationFactor*object.getHeight();
        try{
//            if(Double.isInfinite(v))

            if(v==Double.POSITIVE_INFINITY||v==Double.NEGATIVE_INFINITY){
                throw new InfiniteValueException();
            }
            v = Double.parseDouble(df.format(v));
            this.magnificationFactor = Double.parseDouble(df.format(this.magnificationFactor));
            h2 = Double.parseDouble(df.format(h2));
            this.image = new ImageSpecimen(v,h2);
        }catch(InfiniteValueException e){
            this.image = new ImageSpecimen(v,h2);
        }
        setRealOrNot();
    }

    private double calculateV(double u,double f){
        double one_over_v = (1/f)+(1/u);
        return 1/one_over_v;
    }

    public void setObjVelo(double constVelo){
        this.object.setVelocity(Double.parseDouble(df.format(constVelo)));
        double vi = Double.parseDouble(df.format(constVelo*(Math.pow(image.getDistance()/object.getDistance(),2))));
        this.image.setVelocity(vi);
    }

    public void updateImgVelo(){
        double vi = object.getDistance()*(Math.pow(image.getDistance()/object.getDistance(),2));
        if(Double.isInfinite(vi)){
            this.image.setVelocity(vi);
        }else {
            vi = Double.parseDouble(df.format(object.getVelocity()*(Math.pow(image.getDistance()/object.getDistance(),2))));
            this.image.setVelocity(vi);
        }
    }

    public Lens getLens() {
        return lens;
    }

    public void setLens(Lens lens) {
        this.lens = lens;
        double u = object.getDistance();
        double f = lens.getF();
        double v = calculateV(u,f);
        this.magnificationFactor = v/u;
        double h2 = magnificationFactor*object.getHeight();
        try {
            if(v==Double.POSITIVE_INFINITY||v==Double.NEGATIVE_INFINITY){
                throw new InfiniteValueException();
            }
            v = Double.parseDouble(df.format(v));
            this.magnificationFactor = Double.parseDouble(df.format(this.magnificationFactor));
            h2 = Double.parseDouble(df.format(h2));
            this.image = new ImageSpecimen(v,h2);
        }catch (InfiniteValueException e){
            this.image = new ImageSpecimen(v,h2);
        }
        setRealOrNot();
    }
    public void setObjectDistance(double distance){
        this.object.setDistance(Double.parseDouble(df.format(distance)));
        double u = Double.parseDouble(String.format("%.3f",object.getDistance()));
        double f = lens.getF();
        double v = calculateV(u,f);
        this.magnificationFactor = v/u;
        double h2 = magnificationFactor*object.getHeight();
        try {
            if(v==Double.POSITIVE_INFINITY||v==Double.NEGATIVE_INFINITY){
                throw new InfiniteValueException();
            }
            v = Double.parseDouble(df.format(v));
            this.magnificationFactor = Double.parseDouble(df.format(this.magnificationFactor));
            h2 = Double.parseDouble(df.format(h2));
            this.image.setDistance(v);
            this.image.setHeight(h2);
        }catch (InfiniteValueException e){
            this.image.setDistance(v);
            this.image.setHeight(h2);
        }
        setRealOrNot();

    }

    public ObjectSpecimen getObject() {
        return object;
    }

    public void setObjectHeight(double ho){
        this.object.setHeight(Double.parseDouble(df.format(ho)));
        this.image.setHeight(Double.parseDouble(df.format(ho*magnificationFactor)));
    }

    public void setObject(ObjectSpecimen object) {
        object.setDistance(Double.parseDouble(df.format(object.getDistance())));
        object.setHeight(Double.parseDouble(df.format(object.getHeight())));
        this.object = object;
        double u = Double.parseDouble(String.format("%.3f",object.getDistance()));
        double f = lens.getF();
        double v = calculateV(u,f);
        this.magnificationFactor = v/u;
        double h2 = magnificationFactor*object.getHeight();
        try {
            if(v==Double.POSITIVE_INFINITY||v==Double.NEGATIVE_INFINITY){
                throw new InfiniteValueException();
            }
            v = Double.parseDouble(df.format(v));
            this.magnificationFactor = Double.parseDouble(df.format(this.magnificationFactor));
            h2 = Double.parseDouble(df.format(h2));
            this.image = new ImageSpecimen(v,h2);
        }catch (InfiniteValueException e){
            this.image = new ImageSpecimen(v,h2);
        }
        setRealOrNot();
    }

    public ImageSpecimen getImage() {
        return image;
    }
    
    public String getStringMagnificationFactor(){
        if(this.magnificationFactor==Double.POSITIVE_INFINITY){
            return Character.toString('\u221e');
        } else if (this.magnificationFactor==Double.NEGATIVE_INFINITY) {
            return "-"+Character.toString('\u221e');
        }
        return Double.toString(this.magnificationFactor);
    }

    public void display(){
        System.out.println("Lens Properties:");
        lens.displayProperties();
        System.out.println("Object :"
                +"\nObject Distance - " + getObject().getStringDistance()
                +"\nObject Height - " + getObject().getStringHeight()
                +"\nImage :"
                +"\nImage Distance - " + getImage().getStringDistance()
                +"\nImage Height - " + getImage().getStringHeight()
                +"\n-->Lateral Magnification Factor "+getStringMagnificationFactor()
                +"\nImage is "+getImage().getStringVirtual()
        );
    }

    private void setRealOrNot(){
        if(lens.isDiverging()){
            if(object.getDistance()>0 && object.getDistance()<Math.abs(lens.getF()))image.setVirtual(false);
            else image.setVirtual(true);
        }
        else {
            if(object.getDistance()<0 && Math.abs(object.getDistance())<lens.getF()) image.setVirtual(true);
            else image.setVirtual(false);
        }
//        if(((this.lens.getF()>0 && Math.abs(this.object.getDistance())<Math.abs(this.lens.getF())) && this.getObject().getDistance()<0)|| this.lens.getF()<0){
//            this.image.setVirtual(true);
//        }else {
//            this.image.setVirtual(false);
//        }
    }
}
