import processing.core.PApplet;

public class PongMain extends PApplet{
	public static final int SCR_W = 800;
	public static final int SCR_H = 800;
	
	Paddle p;
	Paddle p2;
	Ball b;
	Score s;
	Portal portal;
	Portal portal2;
	SpeedScore ss;
	
	public void setup() {
		p = new Paddle(25, height/2, 25, 100, 'w','s', 0xFF0079FF, 0, 2, 'q', 'e');
		p2 = new Paddle(775, height/2, 25, 100, 'i','k',0xFFFF7F00, 0, 2, 'q', 'e');
		b = new Ball(25, 255);
		portal = new Portal(random(100, SCR_W -550), random(150, SCR_H -100), 0xFF2f0052);
		portal2 = new Portal(random(550, SCR_W -100), random(150, SCR_H -100), 0xFF5a32a1);
		s = new Score(SCR_W/2 - 100, SCR_H - 700);
		ss = new SpeedScore(SCR_W/2 - 100, SCR_H - 713);
	}
	

	public void draw() {
		background(0);
		
		p.draw(this);
		p.update();
		
		p2.draw(this);
		p2.update();
		
		b.draw(this);
		b.update(p, p2, portal, portal2);
		
		s.draw(this);
		s.update();
		
		ss.draw(this);
		ss.update();
		
		portal.draw(this);
		portal.update();
		
		portal2.draw(this);
		portal2.update();
	}
	
	public void keyPressed() {
		p.keyPressed(key);
		p2.keyPressed(key);

		if (key == 'q') {
			p.angle -= p.direction;
		}
		if (key == 'e') {
			p.angle += p.direction;
			System.out.println("angle");
		}
		
		if (key == 'r') {
			b.reset();
			s.reset();
			ss.reset();
			portal.reset(this, portal, portal2);
			portal2.reset(this, portal, portal2);
		}
		
	}
	public void keyReleased() {
		p.keyReleased(key);
		p2.keyReleased(key);
		p.keyReleased(key);
		p2.keyReleased(key);
	}
	
	
	public void settings() {
		size(SCR_W,SCR_H);
	}


	
	public static void main(String args[]) {
	    PApplet.main("PongMain");
	}	
}