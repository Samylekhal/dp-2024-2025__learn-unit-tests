package fr.anthonyquere.teashop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;



public class teashopTest {

    private TeaShop teaShop;
    private TeaCup teaCup;
    private Tea tea;

    @BeforeEach
    void setUp() {
        teaCup = new TeaCup();
        teaShop = new TeaShop(90);
        tea = new Tea("thé vert", 240, 95, false);
        teaShop.addTea(tea);
    }

    // Test de Tea
    @Test
    void testTeaGettersAndSetters() {
        Tea tea = new Tea("Green Tea", 180, 80, true);
        assertEquals("Green Tea", tea.getName());
        assertEquals(180, tea.getSteepingTimeSeconds());
        assertEquals(80, tea.getIdealTemperatureCelsius());
        assertTrue(tea.isLoose());
    }

    // Test de TeaCup
    @Test
    void testAddWater() {
        teaCup.addWater(90);
        assertFalse(teaCup.isReadyToDrink());
    }

    @Test
    void testAddTeaToEmptyCupThrowsException() {

        Exception exception = assertThrows(IllegalStateException.class, () -> teaCup.addTea(tea));
        assertEquals("Cannot add tea to an empty cup!", exception.getMessage());
    }

    @Test
    void testIsReadyToDrink() throws InterruptedException {
        tea = new Tea("Earl Grey", 3, 85, false); // infuse le thé en 3 secondes
        teaCup.addWater(85);
        teaCup.addTea(tea);
        Thread.sleep(3000);
    
        System.out.println("Is ready to drink: " + teaCup.isReadyToDrink()); 
        assertTrue(teaCup.isReadyToDrink());
    }
    
    // test de TeaShop
    @Test
    void testPrepareTea() {
        TeaCup cup = teaShop.prepareTea("thé vert");
        assertNotNull(cup);
    }

    @Test
    void testPrepareTeaNotAvailableThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> teaShop.prepareTea("Oolong"));
        assertEquals("Tea not available: Oolong", exception.getMessage());
    }

    @Test
    void testSetWaterTemperature() {
        teaShop.setWaterTemperature(85);
        assertThrows(IllegalArgumentException.class, () -> teaShop.setWaterTemperature(150));
    }
}


