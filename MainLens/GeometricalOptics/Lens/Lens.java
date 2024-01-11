package MainLens.GeometricalOptics.Lens;

import java.text.DecimalFormat;

public class Lens {
    double r=30;//Curvature radius of One side Of the lens
    double f;//Focal Length of lens
    double refractiveIndex_wrt_Medium = 1.5;
    double refractiveIndex = 1.5; //Refractive Index Of Lens
    double refractiveIndexOfMedium = 1; //Assumed to have symmetric Medium
    boolean isDiverging;

    public boolean isDiverging(){
        return isDiverging;
    }


    public Lens(double focalLength){
        this.f = focalLength;
        isDiverging = (!(f>0));
    }



    public Lens(double r,double refractiveIndex_wrt_Medium){
        this.r = r;
        this.refractiveIndex_wrt_Medium = refractiveIndex_wrt_Medium;
        this.setFocal();
    }

    public Lens(double r,double refractiveIndex,double refractiveIndexOfMedium){
        this.r = r;
        this.refractiveIndex = refractiveIndex;
        this.refractiveIndexOfMedium = refractiveIndexOfMedium;
        this.refractiveIndex_wrt_Medium = refractiveIndex/refractiveIndexOfMedium;
        this.setFocal();
    }

    private double calculateFocalLength(){

        double one_over_f = (this.refractiveIndex_wrt_Medium - 1.0)*(2/this.r);
        return 1/one_over_f;
    }



    public double getR() {
        return r;
    }

    private void setFocal(){
        this.f = calculateFocalLength();
        try {
            this.f = Double.parseDouble(new DecimalFormat("#.###").format(this.f));
        }catch (NumberFormatException e){
            this.f = f;
        }
        isDiverging = (!(f > 0));
        if(refractiveIndexOfMedium==refractiveIndex){
            if(f<0){
                f = Double.NEGATIVE_INFINITY;
            }else {
                f= Double.POSITIVE_INFINITY;
            }
        }
    }

    public void setR(double r1) {
        this.r = r1;
        this.setFocal();
    }

    public void set_ref_index_lens(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
        this.setRefractiveIndex_wrt_medium();
        this.setFocal();
    }

    public void set_ref_index_medium(double refractiveIndexOfMedium) {
        this.refractiveIndexOfMedium = refractiveIndexOfMedium;
        this.setRefractiveIndex_wrt_medium();
        this.setFocal();
    }

    public double getF() {
        return f;
    }

    public String getStringF(){
        if(f==Double.POSITIVE_INFINITY){
            return Character.toString('\u221e');
        }else if (f==Double.NEGATIVE_INFINITY){
            return "-"+Character.toString('\u221e');
        }

        return ""+f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public void setRefractiveIndex_wrt_medium() {
        this.refractiveIndex_wrt_Medium = refractiveIndex/refractiveIndexOfMedium;
    }

    public double getRefractiveIndex_wrt_Medium() {
        return refractiveIndex_wrt_Medium;
    }

    public void setRefractiveIndex_wrt_Medium(double refractiveIndex_wrt_Medium) {
        this.refractiveIndex_wrt_Medium = refractiveIndex_wrt_Medium;
        this.setFocal();
    }

    public double getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
        this.refractiveIndex_wrt_Medium = this.refractiveIndex/this.refractiveIndexOfMedium;
        this.setFocal();
    }

    public double getRefractiveIndexOfMedium() {
        return refractiveIndexOfMedium;
    }

    public void setRefractiveIndexOfMedium(double refractiveIndexOfMedium) {
        this.refractiveIndexOfMedium = refractiveIndexOfMedium;
        this.refractiveIndex_wrt_Medium = this.refractiveIndex/this.refractiveIndexOfMedium;
        this.setFocal();
    }

    public void displayProperties(){
        System.out.println("Focal Length  - "+f
                +"\nCurvature Radius 1 - "+(r==0.0?"NAN":r)
                +"\nRefractive Index Of Lens - "+(refractiveIndex==0.0?"NAN":refractiveIndex)
                +"\nRefractive Index of Medium - "+(refractiveIndexOfMedium==0.0?"NAN":refractiveIndexOfMedium)
                +"\nRefractive Index Of Lens with respect to Medium - "+(refractiveIndex_wrt_Medium==0.0?"NAN":refractiveIndex_wrt_Medium)
        );
    }

}
