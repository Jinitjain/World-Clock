import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
public class WorldClock extends JFrame implements ActionListener
{
	JComboBox cb_1,cb_2;
	JButton submit;
	String city,cont;
	JRadioButton hr12_format;
	JRadioButton hr24_format;
	public WorldClock()
	{
		Font f = new Font("Century Gothic",Font.ITALIC,25);
		Font font = new Font("Century Gothic",Font.BOLD,45);
		Cursor cursor = new Cursor(HAND_CURSOR);

		JFrame j = new JFrame("World Clock");
		
		submit = new JButton("SUBMIT");
		submit.setBounds(630,600,150,60);
		submit.setFont(f);
		submit.setCursor(cursor);		

		hr12_format = new JRadioButton("12 HOUR Format");
		hr12_format.setBounds(600,400,200,30);
		hr12_format.setCursor(cursor);		

		hr24_format = new JRadioButton("24 HOUR Format");
		hr24_format.setBounds(600,440,200,30);
		hr24_format.setCursor(cursor);

		ButtonGroup bg = new ButtonGroup();
		bg.add(hr12_format);
		bg.add(hr24_format);
		
		JLabel label = new JLabel("Select Time Format :");
		label.setFont(f);
		label.setBounds(520,350,350,60);
		label.setForeground(Color.DARK_GRAY);

		JLabel title = new JLabel("WORLD CLOCK");
		title.setFont(font);		
		title.setBounds(540,50,350,80);
		title.setForeground(Color.getHSBColor(71,456,999));
		
		String continent[] = {"                                                          Select Continent Name you are in","Africa","America","Antarctica","Asia","Atlantic","Australia","Europe","Pacific"}; 
		cb_1 = new JComboBox(continent);
		String GMT_city[] = {"                                                                Select GMT city nearby you","Apia","Midway","Niue","Pago Pago","Adak","Fakaofo","Honolulu","Johnston","Rarotonga","Tahiti","Marquesas","Anchorage","Juneau","Nome","Yakutat","Gambier","Dawson","Los Angeles","Santa Isabel","Tijuana","Vancouver","Whitehorse","Pitcaim","Boise","Cambridge Bay","Chihuahua","Dawson Creek","Denver","Edmonton","Hermosillo","Inuvik","Mazatlan","Ojinaga","Phoenix","Yellowknife","Bahia Banderas","Belize","Cancun","Chicago","Costa Rica","El Salvador","Guatemala","Indiana/Knox","Indiana/Tell City","Managua","Matamoros","Menominee","Merida","Mexico City","Monterrey","North Dakota/Center","North Dakota/New Salem","Rainy River","Rankin Inlet","Regina","Swift Current","Tegucigalpa","Winnipeg","Easter","Galapagos","Atikokan","Bogota","Cayman","Detroit","Grand Turk","Guayaquil","Havana","Indiana/Indianapolis","Indiana/Marengo","Indiana/Petersberg","Vevay","Vincennes","Winamac","Iqaluit","Jamaica","Kentucky/Louisville","Kentucky/Monticello","Lima","Montreal","Nassau","New York","Nipigon","Panama","Pangnirtung","Port-au-Prince","Resolute","Thunder Bay","Toronto","Caracas","Anguilla","Antigua","Argentina/San_Luis","Aruba","Asuncion","Barbados","Blanc-Sablon","Boa Vista","Campo Grande","Cuiaba","Curacao","Dominica","Eirunepe","Glace Bay","Goose Bay","Grenada","Guadeloupe","Guyana","Halifax","La Paz","Manaus","Martinique","Moncton","Montserrat","Port of Spain","Porto Velho","Puerto Rico","Rico Branco","Santiago","SantoDomingo","St Kitts","St Lucia","St Thomas","St Vincent","Thule","Tortola","Palmer","Bermuda","Stanley","St Johns","Araguaina","Argentina/Buenos Aires","Argentina/Catamarca","Argentina/Cordoba","Argentina/Jujuy","Argentina/Cordoba","Argentina/La Rioja"}; 
		Arrays.sort(GMT_city,1,GMT_city.length);
		cb_2 = new JComboBox(GMT_city);
		
		cb_1.setBounds(425,170,550,40);
		cb_2.setBounds(425,300,550,40);
		cb_1.setCursor(cursor);
		cb_2.setCursor(cursor);
		
		j.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Mukesh\\Desktop\\Documents\\Project\\WORLD CLOCK\\World Clock.jpg")));
		j.setSize(2500,2500);
		j.setLayout(null);
		j.setVisible(true);
		
		j.add(title);
		j.add(cb_1);
		j.add(cb_2);
		j.add(label);
		j.add(hr12_format);
		j.add(hr24_format);
		j.add(submit);
		hr12_format.setSelected(true);
		cb_1.addActionListener(this);
		cb_2.addActionListener(this);
		submit.addActionListener(this);
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == cb_1)
		{
			JComboBox c = (JComboBox)e.getSource();
			cont = (String)c.getSelectedItem();
		}
		if(e.getSource() == cb_2)
		{
			JComboBox c = (JComboBox)e.getSource();
			city = (String)c.getSelectedItem();
		}
		if(e.getSource() == submit)
		{
			if(cont==null && city!=null) 
			{
				JOptionPane.showMessageDialog(null,"Please select Continent","Alert!",0);
			}
			if(cont!=null && city==null) 
			{
				JOptionPane.showMessageDialog(null,"Please select GMT City","Alert!",0);
			}
			if(cont==null && city==null) 
			{
				JOptionPane.showMessageDialog(null,"Please select Continent and GMT City","Alert!",0);
			}
			else
			{
				if(hr12_format.isSelected())
				{
					try
					{
						final String DATE_FORMAT = "dd/MM/yyyy  hh:mm:ss a";
						
						Date now = new Date();
			            		SimpleDateFormat formator = new SimpleDateFormat(DATE_FORMAT);
			            		String s2 = formator.format(now);
			            		LocalDateTime ldt;
			            		ldt = LocalDateTime.parse(s2, DateTimeFormatter.ofPattern(DATE_FORMAT));
			           		ZoneId Id = ZoneId.of("Asia/Kolkata");
			            		ZonedDateTime myZonedDateTime = ldt.atZone(Id);
			            
			            		char[] a = city.toCharArray();
	                    			for (int i = 0; i < city.length(); i++)
	                        			if (a[i] == ' ') a[i] = '_';
	                    			city = new String(a);
	                    			String loc = cont + "/" + city;
	                    			ZoneId requiredId = ZoneId.of(loc);
	                    			ZonedDateTime reqDateTime = myZonedDateTime.withZoneSameInstant(requiredId);
	                    			DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
	                    			JOptionPane.showMessageDialog(null,"DATE :           TIME:\n" + format.format(reqDateTime),"TIME",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception x)
					{
						JOptionPane.showMessageDialog(null,"Please select appropriate Continent and GMT City","Alert!",0);
					}
				}
				else
				{
					try
					{
						final String DATE_FORMAT = "dd/MM/yyyy  HH:mm:ss z";
						
						Date now = new Date();
			            		SimpleDateFormat formator = new SimpleDateFormat(DATE_FORMAT);
			            		String s2 = formator.format(now);
			            		LocalDateTime ldt;
			           	        ldt = LocalDateTime.parse(s2, DateTimeFormatter.ofPattern(DATE_FORMAT));
			            		ZoneId Id = ZoneId.of("Asia/Kolkata");
			            		ZonedDateTime myZonedDateTime = ldt.atZone(Id);
			            
			            		char[] a = city.toCharArray();
	                    			for (int i = 0; i < city.length(); i++)
	                        		    if (a[i] == ' ') a[i] = '_';
	                    			city = new String(a);
	                    			String loc = cont + "/" + city;
	                    			ZoneId requiredId = ZoneId.of(loc);
	                    			ZonedDateTime reqDateTime = myZonedDateTime.withZoneSameInstant(requiredId);
	                    			DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
	                    			JOptionPane.showMessageDialog(null,"DATE :          TIME:\n" + format.format(reqDateTime),"TIME",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception x)
					{
						JOptionPane.showMessageDialog(null,"Please select appropriate Continent and GMT City","Alert!",0);
					}
				}
			}
		}
	}
	public static void main (String args[])
	{
		WorldClock worldclock = new WorldClock();
	}
}