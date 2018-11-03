package com.zzuli.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** 
* @author Hejjon
* 创建时间：2018年10月31日 下午11:06:33 
* 
*/
public class MyFrame extends Frame {

	public void launchFrame() {		//加载窗口
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);			//设置窗口宽和高
		setLocation(100, 100);		//设置窗口位置(相对于显示屏)
		setTitle("SolarSystem");
		setVisible(true);			//设置窗口可见性(true表示可见)
		//启动重画线程
		new PaintThread().start(); 
		
		//内部类, 设置窗口的关闭属性, 即关闭窗口就退出程序
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
					
				});
	}
	
	/*
	 * 窗口线程类
	 * 
	 */
	class PaintThread extends Thread {
		public void run() {
			while (true) {
				repaint();					//重画窗口
				try {
					Thread.sleep(40);		//暂停40毫秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
	}
}
