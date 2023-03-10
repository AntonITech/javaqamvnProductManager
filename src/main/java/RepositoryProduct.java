public class RepositoryProduct {
    Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i ++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product foundProduct = findById(id);
        if (foundProduct == null) {
            throw new NotFoundException(id);
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() !=id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public void removePrice(int price) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getPrice() !=price) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
