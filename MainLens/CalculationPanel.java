package MainLens;

import MainLens.FrameToolkit.DetailPanel;
import MainLens.FrameToolkit.FocalLengthPanel;
import MainLens.FrameToolkit.FocalLengthSlider;
import MainLens.FrameToolkit.InformationContainer;
import MainLens.GeometricalOptics.Platform;

public class CalculationPanel extends InformationContainer {
    Visualizer v;
    Platform p;
    public DetailPanel objectDistance;
    public DetailPanel objectHeight;
    public DetailPanel objectType;
    public DetailPanel imageDistance;
    public DetailPanel imageHeight;
    public DetailPanel imageType;
    public FocalLengthSlider focalLengthSlider;
    public FocalLengthPanel focalLengthPanel;
    public DetailPanel focalLength;
    public DetailPanel magnificationFactor;
    
    public CalculationPanel(Visualizer visualizer){
        v = visualizer;
        p = v.p;

        objectDistance = new DetailPanel("Object Distance - ",p.getObject().getStringDistance());
        objectHeight = new DetailPanel("Object Height - ",p.getObject().getStringHeight());
        objectType = new DetailPanel("Object is "+p.getObject().getType(), DetailPanel.NO_TEXTFIELD);
        imageDistance = new DetailPanel("Image Distance - ",p.getImage().getStringDistance());
        imageHeight = new DetailPanel("Image Height - ",p.getImage().getStringHeight());
        imageType = new DetailPanel("Image is "+p.getImage().getType(), DetailPanel.NO_TEXTFIELD);
        focalLengthSlider = new FocalLengthSlider(0,50,(int)p.getLens().getF());
        focalLengthPanel = new FocalLengthPanel();
        focalLength = new DetailPanel("Focal Length - ",String.valueOf(focalLengthSlider.getValue()));
        magnificationFactor = new DetailPanel("Magnification Factor - ",p.getStringMagnificationFactor());
        
        imageDistance.textField.setEditable(false);
        imageHeight.textField.setEditable(false);
        magnificationFactor.textField.setEditable(false);


        this.addDetailPanel(objectDistance);
		this.addDetailPanel(objectHeight);
		this.addDetailPanel(objectType);
		this.addDetailPanel(imageDistance);
		this.addDetailPanel(imageHeight);
		this.addDetailPanel(imageType);

		focalLength.setPreferredSize(DetailPanel.size);

        focalLengthSlider.addChangeListener(v.events);

        objectDistance.textField.addActionListener(v.events);
        objectDistance.textField.addKeyListener(v.events);

        objectHeight.textField.addActionListener(v.events);
        objectHeight.textField.addKeyListener(v.events);

        focalLength.textField.addActionListener(v.events);
        focalLength.textField.addKeyListener(v.events);

		focalLengthPanel.add(focalLengthSlider);
		focalLengthPanel.add(focalLength);

        focalLength.addMouseListener(v.events);
        
        objectDistance.textField.setToolTipText("ENTER OBJECT DISTANCE(In cm)");
		objectHeight.textField.setToolTipText("ENTER OBJECT HEIGHT(IN cm)");
		imageDistance.textField.setToolTipText("IMAGE DISTANCE(IN cm");
		imageHeight.textField.setToolTipText("IMAGE HEIGHT(IN cm");
		imageType.label.setToolTipText(imageType.textField.getText());
		objectType.label.setToolTipText(objectType.textField.getText());
		focalLengthSlider.setToolTipText("SET FOCAL LENGTH(IN cm)");
		focalLength.textField.setToolTipText("ENTER FOCAL LENGTH(IN cm)");
		magnificationFactor.textField.setToolTipText("MAGNIFICATION FACTOR");

		this.addDetailPanel(focalLengthPanel);
		super.row++;
		this.addDetailPanel(magnificationFactor);
    }

    public void setDetails(){



        /*if(p.getLens().getF()>0){
            focalLengthSlider.setMinimum(0);
            focalLengthSlider.setMaximum(50);
        }else {
            focalLengthSlider.setMinimum(-50);
            focalLengthSlider.setMaximum(0);
        }

        focalLengthSlider.setValue((int) p.getLens().getF());*/

        objectDistance.setTextFieldText(p.getObject().getStringDistance());
        objectHeight.setTextFieldText(p.getObject().getStringHeight());
        objectType.setLabelText("Object is "+p.getObject().getType());

        imageHeight.setTextFieldText(p.getImage().getStringHeight());
        imageDistance.setTextFieldText(p.getImage().getStringDistance());
        imageType.setLabelText("Image is "+p.getImage().getType());

        magnificationFactor.setTextFieldText(p.getStringMagnificationFactor());
        focalLength.setTextFieldText(p.getLens().getStringF());

        v.frame.panel.radius_of_cur.setTextFieldText(""+p.getLens().getR());
        v.frame.panel.ref_index_lens.setTextFieldText(""+p.getLens().getRefractiveIndex());
        v.frame.panel.ref_index_medium.setTextFieldText(""+p.getLens().getRefractiveIndexOfMedium());

        focalLength.setTextFieldText(p.getLens().getStringF());

//        v.isScaleNeeded();

//        if(!v.p.getStringMagnificationFactor().equals("NaN") && !v.isOutOfRange()) {
//            v.g_panel.repaint();
//        }
        if (!v.isOutOfRange()) {
            System.out.println("IS OFR"+v.isOutOfRange());
            v.setSlider();
            v.g_panel.repaint();
        }

    }
}
