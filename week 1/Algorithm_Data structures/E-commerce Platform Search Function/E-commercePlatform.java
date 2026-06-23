import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class Main {

    static Product linearSearch(Product[] products, int target) {
        for (Product p : products)
            if (p.productId == target)
                return p;
        return null;
    }

    static Product binarySearch(Product[] products, int target) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == target)
                return products[mid];
            else if (products[mid].productId < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Phone", "Electronics"),
            new Product(1, "Book", "Education"),
            new Product(2, "Shirt", "Clothing")
        };

        Product p = linearSearch(products, 2);
        if (p != null)
            System.out.println("Linear Search Found: " + p.productName);

        Arrays.sort(products, (a, b) -> a.productId - b.productId);

        Product pp = binarySearch(products, 3);
        if (pp != null)
            System.out.println("Binary Search Found: " + pp.productName);
    }
}