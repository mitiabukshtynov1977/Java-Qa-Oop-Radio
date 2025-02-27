package ru.netology.radio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void testDefaultConstructor() {
        Radio radio = new Radio();
        assertEquals(10, radio.getMaxStations());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void testCustomConstructor() {
        Radio radio = new Radio(20);
        assertEquals(20, radio.getMaxStations());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void testSetCurrentStation() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());

        // Проверка на недопустимые значения
        radio.setCurrentStation(-1);
        assertEquals(5, radio.getCurrentStation()); // Не должно измениться

        radio.setCurrentStation(15);
        assertEquals(5, radio.getCurrentStation()); // Не должно измениться
    }

    @Test
    void testSetCurrentVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(75);
        assertEquals(75, radio.getCurrentVolume());

        // Проверка на недопустимые значения
        radio.setCurrentVolume(-1);
        assertEquals(75, radio.getCurrentVolume()); // Не должно измениться

        radio.setCurrentVolume(101);
        assertEquals(75, radio.getCurrentVolume()); // Не должно измениться
    }

    @Test
    void testNextStation() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(14);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation()); // Должно переключиться на 0
    }

    @Test
    void testPrevStation() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(14, radio.getCurrentStation()); // Должно переключиться на 14
    }

    @Test
    void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());

        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume()); // Не должно превышать 100
    }

    @Test
    void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume()); // Не должно быть меньше 0
    }

    @Test
    void testInvalidMaxStations() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
        assertThrows(IllegalArgumentException.class, () -> new Radio(-5));
    }
}
