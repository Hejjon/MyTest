package com.zzuli.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** 
* @author Hejjon
* ����ʱ�䣺2018��10��31�� ����11:06:33 
* 
*/
public class MyFrame extends Frame {

	public void launchFrame() {		//���ش���
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);			//���ô��ڿ�͸�
		setLocation(100, 100);		//���ô���λ��(�������ʾ��)
		setTitle("SolarSystem");
		setVisible(true);			//���ô��ڿɼ���(true��ʾ�ɼ�)
		//�����ػ��߳�
		new PaintThread().start(); 
		
		//�ڲ���, ���ô��ڵĹر�����, ���رմ��ھ��˳�����
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
					
				});
	}
	
	/*
	 * �����߳���
	 * 
	 */
	class PaintThread extends Thread {
		public void run() {
			while (true) {
				repaint();					//�ػ�����
				try {
					Thread.sleep(40);		//��ͣ40����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
	}
}
