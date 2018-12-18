import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class AnimationPanel3 extends JPanel{
	//Properties
	int intBlock1Y = 310;
	int intBlock2Y = 310;
	int intBallX = 625;
	int intBallY = 350;
	int intRandom = (int)(Math.random()*4+1);
	int intRandom2 = (int)(Math.random()*2+1);
	int intRandom3 = (int)(Math.random()*2+1);
	int intPoint1 = 0;
	int intPoint2 = 0;
	boolean blnHitTopWall = false;
	boolean blnHitLeftBlock = false;
	boolean blnHitRightBlock = false;
	boolean blnHitBottomWall = false;
	boolean blnGoDown = false;
	boolean blnGoUp = false;
	boolean blnVerticalDirection;
	//Up-->True
	//Down-->False
	boolean blnHorizontalDirection;
	//Right-->True
	//Left-->False
	//Methods
	//JPanel has method paintComponent
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		g.setColor(Color.WHITE);
		g.drawString(intPoint1+"", 5, 15);
		g.drawString(intPoint2+"", 1265, 15);
		g.fillRect(150, intBlock1Y, 25, 100);
		g.fillRect(1130, intBlock2Y, 25, 100);
		g.fillOval(intBallX, intBallY, 25, 25);
		//Block 1 Movement-->Complete
		if(blnGoDown){
			intBlock1Y = intBlock1Y + 5;
		}
		if(blnGoUp){
			intBlock1Y = intBlock1Y - 5;
		}
		
		if(intBlock1Y<0){
			intBlock1Y = 0;
		}else if(intBlock1Y>620){
			intBlock1Y = 620;
		}
		//Block 2 Movement
		if(intBlock2Y<=0){
			intBlock2Y = 0;
		}else if(intBlock2Y>=620){
			intBlock2Y = 620;
		}
		
		//Ball Movement for First Round
		if(blnHitTopWall==false&&blnHitLeftBlock==false&&blnHitBottomWall==false&&blnHitRightBlock==false&&intPoint1==intPoint2){
			if(intRandom==1){
				intBallX = intBallX + 5;
				intBallY = intBallY + 5;
				blnHorizontalDirection = true;
				blnVerticalDirection = false;
			}else if(intRandom==2){
				intBallX = intBallX + 5;
				intBallY = intBallY - 5;
				blnHorizontalDirection = true;
				blnVerticalDirection = true;
			}else if(intRandom==3){
				intBallX = intBallX - 5;
				intBallY = intBallY + 5;
				blnHorizontalDirection = false;
				blnVerticalDirection = false;
			}else if(intRandom==4){
				intBallX = intBallX - 5;
				intBallY = intBallY - 5;
				blnHorizontalDirection = false;
				blnVerticalDirection = true;
			}
			//Ball Movement if Player 1 is Winning-Round Start
		}else if(intPoint1>intPoint2&&blnHitTopWall==false&&blnHitLeftBlock==false&&blnHitBottomWall==false&&blnHitRightBlock==false){
			if(intRandom2==1){
				intBallX = intBallX + 5;
				intBallY = intBallY + 5;
				blnHorizontalDirection = true;
				blnVerticalDirection = false;
			}else if(intRandom2==2){
				intBallX = intBallX + 5;
				intBallY = intBallY - 5;
				blnHorizontalDirection = true;
				blnVerticalDirection = true;
			}
			//Ball Movement if Player 2 is Winning-Round Start
		}else if(intPoint2>intPoint1&&blnHitTopWall==false&&blnHitLeftBlock==false&&blnHitBottomWall==false&&blnHitRightBlock==false){
			if(intRandom==1){
				intBallX = intBallX - 5;
				intBallY = intBallY + 5;
				blnHorizontalDirection = false;
				blnVerticalDirection = false;
			}else if(intRandom3==2){
				intBallX = intBallX - 5;
				intBallY = intBallY - 5;
				blnHorizontalDirection = false;
				blnVerticalDirection = true;
			}
		}
		//Hit Top Wall-->Going Down
		if(blnHitTopWall){
			intBallY = intBallY + 5;
			//Will only run if the top wall is hit and neither of the blocks have been hit
			if(blnHitLeftBlock==false&&blnHitRightBlock==false){
				if(blnHorizontalDirection){
					intBallX = intBallX + 5;
				}else if(blnHorizontalDirection==false){
					intBallX = intBallX - 5;
				}
			}
		}else{
		}
		//Hit Bottom Wall-->Going Up
		if(blnHitBottomWall){
			intBallY = intBallY - 5;
			//Will only run if bottom wall is hit and neither of the blocks have been hit
			if(blnHitLeftBlock==false&&blnHitRightBlock==false){
				if(blnHorizontalDirection){
					intBallX = intBallX + 5;
				}else if(blnHorizontalDirection==false){
					intBallX = intBallX - 5;
				}
			}
		}else{
		}
		//Hit Right Block-->Going Left
		if(blnHitRightBlock==true){
			intBallX = intBallX - 5;
			//Will only run if the right block has been hit and neither of the walls have been hit
			if(blnHitBottomWall==false&&blnHitTopWall==false){
				if(blnVerticalDirection){
					intBallY = intBallY - 5;
				}else if(blnVerticalDirection==false){
					intBallY = intBallY + 5;
				}
			}
		}else{
		}
		//Hit Left Block-->Going Right
		if(blnHitLeftBlock==true){
			intBallX = intBallX + 5;
			//Will only run if the left block has been hit and neither of the walls have been hit
			if(blnHitBottomWall==false&&blnHitTopWall==false){
				if(blnVerticalDirection){
					intBallY = intBallY - 5;
				}else if(blnVerticalDirection==false){
					intBallY = intBallY + 5;
				}
			}
		}else{
		}
		
		//Determining if any wall or block was hit
		if(intBallY == 0){
			blnHitTopWall = true;
			blnHitBottomWall = false;
			blnVerticalDirection = false;
		}else if(intBallY == 695){
			blnHitBottomWall = true;
			blnHitTopWall = false;
			blnVerticalDirection = true;
		}else if(intBallX >= 150&&intBallX <= 175&&intBallY <= intBlock1Y+100&&intBallY >= intBlock1Y){
			blnHitLeftBlock = true;
			blnHitRightBlock = false;
			blnHorizontalDirection = true;
		}else if(intBallX >= 1105&&intBallX <= 1130&&intBallY <= intBlock2Y+100&&intBallY >= intBlock2Y){
			blnHitRightBlock = true;
			blnHitLeftBlock = false;
			blnHorizontalDirection = false;
		}
		if(intBallX == 0){
			intPoint2 = intPoint2 + 1;
			blnHitLeftBlock = true;
			blnHitRightBlock = false;
			blnHorizontalDirection = true;
		}else if(intBallX == 1255){
			intPoint1 = intPoint1 + 1;
			blnHitRightBlock = true;
			blnHitLeftBlock = false;
			blnHorizontalDirection = false;
		}
	}
	//Constructor
}
