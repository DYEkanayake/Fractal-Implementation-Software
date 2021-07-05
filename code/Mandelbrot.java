import java.awt.*; 
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.geom.Line2D;
//import java.awt.Canvas;

class Mandelbrot extends Canvas{
	
	
    private static int iterations = 1000; //iteration assigned with default of 1000
	
	//the default values of area of interest
	private double xmin=-1;
	private double xmax=1;
	private double ymin=-1;
	private double ymax=1;
	
	
	private BufferedImage image = new BufferedImage(800,800,BufferedImage.TYPE_INT_RGB); //the image which will display the Fractal
	
	//overloaded class constructors
	public Mandelbrot(double xmin, double xmax,double ymin,double ymax,int iterations) { 
		
		this.xmin  = xmin; 
		this.xmax  = xmax; 
		this.ymin  = ymin;
		this.ymax  = ymax; 
		this.iterations  = iterations; 
		setPreferredSize(new Dimension(800, 800)); 
		
    }
	
	public Mandelbrot(double xmin, double xmax,double ymin,double ymax) { 
	
		this.xmin  = xmin; 
		this.xmax  = xmax; 
		this.ymin  = ymin;
		this.ymax  = ymax; 
		setPreferredSize(new Dimension(800, 800)); 
		
    }
	
	public Mandelbrot() { 
	
		setPreferredSize(new Dimension(800, 800)); 
		
    }
	
	
	

    public void paint(Graphics g) { 
	// call paint from parent class 
		super.paint(g); 
		
		//color assigning based on the no.of iterations till x*x+y*y>4 occur
		int black = 0;
		int[] colors = new int[iterations];  //array of colors assigned based on iterations
		for (int i = 0; i<iterations; i++) {
		   colors[i] = Color.HSBtoRGB(i/256f, 1, i/(i+8f)); //calling public static int HSBtoRGB(float hue,float saturation,float brightness) of Color

		}
		int points =iterations; 
		
				
		for (int row = 0; row < 800; row++) {
				for (int col = 0; col < 800; col++) {
					
					//mapping each pixel to a complex number in the area of interest
					double c_re=(((double)col*(xmax-xmin))/800)+xmin;
					double c_im=(((double)row*(ymax-ymin))/800)+ymin;
					
					
					//checking the condition for a complex number c to make the mandelbrot set(i.e.  Zn+1 = Zn2+C, starting with Z0 = 0  where  ABS(Zn) > 2 for given iterations)
					double x = 0, y = 0; 
				
					int iteration = 0;
					while (x*x+y*y < 4 && iteration <points) {
						double x_new = x*x-y*y+c_re;
						double y_new = 2*x*y+c_im;
						x = x_new;
						y=y_new;
						iteration++;
					}
					
				//setting color for the relevant pixel of buffered image
				if(iteration<points ){
					image.setRGB(col, row, colors[iteration]); 
					
				}
				else {
					image.setRGB(col, row, black); //for complex values which satisfies the condition
					
				}
				
				}
			 
			 
			
		}

		g.drawImage(image, 0, 0, null); //drawing the image on canvas
		
	
	
	}
	
}