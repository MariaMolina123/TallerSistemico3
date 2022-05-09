
package View;

import Trazos.MetodosTrazos;

public class startApp {
     public static void main(String[] args) {
        VistasFrame homeView = new VistasFrame();
        
        MetodosTrazos homeController = new MetodosTrazos(homeView);
        
        homeController.homeView.setVisible(true);
        
        System.out.println("Running");
    }
}
