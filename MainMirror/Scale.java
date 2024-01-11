package MainMirror;

class Scale {
	float x, y, scalex, scaley;
	MainFrame obj;
	Scale(MainFrame obj)
	{
		this.obj=obj;
		reset(obj);
	}
	void reset(MainFrame obj) {
		this.obj = obj;
		 x = (obj.d1.width - 280);
		//else x = (obj.d1.width - 280) / 2;
		y = (obj.height.getHeight() / 2);
		obj.scaleX = x / (float)obj.mX;
		obj.scaleY = y / (float)obj.mY;
		}
}