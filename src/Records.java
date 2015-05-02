import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Records extends JFrame{
	
	private ImageIcon fondoRecords = new ImageIcon("Graficos\\fondoRecords.png");
	JTextArea rec;
	
	public Records(){
		
		Font font = new Font("Verdana", Font.BOLD, 12);
		Font font2 = new Font("Blackoak Std", Font.BOLD, 18);
		
		//
		rec=new JTextArea("");
		rec.setBounds(50, 70, 400, 175);
		rec.setEditable(false);
		rec.setBorder(BorderFactory.createLineBorder(Color.black,1));
		rec.setFont(font);
		rec.setForeground(Color.white);
		rec.setBackground(Color.BLACK);
		
		JLabel fondo = new JLabel(fondoRecords);
		fondo.setSize(500,300);
		
		//CREANDO VENTANA
		final JFrame puntos = new JFrame("PUNTAJES  -  TORRES  DE  HANOI");
		puntos.setSize(500, 300);
		puntos.setVisible(true);
		puntos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		puntos.setLocationRelativeTo(null);
		puntos.setResizable(false);
		puntos.setLayout(null);
		
		//
		JLabel titulo = new JLabel("Tabla de puntajes");
		titulo.setBounds(5,12,390,20);
		JLabel encab = new JLabel("Usuario    ||       Tiempo     ||   # Movimientos   ||  # Discos");
		encab.setBounds(50,50,400,20);
		titulo.setFont(font2);
		titulo.setForeground(Color.white);
		encab.setFont(font);
		encab.setForeground(Color.white);
		
		//
		
		JButton regresar = new JButton("Regresar");
		regresar.setBounds(410, 0, 90, 20);
		
		
		puntos.add(titulo);
		puntos.add(encab);
		puntos.add(regresar);
		puntos.add(rec);
		leer();
		puntos.add(fondo);
		puntos.repaint();
		
		
		regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	//nueva.dispose();
            	llamarMenu(puntos);
            }
        });
		
	}
	
	public void llamarMenu(JFrame v){
    	String[] args=null;
    	v.dispose();
    	TorresDeHanoi.main(args);
	}
	
	
	
	public void leer(){
		//Creamos un String que va a contener todo el texto del archivo
		String texto="";
		

		try{
			//Creamos un archivo FileReader que obtiene lo que tenga el archivo
			FileReader lector=new FileReader("data.dat");

			//El contenido de lector se guarda en un BufferedReader
			BufferedReader contenido=new BufferedReader(lector);
			
			

			//Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
			while((texto=contenido.readLine())!=null){
			
				String aux=rec.getText();
				
				rec.setText(aux+"\n"+texto);
				
			}
			
		}catch(Exception e){
			System.out.println("Error al leer");
		}
	
	}
	
	
	

}
