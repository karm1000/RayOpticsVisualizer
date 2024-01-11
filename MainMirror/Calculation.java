package MainMirror;

class Calculation {
	float f, u, v, ho, hi;
	
	Calculation() {
		this.f = 15;
		this.u = -20;
		this.ho = 50;
	}
	
	Calculation(float f, float u, float ho) {
		this.f = f;
		this.u = u;
		this.ho = ho;
	}
	
	void modify(float f, float u, float ho) {
		this.f = f;
		this.u = u;
		this.ho = ho;
	}
	
	float ImageDist() {
		this.v = 1 / ((1 / this.f) - (1 / this.u));
		return this.v;
	}
	
	float ImageHeight() {
		this.hi = (-1f) * (this.v / this.u) * this.ho;
		//if(this.hi < 0) this.hi *= (-1);
		return this.hi;
	}
	
	String ImageType() {
		String type = "";
		if(this.v < 0) {
			if(this.hi < 0 || this.hi > 0) {
				type = "Real and Inverted";
			}
			else if(this.hi == 0) {
				type = "Real and Point-Like";
			}
		}
		else if(this.v >= 0) {
			if(this.hi < 0 || this.hi > 0) {
				type = "Virtual and Errect";
			}
			else if(this.hi == 0) {
				type = "Virtual and Point-Like";
			}
		}
		return type;
	}
	
	String ImageSize() {
		String size = "";
		if(this.hi < 0 && this.ho > 0) {
			if((-1f) * this.hi > this.ho) {
				size = "Enlarged";
			}
			else if(Float.parseFloat(String.format("%.3f", (-1f) * this.hi)) == this.ho) {
				size = "Same as Object";
			}
			else if((-1f) * this.hi < this.ho) {
				size = "Diminished";
			}
		}
		else if(this.hi > 0 && this.ho < 0) {
			if(this.hi > (-1f) * this.ho) {
				size = "Enlarged";
			}
			else if(Float.parseFloat(String.format("%.3f", this.hi)) == (-1f) * this.ho) {
				size = "Same as Object";
			}
			else if(this.hi < (-1f) * this.ho) {
				size = "Diminished";
			}
		}
		else if(this.hi > 0 && this.ho > 0) {
			if(this.hi > this.ho) {
				size = "Enlarged";
			}
			else if(Float.parseFloat(String.format("%.3f", this.hi)) == this.ho) {
				size = "Same as Object";
			}
			else if(this.hi < this.ho) {
				size = "Diminished";
			}
		}
		else if(this.hi < 0 && this.ho < 0) {
			if(this.hi < this.ho) {
				size = "Enlarged";
			}
			else if(Float.parseFloat(String.format("%.3f", this.hi)) == this.ho) {
				size = "Same as Object";
			}
			else if(this.hi > this.ho) {
				size = "Diminished";
			}
		}
		return size;
	}
}