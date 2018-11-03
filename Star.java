package com.zzuli.solar;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.zzuli.util.GameUtil;

/** 
* @author Hejjon
* 创建时间：2018年10月31日 下午11:16:24 
* 
* 中心天体类, 类似于太阳的中心天体
*/
public class Star {
	Image img;
	double x;		//位置
	double y;
	
	int width;		//图片大小
	int height;
	
	//画星星的方法
	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);		
	}
	
	//构造器
	public Star() {
		
	}
	
	public Star(Image img) {
		this.img = img;
		new ImageIcon(img).getImage();
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;
		this.y = y;
	}

	//传入图片的路径即可
	public Star(String imgpath, double x, double y) {
		this(GameUtil.getImage(imgpath), x, y);			//通过this调用同一类中另一个构造器
	}
}
