import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
class myframe
{
	JFrame jf;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3, b4, b5, b6, b7;
	myframe()
	{	
		jf = new JFrame("Tours & Travel");
		jf.getContentPane().setLayout(null);
		l1 = new JLabel("Destination");
		t1 = new JTextField(15);
		l2 = new JLabel("Cities");
		t2 = new JTextField(15);
		l3 = new JLabel("Tourist Attractions");
		t3 = new JTextField(25);
		l4 = new JLabel("Pilgrimages");
		t4 = new JTextField(15);
		l5 = new JLabel("Packages");
		t5 = new JTextField(15);
		b1 = new JButton("|<");
		b2 = new JButton("<");
		b3 = new JButton(">");
		b4 = new JButton(">|");
		b5 = new JButton("Add");
		b6 = new JButton("Delete");
		b7 = new JButton("Search");
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Data d = new Data();
				try
				{
					d.read(1);
				}
				catch(Exception e){}
				t1.setText(d.destination);
				t2.setText(d.city);
				t3.setText(d.attractions);
				t4.setText(d.pilgrimage);
				t5.setText(d.packages);
			}
        	
        	});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				RowNumber r = new RowNumber();
				Data d = new Data();
				try
				{
					int i = r.read(t1.getText());
					d.read(i-1);
				}
				catch(Exception e){}
				t1.setText(d.destination);
				t2.setText(d.city);
				t3.setText(d.attractions);
				t4.setText(d.pilgrimage);
				t5.setText(d.packages);
			}
        	
        	});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				RowNumber r = new RowNumber();
				Data d = new Data();
				try
				{
					int i = r.read(t1.getText());
					d.read(i+1);
				}
				catch(Exception e){}
				t1.setText(d.destination);
				t2.setText(d.city);
				t3.setText(d.attractions);
				t4.setText(d.pilgrimage);
				t5.setText(d.packages);
			}
        	});
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Fileread a = new Fileread();
				try
				{
					a.read();
				}
				catch(Exception e){}
				t1.setText(a.destination);
				t2.setText(a.city);
				t3.setText(a.attractions);
				t4.setText(a.pilgrimage);
				t5.setText(a.packages);
			}
        	});
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				int i;
				String destination, city, attractions, pilgrimage, packages;
				String destination1 = "";
				String city1 = "";
				String attractions1="";
				String pilgrimage1 = "";
				String package1 = "";
				destination = t1.getText().toString();
				for(i = destination.length(); i<12; i++)
				{
					destination1 = destination1 + " ";
				}
				city = t2.getText().toString();
				for(i = city.length(); i<27; i++)
				{
					city1 = city1 + " ";
				}
				attractions = t3.getText().toString();
				for(i = attractions.length(); i<24; i++)
				{
					attractions1 = attractions1 + " ";
				}
				pilgrimage = t4.getText().toString();
				for(i = pilgrimage.length(); i<21; i++)
				{
					pilgrimage1 = pilgrimage1 + " ";
				}
				packages = t5.getText().toString();
				for(i = packages.length(); i<14; i++)
				{
					package1 = package1 + " ";
				}
				try
				{
					FileWriter w1 = new FileWriter("file.txt",true);
					w1.write(System.getProperty("line.separator"));
					w1.write(destination + destination1 + "| ");
					w1.write(city + city1 + "| ");
					w1.write(attractions + attractions1 + "| ");
					w1.write(pilgrimage + pilgrimage1 + "| ");
					w1.write(packages + package1 + "| ");
					JOptionPane.showMessageDialog(jf, "Data Added");
					w1.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(jf, "Error");
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			}
		});
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			}
		});
		b7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				int i;
				Search a = new Search();
				try
				{
					a.read(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText());
				}
				catch(Exception e){}
				String t11 = t1.getText();
				String t22 = t2.getText();
				String t33 = t3.getText();
				String t44 = t4.getText();
				String t55 = t5.getText();
				String p=" ";
				for(i = t11.length(); i<12; i++)
				{
					t11 = t11+p;
				}
				for(i = t22.length(); i<27; i++)
				{
					t22 = t22+p;
				}
				for(i = t33.length(); i<24; i++)
				{
					t33 = t33+p;
				}
				for(i = t44.length(); i<21; i++)
				{
					t44 = t44+p;
				}
				for(i = t55.length(); i<14; i++)
				{
					t55 = t55+p;
				}
				if(t11.equals(a.destination) || t22.equals(a.city) || t33.equals(a.attractions) || t44.equals(a.pilgrimage) || t55.equals(a.packages))
				{
					t1.setText(a.destination);
					t2.setText(a.city);
					t3.setText(a.attractions);
					t4.setText(a.pilgrimage);
					t5.setText(a.packages);
				}
				else
				{
					JOptionPane.showMessageDialog(jf, "Match not found");
				}
			}	
        	});
		l1.setBounds(50,20,120,35);
		l2.setBounds(50,60,120,35);
		l3.setBounds(50,100,120,35);
		l4.setBounds(50,140,120,35);
		l5.setBounds(50,180,120,35);
		t1.setBounds(220,20,180,35);
		t2.setBounds(220,60,180,35);
		t3.setBounds(220,100,180,35);
		t4.setBounds(220,140,180,35);
		t5.setBounds(220,180,180,35);
		b1.setBounds(50,300,80,27);
		b2.setBounds(140,300,80,27);
		b3.setBounds(230,300,80,27);
		b4.setBounds(320,300,80,27);
		b5.setBounds(50,370,80,27);
		b6.setBounds(185,370,80,27);
		b7.setBounds(320,370,80,27);
		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		l5.setForeground(Color.blue);
		jf.getContentPane().add(l1);
		jf.getContentPane().add(l2);
		jf.getContentPane().add(l3);
		jf.getContentPane().add(l4);
		jf.getContentPane().add(l5);
		jf.getContentPane().add(t1);
		jf.getContentPane().add(t2);
		jf.getContentPane().add(t3);
		jf.getContentPane().add(t4);
		jf.getContentPane().add(t5);
		jf.getContentPane().add(b1);
		jf.getContentPane().add(b2);
		jf.getContentPane().add(b3);
		jf.getContentPane().add(b4);
		jf.getContentPane().add(b5);
		jf.getContentPane().add(b6);
		jf.getContentPane().add(b7);
		jf.setSize(500,500);
		jf.setVisible(true);
	}
}

