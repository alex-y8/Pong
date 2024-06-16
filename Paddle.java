import processing.core.PApplet;

public class Paddle {
	float x, y,direction, angle;

	static int width, height;
	int color1;
	char up,down, rotateL, rotateR;

	private boolean uPressed, dPressed;
	
	public Paddle(float x, float y, int width, int height, char up, char down,
			int c1, float angle, float direction,
			char rotateL, char rotateR) {
		this.x = x;
		this.y = y;
		Paddle.width = width;
		Paddle.height = height;
		this.up = up;
		this.down = down;
		
		this.rotateL = rotateL;
		this.rotateR = rotateR;
		color1 = c1;
		
		uPressed = false;
		dPressed = false;
		
		this.angle = angle;
		this.direction = direction;
		
	}
	

	
	public void draw(PApplet p) {
		p.rectMode(PApplet.CENTER);
		p.noStroke();
		
		p.fill(color1);
		p.rect(x,y,width,height);
		

		//p.circle(scr_W/2, scr_H/2, 1000);
		
		/*if (y > PongMain.SCR_H + 50) {
			y = -50;
		}
		if (y < 0 - 50) {
			y = PongMain.SCR_H + 50;
		}*/
		
	}
	
	public void update() {
		if (uPressed && y >= 50) {
			y -= 10;
		}
		if (dPressed && y <= PongMain.SCR_H -50) {
			y += 10;
		}

		
		
	}
	
	public void keyPressed(char key) {
		if (key == up) {
			uPressed = true;
		}
		if (key == down) {
			dPressed = true;
		}

	}
	public void keyReleased(char key) {
		if (key == up) {
			uPressed = false;
		}
		if (key == down) {
			dPressed = false;
		}

	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	
}

