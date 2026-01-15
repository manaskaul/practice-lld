package lld_04_zoomcar.classes;

public class PaymentManager {
    
    public void processPayment(Invoice invoice) {
        try {
            System.out.println("Processing payment. It will take 2 seconds...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
