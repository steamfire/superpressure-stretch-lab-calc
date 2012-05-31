// SEE LICENSE FILE FOR COPYING/LICENSE INFORMATION

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;








public class envelope2 extends JFrame
{


	private static final int width=805;
	private static final int height=400;

	private JLabel increment,eMass, temp,liftForce,pressureB,pressureA,volume,file,date,time,id,humid,gas,blank,blank2,eql;
	private JTextField inctf,eMasstf,temptf,liftForcetf,pressureBtf,pressureAtf,volumetf,filetf,datetf,timetf,idtf,humidtf,eqtf;
	private JButton newfile,save,choose, calculate,graph;
	private File filename;

	private NewButtonHandler newhandler;
	private SaveButtonHandler savehandler; 
	private ChooseButtonHandler choosehandler; 
	private CalcButtonHandler calculatehandler; 

	private GraphButtonHandler graphhandler; 

	private JFrame frame1,frame2;
	private Container pane, pane2,pane3;
	
	String eq;
	

	

	JCheckBox h,he;
	JCheckBox pow,exp;
	
	private TableView table = new TableView();
	private JFXPanel fxtable = new JFXPanel();



//This sets upt the gui
	public envelope2()
	{


		increment=new JLabel ("enter the increment #: ", SwingConstants.RIGHT);
		eMass=new JLabel ("enter the mass (kg): ", SwingConstants.RIGHT);
		temp=new JLabel ("enter the temperature(C): ", SwingConstants.RIGHT);
		liftForce=new JLabel ("enter the lift(kg): ", SwingConstants.RIGHT);
		pressureB=new JLabel ("enter the ballon pressure(mb): ", SwingConstants.RIGHT);
		pressureA=new JLabel ("enter the ambient pressure(mb): ", SwingConstants.RIGHT);
		volume=new JLabel ("output volume(m^3): ", SwingConstants.RIGHT);
		file=new JLabel ("new file name: ", SwingConstants.RIGHT);
		date=new JLabel ("enter the date: ", SwingConstants.RIGHT);
		time=new JLabel ("enter the time: ", SwingConstants.RIGHT);
		id=new JLabel ("enter the balloon ID: ", SwingConstants.RIGHT);
		humid=new JLabel ("enter the % humidity:  ", SwingConstants.RIGHT);
		gas=new JLabel ("gas type: ", SwingConstants.RIGHT);
		blank=new JLabel ("", SwingConstants.RIGHT);
		blank2=new JLabel ("", SwingConstants.RIGHT);
		eql=new JLabel ("line equation: ", SwingConstants.RIGHT);

		inctf=new JTextField(5);
		eMasstf=new JTextField(5);
		temptf=new JTextField(5);
		liftForcetf=new JTextField(5);
		pressureBtf=new JTextField(5);
		pressureAtf=new JTextField(5);
		volumetf=new JTextField(5);
		datetf=new JTextField(5);
		timetf=new JTextField(5);
		idtf=new JTextField(5);
		filetf=new JTextField(5);
		humidtf=new JTextField(5);
		eqtf=new JTextField(5);

		h = new JCheckBox("Hydrogen");
		he = new JCheckBox("Helium");
		pow = new JCheckBox("logarithmic regression");
		exp = new JCheckBox("exponetial regression");



		newfile=new JButton("Create file to save to");
		newhandler= new NewButtonHandler();
		newfile.addActionListener(newhandler);
		save=new JButton("Save");
		savehandler= new SaveButtonHandler();
		save.addActionListener(savehandler);
		choose=new JButton("Open file");
		choosehandler= new ChooseButtonHandler();
		choose.addActionListener(choosehandler);
		calculate=new JButton("Calculate Volume");
		calculatehandler= new CalcButtonHandler();
		calculate.addActionListener(calculatehandler);
		graph=new JButton("Graph");
		graphhandler= new GraphButtonHandler();
		graph.addActionListener(graphhandler);



		frame1=new JFrame("Envelope Quuantifier");
		frame2=new JFrame("Envelope Quuantifier");
		



		pane=frame1.getContentPane();
		pane.setLayout(new GridLayout(6,5));
		pane2=frame2.getContentPane();
		pane2.setLayout(new GridLayout (6,2));
		pane3=getContentPane();
		pane3.setLayout(new GridLayout (1,2));
		


		frame1.setSize(width, height);
		frame1.setVisible(true);
		frame2.setSize(width, height);
		frame2.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
     
        
     
        
      









		pane.add(date);
		pane.add(datetf);

		pane.add(time);
		pane.add(timetf);

		pane.add(id);
		pane.add(idtf);


		pane.add(eMass);
		pane.add(eMasstf);

		pane.add(temp);
		pane.add(temptf);

		pane.add(humid);
		pane.add(humidtf);

		pane.add(pressureA);
		pane.add(pressureAtf);

		pane.add(file);
		pane.add(filetf);

		pane.add(gas);


		pane3.add(h);
		pane3.add(he);
		
	

		pane.add(pane3);

		pane2.add(increment);
		pane2.add(inctf);

		pane2.add(liftForce);
		pane2.add(liftForcetf);


		pane2.add(pressureB);
		pane2.add(pressureBtf);


		pane2.add(volume);
		pane2.add(volumetf);

		pane2.add(graph);
		pane2.add(calculate);
		
		pane2.add(pow);
		pane2.add(exp);
		

		pane.add(blank);


		pane.add(newfile);
		pane.add(choose);
		pane.add(save);
		pane.add(eql);
		pane.add(eqtf);



	}
	//creates a new text file with the name entered by the user
	private class NewButtonHandler implements ActionListener
	{

