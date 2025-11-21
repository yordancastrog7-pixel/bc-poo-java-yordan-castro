public class CafeOrder {
    private String orderNumber;
    private String customerName;
    private double totalAmount;

    public CafeOrder(String orderNumber, String customerName, double totalAmount) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public void showInfo() {
        System.out.println("Pedido No.: " + orderNumber);
        System.out.println("Cliente: " + customerName);
        System.out.println("Total: $" + totalAmount);
        System.out.println("-----------------------");
    }
}
