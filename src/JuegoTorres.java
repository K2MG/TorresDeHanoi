import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class JuegoTorres{
	
	//CARGANDO IMAGENES
	private ImageIcon fondoJuego = new ImageIcon("Graficos\\fondo.png");
	JFrame nueva = null;
	private ImageIcon disc1 = new ImageIcon("Graficos\\disco1.png");
	private ImageIcon disc2 = new ImageIcon("Graficos\\disco2.png");
	private ImageIcon disc3 = new ImageIcon("Graficos\\disco3.png");
	private ImageIcon disc4 = new ImageIcon("Graficos\\disco4.png");
	private ImageIcon disc5 = new ImageIcon("Graficos\\disco5.png");
	private ImageIcon disc6 = new ImageIcon("Graficos\\disco6.png");
	private ImageIcon disc7 = new ImageIcon("Graficos\\disco7.png");
	private ImageIcon disc8 = new ImageIcon("Graficos\\disco8.png");
	
	////////////
	JLabel disco0 = null;
	JLabel disco1 = null;
	JLabel disco2 = null;
	JLabel disco3 = null;
	JLabel disco4 = null;
	JLabel disco5 = null;
	JLabel disco6 = null;
	JLabel disco7 = null;
	
	

	Runnable rT;
    Thread tT = new Thread(rT);
	
	int discosG;
	String cron;
	int mov=0;
	String user;
	int partidas=0;
    
	public void nuevoJuego(String discos,String usuario,int partidas){
		
		discosG=Integer.parseInt(discos);
		user=usuario;
		this.partidas=partidas;
		
		//CREANDO VENTANA
		final JFrame nueva = new JFrame("NUEVO  JUEGO  -  TORRES  DE  HANOI");
		nueva.setSize(900, 620);
		nueva.setVisible(true);
		nueva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		nueva.setLocationRelativeTo(null);
		nueva.setResizable(false);
		nueva.setLayout(null);
		
		//CREANDO FONDO
		JLabel fondoJ = new JLabel(fondoJuego);
		fondoJ.setSize(900, 600);
		
		//BOTON
		JButton bRegresar = new JButton("Regresar");
		bRegresar.setBounds(800, 0, 100, 20);
		
		final JButton empezar = new JButton("Empezar a jugar");
		empezar.setBounds(400,90,150,20);
		
		//LABEL CRONOMETRO:
		final JLabel crono = new JLabel("00:00:00:00");
		crono.setBounds(435, 65, 100, 20);
		
		//LABEL DE MOVIMIENTOS MINIMOS
		final JLabel moves = new JLabel("AA");
		moves.setFont(new java.awt.Font("Lucida Sans", 0, 18)); 
		moves.setBounds(90,90,100,20);
		
		//LABEL DE MOVIMIENTOS REALIZADOS
				final JLabel realiz = new JLabel("0");
				realiz.setFont(new java.awt.Font("Lucida Sans", 0, 25)); 
				realiz.setBounds(760,100,100,20);
		
		
		rT = new Runnable() {
	        @Override
	        public void run() { 
	            try{
	                int minutos = 0 ;
	                int segundos= 0 ;
	                int horas = 0;
	                int miles=0;
	                while (true) {
	                	if(miles<100){
	                		miles++;
	                	}else if(miles==100){
	                		segundos++;
	                		miles=0;
	                	}
	                    if(segundos==60){
	                        minutos++;
	                        segundos=0;
	                    }
	                    if(minutos==60){
	                        minutos=0;
	                        horas++;
	                    }
	                    Tiempo(horas,minutos,segundos,miles);
	                    tT.sleep(10);
	                }               
	            }catch(Exception e){
	                
	            }
	            
	            

	        }
	        
	        public void Tiempo(int h,int m,int s,int mm){
	            crono.setText((h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(mm<=9?"0":"")+mm);
	            cron=crono.getText();
	            
	        }
	    };
		
		
		
		//GENERANDO
		generarDiscos(nueva,discos);
		
		//NUMERO DE MOVES MINIMOS
		moves.setText(movMinimos(discos));
		
		//BOTONES DE MOVIMIENTO
		final JButton t1mt2 = new JButton("A TORRE 2");
		final JButton t1mt3 = new JButton("A TORRE 3");
		final JButton t2mt1 = new JButton("A TORRE 1");
		final JButton t2mt3 = new JButton("A TORRE 3");
		final JButton t3mt1 = new JButton("A TORRE 1");
		final JButton t3mt2 = new JButton("A TORRE 2");
		
		t1mt2.setBounds(60,560,100,20);
		t1mt3.setBounds(170,560,100,20);
		t2mt1.setBounds(350,560,100,20);
		t2mt3.setBounds(460,560,100,20);
		t3mt1.setBounds(640,560,100,20);
		t3mt2.setBounds(750,560,100,20);
		
		t1mt2.setEnabled(false);
		t1mt3.setEnabled(false);
		t2mt1.setEnabled(false);
		t2mt3.setEnabled(false);
		t3mt1.setEnabled(false);
		t3mt2.setEnabled(false);
		
		
		//AGREGANDO A INTERFAZ
		nueva.add(realiz);
		nueva.add(moves);
		nueva.add(crono);
		nueva.add(t1mt2);
		nueva.add(t1mt3);
		nueva.add(t2mt1);
		nueva.add(t2mt3);
		nueva.add(t3mt1);
		nueva.add(t3mt2);
		nueva.add(bRegresar);
		nueva.add(empezar);
		nueva.repaint();
		nueva.add(fondoJ);
		
		//EVENTO REGRESAR
		empezar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	
        		empezar.setEnabled(false);
        		t1mt2.setEnabled(true);
        		t1mt3.setEnabled(true);
        		t2mt1.setEnabled(true);
        		t2mt3.setEnabled(true);
        		t3mt1.setEnabled(true);
        		t3mt2.setEnabled(true);
        		tT = new Thread(rT);
        		tT.start();
            }
        });
		
		//EVENTO INICIAR
		bRegresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	//nueva.dispose();
            	llamarMenu(nueva);
            }
        });
		
		
		//****************
		ingresar();
		t1mt2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	moverT1T2();
            	mov++;
            	realiz.setText(mov(mov));
            	gameOver(nueva);
            }
        });
		
		t1mt3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	moverT1T3();
            	mov++;
            	realiz.setText(mov(mov));
            	gameOver(nueva);
            }
        });
		
		//
		t2mt1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	moverT2T1();
            	mov++;
            	realiz.setText(mov(mov));
            	gameOver(nueva);
            }
        });
		
		t2mt3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	moverT2T3();
            	mov++;
            	realiz.setText(mov(mov));
            	gameOver(nueva);
            }
        });
		
		//
		t3mt2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	moverT3T2();
            	mov++;
            	realiz.setText(mov(mov));
            	gameOver(nueva);
            }
        });
		
		t3mt1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	moverT3T1();
            	mov++;
            	realiz.setText(mov(mov));
            	gameOver(nueva);
            }
        });
		
		
		
	}
	Pilas pilas = new Pilas();
	Pilas pilas2 = new Pilas();
	Pilas pilas3 = new Pilas();
	
	int top1[]={0,0,0,0,0,0,0,0};
	int top2[]={0,0,0,0,0,0,0,0};
	int top3[]={0,0,0,0,0,0,0,0};
	int lista[]={0,0,0};
	
	public void ingresar(){
		pilas.push(disco7);
		pilas.push(disco6);
		pilas.push(disco5);
		pilas.push(disco4);
		pilas.push(disco3);
		pilas.push(disco2);
		pilas.push(disco1);
		pilas.push(disco0);
		lista[0]=discosG;
	}
	
	
	
	
	public void moverT1T2(){
		JLabel color = pilas.peek();
		int i=0;
		while(top2[i]!=0){
			i++;
		}
		top1[i]=0;
		top2[i]=1;
		lista[0]--;
		lista[1]++;
		int y=nivel(lista[1]-1);
		color.setLocation(t[2],y);
		pilas2.push(pilas.pop());
	}
	
	
	public void moverT1T3(){
		JLabel color = pilas.peek();
		int i=0;
		while(top3[i]!=0){
			top3[i]=1;
			i++;
		}
		top1[i]=0;
		top3[i]=1;
		lista[0]--;
		lista[2]++;
		
		int y=nivel(lista[2]-1);
		color.setLocation(t[3],y);
		pilas3.push(pilas.pop());
		
	}
	
	//
	
	public void moverT2T1(){
		JLabel color = pilas2.peek();
		int i=0;
		while(top1[i]!=0){
			i++;
		}
		top2[i]=0;
		top1[i]=1;
		lista[1]--;
		lista[0]++;

		
		int y=nivel(lista[0]-1);
		color.setLocation(t[1],y);
		pilas.push(pilas2.pop());
		
	}
	public void moverT2T3(){
		JLabel color = pilas2.peek();
		int i=0;
		while(top3[i]!=0){
			top2[i]=0;
			i++;
		}
		top2[i]=0;
		top3[i]=1;
		lista[1]--;
		lista[2]++;
		int y=nivel(lista[2]-1);
		color.setLocation(t[3],y);
		pilas3.push(pilas2.pop());
		
	}
	
	//
	
	public void moverT3T2(){
		JLabel color = pilas3.peek();
		int i=0;
		while(top2[i]!=0){
			top3[i]=0;
			i++;
		}
		top3[i]=0;
		top2[i]=1;
		lista[2]--;
		lista[1]++;

		
		int y=nivel(lista[1]-1);
		color.setLocation(t[2],y);
		pilas2.push(pilas3.pop());
		
	}
	
	public void moverT3T1(){
		JLabel color = pilas3.peek();
		int i=0;
		while(top1[i]!=0){
			i++;
		}
		top3[i]=0;
		top1[i]=1;
		lista[2]--;
		lista[0]++;

		
		int y=nivel(lista[0]-1);
		color.setLocation(t[1],y);
		pilas.push(pilas3.pop());
		
	}
	
	
	
	public int nivel(int a){
		if(a==0){
			return y[0];
		}else if(a==1){
			return y[1];
		}else if (a==2){
			return y[2];
		}else if (a==3){
			return y[3];
		}else if (a==4){
			return y[4];
		}else if (a==5){
			return y[5];
		}else if (a==6){
			return y[6];
		}else if (a==7){
			return y[7];
		}else
			return 0;
	}
	
	public void llamarMenu(JFrame v){
    	String[] args=null;
    	v.dispose();
    	TorresDeHanoi.main(args);
	}
		
	final int y[] ={485,445,405,365,325,285,245,205};
	final int t[]={0,45,337,627};
	
	public String movMinimos(String n){
		int d = Integer.parseInt(n);
		if(d==3){
			return "7";
		}else if(d==4)
			return "15";
		else if (d==5)
			return "31";
		else if (d==6)
			return "63";
		else if (d==7)
			return "127";
		else if (d==8)
			return "255";
		else 
			return "0";
	}
	
	
	public void generarDiscos(JFrame ventana, String Discos){
		
		JuegoTorres jn = new JuegoTorres();
		disco0 = new JLabel(jn.disc1);
		disco1 = new JLabel(jn.disc2);
		disco2 = new JLabel(jn.disc3);
		disco3 = new JLabel(jn.disc4);
		disco4 = new JLabel(jn.disc5);
		disco5 = new JLabel(jn.disc6);
		disco6 = new JLabel(jn.disc7);
		disco7 = new JLabel(jn.disc8);
		
		
		
		int d = Integer.parseInt(Discos);
		
		//GENERANDO DISCOS
		if(d==3){
			disco2.setBounds(45, y[0], 240, 40);
			disco1.setBounds(45, y[1], 240, 40);
			disco0.setBounds(45, y[2], 240, 40);
			ventana.add(disco2);
			ventana.add(disco1);
			ventana.add(disco0);
			ventana.repaint();
		}else if(d==4){
			disco3.setBounds(45, y[0], 240, 40);
			disco2.setBounds(45, y[1], 240, 40);
			disco1.setBounds(45, y[2], 240, 40);
			disco0.setBounds(45, y[3], 240, 40);
			ventana.add(disco3);
			ventana.add(disco2);
			ventana.add(disco1);
			ventana.add(disco0);
			ventana.repaint();
		}else if (d==5){
			disco4.setBounds(45, y[0], 240, 40);
			disco3.setBounds(45, y[1], 240, 40);
			disco2.setBounds(45, y[2], 240, 40);
			disco1.setBounds(45, y[3], 240, 40);
			disco0.setBounds(45, y[4], 240, 40);
			ventana.add(disco4);
			ventana.add(disco3);
			ventana.add(disco2);
			ventana.add(disco1);
			ventana.add(disco0);
			ventana.repaint();
		}else if(d==6){
			disco5.setBounds(45, y[0], 240, 40);
			disco4.setBounds(45, y[1], 240, 40);
			disco3.setBounds(45, y[2], 240, 40);
			disco2.setBounds(45, y[3], 240, 40);
			disco1.setBounds(45, y[4], 240, 40);
			disco0.setBounds(45, y[5], 240, 40);
			ventana.add(disco5);
			ventana.add(disco4);
			ventana.add(disco3);
			ventana.add(disco2);
			ventana.add(disco1);
			ventana.add(disco0);
			ventana.repaint();
		}else if (d==7){
			disco6.setBounds(45, y[0], 240, 40);
			disco5.setBounds(45, y[1], 240, 40);
			disco4.setBounds(45, y[2], 240, 40);
			disco3.setBounds(45, y[3], 240, 40);
			disco2.setBounds(45, y[4], 240, 40);
			disco1.setBounds(45, y[5], 240, 40);
			disco0.setBounds(45, y[6], 240, 40);
			ventana.add(disco6);
			ventana.add(disco5);
			ventana.add(disco4);
			ventana.add(disco3);
			ventana.add(disco2);
			ventana.add(disco1);
			ventana.add(disco0);
			ventana.repaint();
		}else{
			disco7.setBounds(45, y[0], 240, 40);
			disco6.setBounds(45, y[1], 240, 40);
			disco5.setBounds(45, y[2], 240, 40);
			disco4.setBounds(45, y[3], 240, 40);
			disco3.setBounds(45, y[4], 240, 40);
			disco2.setBounds(45, y[5], 240, 40);
			disco1.setBounds(45, y[6], 240, 40);
			disco0.setBounds(45, y[7], 240, 40);
			ventana.add(disco7);
			ventana.add(disco6);
			ventana.add(disco5);
			ventana.add(disco4);
			ventana.add(disco3);
			ventana.add(disco2);
			ventana.add(disco1);
			ventana.add(disco0);
			ventana.repaint();
		}
		
	}
	
	public void gameOver(JFrame vv){
		if(lista[1]== discosG || lista[2]==discosG){
			try{
				tT.interrupt();
				
			}catch(Exception e){
				System.out.println("Dentro de catch");
			}
			JOptionPane.showMessageDialog(nueva, "¡Felicidades! \n Has terminado el juego en:\n"+cron+ " y "+mov+" movimientos", "GAME OVER",1);
			datosGuardado();
			guardaDatos();
			llamarMenu(vv);
			
			
		}
	}
	
	public String mov(int contador){
		String dato;
		dato=Integer.toString(contador);
		return dato;
	}
	
	
	
	
	
	
	
	
	
	Pilas grabar = new Pilas();
	String g;
	public void datosGuardado(){
		g=(user+"    ||    "+cron+"    ||       "+mov+"       ||    "+discosG);
		
	}
	
	
	
	
	String retorno=Character.toString ((char) 13);
	String enter=Character.toString ((char) 10);

	
	
	
	public void guardaDatos() {
		
		FileWriter f = null;
		try {
			f = new FileWriter("data.dat",true);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

        try {

        	BufferedWriter bw;//Instancia de BW

            bw = new BufferedWriter(f);
            
//Inicialización de "BW" con "FW" como parámetro con "fichero" como parámetro

            bw.write(g+retorno+enter);
            
            
          
            
            
//Escribimos lo que haya en los TextFields

            //y entre ello agregamos una coma (",").

            bw.close();//Cerramos para guardar los datos en el fichero

        } catch (IOException ex) {

            System.out.print("No se pudieron guardar los datos!n" + ex.getMessage());

        }

}
	
	

	
	
	
	
	
	

}
