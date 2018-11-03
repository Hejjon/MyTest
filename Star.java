package com.zzuli.solar;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.zzuli.util.GameUtil;

/** 
* @author Hejjon
* ����ʱ�䣺2018��10��31�� ����11:16:24 
* 
* ����������, ������̫������������
*/
public class Star {
	Image img;
	double x;		//λ��
	double y;
	
	int width;		//ͼƬ��С
	int height;
	
	//�����ǵķ���
	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);		
	}
	
	//������
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

	//����ͼƬ��·������
	public Star(String imgpath, double x, double y) {
		this(GameUtil.getImage(imgpath), x, y);			//ͨ��this����ͬһ������һ��������
	}
}
