import java.awt.Graphics;

public abstract class SpaceShip{
	int hp;
	int velocity;
	int armor;
	public SpaceShip(int hp, int velocity, int armor) {
		super();
		this.hp = hp;
		this.velocity = velocity;
		this.armor = armor;
	
	}

	abstract void stopVx();
	abstract void stopVy();
	abstract void ship(Graphics g);
}
