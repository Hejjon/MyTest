 package com.zzuli.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import com.zzuli.util.GameUtil;

/** 
* @author Hejjon
* 创建时间：2018年11月1日 下午4:45:13 
* 
* 行星类
*/
public class Planet extends Star {
	
	//天体属性
	double longAxis;		//椭圆轨道的半长轴
	double shortAxis;		//椭圆轨道的半短轴
	double speed;			//飞行速度
	double degree = 0;		//角度
	Star center;			//中心天体
	boolean issatellite;	//是否是卫星

	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}

	public Planet(Star center, String imgpath, double longAxis,
			double shortAxis, double speed) {
		
		super(GameUtil.getImage(imgpath));
		this.x = center.x + longAxis;
		this.y = center.y;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
	}
	
	public Planet(Star center, String imgpath, double longAxis,
			double shortAxis, double speed, boolean issatellite) {
		
		this(center, imgpath, longAxis, shortAxis, speed);
		this.issatellite = issatellite;
	}


	@Override
	public void draw(Graphics g) {
		super.draw(g);
		move();
		if (!issatellite) {
			drawTrace(g);
		}
	}
	
	//绘制运行椭圆轨迹
	public void drawTrace(Graphics g) {
		
		double ovalX, ovalY, ovalWidth, ovalHeight;
		ovalWidth = longAxis * 2;
		ovalHeight = shortAxis * 2;
		ovalX = center.x + center.width / 2 - longAxis;
		ovalY = center.y + center.height / 2 - shortAxis;
		
		//设置轨迹颜色
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	//沿着椭圆轨道飞行
	public void move() {
		x = (center.x + center.width / 2 - this.width / 2) + longAxis * Math.cos(degree);
		y = (center.y + center.height / 2 - this.height / 2) + shortAxis * Math.sin(degree);
		degree = degree + speed;	
	}
	
	
}
