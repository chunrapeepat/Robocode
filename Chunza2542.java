package NOOBZA;
import robocode.*;
import java.awt.Color;
import robocode.util.Utils;
import java.util.*;

/**
 * Chunza2542 - a robot by Chun Rapeepat
 */
 
public class Chunza2542 extends AdvancedRobot
{

	boolean inWall;
	boolean movingForward;
	Random rand = new Random();
	
	/* RUN METHOD */

	public void run() {
	
		setBodyColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		setGunColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		setRadarColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		setBulletColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		setScanColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
	
		setAhead(40000);
		setTurnRadarRight(360);
		this.movingForward = true;

		while(true) {

			if(getX() > 50 && getY() > 50 
				&& getBattleFieldWidth() - getX() > 50
				&& getBattleFieldHeight() - getY() > 50
				&& this.inWall == true) {
				
				this.inWall = false;
				
			}
			
			if(getX() <= 50 && getY() <= 50 
				|| getBattleFieldWidth() - getX() <= 50
				|| getBattleFieldHeight() - getY() <=  50){
				
				if(this.inWall == false){
					reverseDirection();
					this.inWall = true;
				}
				
			}
			
			if(getRadarTurnRemaining() == 0){
				setTurnRadarRight(360);
			}
			
			execute();
			
			setMaxVelocity(5);
			

		}
	}
	
	/* ScannedRobot METHOD */

	public void onScannedRobot(ScannedRobotEvent e) {
		
		turnRight(e.getBearing() + 90);
		
		double gunTurn = Utils.normalRelativeAngleDegrees(getHeading() + e.getBearing() - getGunHeading());
		double radarTurn = Utils.normalRelativeAngleDegrees(getHeading() + e.getBearing() - getRadarHeading());
		
		setTurnGunRight(gunTurn);
		setTurnRadarRight(radarTurn);
		
		if(e.getDistance() < 300){
			fire(1);
		}
		if(e.getDistance() < 100){
			fire(2);
		}
		if(e.getDistance() < 50){
			fire(3);
		}

	}
	
	/* Reverse Direction METHOD */
	
	public void reverseDirection(){
		if(this.movingForward){
			setBack(40000);
			this.movingForward = false;
		}else{
			setAhead(40000);
			this.movingForward = true;
		}
	}
	
	/* ON HIT METHODS */

	public void onHitByBullet(HitByBulletEvent e) {
		reverseDirection();
	}
	
	public void onHitWall(HitWallEvent e) {
		reverseDirection();
	}
	
	public void onHitRobot(HitRobotEvent e) {
		reverseDirection();
	}		
}
