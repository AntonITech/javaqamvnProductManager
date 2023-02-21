import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRepositoryProduct {
    RepositoryProduct repo = new RepositoryProduct();

    Product product1 = new Product(1, "Name1", 300);
    Product product2 = new Product(2, "Name2", 3000);
    Product product3 = new Product(3, "Name3", 700);

    @Test
    public void testFindAllProducts() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindOneProduct() {

        repo.save(product1);

        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindTwoProduct() {

        repo.save(product1);
        repo.save(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEptyProduct() {

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveOneProduct() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveTwoProduct() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(product2.getId());
        repo.removeById(product3.getId());

        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemovePriceProduct() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removePrice(product2.getPrice());
        repo.removePrice(product3.getPrice());

        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveIdWhenIdMatches() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(3);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveIdWhenIdNotMatch() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(7)
                );
    }

}
