import java.util.*;
import java.awt.*; 
import javax.swing.*;


public class Fractal{
	
	public static void mandelbrotInitialize(String [] args){  //the method to initialize the mendelbrot
		JFrame frame = new JFrame("Mandelbrot Set");   //setting up the frame (this will hold a canvas object mandelbrot)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		if(args.length == 1){     ////case where default values for area of interest and no.of iterations are used
			Mandelbrot canvas=new Mandelbrot();
			frame.add(canvas);
		}
		else if(args.length == 5){  ////case where values for area of interest is given by the user and default value for no.of iterations are used
			
			double[] area = new double[4];
			for (int i = 0; i < 4; i++){
				area[i] = Double.parseDouble(args[i+1]);  //area array holds values(type double) for area of interest, in order real_lowest, real_highest, imaginary_lowest, imaginary_highest
			}
			 
			Mandelbrot canvas=new Mandelbrot(area[0],area[1],area[2],area[3]);
			frame.add(canvas);
		}
		else if(args.length == 6){  ////case where values for area of interest and no.of iterations are given by the user
			
			double[] area = new double[4];
			for (int i = 0; i < 4; i++){
				area[i] = Double.parseDouble(args[i+1]);  //area array holds values(type double) for area of interest, in order real_lowest, real_highest, imaginary_lowest, imaginary_highest
			}
			int iterations=Integer.parseInt(args[5]);  //no.of iterations expected by the user
			
			Mandelbrot canvas=new Mandelbrot(area[0],area[1],area[2],area[3],iterations);
			frame.add(canvas);
		}
		
		else{   //when the input format is wrong
			System.out.println("Error in input format");
			System.out.println("Usage: java Fractal Mandelbrot <real_lowest> <real_highest> <imaginary_lowest> <imaginary_highest> <iterations>");
			System.exit(0);
		}
		frame.pack(); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}
	
	
	
	public static void juliaInitialize(String [] args){ 
		JFrame frame = new JFrame("Julia Set"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		if(args.length == 1){ ////case where default values for the compex number and no.of iterations are used
			
			Julia canvas=new Julia();
			frame.add(canvas);
		}
		else if(args.length == 3){   ////case where the complex number(as real_part complex_part) is given by the user and default value for no.of iterations are used
			
			double[] complexNum = new double[2];
			for (int i = 0; i < 2; i++){
				complexNum[i] = Double.parseDouble(args[i+1]); 
			}
			
			Julia canvas=new Julia(complexNum[0],complexNum[1]);
			frame.add(canvas);
		}
		else if(args.length == 4){  ////case where the complex number(as real_part complex_part) and no.of iterations are given by the user
			
			double[] complexNum = new double[3];
			for (int i = 0; i < 2; i++){
				complexNum[i] = Double.parseDouble(args[i+1]);
			}
			int iterations=Integer.parseInt(args[3]);
			
			Julia canvas=new Julia(complexNum[0],complexNum[1],iterations);
			frame.add(canvas);
		}
		
		else{   //when the input format is wrong
			System.out.println("Error in input format");
			System.out.println("Usage: java Fractal Julia <real_part> <imaginary_part> <iterations>");
			System.exit(0);
		}
		frame.pack(); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}
	
	
	
	public static void main(String [] args) { 
	
	
		if(args.length == 0){  //checking whether which set to be displayed is given
			System.out.println("Please input which set is needed to be displayed");
			System.exit(0);
		}
		
		 
		else{
			 
			if(args[0].equals("Mandelbrot")){  
				mandelbrotInitialize(args);
			}
			
			else if(args[0].equals("Julia")){
				juliaInitialize(args);
			}
			else{  
				System.out.println("Error in input format");
			}
			 
		}		
		
		
    }
	
}