/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trazos;

import Listas.Coordenada;
import Listas.Nodo;
import View.VistasFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Fernanda
 */

public class MetodosTrazos implements ActionListener {
    
    public VistasFrame homeView;
    
    public MetodosTrazos(VistasFrame homeView){
        this.homeView = homeView;
        
        this.homeView.btnAbrir.addActionListener((ActionListener) this);
        this.homeView.btnGuardar.addActionListener((ActionListener) this);
        this.homeView.btnLimpiar.addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.homeView.btnAbrir) {
            try {
                abrirDibujo();
            } catch (IOException ex) {
                Logger.getLogger(MetodosTrazos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (e.getSource() == this.homeView.btnGuardar){
            guardarComo();
        }else if (e.getSource() == this.homeView.btnLimpiar){
            limpiarCoordenadas();
        }
    }
    
     public void abrirDibujo() throws FileNotFoundException, IOException{

        JFileChooser abrir = new JFileChooser();
        abrir.setDialogTitle("Abriendo dibujo");
        abrir.showDialog(null, "Abrir Dibujo");
        abrir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File dibujo = abrir.getSelectedFile();

        BufferedReader obj = new BufferedReader(new FileReader(dibujo));
        
        ArrayList<Coordenada> stringsLineas = (ArrayList<Coordenada>) new ArrayList<String>(Arrays.asList(obj.readLine().split(","))).stream()
        .map(coordenadas -> transformarAObjeto(coordenadas))
        .collect(Collectors.toList());
        
        ArrayList<Coordenada> stringsRectangulos = (ArrayList<Coordenada>) new ArrayList<String>(Arrays.asList(obj.readLine().split(","))).stream()
        .map(coordenadas -> transformarAObjeto(coordenadas))
        .collect(Collectors.toList());
        
        ArrayList<Coordenada> stringsCirculos = (ArrayList<Coordenada>) new ArrayList<String>(Arrays.asList(obj.readLine().split(","))).stream()
        .map(coordenadas -> transformarAObjeto(coordenadas))
        .collect(Collectors.toList());
        
        limpiarCoordenadas();
        
        
        for (Coordenada posision: stringsLineas) {
            this.homeView.lineas = this.homeView.agregar(this.homeView.lineas, posision);
        }
        for (Coordenada posision: stringsRectangulos) {
            this.homeView.rectangulos = this.homeView.agregar(this.homeView.rectangulos, posision);
        }
        for (Coordenada posision: stringsCirculos) {
            this.homeView.circulos = this.homeView.agregar(this.homeView.circulos, posision);
        }
        this.homeView.repaint();
    }
     
     private Coordenada transformarAObjeto(String string){
         String[] coor = string.split(" ");
         return new Coordenada(
                 Integer.parseInt(coor[0]),
                 Integer.parseInt(coor[1]),
                 Integer.parseInt(coor[2]),
                 Integer.parseInt(coor[3])
         );
     }
    
    public void guardarComo(){
        
        
                 
      //    JFileChooser guardar = new JFileChooser();
     //   guardar.setSelectedFile(new File("dibujo"));
     //   guardar.setDialogTitle("Guardando dibujo");
     //   guardar.showDialog(null, "Guardar Dibujo");
     //   guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

      //  File archivo = guardar.getSelectedFile();

      //  int tn = obtenerLongitud();
      //   String[] lineas = new String[tn];
        // String[] circulo = new String[tn];
      //   String[] rectangulo = new String[tn];
    //     if (tn > 0) {
   
  //          Node apuntador = cabeza;
//            while (apuntador != null) {
     //           lineas[i] = (apuntador.height != null ? apuntador.height : " ") + "\t"
                //        + (apuntador.width != null ? apuntador.width : " ") + "\t"
              //          + (apuntador.x != null ? apuntador.x : " ") + "\t"
            //            + (apuntador.y != null ? apuntador.y: " ");
          //      apuntador = apuntador.next;
        //        circulo[i] =(apuntador.height != null ? apuntador.height : " ") + "\t"
      //                  + (apuntador.width != null ? apuntador.width : " ") + "\t"
    //                    + (apuntador.x != null ? apuntador.x : " ") + "\t"
   //                     + (apuntador.y != null ? apuntador.y: " ");
             //   apuntador = apuntador.next;
                
                
            //    i++;
          //  }
            
         //         String str = String.join(",", lineas);
         //       str += "\n" + String.join(",", rectangulo);
       //          str += "\n" + String.join(",", circulo);
      //        guardarFichero(str, archivo);
    //}


        JFileChooser guardar = new JFileChooser();
        guardar.setSelectedFile(new File("dibujo"));
        guardar.setDialogTitle("Guardando dibujo");
        guardar.showDialog(null, "Guardar Dibujo");
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File archivo = guardar.getSelectedFile();
        
        List<Coordenada>  lineas = new ArrayList();
        List<Coordenada>  rectangulos = new ArrayList();
        List<Coordenada>  circulos = new ArrayList();
        
        
        for (Nodo i = this.homeView.lineas; i != null; i = i.getNext()) {
            lineas.add(i.getValue());
        }
        for (Nodo i = this.homeView.rectangulos; i != null; i = i.getNext()) {
            rectangulos.add(i.getValue());
        }
        for (Nodo i = this.homeView.circulos; i != null; i = i.getNext()) {
            circulos.add(i.getValue());
        }
        
        List<String> stringsLineas = lineas.stream()
        .map(object -> 
                object.getxStart() + " "+
                object.getyStart()+ " "+
                object.getxEnd()+ " " +
                object.getyEnd())
        .collect(Collectors.toList());
        List<String> stringsRectangulos = rectangulos.stream()
        .map(object -> 
                object.getxStart() + " "+
                object.getyStart()+ " "+
                object.getxEnd()+ " " +
                object.getyEnd())
        .collect(Collectors.toList());
        List<String> stringsCirculos = circulos.stream()
        .map(object -> 
                object.getxStart() + " "+
                object.getyStart()+ " "+
                object.getxEnd()+ " " +
                object.getyEnd())
        .collect(Collectors.toList());

         String str = String.join(",", stringsLineas);
         str += "\n" + String.join(",", stringsRectangulos);
         str += "\n" + String.join(",", stringsCirculos);
        guardarFichero(str, archivo);
    }
    
    public void guardarFichero(String cadena, File archivo){

        FileWriter escribir;
        try {

            escribir = new FileWriter(archivo + ".txt", true);
            escribir.write(cadena);
            escribir.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }
//    
    public void limpiarCoordenadas(){
        this.homeView.lineas = null;
        this.homeView.rectangulos = null;
        this.homeView.circulos = null;
        this.homeView.xStart = 0;
        this.homeView.yStart = 0;
        this.homeView.xEnd = 0;
        this.homeView.yEnd = 0;
        this.homeView.repaint();
    }
}
