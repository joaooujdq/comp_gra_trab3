package trabalho4_cg;


import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class TransfGeo extends JFrame {

 
    
    TransfGeo(String modo) {
        this.setTitle("Algorimto de Transformações Geométricas");
        this.setSize(600,500);
        this.add("Center",new TranformaGeo(modo));
        this.setLocationRelativeTo(null);
    
        this.setVisible(true);
    }

    private static class TranformaGeo extends Canvas {
        Polygon poly;
        double tx=10, ty=10, ang=0.1;
        double mi[][];
        double mt[][];
        double mr[][];
        int li, ci, lt, ct;
        
        
        public TranformaGeo(String modo) {
            iniciaMatrizes();
          System.out.println(modo);
            addKeyListener(new KeyAdapter() {
            	@Override
            	 public void keyPressed(KeyEvent evt) {
            		 System.out.println(modo + "teste");
            		 switch(modo) {
            		 case "escala":
            			 if(evt.getKeyCode() == KeyEvent.VK_LEFT) {System.out.println(0); transformaEscala1();}
            			 else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {transformaEscala2();}
            		  break;
            		 case "translacao":
            			 if(evt.getKeyCode() == KeyEvent.VK_LEFT) {System.out.println(1); transformaTranslada1();}
            			 else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {transformaTranslada2();}
            		  break;
            		 case "rotacao":
            			 if(evt.getKeyCode() == KeyEvent.VK_LEFT) {System.out.println(2); transformaRotacao1();}
            			 else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {transformaRotacao2();}
            		  break;
            		 }
                 
                     repaint();
                 }
            
            
            });

        }
        
        private void iniciaMatrizes() {
            poly = new Polygon();
            li = 3; ci = 2;
            
            mi = new double[li][ci];
            mi[0][0] = 150; mi[0][1] = 100;
            mi[1][0] = 20; mi[1][1] = 200;
            mi[2][0] = 120; mi[2][1] = 200;
            
            for(int i=0;i<li;i++) poly.addPoint((int)mi[i][0],(int)mi[i][1]);
            
        }
        
        public void transformaEscala1() {
            lt = 2; ct = 2;
            mt = new double[lt][ct];
            mt[0][0] = (double) 1.5; mt[0][1] = (double) 0.0;
            mt[1][0] = (double) 0.0; mt[1][1] = (double) 1.5;
            
            mr = new double[li][ct];
            for (int i =0; i<li; i++) 
                for(int j=0; j<ci; j++)
                    mr[i][j] = (mi[i][0] * mt[0][j]) + (mi[i][1] * mt[1][j]);
                                    
            pushMatrix();
            
            
            
        }
        
        public void transformaTranslada1() {
            mr = new double[li][ci];
            
            for (int i=0; i<li; i++) {
                mr[i][0] = (mi[i][0] - tx);
                mr[i][1] = (mi[i][1] - ty);
            }
            
            pushMatrix();
            
        }
        
        public void transformaRotacao1() {
            lt = 2; ct = 2;
            mr = new double[li][ct];
            
            double cos = Math.cos(ang);
            double sen = Math.sin(ang);
            
            for (int i=0; i<li; i++) {
                mr[i][0] = (mi[i][0] * cos) - (mi[i][1] * sen);
                mr[i][1] = (mi[i][0] * sen) + (mi[i][1] * cos);
            }
            
            pushMatrix();
        }
        
        public void transformaEscala2() {
        	 lt = 2; ct = 2;
             mt = new double[lt][ct];
             mt[0][0] = (double) 0.66; mt[0][1] = (double) 0.0;
             mt[1][0] = (double) 0.0; mt[1][1] = (double) 0.66;
             
             mr = new double[li][ct];
             for (int i =0; i<li; i++) 
                 for(int j=0; j<ci; j++)
                     mr[i][j] = (mi[i][0] * mt[0][j]) + (mi[i][1] * mt[1][j]);
                                     
             pushMatrix();
             
             
            
            
        }
        
        public void transformaTranslada2() {
            mr = new double[li][ci];
            
            for (int i=0; i<li; i++) {
                mr[i][0] = (mi[i][0] + tx);
                mr[i][1] = (mi[i][1] + ty);
            }
            
            pushMatrix();
            
        }
        
        public void transformaRotacao2() {
            lt = 2; ct = 2;
            mr = new double[li][ct];
            
            double cos = Math.cos(ang);
            double sen = Math.sin(ang);
            
            for (int i=0; i<li; i++) {
                mr[i][0] = (mi[i][0] * cos) + (mi[i][1] * sen);
                mr[i][1] =  (mi[i][1] * cos) - (mi[i][0] * sen) ;
            }
            
            pushMatrix();
        }
        
        /// transfere a matriz resultante para a matriz inicial
        private void pushMatrix() {
            for(int i=0; i<li; i++)
                for(int j=0;j<ci; j++)
                    mi[i][j] = mr[i][j];
                       
        }
        
        /// usa os recursos java (Graphics e Polígono) para gerar o gráfico 
        @Override
        public void paint(Graphics g) {
            poly = new Polygon();
            for(int i=0;i<li;i++) poly.addPoint((int)mi[i][0],(int)mi[i][1]);
            g.fillPolygon(poly);
        }
    }
    
}

