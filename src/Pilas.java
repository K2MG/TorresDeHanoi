import java.util.ArrayList;
import javax.swing.JLabel;

public class Pilas {
	
	private ArrayList<JLabel> filo= new ArrayList();
	
	
	public void push(JLabel o){
		//AGREGAR VALORES A LA PILA
	filo.add(o);
	
	
	}
	
	
	

	
	public JLabel pop(){
		//MOSTRAR EL ULTIMO VALOR Y LO ELIMINA

	       if(!(filo.isEmpty())){
               JLabel o = filo.get(filo.size()-1);
               filo.remove(filo.size()-1);
               return o;
       }else{
               return null;
       }
	       
	}

	public JLabel peek(){
		//MOSTRAR EL ULTIMO VALOR
		
		 if(!(filo.isEmpty())){
             return filo.get(filo.size()-1);
     }else{
             return null;
     }
		 
	}

	public boolean empty(){
		//PILA LLENA O VACIA
		 return filo.isEmpty();
	}

}