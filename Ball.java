import processing.core.PApplet;

public class Ball {
	private static final float DEFAULT_SPEED = 5;
	
	float x, y, size, speed, direction;
	int color, count;
	
	public Ball(float size, int color) {
		this.size = size;
		this.color = color;
		
		reset();
	}
	
	public void draw(PApplet p) {
		p.ellipseMode(PApplet.CENTER);
		p.fill(255);
		p.circle(x, y, 25);
		
	}
	
	public void update(Paddle p, Paddle p2, Portal portal, Portal portal2) {
		x += speed * PApplet.cos(PApplet.radians(direction));
		y += speed * PApplet.sin(PApplet.radians(direction));
		
		//top and bottom
		if (y - size/2 <= 0 || y + size/2 >= PongMain.SCR_H) {
			direction = -direction;
		}
		//left paddle
		if ((x <= p.getX() + 25) && (y <= (p.getY() + 50) && y >= (p.getY() - 50)) ) {
			direction = 180 -direction;
			if (speed <= 20) {
				speed++;
			}
			SpeedScore.scoreSpeed++;
		}// bottom and top of left paddle
		if ((x >= (p.getX() - p.width/2) && x <= (p.getX() + p.width/2) && y == (p.getY() - p.height/2))
				|| (x >= (p.getX() - p.width/2) && x <= (p.getX() + p.width/2) && y == (p.getY() + p.height/2))) {
			System.out.println("leftmet");
			direction = -direction;
			
		}

		//right paddle
		if ((x >= p2.getX() - 25) && (y >= (p2.getY() - 50) && (y <= (p2.getY()) + 50))) {
			direction = 180 -direction;

			if (speed <= 20) {
				speed++;
			}
			SpeedScore.scoreSpeed++;
		} //bottom and top of right paddle
		if ((x >= (p2.getX() - p2.width/2) && x <= (p2.getX() + p2.width/2) && y == (p2.getY() - p2.height/2))
				|| (x >= (p2.getX() - p2.width/2) && x <= (p2.getX() + p2.width/2) && y == (p2.getY() + p2.height/2))) {
			System.out.println("rightmet");
			direction = -direction;
		}
		//portal1
		if (x >= (portal.getX() -40) && y >= (portal.getY() -40)
				&& x <= (portal.getX() +40) && y <= (portal.getY()+40) ) {
			System.out.println("done");
			x = portal2.getX() - 41;
			y = portal2.getY() - 41;
			speed = DEFAULT_SPEED;
			direction = (float)Math.random() * 360;
			SpeedScore.reset();
		}
		//portal2
		if (x >= (portal2.getX() -40) && y >= (portal2.getY() -40)
				&& x <= (portal2.getX() +40) && y <= (portal2.getY() +40) ) {
			System.out.println("done2");
			x = portal.getX() + 41;
			y = portal.getY() + 41;
			SpeedScore.reset();
			speed = DEFAULT_SPEED;
			direction = (float)Math.random() * 360;
			
		}
		//score change when ball goes off the screen
		if (x < 0) {
			Score.score2++;
			reset();
			SpeedScore.reset();
		}
		if (x > PongMain.SCR_W) {
			Score.score1++;
			reset();
			SpeedScore.reset();
		}
		
	
	}
	

	public void reset() {
		x = PongMain.SCR_W / 2;
		y = PongMain.SCR_H / 2;
		speed = DEFAULT_SPEED;
		direction = (float)Math.random() * 360;
	}
	
}
