class Product{
    String name;
    String category;
    double price;
    int quantity;

    static int  totalProductsCreated=0;

    Product(String category, String name){
        this.category=category;
        this.name=name;
        this.price=0.0;
        this.quantity=0;
      
         totalProductsCreated++;
    }

    Product(String category, String name, double price, int quantity){
        this(category, name);
        this.price=price;
        this.quantity=quantity;

    }
    double getTotalValue(){
        return price * quantity;
    }

    void applyDiscount(double percent){
        price=Math.max(0.0,price-price*percent/100.0);
    }

    String getLabel(){
        return name +" (" + category + ")";
    }
    String  isInStock(){
        if(quantity > 0){
            return "IN STOCK";
        }
        else{
         return "OUT OF STOCK";
        }
    }

    static int getTotalProductsCreated(){
        return totalProductsCreated;
    }
}

public class Inventory {

    public static void main(String[] args){
        Product p1=new Product("ELECTRONICS","Laptop",1200.00,5);
        Product p2=new Product("CLOTHING","T-Shirt",15.00,20);
        Product p3=new Product("BOOKS","Java programming",45.00,0);
        Product p4=new Product("FOOD","Rice",32.50,10);

        p1.applyDiscount(10);

        Product[] products={p1,p2,p3,p4};
        
        System.out.println("===============================================================================");
        System.out.println("                           CS 234 - PRODUCT INVENTORY REPORT                                              ");
        System.out.println("===============================================================================");
        
        double totalInventoryValue=0;
        Product mostValuable = products[0];
        for(int i=0; i<products.length; i++){
            System.out.printf("%-20s %-20s %-20.2f %-20d %-20.2f %-20s%n",
                products[i].category,
                products[i].name,
                products[i].price,
                products[i].quantity,
                products[i].getTotalValue(),
                products[i].isInStock());
                
                totalInventoryValue+=products[i].getTotalValue();
                if(products[i].getTotalValue() > mostValuable.getTotalValue()) {
                               mostValuable = products[i];
        }
                
        }
    
        System.out.println("===============================================================================");
        System.out.println("Total Products Created : "+Product.getTotalProductsCreated());
        System.out.println("Total Inventory Value : "+totalInventoryValue);
        System.out.print("Most Valuable Product : "+mostValuable.name+" (");
        System.out.printf("%.2f",mostValuable.getTotalValue());
        System.out.println(")");
        System.out.println( "==============================================================================");
    }
}
