package com.zzuli.util;

import java.awt.Image;
import java.awt.Toolkit;


/** 
* @author Hejjon
* 创建时间：2018年10月30日 下午1:05:22 
* 
* 游戏工具类 
* 图片加载等方法
*/
public class GameUtil {
	
	private GameUtil() {}			//工具类通常将构造器私有
	
	//传入图片路径获取图片
	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
