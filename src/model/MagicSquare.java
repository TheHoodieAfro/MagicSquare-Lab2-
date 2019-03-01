package model;

import customExceptions.*;

public class MagicSquare {
	
	public int calculateMagicNumber(int n) {
		
		int numba = 0;
		
		numba = (n*((n*n)+1))/(2);
		
		return numba;
		
	}
	
	public String setTrack(String t) throws IllegalArgumentException, NonValidTrackException{
		
		String tt = t;
		
		if(!tt.equalsIgnoreCase("nw") && !tt.equalsIgnoreCase("ne")) {
			
			throw new NonValidTrackException(tt);
			
		}
		
		return tt;
		
	}
	
	public int selectLevel(String l) throws IllegalArgumentException, NonOddLevelException{
		
		int level = 0;
			
		level = Integer.parseInt(l);
		
		if(level%2 == 0) {
			
			throw new NonOddLevelException(level);
		}
		
		if(level<0) {
			
			throw new IllegalArgumentException();
			
		}
		
		return level;
		
	}
	
	public int calcRow(String x, int y) throws IllegalArgumentException{
		
		int row = 0;
		
		if(!x.equalsIgnoreCase("up") && !x.equalsIgnoreCase("down") && !x.equalsIgnoreCase("left") && !x.equalsIgnoreCase("right")) {
			
			throw new IllegalArgumentException();
			
		}else {
			
			if(x.equalsIgnoreCase("up")) {
				
				row = 0;
				
			}else if(x.equalsIgnoreCase("right")) {
				
				row = (y-1)/2;
				
			}else if(x.equalsIgnoreCase("left")) {
				
				row = (y-1)/2;
				
			}else {
				
				row = y-1;
				
			}
			
			return row;
			
		}
		
	}
	
	public int calcColumn(String x, int y) throws IllegalArgumentException{
		
		int col = 0;
		
		if(!x.equalsIgnoreCase("up") && !x.equalsIgnoreCase("down") && !x.equalsIgnoreCase("left") && !x.equalsIgnoreCase("right")) {
			
			throw new IllegalArgumentException();
			
		}else {
			
			if(x.equalsIgnoreCase("up")) {
				
				col = (y-1)/2;
				
			}else if(x.equalsIgnoreCase("right")) {
				
				col = y-1;
				
			}else if(x.equalsIgnoreCase("left")) {
				
				col = 0;
				
			}else {
				
				col = (y-1)/2;
				
			}
			
			return col;
			
		}
		
	}
	
	public boolean calcMagic(int[][] mm, int mn) throws IndexOutOfBoundsException{
		
		boolean m = true;
		int sumR = 0;
		int sumC = 0;
		int sumD = 0;
		
		for(int i=0; i<mm.length && m == true; i++) {
			
			for(int j=0; j<mm.length; j++) {
				
				sumR += mm[i][j];
				sumC += mm[j][i];
				
			}
			
			sumD += mm[i][i];
			
			if(sumR%mn != 0 || sumC%mn != 0) {
				
				m = false;
				
			}
			
		}
		
		if(sumD != mn) {
			
			m = false;
			
		}
			
		return m;
		
	}
	
}
