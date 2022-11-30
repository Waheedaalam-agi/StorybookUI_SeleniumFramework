package utils;


public class CommonUI extends Constants {

    public static void refresh() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            System.out.println("Webpage refresh failed");
            e.printStackTrace();
        }
    }

    public static void backward() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("No previous page to go back to");
            e.printStackTrace();
        }
    }

    public static void forward() {
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            System.out.println("No next page to go forward to");
            e.printStackTrace();
        }
    }
    }
