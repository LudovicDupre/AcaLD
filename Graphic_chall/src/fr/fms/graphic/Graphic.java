/**
 * Programme permettant l'affichage de plusieurs formes géométriques
 * 
 * @author El babili - 2022
 * 
 */

package fr.fms.graphic;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class Graphic extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Graphic() {
		super("Drawing shapes");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);		
		setLocationRelativeTo(null);	
		setVisible(true);			
	}
	
	@Override	//le repère x,y commence en haut à gauche (0,0)
	public void paint(Graphics g) {	
		super.paint(g);
		
		
		// Circle c1
		Circle c1 = new Circle(20 , 30 , 100); 
		int  l1 = (int) c1.getRadius()*2;
		//int l1 = (int) c1.getRadius()*2;
		int x1 = (int) c1.getX();
		int y1 = (int) c1.getY();
	
		
		//Circle 2
		Point p = new Point(100, 150);
		Circle c2 = new Circle(15,p);

		int h2 = (int) c2.getRadius()*2;
		int l2 = (int) c2.getRadius()*2;
		int x2 = p.getX();
		int y2 = p.getY();
		
		//Circle 3
		Circle c3 = new Circle(30 , 300 , 300); 
		int h3 = (int) c3.getRadius()*2;
		int l3 = (int) c3.getRadius()*2;
		int x3 = (int) c3.getX();
		int y3 = (int) c3.getY();
		
		//Square 1
		Square sq1  = new Square(50 , 200, 200); 
		int  l4= (int) sq1.getSide();
//		int x4 = (int) sq1.getX();
//		int y4 = (int) sq1.getY();
		
		g.fillOval(x1, y1, l1, l1);	//c1 x , y , largeur , hauteur (diamètre)
		g.fillOval(x2, y2, l2, h2);//c2
		g.drawRect(200, 200, l4, l4);//s1 x , y , largeur , hauteur 
//		g.drawRect(200, 50, 65, 65);//s2
		g.fillOval(300, 300, l3, h3);//c3
		
		
//				
//		g.fillOval(30, 30, 25, 25);	//c1 x , y , largeur , hauteur (diamètre)
//		g.fillOval(100, 150, 15, 15);//c2
//		g.drawRect(200, 200, 50, 50);//s1 x , y , largeur , hauteur 
//		g.drawRect(200, 50, 65, 65);//s2
//		g.fillOval(300, 300, 30, 30);//c3
//		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(new GradientPaint(0, 0, Color.GREEN, 50, 50, Color.RED,true));
		//g2d.fillRect(250, 50, 70, 50);		
		
		//g2d.fillOval(250,150,55,55);		
	}
	
	public static void main(String[] args) {
	
		new Graphic();
	}
}
