import processing.core.PApplet;

public class Portal {
	float x,y;
	int width, height,color;
	
	public Portal(float x, float y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;

	}
	
	public void draw(PApplet p) {
		p.fill(color);
		p.stroke(0xFF4e0087);
		p.strokeWeight(7);
		p.ellipseMode(PApplet.CENTER);
		p.circle(x, y, 80);
		
	}
	
	public void update() {
		
	}
	
	public void reset(PApplet p, Portal portal, Portal portal2) {
		portal.x = p.random(100, PongMain.SCR_W -550);
		portal2.x = p.random(550, PongMain.SCR_W -100);
		y = p.random(150, PongMain.SCR_H -100);
		
		
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
}
