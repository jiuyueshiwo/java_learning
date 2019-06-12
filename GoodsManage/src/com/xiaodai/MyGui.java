package com.xiaodai;

import java.awt.*;
import java.time.*;
import java.util.Date;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class MyGui {
		
	private JFrame frame = new MyMainFrame("小呆商品日期管理软件");
	private JPanel paneleast =new JPanel();
	private JPanel panelwest =new JPanel();	
	private JTextField codenum;
	private JTextField goodname;
	private JTextField productiondate;
	private JTextField keeptime;
	private JTextArea displayinfo;
	public String[] titles = {"条形码	","商品名称","生产日期","保质期"};
				
	public static void main(String[] args) {
		new MyGui().buildGUI();
		
	}
	public void buildGUI() {
		
		//Food food01 =new Food("猪肉", "1686248912575", LocalDate.now(), 160);
		//System.out.println(LocalDate.now());
		
		paneleast.setBackground(Color.green);
		paneleast.setLayout(new BorderLayout());
		panelwest.setBackground(Color.white);
		
		displayinfo = new JTextArea(15,30);
		displayinfo.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(displayinfo);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		
		panelwest.add(scroller);
		
		Box titleBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 4; i++)
		{
			titleBox.add(new Label(titles[i]));
		}
		
		codenum = new JTextField(10);
		goodname = new JTextField(10);
		productiondate = new JTextField(10);
		keeptime = new JTextField(10);
		
		Box textBox = new Box(BoxLayout.Y_AXIS);
		textBox.add(codenum);
		textBox.add(goodname);
		textBox.add(productiondate);
		textBox.add(keeptime);
		
		paneleast.add(BorderLayout.WEST,titleBox);
		paneleast.add(BorderLayout.EAST,textBox);
		
		JButton addinfo = new JButton("添加");
		JButton queryinfo = new JButton("查询");
		addinfo.addActionListener(new AddButtonListener());
		queryinfo.addActionListener(new QueryButtonListener());
		
		frame.getContentPane().add(BorderLayout.EAST,paneleast);
		frame.getContentPane().add(BorderLayout.WEST,panelwest);
		
		paneleast.add(BorderLayout.SOUTH,queryinfo);
		paneleast.add(BorderLayout.SOUTH,addinfo);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	
	public class QueryButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
		}
	}
	public class AddButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			String name = goodname.getText();
			String code = codenum.getText();
			int period = Integer.parseInt(keeptime.getText());
			LocalDate startdate = null;
			SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy.MM.dd");
			try {
				Date date = simpledateformat.parse(productiondate.getText());
				Instant instant = date.toInstant();
				ZoneId zone = ZoneId.systemDefault();
				LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
			    LocalDate localDate = localDateTime.toLocalDate();
			    startdate = localDate;
			} catch(ParseException px) {
				px.printStackTrace();
			}
			Food food = new Food(name, code, startdate, period);
			displayinfo.append(name+" "+code+" "+food.getEnddate()+" "+period+" "+startdate+"\n");
		}
	}
}
