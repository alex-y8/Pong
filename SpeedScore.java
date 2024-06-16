import processing.core.PApplet;

public class SpeedScore {
	float x,y;
	public static int scoreSpeed;
	
	public SpeedScore(float x, float y) {
		this.x = x;
		this.y = y;
		scoreSpeed = 1;
		reset();
	}
	
	public void draw(PApplet p) {
		p.textSize(30);
		p.text("speed " + scoreSpeed, x + 300, y);
	}
	public void update() {
		
	}
	
	public void keyPressed(char key) {
		if (key == 'r') {
			reset();
		}
	}
	public static void reset() {
		scoreSpeed = 1;
	}
	
} 	
