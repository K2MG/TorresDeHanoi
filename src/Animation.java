import javax.swing.JLabel;

public class Animation{
	
	Runnable rT;
	Thread tT = new Thread(rT);
	
	final int dormir=1000;
	final int r=3;
	
	public void empezar(int I,JLabel Color, int F,int o, String Direccion){
		if(Direccion=="R"){
			animacionxR(I,Color,F,o);
			tT = new Thread(rT);
			tT.start();
			try{
				tT.sleep(dormir);
			}catch(Exception e){}
		}else if(Direccion=="L"){
			animacionxL(I,Color,F,o);
			tT = new Thread(rT);
			tT.start();
			try{
				tT.sleep(dormir);
			}catch(Exception e){}
		}else if(Direccion == "U"){
			animacionyU(I,Color,F,o);
			tT = new Thread(rT);
			tT.start();
			try{
				tT.sleep(dormir);
			}catch(Exception e){}
		}else if(Direccion=="D"){
			animacionyD(I,Color,F,o);
			tT = new Thread(rT);
			tT.start();
			try{
				tT.sleep(dormir);
			}catch(Exception e){}
		}
		
	}
	
	public void animacionxR(final int xI, final JLabel Color, final int xF, final int y){
		
		rT = new Runnable() {
	        @Override
	        public void run() { 
	            try{
	            	for(int i=xI;i<=xF;i++){
	    	        	Color.setLocation(i, y);
	    	        	tT.sleep(r);
	    	        }
	            	
	            }catch(Exception e){
	            	System.out.println("Error");
	            }
	            
	            

	        }
	        
	        
	        
	       
	    };
		
	}
    
    

	public void animacionxL(final int xI, final JLabel Color, final int xF, final int y){
		
		rT = new Runnable() {
	        @Override
	        public void run() { 
	            try{
	            	for(int i=xI;i>=xF;i--){
	    	        	Color.setLocation(i, y);
	    	        	tT.sleep(r);
	    	        }
	            	
	            }catch(Exception e){
	            	System.out.println("Error");
	            }
	            
	            

	        }
	        
	        
	        
	        
	    };
	    
		
		
	}
	
	public void animacionyU(final int yI, final JLabel Color, final int yF, final int x){
		
		rT = new Runnable() {
	        @Override
	        public void run() { 
	            try{
	            	for(int i=yI;i>=yF;i--){
	    	        	Color.setLocation(x,i);
	    	        	tT.sleep(r);
	    	        }
	            	
	            }catch(Exception e){
	            	System.out.println("Error");
	            }
	            
	            

	        }
	        
	        
	        
	        
	    };
	    
		
		
	}
    
    
	public void animacionyD(final int yI, final JLabel Color, final int yF, final int x){
		
		rT = new Runnable() {
	        @Override
	        public void run() { 
	            try{
	            	for(int i=yI;i<=yF;i++){
	    	        	Color.setLocation(x,i);
	    	        	tT.sleep(r);
	    	        }
	            	
	            }catch(Exception e){
	            	System.out.println("Error");
	            }
	            
	            

	        }
	        
	        
	        
	        
	    };
	    
		
		
	}
	
	
    
	
}