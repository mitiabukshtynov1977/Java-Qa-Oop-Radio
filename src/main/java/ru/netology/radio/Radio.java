package ru.netology.radio;

public class Radio {
    private int currentStation; // Текущая радиостанция
    private int currentVolume;  // Текущая громкость
    private int maxStations;   // Максимальное количество радиостанций

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this(10); // Вызов основного конструктора
    }

    // Основной конструктор с параметром
    public Radio(int maxStations) {
        if (maxStations <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть больше 0");
        }
        this.maxStations = maxStations;
        this.currentStation = 0;
        this.currentVolume = 50; // Начальная громкость
    }

    // Геттеры и сеттеры
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < maxStations) {
            this.currentStation = station;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.currentVolume = volume;
        }
    }

    public int getMaxStations() {
        return maxStations;
    }

    // Переключение на следующую станцию
    public void nextStation() {
        if (currentStation == maxStations - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Переключение на предыдущую станцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = maxStations - 1;
        } else {
            currentStation--;
        }
    }

    // Увеличение громкости на 1
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменьшение громкости на 1
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}