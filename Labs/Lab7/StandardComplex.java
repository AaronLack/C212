public class StandardComplex {
	
/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/25/20
 * Class StandardComplex, part of lab7 redo
 * I really screwed up the complex and standard class numbers problem so I redid it to make it easier to understand.
 * I have working junit tests as well. 
 */
	
	
	private double realPart, imaginaryPart;
	
	//Overloaded Constructors
	public StandardComplex() {
		this.realPart = 10;
		this.imaginaryPart = 20;
	}
	
	public StandardComplex(double RP, double IP) {
		this.realPart = RP;
		this.imaginaryPart = IP;
	}
	
	public StandardComplex(double RP) {
		this.realPart = RP;
		this.imaginaryPart = RP;
	}
	
	//Getter Methods
	public double getRP() {
		return realPart;
	}
	
	public double getIP() {
		return imaginaryPart;
	}
	
	//Setter methods
	public void setRP(double RP) {
		this.realPart = RP;
	}
	
	public void setIP(double IP) {
		this.imaginaryPart = IP;
	}
	
	public String toString() {
		return realPart+" + "+imaginaryPart+"i";
	}
	
	public StandardComplex getConjugate() {
		StandardComplex conjugate = new StandardComplex(getRP(),-getIP());
		return conjugate;
	}
	
	public PolarComplex getPolarComplex() {
		double r =  Math.round(Math.sqrt(Math.pow(realPart, 2)+Math.pow(imaginaryPart, 2)));
		double ang = Math.round(Math.toDegrees(Math.atan(imaginaryPart/realPart)));
		
		r = Math.round(r*100.0)/100.0;
		ang = Math.round(ang*100.0)/100.0;
		
		PolarComplex polar = new PolarComplex(r,ang);
		return polar;
	}
	
	public StandardComplex getStandardComplex() {
		double a = this.getRP();
		double b = this.getIP();
		a = Math.round(a*100.0)/100.0;
		b = Math.round(b*100.0)/100.0;
		StandardComplex ab = new StandardComplex(a,b);
		return ab;
	}
	
	public boolean isEqual(Object other) {
		if(other instanceof PolarComplex) {
			if((((PolarComplex) other).getStandardComplex().getRP() == this.getRP()) &&(((PolarComplex) other).getStandardComplex().getIP() == this.getIP())) {
				return true;
			}else {
				return false;
			}
		}else {
			if((((StandardComplex) other).getRP() == this.getRP()) && (((StandardComplex) other).getIP() == this.getIP())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public StandardComplex add(Object other) {
		double x,y;
		if(other instanceof PolarComplex) {
			StandardComplex sc = ((PolarComplex) other).getStandardComplex();
			x = this.getRP() + sc.getRP();
			y = this.getIP() + sc.getIP();
		}else {
			StandardComplex sc = ((StandardComplex) other).getStandardComplex();
			x = this.getRP() + sc.getRP();
			y = this.getIP() + sc.getIP();
		}
		StandardComplex ad = new StandardComplex(x,y);
		return ad;
		
	}
	
	public StandardComplex subtract(Object other) {
		double x,y;
		if(other instanceof PolarComplex) {
			StandardComplex sc = ((PolarComplex) other).getStandardComplex();
			x = this.getRP() - sc.getRP();
			y = this.getIP() - sc.getIP();
		}else {
			StandardComplex sc = ((StandardComplex) other).getStandardComplex();
			x = this.getRP() - sc.getRP();
			y = this.getIP() - sc.getIP();
		}
		StandardComplex ad = new StandardComplex(x,y);
		return ad;
	}
	
	public StandardComplex multiply(Object other) {
		double a,b,c,d;
		if(other instanceof PolarComplex) {
			a = this.getRP();
			b = this.getIP();
			c = ((PolarComplex) other).getStandardComplex().getRP();
			d = ((PolarComplex) other).getStandardComplex().getIP();
		}else {
			a = this.getRP();
			b = this.getIP();
			c = ((StandardComplex) other).getStandardComplex().getRP();
			d = ((StandardComplex) other).getStandardComplex().getIP();
		}
		double x = ((a*c)-(b*d));
		double y = ((a*d)+(b*c));
		
		StandardComplex ret = new StandardComplex(x,y);
		
		return ret.getStandardComplex();
	}
	
	public StandardComplex divide(Object other) {
		double a,b,c,d;
		if(other instanceof PolarComplex) {
			a = this.getRP();
			b = this.getIP();
			c = ((PolarComplex) other).getStandardComplex().getRP();
			d = ((PolarComplex) other).getStandardComplex().getIP();
		}else {
			a = this.getRP();
			b = this.getIP();
			c = ((StandardComplex) other).getStandardComplex().getRP();
			d = ((StandardComplex) other).getStandardComplex().getIP();
		}
		double x = ((a*c)+(b*d))/(Math.pow(c, 2)+Math.pow(d, 2));
		double y = ((b*c)-(a*d))/(Math.pow(c, 2)+Math.pow(d, 2));
		
		StandardComplex ret = new StandardComplex(x,y);
		return ret.getStandardComplex();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
