
package View;

import Controller.HomeController;

public class startApp {
     public static void main(String[] args) {
        HomeView homeView = new HomeView();
        
        HomeController homeController = new HomeController(homeView);
        
        homeController.homeView.setVisible(true);
        
        System.out.println("Running");
    }
}
