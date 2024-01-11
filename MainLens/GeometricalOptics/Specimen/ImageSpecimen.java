package MainLens.GeometricalOptics.Specimen;

public class ImageSpecimen{
    double distance;
    double height;
    boolean isVirtual;

    double velocity = 0.0;

    public boolean isVirtual() {
        return isVirtual;
    }

    public void setVirtual(boolean virtual) {
        isVirtual = virtual;
    }


    public ImageSpecimen(double distance, double height){
        this.distance = distance;
        this.height = height;
        this.isVirtual = false;
    }
    
    public String getStringDistance(){
        if(this.distance==Double.POSITIVE_INFINITY){
            return Character.toString('\u221e');
        } else if (this.distance==Double.NEGATIVE_INFINITY) {
            return "-"+Character.toString('\u221e');
        }
        return Double.toString(this.distance);

    }
    public String getStringHeight(){
        if(this.height==Double.POSITIVE_INFINITY){
            return Character.toString('\u221e');
        } else if (this.height==Double.NEGATIVE_INFINITY) {
            return "-"+Character.toString('\u221e');
        }
        return Double.toString(this.height);

    }

    public String getStringVirtual(){
        return (isVirtual==true?"Virtual":"Real");
    }

    public double getDistance() {
        return distance;
    }

    public double getHeight() {
        return height;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getType(){
        return (isVirtual==true?"Virtual":"Real")+(height==0.0?", Point Image":"");
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

}

