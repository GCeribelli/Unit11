package rational;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
        private int num,den;
        public Rational(){}
        public Rational(int n, int d){
            num = n;
            den = d;
        }
        public void setRational(int n, int d){
            num = n;
            den = d;
        }
        public void setDen(int d){
            den = d;
        }
        public void setNum(int n){
            num = n;
        }
        public int getDen(){
            return den;
        }
        public int getNum(){
            return num;
        }
	
	public void add(Rational  other)
	{
		num = (other.getNum() * den) + (other.getDen() * num);
                den = den * other.getDen();
		reduce();
	}

	private void reduce()
	{
            for(int i = 2; i <= den; i++){
                if(num%i == 0 && den%i == 0){
                    num/= i;
                    den/= i;
                    reduce();
                }
            }
	}

	private int gcd(int numOne, int numTwo)
	{
                for(int i = den; i > 0; i--){
                if(num%i == 0 && den%i == 0){
                    return i;
                }
            }
		return 1;
	}

	public Object clone ()
	{
            return new Rational(num, den);
	}
	
	
	public boolean equals( Rational obj)
	{
            Rational t = new Rational(num, den);
            t.reduce();
            obj.reduce();
            return (obj.getDen() == t.getDen() && obj.getNum() == t.getNum());
	}

	public int compareTo(Rational other)
	{
                if(other.getDen() == den && other.getNum() == num){
                    return 1;
                }else{return -1;}
	}
        
        public String toString(){
            return "Numerator: " + num + "\t Denominator: " + den;
        }


	
	//write  toString() method
	
	
}