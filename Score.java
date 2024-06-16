import processing.core.PApplet;

public class Score {
	float x,y;
	public static int score1, score2, scoreSpeed;
	int color;
	
	public Score(float x, float y) {
		this.x = x;
		this.y = y;
		scoreSpeed = 1;
		reset();
	}
	
	public void draw(PApplet p) {
		p.textSize(60);
		p.fill(0xFF0079FF);
		p.text(score1, x, y);
		p.fill(0xFFFF7F00);
		p.text(score2, x + 125, y);
		p.textSize(30);
		p.fill(255);
		//p.text("speed " + scoreSpeed, x + 300, y);
	}
	public void update() {
		
	}
	
	public void keyPressed(char key) {
		if (key == 'r') {
			reset();
		}
	}
	public static void reset() {
		score1 = 0;
		score2 = 0;
		scoreSpeed = 1;
	}
	
} 	
