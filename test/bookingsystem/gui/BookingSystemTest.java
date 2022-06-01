package bookingsystem.gui;

import bookingsystem.Cart;
import bookingsystem.layout.Column;
import bookingsystem.layout.Row;
import bookingsystem.layout.SetReservation;
import java.util.Random;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class BookingSystemTest {

    SetReservation setReservation = new SetReservation();
    Database dbManager = new Database();

    public BookingSystemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    // test that buses reserve is working
    public void test1() {
        dbManager.dbsetup();
        setReservation.setUpReservations();

        System.out.println("Bus");

        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int row = rand.nextInt(7) + 1;
            char col = (char) (rand.nextInt(4) + 65);

            setReservation.reserveBus(col, row);
            System.out.println(col + "," + row);
        }
        Assert.assertEquals(Cart.busCart.size(), 5);
    }

    @Test
    // test that boats reserve is working
    public void test2() {
        dbManager.dbsetup();
        setReservation.setUpReservations();

        System.out.println("\nBoat");

        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int row = rand.nextInt(6) + 1;
            char col = (char) (rand.nextInt(7) + 65);

            setReservation.reserveBoat(col, row);
            System.out.println(col + "," + row);
        }
        Assert.assertEquals(Cart.boatCart.size(), 5);
    }

    @Test
    // test that trams reserve is working
    public void test3() {
        dbManager.dbsetup();
        setReservation.setUpReservations();

        System.out.println("\nTram:");

        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int row = rand.nextInt(7) + 1;
            char col = (char) (rand.nextInt(3) + 65);

            setReservation.reserveTram(col, row);
            System.out.println(col + "," + row);
        }
        Assert.assertEquals(Cart.tramCart.size(), 5);
    }

    @Test
    // check if seat not is reserved
    public void test4() {
        System.out.println("\nTesting boat seat not reserved");
        dbManager.dbsetup();
        boolean res = SetReservation.reserveBoat.isReserved(new Row(4), new Column('A'));
        System.out.println("Test: " + res);
        System.out.println("Contains: " + Cart.boatCart.contains("(A, 4)"));
        Assert.assertEquals(res, Cart.boatCart.contains("(A, 4)"));
    }

    @Test
    // check if seat is reserved
    public void test5() {
        System.out.println("\nTesting boat seat is reserved");
        dbManager.dbsetup();
        setReservation.reserveBoat('A', 4);
        boolean res = SetReservation.reserveBoat.isReserved(new Row(4), new Column('A'));
        System.out.println("Test: " + res);
        System.out.println("Equals: " + SetReservation.boatBooking.equals("(4,A)"));
        
        Assert.assertEquals(res, SetReservation.boatBooking.equals("(4,A)"));
    }
}
