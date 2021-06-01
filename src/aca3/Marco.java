package aca3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sergio Trujillo del Valle
 */
public class Marco extends JFrame implements ActionListener{
    
     public int 
            ancho = 435, 
            alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
     
    public String[] nombreColumnas = {"Columna 1","Columna 2","Columna 3", "Columna 4", "Columna 5",  "Columna 6"};
     
    public numerosAleatorios numeros = new numerosAleatorios();   
    private final DefaultTableModel cuadro;
    private final DefaultTableCellRenderer alingCenter;
    static JTable tabla;
    static JButton actualizar;
    static JLabel title, menorDiez, menorVeinte, mayorVeinte;
    
    public Marco() {
        // Titulo del Marco
        super("Matriz 6x6 con valores Aleatorios");
        
        this.numeros.valoresAleatorios();
        
        // Titulo de la Ventana
        title = new JLabel("Matriz de Numeros Aleatorios");
        
        // Creación de la tabla de valores
        cuadro= new DefaultTableModel(this.numeros.getCuadroNumeros(),nombreColumnas);
        alingCenter = new DefaultTableCellRenderer();
        alingCenter.setHorizontalAlignment(SwingConstants.CENTER);
        
        tabla = new JTable(cuadro);        
        tabla.getColumnModel().getColumn(0).setCellRenderer(alingCenter);
        tabla.getColumnModel().getColumn(1).setCellRenderer(alingCenter);
        tabla.getColumnModel().getColumn(2).setCellRenderer(alingCenter);
        tabla.getColumnModel().getColumn(3).setCellRenderer(alingCenter);
        tabla.getColumnModel().getColumn(4).setCellRenderer(alingCenter);
        tabla.getColumnModel().getColumn(5).setCellRenderer(alingCenter);
        
        // Panel que muestra la tabla
        JScrollPane panelTabla = new JScrollPane();
        panelTabla.setViewportView(tabla);
        
        JPanel conteo = new JPanel();
        
        this.numeros.validarNumeros();
        
        menorDiez = new JLabel("Hay " + this.numeros.getMenorDiez() + " números menores a 10");
        menorVeinte = new JLabel("Hay " + this.numeros.getMenorVeinte() + " números menores a 20 y mayores que 10");
        mayorVeinte = new JLabel("Hay " + this.numeros.getMayorVeinte() + " números mayores a 20");
        
        conteo.add(menorDiez);
        conteo.add(menorVeinte);
        conteo.add(mayorVeinte);
        
        // Botonón para hacer el calculo de las ventas
        actualizar = new JButton("Actualizar Tabla");
        actualizar.addActionListener(this);
        
        // Configuración de la posision de los elementos en el Marco        
        title.setBounds(10, 5, 200, 25);
        panelTabla.setBounds(10, 40, 410,119);
        conteo.setBounds(10, 160, 410,70);
        actualizar.setBounds(120, 230, 150, 30);
        
        //Configuración del marco General
        setLayout(null);
        setSize(ancho,300);
        setLocation(ancho,alto/4);
        setResizable(false);
        add(title);
        add(panelTabla);
        add(conteo);
        add(actualizar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == actualizar) {
            this.numeros.setMenorDiez(0);
            this.numeros.setMenorVeinte(0);
            this.numeros.setMayorVeinte(0);
            this.numeros.valoresAleatorios(); 
            this.numeros.validarNumeros();
            this.cuadro.setDataVector(this.numeros.getCuadroNumeros(),nombreColumnas);
            tabla.getColumnModel().getColumn(0).setCellRenderer(alingCenter);
            tabla.getColumnModel().getColumn(1).setCellRenderer(alingCenter);
            tabla.getColumnModel().getColumn(2).setCellRenderer(alingCenter);
            tabla.getColumnModel().getColumn(3).setCellRenderer(alingCenter);
            tabla.getColumnModel().getColumn(4).setCellRenderer(alingCenter);
            tabla.getColumnModel().getColumn(5).setCellRenderer(alingCenter);
            menorDiez.setText("Hay " + this.numeros.getMenorDiez() + " números menores a 10");
            menorVeinte.setText("Hay " + this.numeros.getMenorVeinte() + " números menores a 20 y mayores que 10");
            mayorVeinte.setText("Hay " + this.numeros.getMayorVeinte() + " números mayores a 20");
        }        
    }
}
