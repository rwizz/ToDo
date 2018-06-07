package UserInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskGui extends JFrame{
//Definition Panels
JPanel pnl_center=new JPanel();
JPanel pnl_TimeSelection=new JPanel();
JPanel pnl_btnBottom=new JPanel();
JPanel pnl_favselection=new JPanel();

//Definition Buttons	
JButton btn_confirm=new JButton("Confirm");
JButton btn_cancel=new JButton("Cancel");
JButton btn_favyes=new JButton("Yes");
JButton btn_favno=new JButton("No");

//Definition Lables
JLabel lbl_TopTitle=new JLabel("New Task",JLabel.CENTER);
JLabel lbl_titel=new JLabel("Titel:",JLabel.CENTER);
JLabel lbl_time=new JLabel("Time to Finish",JLabel.CENTER);
JLabel lbl_favorite=new JLabel("Favorite ",JLabel.CENTER);

//Definition TextFelder
JTextField txt_titel=new JTextField();

//Definition Auswahl Boxen für Tag Monat Jahr
String tagListe[]= {"1","2","3","2","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
JComboBox tagAuswahl=new JComboBox(tagListe);
String monatListe[]= {"1","2","3","2","5","6","7","8","9","10","11","12"};
JComboBox monatAuswahl=new JComboBox(monatListe);
String jahrListe[]= {"2018","2019","2020","2021"};
JComboBox jahrAuswahl=new JComboBox(jahrListe);

	public TaskGui() {
		setSize(500,180);
		setLayout(new BorderLayout());
		add(lbl_TopTitle,BorderLayout.NORTH); //Titel oben ans Fenster geadded
		
		pnl_center.setLayout(new GridLayout(3,2)); //Grid Layout für Eingaben definiert
		pnl_center.add(lbl_titel);
		pnl_center.add(txt_titel);
		pnl_center.add(lbl_time);
		
		pnl_TimeSelection.setLayout(new GridLayout(1,3)); //Grid Layout mit Time auswahl
		pnl_TimeSelection.add(tagAuswahl);
		pnl_TimeSelection.add(monatAuswahl);
		pnl_TimeSelection.add(jahrAuswahl);
		
		pnl_center.add(pnl_TimeSelection);
		pnl_center.add(lbl_favorite);
		
		pnl_favselection.setLayout(new GridLayout(1,2)); //Grid Layout für yes no buttons für favoriten
		pnl_favselection.add(btn_favno);
		pnl_favselection.add(btn_favyes);
		
		pnl_center.add(pnl_favselection); //Panel mit yes no wird in center geadded
		
		add(pnl_center,BorderLayout.CENTER);
		
		
		pnl_btnBottom.setLayout(new GridLayout(1,2)); //Grid Layouout für fusszeile mit cancel und confirm buttons
		pnl_btnBottom.add(btn_cancel);
		pnl_btnBottom.add(btn_confirm);
		
		add(pnl_btnBottom,BorderLayout.SOUTH);
		setVisible(true);
	}

}
