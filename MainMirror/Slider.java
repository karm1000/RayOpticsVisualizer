package MainMirror;

class Slider {
	int maxValueX(float u, float v, float f) {
		int x = (int) (Math.max(Math.max(Math.abs(u), Math.abs(v)), Math.abs(2f * f)));
		if (x <= 100)
			return 200;
		else if (x <= 200)
			return 400;
		else if (x <= 300)
			return 600;
		else if (x <= 400)
			return 800;
		else if (x <= 500)
			return 1000;
		else if (x <= 600)
			return 1200;
		else if (x <= 700)
			return 1400;
		else if (x <= 800)
			return 1600;
		else if (x <= 900)
			return 1800;
		else if (x <= 1000)
			return 2000;
		else if (x <= 2000)
			return 4000;
		else if (x <= 5000)
			return 10000;
		else if (x <= 10000)
			return 20000;
		else if (x <= 60000)
			return 120000;
		else
			return 1000000;
	}

	int maxValueY(float ho, float hi) {
		int y = (int) Math.max(Math.abs(hi), Math.abs(ho));
		if (y <= 100)
			return 200;
		else if (y <= 200)
			return 300;
		else if (y <= 300)
			return 400;
		else if (y <= 500)
			return 600;
		else if (y <= 600)
			return 700;
		else if (y <= 700)
			return 800;
		else if (y <= 800)
			return 900;
		else if (y <= 900)
			return 1000;
		else if (y <= 1000)
			return 2000;
		else if (y <= 2000)
			return 3000;
		else if (y <= 5000)
			return 10000;
		else if (y <= 10000)
			return 20000;
		else if (y <= 60000)
			return 100000;
		else
			return 1000000;
	}

	int gapObject(float u, float v, float f) {
		int x = this.maxValueX(u, v, f);
		if (x <= 200)
			return 10;
		else if (x <= 500)
			return 50;
		else if (x <= 1000)
			return 100;
		else if (x <= 3000)
			return 300;
		else if (x <= 5000)
			return 500;
		else if (x <= 10000)
			return 1000;
		else if (x <= 100000)
			return x/5;
		else
			return 100000;
	}

	int gapHeight(float ho, float hi) {
		int y = this.maxValueY(ho, hi);
		if (y <= 200)
			return 50;
		else if (y <= 500)
			return 100;
		else if (y <= 1000)
			return 250;
		else if (y <= 10000)
			return 1000;
		else if (y <= 100000)
			return 10000;
		else if (y <= 1000000)
			return 100000;
		else
			return y / 5;
	}
	int gapObjectSlider(int myMx) {
		int x = myMx;
		if (x <= 200)
		return 10;
	else if (x <= 500)
		return 50;
	else if (x <= 1000)
		return 100;
	else if (x <= 3000)
		return 300;
	else if (x <= 5000)
		return 500;
	else if (x <= 10000)
		return 1000;
	else if (x <= 100000)
		return x/5;
	else
		return 100000;
}

	int gapHeightSlider(int myMy) {
		int y = myMy;
		if (y <= 200)
			return 50;
		else if (y <= 500)
			return 100;
		else if (y <= 1000)
			return 250;
		else if (y <= 10000)
			return 1000;
		else if (y <= 100000)
			return 10000;
		else if (y <= 1000000)
			return 100000;
		else
			return y / 5;
	}
}