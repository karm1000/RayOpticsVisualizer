package MainMirror;

class Logic {
    MainFrame obj;
    int flag;

    Logic(MainFrame f, int flag) {
        obj = f;
        this.flag = flag;
    }

    void modify(MainFrame f, int flag) {
        obj = f;
        this.flag = flag;
	}

    public void actionMethod() throws NumberFormatException, MyException1 {
        if (flag == 1) {
			
			
			obj.u = obj.distance.getValue();
            obj.ho = obj.height.getValue();
            obj.f = obj.top.focal.getValue();
            
			obj.obj.modify(obj.f, obj.u, obj.ho);
			obj.v = obj.obj.ImageDist();
            obj.hi = obj.obj.ImageHeight();
            
			obj.top.u_tf.setText("" + obj.u);
            obj.top.f_tf.setText("" + obj.f);
            obj.top.ho_tf.setText("" + obj.ho);

            obj.top.s = String.valueOf(String.format("%.3f", obj.v));
            obj.top.v_tf.setText(obj.top.s);
            
			obj.top.s = String.valueOf(String.format("%.3f", obj.hi));
            obj.top.hi_tf.setText(obj.top.s);
            
			obj.top.s = String.valueOf(String.format("%.3f", obj.hi / obj.ho));
            obj.top.mag_tf.setText(obj.top.s);
			
			obj.top.s = obj.obj.ImageSize();
            obj.top.isize.setText("Image Size : " + obj.top.s);
            
			obj.top.s = obj.obj.ImageType();
            obj.top.itype.setText("Image Type : " + obj.top.s);
			obj.top.isize.setToolTipText(obj.top.isize.getText());
			obj.top.itype.setToolTipText(obj.top.itype.getText());
		  
            
			obj.graphics.repaint();

            if (obj.f < 0) {
                if (obj.u <= obj.f) {
                    obj.distance.removeChangeListener(obj.me);
                    obj.distance.setSize((obj.d1.width - 280), 80);
                    obj.distance.setMinimum((int) (-obj.mX));
                    obj.distance.addChangeListener(obj.me);
				}
				else if (obj.u > obj.f) {
                    obj.distance.removeChangeListener(obj.me);
                    obj.distance.setSize((obj.d1.width - 280) / 2, 80);
                    obj.distance.setMinimum((int) (-obj.mX / 2));
                    obj.distance.addChangeListener(obj.me);
				}
                obj.top.faltu();
			}
			/*else if(obj.f > 0) {
				obj.distance.removeChangeListener(obj.me);
				obj.distance.setSize((obj.d1.width - 280) / 2, 80);
				obj.distance.setMinimum((int) (-obj.mX / 2));
				obj.distance.addChangeListener(obj.me);
			}*/
        }
		else if (flag == 2) {
            float temp, temp2;
            temp = obj.u;
			temp2 = obj.ho;
			
			obj.u = Float.parseFloat(obj.top.u_tf.getText());
            obj.ho = Float.parseFloat(obj.top.ho_tf.getText());
			
			if(obj.u > 0) {
				obj.u = temp;
				throw new MyException1(1);
			}
			else if(obj.u < -10000 || Math.abs(obj.ho) > 10000) {
				obj.u = temp;
				obj.ho = temp2;
				throw new MyException1(2);
			}
			else if(obj.u < -1000 || Math.abs(obj.ho) > 1000) {
				try {
					throw new MyException1();
				} catch(MyException1 me1) {
					int a = me1.tooLarge();
					//System.out.println("response : " + a);
					if(a == 1) {
						obj.u = temp;
						obj.ho = temp2;
						return;
					}
				  }
			}
			
            obj.obj.modify(obj.f, obj.u, obj.ho);
			obj.v = obj.obj.ImageDist();
            obj.hi = obj.obj.ImageHeight();

            obj.top.s = String.valueOf(String.format("%.3f", obj.v));
            obj.top.v_tf.setText(obj.top.s);
            
			obj.top.s = String.valueOf(String.format("%.3f", obj.hi));
            obj.top.hi_tf.setText(obj.top.s);
            
			obj.top.s = String.valueOf(String.format("%.3f", obj.hi / obj.ho));
            obj.top.mag_tf.setText(obj.top.s);

            obj.top.s = obj.obj.ImageSize();
            obj.top.isize.setText("Image Size : " + obj.top.s);
            
			obj.top.s = obj.obj.ImageType();
            obj.top.itype.setText("Image Type : " + obj.top.s);
            
			obj.mX = obj.slider.maxValueX(obj.u, obj.v, obj.f);
            obj.mY = obj.slider.maxValueY(obj.ho, obj.hi);
		
			obj.top.isize.setToolTipText(obj.top.isize.getText());
			obj.top.itype.setToolTipText(obj.top.itype.getText());
		  
            obj.scale.reset(obj);
			obj.graphics.repaint();
            
            if (obj.f < 0) {
				if (temp <= obj.f && obj.u > obj.f) {
					obj.distance.setSize((obj.d1.width - 280) / 2 , 80);
				}
				else if (temp > obj.f && obj.u <= obj.f) {
					obj.distance.setSize((obj.d1.width - 280), 80);
				}
				
				if(obj.u > obj.f) {
					obj.distance.removeChangeListener(obj.me);
					obj.distance.setMinimum((int) (-obj.mX /2));
					obj.distance.addChangeListener(obj.me);
				}
				else if(obj.u <= obj.f) {
					obj.distance.removeChangeListener(obj.me);
					obj.distance.setMinimum((int) (-obj.mX));
					System.out.println("mX = " + obj.mX + " ... slider min = " + obj.distance.getMinimum());
					obj.distance.addChangeListener(obj.me);
				}
			}
			else if(obj.f > 0) {
				obj.distance.removeChangeListener(obj.me);
				obj.distance.setMinimum((int) (-obj.mX / 2));
				obj.distance.setSize((obj.d1.width - 280) / 2, 80);
				obj.distance.addChangeListener(obj.me);
			}
			
			obj.distance.removeChangeListener(obj.me);
			obj.distance.setValue((int) (obj.u));
			obj.distance.addChangeListener(obj.me);
			
			obj.height.removeChangeListener(obj.me);
			obj.height.setMinimum((int) (-obj.mY));
			obj.height.setMaximum((int) (obj.mY));
			obj.height.setValue((int) obj.ho);
			obj.height.addChangeListener(obj.me);
			
			obj.top.faltu();
		}
		else if(flag == 3) {
			obj.f *= -1;
			if(obj.f < 0) obj.f = -30;
			else if(obj.f > 0) obj.f = 30;
			obj.u = -50;
			obj.ho = 100;
			
			obj.obj.modify(obj.f, obj.u, obj.ho);
			
            obj.v = obj.obj.ImageDist();
            obj.hi = obj.obj.ImageHeight();

            obj.top.u_tf.setText("" + obj.u);
            obj.top.f_tf.setText("" + obj.f);
            obj.top.ho_tf.setText("" + obj.ho);
			
			obj.top.s = String.valueOf(String.format("%.3f", obj.v));
            obj.top.v_tf.setText(obj.top.s);
            
			obj.top.s = String.valueOf(String.format("%.3f", obj.hi));
            obj.top.hi_tf.setText(obj.top.s);
            
			obj.top.s = String.valueOf(String.format("%.3f", obj.hi / obj.ho));
            obj.top.mag_tf.setText(obj.top.s);

            obj.top.s = obj.obj.ImageSize();
            obj.top.isize.setText("Image Size : " + obj.top.s);
            
			obj.top.s = obj.obj.ImageType();
            obj.top.itype.setText("Image Type : " + obj.top.s);
			
			obj.top.isize.setToolTipText(obj.top.isize.getText());
			obj.top.itype.setToolTipText(obj.top.itype.getText());
		  

			obj.mX = obj.slider.maxValueX(obj.u, obj.v, obj.f);
            obj.mY = obj.slider.maxValueY(obj.ho, obj.hi);
			
			obj.scale.reset(obj);
			obj.graphics.repaint();
			
			if(obj.f < 0) {
                obj.top.focal.removeChangeListener(obj.me);
                obj.top.focal.setMaximum(-10);
                obj.top.focal.setMinimum(-210);
                obj.top.focal.setValue((int) obj.f);
                obj.top.focal.addChangeListener(obj.me);
				
				obj.distance.removeChangeListener(obj.me);
				obj.distance.setSize((obj.d1.width - 280), 80);
				obj.distance.setMinimum((int) (-obj.mX));
				obj.distance.addChangeListener(obj.me);
			}
			else if (obj.f > 0) {
                obj.top.focal.removeChangeListener(obj.me);
                obj.top.focal.setMaximum(210);
                obj.top.focal.setMinimum(10);
                obj.top.focal.setValue((int) obj.f);
                obj.top.focal.addChangeListener(obj.me);
				
				obj.distance.removeChangeListener(obj.me);
				obj.distance.setMinimum((int) (-obj.mX / 2));
				obj.distance.setSize((obj.d1.width - 280) / 2, 80);
				obj.distance.addChangeListener(obj.me);
            }
			
			obj.distance.removeChangeListener(obj.me);
			obj.distance.setValue((int) (obj.u));
			obj.distance.addChangeListener(obj.me);
			
			obj.height.removeChangeListener(obj.me);
			obj.height.setMinimum((int) (-obj.mY));
			obj.height.setValue((int) obj.ho);
			obj.height.setMaximum((int) (obj.mY));
			obj.height.addChangeListener(obj.me);
		}
    }
}