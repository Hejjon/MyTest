package com.zzuli.util;

import java.awt.Image;
import java.awt.Toolkit;


/** 
* @author Hejjon
* ����ʱ�䣺2018��10��30�� ����1:05:22 
* 
* ��Ϸ������ 
* ͼƬ���صȷ���
*/
public class GameUtil {
	
	private GameUtil() {}			//������ͨ����������˽��
	
	//����ͼƬ·����ȡͼƬ
	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
