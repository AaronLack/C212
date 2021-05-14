public class PolarComplex {
/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/25/20
 * Class PolarComplex, part of lab7 redo
 * I really screwed up the complex and standard class numbers problem so I redid it to make it easier to understand.
 * I have working junit tests as well. 
*/	
	
	private double amplitude,angle;
	
	public PolarComplex(double amp, double ang) {
		this.amplitude = amp;
		this.angle = ang;
	}
	
	public PolarComplex(double amp) {
		this.amplitude = amp;
		this.angle = amp;
	}
	
	public PolarComplex() {
		this.angle = 45;
		this.amplitude = 5;
	}
	
	public double getAmp() {
		return amplitude;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void setAmp(double amp) {
		this.amplitude = amp;
	}
	
	public void setAng(double ang) {
		this.angle = ang;
	}
	
	public String toString() {
		return amplitude+"(cos("+angle+") + isin("+angle+"))";
	}
	
	public PolarComplex getConjugate() {
		PolarComplex conjugate = new PolarComplex(this.amplitude,-this.angle);
		return conjugate;
	}
	
	public StandardComplex getStandardComplex() {
		double a = (Math.cos( Math.toRadians(getAngle()))*getAmp());
		double b = (Math.sin( Math.toRadians(getAngle()))*getAmp());
		a = Math.round(a*100.0)/100.0;
		b = Math.round(b*100.0)/100.0;
		StandardComplex ab = new StandardComplex(a,b);
		return ab;
	}
	
	public PolarComplex getPolarComplex() {
		double a = this.getAmp();
		double b  = this.getAngle();
		a = Math.round(a*100.0)/100.0;
		b = Math.round(b*100.0)/100.0;
		PolarComplex ab = new PolarComplex(a,b);
		return ab;
	}
	
	public boolean isEqual(Object other) {
		if(other instanceof StandardComplex) {
			if((((StandardComplex) other).getPolarComplex().getAmp() == this.getAmp()) &&(((StandardComplex) other).getPolarComplex().getAngle() == this.getAngle())) {
				return true;
			}else {
				return false;
			}
		}else {
			if((((PolarComplex) other).getAmp() == this.getAmp()) && (((PolarComplex) other).getAngle() == this.getAngle())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public PolarComplex add(Object other) {
		double x,y;
		if(other instanceof PolarComplex) {
			StandardComplex sc = ((PolarComplex) other).getStandardComplex();
			x = this.getStandardComplex().getRP() + sc.getRP();
			y = this.getStandardComplex().getIP() + sc.getIP();
		}else {
			StandardComplex sc = ((StandardComplex) other).getStandardComplex();
			x = this.getStandardComplex().getRP() + sc.getRP();
			y = this.getStandardComplex().getIP() + sc.getIP();
		}
		StandardComplex ad = new StandardComplex(x,y);
		return ad.getPolarComplex();
	}
	
	public PolarComplex subtract(Object other) {
		return this.getStandardComplex().subtract(other).getPolarComplex();
	}
	
	public PolarComplex multiply(Object other) {
		StandardComplex ret = this.getStandardComplex();
		return ret.multiply(other).getPolarComplex();
	}
	
	public PolarComplex divide(Object other) {
		StandardComplex ac = this.getStandardComplex();
		return ac.divide(other).getPolarComplex();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
