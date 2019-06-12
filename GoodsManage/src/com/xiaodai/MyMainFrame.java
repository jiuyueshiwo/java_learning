package com.xiaodai;

import java.awt.*;

import javax.swing.*;

public class MyMainFrame extends JFrame {
	public MyMainFrame(String title)
	{	
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth/2, screenHeight/2);
		setLocationByPlatform(true);
		
		//ImageIcon img = new ImageIcon("D:\\eclipse\\\\GoodsManage\\src\\\\com\\xiaodai\\sword.jpg");
		Image img = kit.getImage("666.png");
		//img.setImage(img.getImage().getScaledInstance(1000, 1000,Image.SCALE_DEFAULT ));
		setIconImage(img);
		
		setTitle(title);
	}
}
