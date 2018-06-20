package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TaskGui extends JFrame{

GuiController gc=new GuiController();
//JFrame Definition
static JFrame jf=new JFrame();

//Definition Panels
JPanel pnl_center=new JPanel();
JPanel pnl_TimeSelection=new JPanel();
JPanel pnl_btnBottom=new JPanel();
JPanel pnl_favselection=new JPanel();
JPanel pnl_DateSelection=new JPanel();
JPanel pnl_fav=new JPanel();
JPanel pnl_center_center=new JPanel();
JPanel pnl_center_left=new JPanel();

//Definition Buttons	
static JButton btn_confirm=new JButton("Confirm");
static JButton btn_cancel=new JButton("Cancel");

//Definition Radio Buttons
static JRadioButton btn_favyes=new JRadioButton("Yes");
static JRadioButton btn_favno=new JRadioButton("No");

//Definiere ButtonGroup
static ButtonGroup btng_fav=new ButtonGroup();

//Definition Lables
JLabel lbl_TopTitle=new JLabel("New Task",JLabel.CENTER);
JLabel lbl_titel=new JLabel("Titel:    ",JLabel.CENTER);
JLabel lbl_time=new JLabel("Time:    ",JLabel.CENTER);
JLabel lbl_favorite=new JLabel("Favorite:    ",JLabel.CENTER);
JLabel lbl_date=new JLabel("Date:    ",JLabel.CENTER);

//Definition TextFelder
static JTextField txt_titel=new JTextField();

//Aktuelle Zeit wird definiert
static LocalDate today=LocalDate.now();
static LocalTime today_time=LocalTime.now();

//Definition Auswahl Boxen fï¿½r Tag Monat Jahr
static String tagListe[]= {""+today.getDayOfMonth()+"","1","2","3","2","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
static JComboBox tagAuswahl=new JComboBox(tagListe);
static String monatListe[]= {""+today.getMonthValue()+"","1","2","3","2","5","6","7","8","9","10","11","12"};
static JComboBox monatAuswahl=new JComboBox(monatListe);
static String jahrListe[]= {""+today.getYear()+"","2018","2019","2020","2021"};
static JComboBox jahrAuswahl=new JComboBox(jahrListe);
static String stundeListe[]= {""+today_time.getHour()+"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
static JComboBox stundeAuswahl=new JComboBox(stundeListe);
static String minuteListe[]= {"00","10","20","30","40","50"};
static JComboBox minuteAuswahl=new JComboBox(minuteListe);


public TaskGui() {
		jf.setSize(400,250);
		jf.setLayout(new BorderLayout());
		jf.setResizable(false);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.add(lbl_TopTitle,BorderLayout.NORTH); //Titel oben ans Fenster geadded
		
		pnl_DateSelection.setLayout(new GridLayout(1,4)); //Grid Layout mit Datum auswahl
		pnl_DateSelection.add(lbl_date);
		pnl_DateSelection.add(tagAuswahl);
		pnl_DateSelection.add(monatAuswahl);
		pnl_DateSelection.add(jahrAuswahl);
		
		pnl_TimeSelection.setLayout(new GridLayout(1,3)); //Grid Layout mit Time auswahl
		pnl_TimeSelection.add(lbl_time);
		pnl_TimeSelection.add(stundeAuswahl);
		pnl_TimeSelection.add(minuteAuswahl);
		
		//Radio Buttons zur Gruppe hinzugefï¿½gt damit nur einer der beiden ausgewï¿½hlt werden kann
		btng_fav.add(btn_favno);
		btng_fav.add(btn_favyes);
		
		pnl_favselection.setLayout(new GridLayout(1,2)); //Grid Layout fï¿½r yes no buttons fï¿½r favoriten
		pnl_favselection.add(btn_favno);
		pnl_favselection.add(btn_favyes);
		
		//panel das in pnl_center geadded wird und dort im border Layout im center steht
		pnl_center_center.setLayout(new GridLayout(4, 1));
		pnl_center_center.add(txt_titel);
		pnl_center_center.add(pnl_DateSelection);
		pnl_center_center.add(pnl_TimeSelection);
		pnl_center_center.add(pnl_favselection);
		
		//panel das in pnl_center geadded wird und dort im border Layout im left steht
		pnl_center_left.setLayout(new GridLayout(4, 1));
		pnl_center_left.add(lbl_titel);
		pnl_center_left.add(lbl_date);
		pnl_center_left.add(lbl_time);
		pnl_center_left.add(lbl_favorite);
		
		//Border Layout für den Hauptteil des Guis definiert
		pnl_center.setLayout(new BorderLayout());
		
		pnl_center.add(pnl_center_center,BorderLayout.CENTER);
		pnl_center.add(pnl_center_left,BorderLayout.WEST);
		
		jf.add(pnl_center,BorderLayout.CENTER);
		
		
		pnl_btnBottom.setLayout(new GridLayout(1,2)); //Grid Layouout fï¿½r fusszeile mit cancel und confirm buttons
		btn_confirm.addActionListener(gc);
		btn_cancel.addActionListener(gc);
		pnl_btnBottom.add(btn_cancel);
		pnl_btnBottom.add(btn_confirm);
		
		jf.add(pnl_btnBottom,BorderLayout.SOUTH);
		jf.setVisible(true);
	}

	public static void reset() {
		txt_titel.setText(" ");
		tagAuswahl.setSelectedIndex(0);
		monatAuswahl.setSelectedIndex(0);
		jahrAuswahl.setSelectedIndex(0);
		stundeAuswahl.setSelectedIndex(0);
		minuteAuswahl.setSelectedIndex(0);
		btng_fav.clearSelection();
	}

}