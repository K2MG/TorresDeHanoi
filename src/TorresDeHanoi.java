import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class TorresDeHanoi{
	
	int part=0;
	//cargando fondo
	private ImageIcon fondoMenu = new ImageIcon("Graficos\\fondoMenu.png");
	String user;
	
	public TorresDeHanoi(){
		
		//CREANDO VENTANA
		final JFrame ven = new JFrame("TORRES  DE  HANOI  -  KEVIN  MEJIA");
		ven.setSize(900, 620);
		ven.setVisible(true);
		ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ven.setLocationRelativeTo(null);
		ven.setResizable(false);
		ven.setLayout(null);
		
		//CREANDO FONDO
		JLabel fondo = new JLabel(fondoMenu);
		fondo.setSize(900, 600);
		fondo.setVisible(true);
		
		//CREANDO BOTONES
		JButton bNuevo = new JButton("Nuevo Juego");
		bNuevo.setBounds(462, 310, 200, 35);

		JButton bDemo = new JButton("Instrucciones / Demo");
		bDemo.setBounds(462, 355, 200, 35);
		
		JButton bPuntajes = new JButton("Puntajes");
		bPuntajes.setBounds(462, 400, 200, 35);
		
		//CREANDO CAJA DE USUARIO
		final JTextField usuario = new JTextField();
		usuario.setBounds(545, 207, 120, 20);
		
		
		//CREANDO LISTA DE DISCOS
		String[] numero = new String[] {"3","4","5","6","7","8"};
        final JComboBox<String> discos = new JComboBox<String>(numero);
        discos.setVisible(false);
        discos.setBounds(600,248,50,20);
		
		
		//AÑADIENDO COMPONENTES
		ven.add(bNuevo);
		ven.add(bDemo);
		ven.add(bPuntajes);
		ven.add(discos);
		discos.setVisible(true);
		ven.add(usuario);
		ven.repaint();
		ven.add(fondo);
		
		//EVENTO DE BOTON NUEVO JUEGO
		bNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	ven.dispose();
            	
            	part++;
            	
            	user=usuario.getText();
            	
            	llamarNuevo(discos.getSelectedItem());
            	
            	
            	
            }
        });
		
		//EVENTO DE BOTON DEMO
		bDemo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	ven.dispose();
            	llamarDemo();
            }
        });
		
		//EVENTO DE BOTON PUNTAJES
		bPuntajes.addActionListener(new ActionListener(){
		     @Override
		     public void actionPerformed(ActionEvent e){
		         ven.dispose();
		         llamarRecords();
		     }
		 });
		
	}
	
	public void llamarNuevo(Object num){
        String i = (String) num;
		JuegoTorres jt = new JuegoTorres();
		jt.nuevoJuego(i,user,part);
	}
	
	public void llamarDemo(){
		Demo demo = new Demo();
		demo.demo();
	}
	
	public void llamarRecords(){
		Records records= new Records();
		
	}
	
	public static void main(String[] args){
		TorresDeHanoi t = new TorresDeHanoi();
		
		
		
	}
	
	

}