		public void actionPerformed (ActionEvent e)
		{
			String name;
			File f;
			name =(filetf.getText());
			f=new File(name+".txt");

			try {
				f.createNewFile();
			} catch (IOException e1) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"The file already exists ",
						"warning",
						JOptionPane.WARNING_MESSAGE);
			}



			filename=f;
			PrintWriter out;
			try {
				out = new PrintWriter(new FileWriter(filename,true));
				out.println("Date,"+"Time,"+"ID,"+"increment#,"+"mass,"+"temperature,"+"lift,"+"pressureA,"+ "pressureB,"+"volume,"+"humidity,"+"gas");
			
				out.close();
			} catch (Exception e1) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"The file does not exist",
						"warning",
						JOptionPane.WARNING_MESSAGE);
			}



		}
	}
	//This method gets the values from the text boxes and saves them to a file
	public class SaveButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String i,m,t,l,pb,pa,v,d,time,id,hu;
			Double vol;

			i=inctf.getText();
			m=eMasstf.getText();
			t=temptf.getText();
			l=liftForcetf.getText();
			pa=pressureAtf.getText();
			pb=pressureBtf.getText();
			v=volumetf.getText();
			d=datetf.getText();
			time=timetf.getText();
			id=idtf.getText();
			hu=humidtf.getText();
			
			vol=Double.parseDouble(v);
			
			
			System.out.println(vol);

			PrintWriter out;
			try {
				out = new PrintWriter(new FileWriter(filename,true));
				//out.printf(i + ", "+ m + ", "+ t + ", "+ l + ", "+ p + ", "+ v );
				if(h.isSelected())
				{
					out.println(d+","+time+","+id+","+i+","+m+","+t+","+l+","+pa+","+pb+","+v+","+hu+","+"hydrogren,");
					
				}
				else if(he.isSelected())
				{
					out.println(d+","+time+","+id+","+i+","+m+","+t+","+l+","+pa+","+pb+","+v+","+hu+","+"helium,");
				}
			

				out.close();
			} catch (Exception e1) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"The file does not exist",
						"warning",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}
	public class ChooseButtonHandler extends AbstractAction 
	{


		public void actionPerformed(ActionEvent evt) 
		{

			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			filename = f;



		}
	}
	//calculated the volume of the balloon based on the data entered 
	public class CalcButtonHandler extends AbstractAction 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			double t,l,m,v,pb,ad,gd,hu,pa;
			t=0;
			l=0;
			m=0;
			v=0;
			pb=0;
			hu=0;
			pa=0;






			try {
				m=Double.parseDouble(eMasstf.getText());
				t=Double.parseDouble(temptf.getText());
				l=Double.parseDouble(liftForcetf.getText());
				pb=Double.parseDouble(pressureBtf.getText());
				hu=Double.parseDouble(humidtf.getText());
				pa=Double.parseDouble(pressureAtf.getText());
			} catch (Exception e1) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"enter a value into all boxes",
						"warning",
						JOptionPane.WARNING_MESSAGE);
			}


			ad=gasDensity(t,pa,hu,287.05,461.495);


			if(h.isSelected()&&he.isSelected())
			{
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"only one gas can be selected at a time",
						"warning",
						JOptionPane.WARNING_MESSAGE);
			}
			else if(!h.isSelected()&&!he.isSelected())
			{
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"please select a gas",
						"warning",
						JOptionPane.WARNING_MESSAGE);
			}

			else if(h.isSelected())
			{
				gd=gasDensity(t,pb+pa,0.0,4124.0,18.016);
				v=((l+m))/((ad-gd));
			}
			else if(he.isSelected())
			{
				gd=gasDensity(t,pb+pa,0.0,2077.0,18.016);
				v=((l+m))/((ad-gd));
			}

			volumetf.setText(Double.toString(v));

		}
	}

	public class GraphButtonHandler extends AbstractAction 
	{


		public void actionPerformed(ActionEvent evt) 
		{


			final NumberAxis xAxis = new NumberAxis(0,15,.5);
			final NumberAxis yAxis = new NumberAxis(0, 200, 20);  
			final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
			final XYChart.Series series1 = new XYChart.Series();
			final XYChart.Series series2 = new XYChart.Series();


			xAxis.setLabel("volume (m^3)");                
			yAxis.setLabel("pressure (mb)");
			sc.setTitle("volume vs. pressure");

			BufferedReader br = null;

			String line= null;


			double x,y = 0;
			
			String [] value=null;
			final ArrayList <Double> xs=new ArrayList <Double>();
			final ArrayList <Double> ys=new ArrayList <Double>();
			
			

			try {
				br = new BufferedReader(new FileReader(filename));
				
				line=br.readLine();


				while( (line=br.readLine())!=null)
				{
					
					value = line.split(",");
					y= Double.parseDouble(value[8]);
					x= Double.parseDouble(value[9]);
					xs.add(x);
					ys.add(y);
					series1.getData().add(new XYChart.Data(x,y));
					series1.setName("data points");




				}
			

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		
			xAxis.setLowerBound(xs.get(0));
			xAxis.setUpperBound((xs.get(xs.size()-1)+3));
			
			JFrame frame = new JFrame("graph");
			
			final JFXPanel fxPanel = new JFXPanel();
			frame.add(fxPanel);
			frame.setSize(600, 450);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			


			frame.setTitle("volume vs. pressure");

			

			Platform.runLater(new Runnable()
			{
				@Override
				public void run()  
				{
		

			Scene scene = new Scene(sc);
			
			if(pow.isSelected()&&exp.isSelected())
			{
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"only one type of regression can be selected at a time",
						"warning",
						JOptionPane.WARNING_MESSAGE);
			}
			else if(!pow.isSelected()&&!exp.isSelected())
			{
				sc.getData().addAll(series1);
			}

			else if(pow.isSelected())
			{
				sc.getData().addAll(findpow(xs, ys),series1);
			}
			else if(exp.isSelected())
			{
				sc.getData().addAll(findex(xs, ys),series1);
			}

			fxPanel.setScene(scene);
			

				}
			});
			
			
			
			
			
			frame.setVisible(true);
			
			
		
			

		}


	}

	//calculates the density of a gas
	//rg is the gas constant, and rv is the vapor constant
	public double gasDensity (Double t, Double pres, Double humid,Double rg,Double rv)
	{

		double d,h,es,p,pv,pd,da,dv; 

		//convert to pascals 
		pres=pres*100;



		double c0=0.99999683;
		double c1=-0.90826951E-02;
		double c2=0.78736169E-04;
		double c3=-0.61117958E-06;
		double c4=0.43884187E-08;
		double c5=-0.29883885E-10;
		double c6=0.21874425E-12;
		double c7=-0.17892321E-14;
		double c8=0.11112018E-16;
		double c9=-0.30994571E-19;

		double c=c0+t*(c1+t*(c2+t*(c3+t*(c4+t*(c5+t*(c6+t*(c7+t*(c8+t*(c9)))))))));

		p=Math.pow(c,8);
		//find the saturation vapor pressure
		es=6.1078/p;
		//convert to pascals
		es=es*100;
		//convert to kelvin
		t=t+273.15;

		h=humid*.01;

		pv=h*es;

		pd=pres-pv;

		da=(pd)/(rg*t);

		dv=(pv)/(rv*t);

		d=da+dv;



		return d;
	}
	
	public XYChart.Series findpow(ArrayList <Double> xs,	ArrayList <Double> ys)
	{
		XYChart.Series series = new XYChart.Series();
		double sumxy=0, sumx=0,sumy=0,sumx2=0;
		double m,b,a,r=0;
		int n=0;
		for (int i=0;i<xs.size();i++)
		{
			sumxy+=((Math.log10(xs.get(i)))*((ys.get(i))));
			sumx+=(Math.log10(xs.get(i)));
			sumy+=((ys.get(i)));
			sumx2+=(Math.pow(Math.log10(xs.get(i)),2));
			n++;
		}
		
		m=((n*(sumxy)-(sumx)*(sumy)))/
			((n*(sumx2)-Math.pow(sumx, 2)));
		b=((sumy)-m*(sumx))/n;
		
		
		
		
		a=Math.pow(10, b);
		
		
		System.out.println("m= "+ m);
		System.out.println("a= "+ b);
		
	
		
		
	
		for(double i=xs.get(0);i<xs.get(xs.size()-1)+4;i+=.01)
		{
			
			series.getData().add(new XYChart.Data(i,b+m*(Math.log10(i))));
			
		}
		
		series.setName((((double)Math.round( b* 10000) / 10000)) +" + "+(((double)Math.round(m * 1000) / 1000)) + "*log(x))");
		eq=series.getName();
		System.out.println("eq: "+eq);
		eqtf.setText(eq);
		return series;
		
	}
	
	public XYChart.Series findex(ArrayList <Double> xs,	ArrayList <Double> ys)
	{
		XYChart.Series series = new XYChart.Series();
		double sumxy=0, sumx=0,sumy=0,sumx2=0;
		double m,b,a,r=0;
		int n=0;
		for (int i=0;i<xs.size();i++)
		{
			sumxy+=(xs.get(i)*Math.log10(ys.get(i)));
			sumx+=(xs.get(i));
			sumy+=Math.log10((ys.get(i)));
			sumx2+=(Math.pow(xs.get(i),2));
			n++;
		}
		
		m=((n*(sumxy)-(sumx)*(sumy)))/
			((n*(sumx2)-Math.pow(sumx, 2)));
		b=((sumy)-m*(sumx))/n;
		
		
		System.out.println("m= "+ m);
		System.out.println("b= "+ b);
		
		
		r=Math.pow(10,m);
		a=Math.pow(10,b);
		
		System.out.println("r= "+ r);
		System.out.println("a= "+a);
		
		System.out.println("here2");
		for(double i=xs.get(0);i<xs.get(xs.size()-1)+4;i+=.005)
		{
			series.getData().add(new XYChart.Data(i,a*(Math.pow(r, i)-1)));
			//System.out.println(i+"  "+a*Math.pow(r, i) );
			
		}
		series.setName((double)Math.round( a* 1000000000) / 1000000000+"*"+(double)Math.round(r * 1000) / 1000+"^x");
		eq=series.getName();
		System.out.println("eq: "+eq);
		eqtf.setText(eq);



		return series;
	}



	public static void main(String[] args)
	{
		envelope2 evelopeCalc = new envelope2();

	}
	

}

