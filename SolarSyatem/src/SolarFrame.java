package com.zzuli.solar;

import java.awt.Graphics;
import java.awt.Image;

import com.zzuli.util.Constant;
import com.zzuli.util.GameUtil;
import com.zzuli.util.MyFrame;

/** 
* @author Hejjon
* 创建时间：2018年10月31日 下午11:27:18 
* 
* 太阳系的主窗口
*/
public class SolarFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg.png");
	Star sun = new Star("images/Sun.png", Constant.GAME_WIDTH / 2 - 35, 
			Constant.GAME_HEIGHT / 2 - 35);
	
	Planet mars = new Planet(sun, "images/Mars.png", Constant.MARS_LONGAXIS, 
			Constant.MARS_SHORTAXIS, Constant.MARS_SPEED);
	
	Planet earth = new Planet(sun, "images/Earth.png", Constant.EARTH_LONGAXIS, 
			Constant.EARTH_SHORTAXIS, Constant.EARTH_SPEED);
	
	Planet moon = new Planet(earth, "images/Moon.png", Constant.MOON_LONGAXIS, 
			Constant.MOON_SHORTAXIS, Constant.MOON_SPEED, true);
	
	Planet eris = new Planet(sun, "images/Eris.png", Constant.ERIS_LONGAXIS, 
			Constant.ERIS_SHORTAXIS, Constant.ERIS_SPEED);
	
	Planet saturn = new Planet(sun, "images/Saturn.png", Constant.SATURN_LONGAXIS, 
			Constant.SATURN_SHORTAXIS, Constant.SATURN_SPEED);
	
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT, null);
		sun.draw(g);
		mars.draw(g);
		earth.draw(g);
		moon.draw(g);
		eris.draw(g);
		saturn.draw(g);
	} 
	
	//双缓冲技术解决闪屏问题
		private Image offScreenImage = null;
		 
		public void update(Graphics g) {
		    if(offScreenImage == null)
		        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度
		     
		    Graphics gOff = offScreenImage.getGraphics();
		    paint(gOff);
		    g.drawImage(offScreenImage, 0, 0, null);
		}
		
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
