
package View;

import Trazos.HomeController;

public class startApp {
     public static void main(String[] args) {
        VistasFrame homeView = new VistasFrame();
        
        HomeController homeController = new HomeController(homeView);
        
        homeController.homeView.setVisible(true);
        
        System.out.println("Running");
    }
}
