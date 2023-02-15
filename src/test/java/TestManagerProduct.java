import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestManagerProduct {

    RepositoryProduct repo = new RepositoryProduct();
    ManagerProduct manager = new ManagerProduct(repo);

    @Test
    public void testSearchNameProduct() {
        Book book1 = new Book(1, "book one", 333, "idea1");
        Book book2 = new Book(2, "book two", 337, "idea2");
        Book book3 = new Book(3, "book one three", 33, "idea3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1,book2, book3};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneName() {
        Book book1 = new Book(1, "book one", 333, "idea1");
        Book book2 = new Book(2, "book two", 337, "idea2");
        Book book3 = new Book(3, "book one three", 33, "idea3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("two");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchTwoNameProduct() {
        Book book1 = new Book(1, "book one", 333, "idea1");
        Book book2 = new Book(2, "book two", 337, "idea2");
        Book book3 = new Book(3, "book one three", 33, "idea3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("one");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEmptyProduct() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindOneProduct() {
        Book book1 = new Book(1, "book one", 333, "idea1");

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddProduct() {
        Book book1 = new Book(1, "book one", 333, "idea1");
        Book book2 = new Book(2, "book two", 337, "idea2");
        Book book3 = new Book(3, "book one three", 33, "idea3");
        Book book4 = new Book(4, "book one two", 31, "idea4");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNameProductSmartphone() {
        Smartphone phone1 = new Smartphone(1, "smart one", 333, "idea1");
        Smartphone phone2 = new Smartphone(2, "smart two", 333, "idea2");
        Smartphone phone3 = new Smartphone(3, "smart three two", 333, "idea3");

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {phone1, phone2, phone3};
        Product[] actual = manager.searchBy("smart");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchTwoNameSmartphone() {
        Smartphone phone1 = new Smartphone(1, "smart one", 333, "idea1");
        Smartphone phone2 = new Smartphone(2, "smart two", 333, "idea2");
        Smartphone phone3 = new Smartphone(3, "smart three two", 333, "idea3");

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {phone2, phone3};
        Product[] actual = manager.searchBy("two");

        Assertions.assertArrayEquals(expected, actual);
    }
}