class RowNumber
{
	String line, destination, city, attractions, pilgrimage, packages;
	int i = 0;
	int read(String t1) throws IOException
	{
		FileReader fr = new FileReader("file.txt");
		BufferedReader br = new BufferedReader(fr);
		while((line = br.readLine()) != null)
		{
			i++;
			destination = line.substring(0,12);
			city = line.substring(14,41);
		 	attractions = line.substring(43,67);
		 	pilgrimage = line.substring(69,90);
			packages = line.substring(92,line.length()-2);
			if(t1.equals(destination))
			{
				break;
			}
		}
		br.close();
		return i;
	}
}

class Data
{
	String line, destination, city, attractions, pilgrimage, packages;
	void read(int n) throws IOException
	{
		FileReader fr = new FileReader("file.txt");
		BufferedReader br = new BufferedReader(fr);
		while(((line = br.readLine()) != null) && (n>0))
		{
			destination = line.substring(0,12);
			city = line.substring(14,41);
		 	attractions = line.substring(43,67);
		 	pilgrimage = line.substring(69,90);
			packages = line.substring(92,line.length()-2);
			n--;
		}
		br.close();
	}
}

class Search
{
	String line, destination, city, attractions, pilgrimage, packages;
	void read(String t1,String t2,String t3,String t4,String t5)throws IOException
	{
		int i;
		FileReader fr = new FileReader("file.txt");
		BufferedReader br = new BufferedReader(fr);
		String p = " ";
		while((line = br.readLine()) != null)
		{
			destination = line.substring(0,12);
			city = line.substring(14,41);
		 	attractions = line.substring(43,67);
		 	pilgrimage = line.substring(69,90);
			packages = line.substring(92,line.length()-2);
		 	for(i = t1.length(); i<12; i++)
		 	{
				t1 = t1 + p;
			}
		 	for(i = t2.length(); i<27; i++)
		 	{
				t2 = t2 + p;
			}
		 	for(i = t3.length(); i<24; i++)
		 	{
				t3 = t3 + p;
		 	}
		 	for(i = t4.length(); i<21; i++)
		 	{
				t4 = t4 + p;
		 	}
			for(i = t5.length(); i<14 ; i++)
			{
				t5 = t5 + p;
			}
		 	if(t1.equals(destination) || t2.equals(city) || t3.equals(attractions) || t4.equals(pilgrimage) || t5.equals(packages))
		 	{
				break;
		 	}
		}
		br.close();
	}
}

class Fileread
{
	String line, destination, city, attractions, pilgrimage, packages;
	void read() throws IOException
	{
		FileReader fr = new FileReader("file.txt");
		BufferedReader br = new BufferedReader(fr);
		while((line = br.readLine()) != null)
		{
			destination = line.substring(0,13);
			city = line.substring(14,42);
		 	attractions = line.substring(43,68);
		 	pilgrimage = line.substring(69,91);
			packages = line.substring(92,line.length()-1);
			System.out.print(destination);
			System.out.print(city);
			System.out.print(attractions);
			System.out.println(pilgrimage);
			System.out.println(packages);
		}
		br.close();
	}
}

class tour_travel
{
	public static void main(String [] args) throws IOException
	{
		Fileread f = new Fileread();
		f.read();
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new myframe();
			}
		});
	}
}