package trabalho4_cg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Janela extends JFrame {

	String transfModo;

	JMenuBar menuBar = new JMenuBar();
	JMenu recorteMenu = new JMenu("Recortes");
	JMenu curvaMenu = new JMenu("Curvas");
	JMenu transfMenu = new JMenu("Transformações");
	JMenuItem exitMenu = new JMenuItem("Sair");
	

	JMenuItem linhasRetas = new JMenuItem("Linhas Retas");
	JMenuItem poligonos = new JMenuItem("Polígonos");
	
	
	JMenuItem bezier = new JMenuItem("Bézier");
	JMenuItem bspilne = new JMenuItem("B-Spilne");
	
	JMenuItem translacao = new JMenuItem("Translação");
	JMenuItem escala = new JMenuItem("Escala");
	JMenuItem rotacao = new JMenuItem("Rotação");

	public Janela() {
		initUI();
	}

	private void initUI() {

		createMenuBar();

		setTitle("Trabalho 3 - Computação Gráfica");
		setSize(360, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createMenuBar() {

		recorteMenu.add(linhasRetas);
		recorteMenu.add(poligonos);
		
		curvaMenu.add(bezier);
		curvaMenu.add(bspilne);
		
		transfMenu.add(translacao);
		transfMenu.add(escala);
		transfMenu.add(rotacao);
		
		linhasRetas.addActionListener((event) -> new AlgRecLinhas());
		poligonos.addActionListener((event) -> new AlgRecPoli());
		bezier.addActionListener((event) -> new AlgCurvaBezier());
		bspilne.addActionListener((event) -> new AlgCurvaSpline());
	    translacao.addActionListener((event) -> new TransfGeo("translacao"));
	    escala.addActionListener((event) -> new TransfGeo("escala"));
	    rotacao.addActionListener((event) -> new TransfGeo("rotacao"));

		exitMenu.addActionListener((event) -> System.exit(0));
		

		menuBar.add(recorteMenu);
		menuBar.add(curvaMenu);
		menuBar.add(transfMenu);
		menuBar.add(exitMenu);

		setJMenuBar(menuBar);

	}

	
}