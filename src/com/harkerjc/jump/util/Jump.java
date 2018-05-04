package com.harkerjc.jump.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator
 *
 */
public class Jump extends JFrame{
	boolean flag=true;
	int x0,y0,x1,y1;
	public Jump() {
		super("wechat jump");
		// TODO Auto-generated constructor stub
		this.setSize(350,605);
		this.setUndecorated(true);
		this.setOpacity(0.4f);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		final JLabel label=new JLabel();
		this.add(label);
		
	
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (e.getButton()) {
				case MouseEvent.BUTTON1:
					if(flag)
					{
						x0=e.getX();
						y0=e.getY();
						System.out.println(x0+"=="+y0);
						flag=false;
					}
					else
					{
						x1=e.getX();
						y1=e.getY();
						 System.out.println(x1+"=="+y1);
						flag=true;
						double x=Math.abs(x0-x1);
						double y=Math.abs(y0-y1);
						double dis=Math.sqrt(x*x+y*y);
						long length=Math.round(dis)*5;
						System.out.println("jump length:"+length);
						String cmd="adb shell input touchscreen swipe 170 187 170 187 "+length;
								Runtime run=Runtime.getRuntime();
						try {
							Process pr=run.exec(cmd);
						} catch (Exception e2) {
							e2.printStackTrace();
							// TODO: handle exception
						}
					}
					
					break;
				case MouseEvent.BUTTON2:
					break;
				case MouseEvent.BUTTON3:
					break;


				default:
					break;
				}
				// TODO Auto-generated method stub
			
			}
		
		});
	}
public static void main(String[] args) {
	new Jump();
	
}
}
