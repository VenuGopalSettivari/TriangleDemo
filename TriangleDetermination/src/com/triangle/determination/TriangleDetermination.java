package com.triangle.determination;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The class represents the triangle computations.
 * @author venugopal.settivari
 *
 */

public class TriangleDetermination {

	/**Sides of the triangle used for computation
	 * the member is final as it doesnt modify.*/
	public static final int TRIANGLE_SLIDES = 3;
	
	public static void main(String[] args) {

	/** array for triangle data*/	
	int[] triangleData = new int[TRIANGLE_SLIDES];

	/**
	 * Accept the input dynamically from the keyboard 
	 */
	for (int x = 1; x <= TRIANGLE_SLIDES; x++) {
		Scanner sides = new Scanner(System.in);	
		try{
		System.out.print("Please enter side " + x+" of triangle :");
		triangleData[x-1] = sides.nextInt();
		}catch(InputMismatchException iME){
			x = x-1; //It makes to re-enter the value for same side again
			System.out.println("Error on entering the input, as it considers number(s)");
			
		}catch(ArrayIndexOutOfBoundsException aIOBE){
			System.out.println("Erro on trying to insert data putinto overflow");
		}

	}
	
	TriangleType triangleType;
	try {
		triangleType = getTriangleType(triangleData);
		System.out.println("Its.. "+triangleType);

	} catch (Exception e) {
		System.out.println("Problem while calculating triangle service");
	}
	

}

	/**
	 * Compute the input data and determine the triangle
	 * @param data
	 * @return
	 * @throws Exception
	 */
static TriangleType getTriangleType(int[] data) throws Exception{
	try{
	if((data[0]>0 && data[1] >0 && data[2]>0) 
				   && (data[0] < (data[1]+data[2]) 
					&& data[1] < (data[0]+data[2]) 
					&& data[2] < (data[0]+data[1]))){
		
		if(data[0] == data[1] && data[1] == data[2]) return TriangleType.EQUILATERAL;
		if(data[0] == data[1] || data[1] ==data[2] || data[2] == data[0]) return TriangleType.ISOSCELES;
		if(data[0] != data[1] && data[1] != data[2] && data[2] != data[0]) return TriangleType.SCALENE;
	}else{
		return TriangleType.NOT_TRIANGLE;
	}
}catch(ArrayIndexOutOfBoundsException aIOBE){
	System.out.println("Erro on trying to access data array index not exist");
}
	return TriangleType.NOT_TRIANGLE;
}


}

/**
 * Represents the constants.
 * @author venugopal.settivari
 *
 */
enum TriangleType{
		EQUILATERAL,
		ISOSCELES,
		SCALENE,
		NOT_TRIANGLE;
}

/** Sysout's will be replaced by the logger API*/
