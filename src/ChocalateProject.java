
//Author: Omer Muhit

public class ChocalateProject {

	
	
	public static void main(String[] args) {
		
		//I have added extra zeros to apply findHighest function on all steps since it requires 4 parameters
		int [][] array = {	{0,0,0,0,0,0,0},
							{0,6,8,9,7,4,0}, 
							{0,0,0,8,0,5,0}, 
							{0,5,7,4,5,10,0},
							{0,4,2,0,6,9,0},
							{0,0,0,0,0,0,0}};
	    	    
		totalChocolateEaten(array);
	   
		
	}

	static void totalChocolateEaten (int array [][]){
		int colIndex = 0, rowIndex = 0;
		int chocolateEaten = 0;
		int rowNumber = array.length;
		int colNumber = array [0].length;

		//check if it has a center with next 4 if statements
	    if(rowNumber%2 == 1 && colNumber%2 == 1){
	        colIndex = colNumber/2;
	        rowIndex = rowNumber/2;
	        
	    }
	    
	    
	    if(rowNumber%2 == 0 && colNumber%2 == 1){
	    	colIndex = colNumber/2;
	    	if(array[rowNumber/2-1][colIndex] > array[rowNumber/2][colIndex])
	    		rowIndex = rowNumber/2-1;
	    	else
	    		rowIndex = rowNumber/2;
	    }
	    
	    if(rowNumber%2 == 1 && colNumber%2 == 0){
	        rowIndex = rowNumber/2;
	        if(array[rowIndex][colNumber/2-1]>array[rowIndex][colNumber/2])
	        	colIndex = colNumber/2 - 1;
	        else
	        	colIndex = colNumber/2;
	    }
	    
	    
	    if(rowNumber%2 == 0 && colNumber%2 == 0){
	    	int a,b,c,d,highest;
	    	
	    	a = array[rowNumber/2-1][colNumber/2-1];
	    	b = array[rowNumber/2-1][colNumber/2];
	    	c = array[rowNumber/2][colNumber/2-1];
	    	d = array[rowNumber/2][colNumber/2];
	    	highest = a;
	    	
	    	if(b>highest)
	    		highest = b;
	    	if(c>highest)
	    		highest = c;
	    	if(d>highest)
	    		highest = d;
	    	
	    if(highest == a){
	    	rowIndex = rowNumber/2-1;
	    	colIndex = colNumber/2-1;
	    }
	    else if(highest == b){
	    	rowIndex = rowNumber/2-1;
	    	colIndex = colNumber/2;
	    	
	    }
	    else if(highest == c){
	    	rowIndex = rowNumber/2;
	    	colIndex = colNumber/2-1;
	    }
	    else if(highest == d){
	    	rowIndex = rowNumber/2;
	    	colIndex = colNumber/2;
	    }
	    }
	    
	    
		chocolateEaten = array [rowIndex][colIndex];
		array [rowIndex][colIndex] = 0;
		
		
		
		do
		{
		
		int highest = findHighest(	array[rowIndex][colIndex-1],
									array[rowIndex-1][colIndex],
									array[rowIndex+1][colIndex],
									array[rowIndex][colIndex+1]);
		chocolateEaten += highest;
		
		if(array[rowIndex][colIndex-1] == highest){
			colIndex = colIndex - 1;
		}
		else if(array[rowIndex-1][colIndex] == highest){
			rowIndex = rowIndex - 1;
		}
		else if(array[rowIndex+1][colIndex] == highest){
			rowIndex = rowIndex + 1;
		}
		else if(array[rowIndex][colIndex+1] == highest){
			colIndex = colIndex + 1;
		}
		
		array[rowIndex][colIndex] = 0;
			
		
		}while(	array[rowIndex][colIndex-1] != 0 ||
				array[rowIndex-1][colIndex] != 0 ||
				array[rowIndex+1][colIndex] != 0 ||
				array[rowIndex][colIndex+1] != 0 );

		
		
		System.out.println("Total Chocolate Eaten is: " + chocolateEaten);

	  
	}
	
	static int findHighest(int a, int b, int c, int d){
		
		int highest = a;
		
		
		if(b>highest)
			highest = b;
		if(c>highest)
			highest = c;
		if(d>highest)
			highest = d;
		
		return highest;
	}
}

