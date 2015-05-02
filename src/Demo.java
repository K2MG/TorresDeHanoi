import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Demo extends JFrame{
	
	final int dormir=1000;
	
	private ImageIcon fondoDemo = new ImageIcon("Graficos\\fondoDemo.png");
	private ImageIcon disc1 = new ImageIcon("Graficos\\disco1.png");
	private ImageIcon disc2 = new ImageIcon("Graficos\\disco2.png");
	private ImageIcon disc3 = new ImageIcon("Graficos\\disco3.png");
	private ImageIcon disc4 = new ImageIcon("Graficos\\disco4.png");
	private ImageIcon disc5 = new ImageIcon("Graficos\\disco5.png");
	
	JLabel disco0 = null;
	JLabel disco1 = null;
	JLabel disco2 = null;
	JLabel disco3 = null;
	JLabel disco4 = null;
	final int y[] ={485,445,405,365,325,285,245,205};
	
	Runnable rT1;
	Thread tT1 = new Thread(rT1);
	JFrame v;
	
	public void demo(){
		final JFrame ven = new JFrame();
		//GENERANDO VENTANA
		ven.setTitle("INSTRUCCIONES  Y  DEMOSTRACION  -  TORRES  DE  HANOI");
		ven.setSize(900, 620);
		ven.setVisible(true);
		ven.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ven.setLocationRelativeTo(null);
		ven.setResizable(false);
		ven.setLayout(null);
		
		//CREANDO FONDO
		JLabel fondoD = new JLabel(fondoDemo);
		fondoD.setSize(900, 600);
		
		//boton
		JButton regresar = new JButton("Regresar");
		regresar.setBounds(800, 0, 100, 20);
		
		regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	//nueva.dispose();
            	llamarMenu(ven);
            }
        });
		
		//CREANDO DISCOS

		Demo d = new Demo();
		disco0 = new JLabel(d.disc1);
		disco1 = new JLabel(d.disc2);
		disco2 = new JLabel(d.disc3);
		disco3 = new JLabel(d.disc4);
		disco4 = new JLabel(d.disc5);
		
		
		disco4.setBounds(45, y[0], 240, 40);
		disco3.setBounds(45, y[1], 240, 40);
		disco2.setBounds(45, y[2], 240, 40);
		disco1.setBounds(45, y[3], 240, 40);
		disco0.setBounds(45, y[4], 240, 40);
		
		final JButton iniciar = new JButton("Iniciar Demo");
		iniciar.setBounds(600,65,150,20);
		
		//AGREGANDO A VENTANA
		ven.add(disco4);
		ven.add(disco3);
		ven.add(disco2);
		ven.add(disco1);
		ven.add(disco0);
		ven.add(iniciar);
		ven.add(regresar);
		ven.repaint();
		ven.add(fondoD);
		
		
		rT1 = new Runnable() {
			
			
	        @Override
	        public void run() { 
	        	
	            try{
	            	
	            	empezarAnimacion(t[1],disco0,t[2],y[4],"R");
	    	        empezarAnimacion(y[4],disco0,y[0],t[2],"D");
	    	        empezarAnimacion(t[1],disco1,t[3],y[3],"R");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[3],disco1,y[0],t[3],"D");
	    	        empezarAnimacion(y[0],disco0,y[1],t[2],"U");
	    	        empezarAnimacion(t[2],disco0,t[3],y[1],"R");
	    	        empezarAnimacion(t[1],disco2,t[2],y[2],"R");
	    	        empezarAnimacion(y[2],disco2,y[0],t[2],"D");
	    	        empezarAnimacion(y[1],disco0,y[2],t[3],"U");
	    	        empezarAnimacion(t[3],disco0,t[1],y[2],"L");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[0],disco1,y[1],t[3],"U");
	    	        empezarAnimacion(t[3],disco1,t[2],y[1],"L");
	    	        empezarAnimacion(t[1],disco0,t[2],y[2],"R");
	    	        empezarAnimacion(y[1],disco3,y[4],t[1],"U");
	    	        empezarAnimacion(t[1],disco3,t[3],y[4],"R");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[4],disco3,y[0],t[3],"D");
	    	        empezarAnimacion(t[2],disco0,t[3],y[2],"R");
	    	        empezarAnimacion(y[2],disco0,y[1],t[3],"D");
	    	        empezarAnimacion(t[2],disco1,t[1],y[1],"L");
	    	        empezarAnimacion(y[1],disco0,y[2],t[3],"U");
	    	        empezarAnimacion(t[3],disco0,t[1],y[2],"L");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[0],disco2,y[1],t[2],"U");
	    	        empezarAnimacion(t[2],disco2,t[3],y[1],"R");
	    	        empezarAnimacion(t[1],disco0,t[2],y[2],"R");
	    	        empezarAnimacion(y[2],disco0,y[0],t[2],"D");
	    	        empezarAnimacion(y[1],disco1,y[2],t[1],"U");
	    	        empezarAnimacion(t[1],disco1,t[3],y[2],"R");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[0],disco0,y[3],t[2],"U");
	    	        empezarAnimacion(t[2],disco0,t[3],y[3],"R");
	    	        empezarAnimacion(t[1],disco4,t[2],y[0],"R");
	    	        empezarAnimacion(t[3],disco0,t[1],y[3],"L");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[3],disco0,y[0],t[1],"D");
	    	        empezarAnimacion(t[3],disco1,t[2],y[2],"L");
	    	        empezarAnimacion(y[2],disco1,y[1],t[2],"D");
	    	        empezarAnimacion(y[0],disco0,y[2],t[1],"U");
	    	        empezarAnimacion(t[1],disco0,t[2],y[2],"R");
	    	        empezarAnimacion(y[1],disco2,y[4],t[3],"U");
	    	        empezarAnimacion(t[3],disco2,t[1],y[4],"L");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[4],disco2,y[0],t[1],"D");
	    	        empezarAnimacion(t[2],disco0,t[3],y[2],"R");
	    	        empezarAnimacion(y[2],disco0,y[1],t[3],"D");
	    	        empezarAnimacion(t[2],disco1,t[1],y[1],"L");
	    	        empezarAnimacion(y[1],disco0,y[2],t[3],"U");
	    	        empezarAnimacion(t[3],disco0,t[1],y[2],"L");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[0],disco3,y[1],t[3],"U");
	    	        empezarAnimacion(t[3],disco3,t[2],y[1],"L");
	    	        empezarAnimacion(t[1],disco0,t[2],y[2],"R");
	    	        empezarAnimacion(y[1],disco1,y[4],t[1],"U");
	    	        empezarAnimacion(t[1],disco1,t[3],y[4],"R");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[4],disco1,y[0],t[3],"D");
	    	        empezarAnimacion(t[2],disco0,t[3],y[2],"R");
	    	        empezarAnimacion(y[2],disco0,y[1],t[3],"D");
	    	        empezarAnimacion(y[0],disco2,y[2],t[1],"U");
	    	        empezarAnimacion(t[1],disco2,t[2],y[2],"R");
	    	        empezarAnimacion(y[1],disco0,y[4],t[3],"U");
	    	        empezarAnimacion(t[3],disco0,t[1],y[4],"L");
	    	        tT1.sleep(dormir);
	    	        empezarAnimacion(y[4],disco0,y[0],t[1],"D");
	    	        empezarAnimacion(y[0],disco1,y[3],t[3],"U");
	    	        empezarAnimacion(t[3],disco1,t[2],y[3],"L");
	    	        empezarAnimacion(y[0],disco0,y[4],t[1],"U");
	    	        empezarAnimacion(t[1],disco0,t[2],y[4],"R");
	    	        tT1.sleep(300);
	    	        JOptionPane.showMessageDialog(v, "Fin de la demostración");
	    	        dispose();
	    	        String args[]=null;
	    	        TorresDeHanoi.main(args);
	            	
	            }catch(Exception e){
	            	System.out.println("Error");
	            }
	            
	            

	        }
	        
	           
	        
	    };
		
		
		iniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	iniciar.setEnabled(false);
            	tT1 = new Thread(rT1);
        		tT1.start();
        		
            	
            }
        });
		
		
	}
	
	public void empezarAnimacion(int I,JLabel Color, int F,int o,String direccion){
		Animation animation = new Animation();
		animation.empezar(I, Color, F, o,direccion);
	}
	
	public void llamarMenu(JFrame v){
    	String[] args=null;
    	v.dispose();
    	TorresDeHanoi.main(args);
	}
	
	final int t[]={0,45,337,627};
	
	
	
	
	
	

}
