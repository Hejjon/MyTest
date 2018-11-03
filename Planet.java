 package com.zzuli.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import com.zzuli.util.GameUtil;

/** 
* @author Hejjon
* ����ʱ�䣺2018��11��1�� ����4:45:13 
* 
* ������
*/
public class Planet extends Star {
	
	//��������
	double longAxis;		//��Բ����İ볤��
	double shortAxis;		//��Բ����İ����
	double speed;			//�����ٶ�
	double degree = 0;		//�Ƕ�
	Star center;			//��������
	boolean issatellite;	//�Ƿ�������

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
	
	//����������Բ�켣
	public void drawTrace(Graphics g) {
		
		double ovalX, ovalY, ovalWidth, ovalHeight;
		ovalWidth = longAxis * 2;
		ovalHeight = shortAxis * 2;
		ovalX = center.x + center.width / 2 - longAxis;
		ovalY = center.y + center.height / 2 - shortAxis;
		
		//���ù켣��ɫ
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	//������Բ�������
	public void move() {
		x = (center.x + center.width / 2 - this.width / 2) + longAxis * Math.cos(degree);
		y = (center.y + center.height / 2 - this.height / 2) + shortAxis * Math.sin(degree);
		degree = degree + speed;	
	}
	
	
}
