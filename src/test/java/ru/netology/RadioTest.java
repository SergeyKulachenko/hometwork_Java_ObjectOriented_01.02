package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    public void NumberStationEntered() {
        int enteredNumberStation = 7;
        int expected = 7;
        Radio station = new Radio();
        station.setCurrentNumberStation(enteredNumberStation);
        int actual = station.getCurrentNumberStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "NumberStationFrom_0Forward,0,1",
            "NumberStationFrom_5Forward,5,6",
            "NumberStationFrom_9Forward,9,0",
    })
    public void NumberStationNext(String name, int currentNumberS, int expected) {
        Radio station = new Radio();
        station.NumberStationNext(currentNumberS);
        int actual = station.getCurrentNumberStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "NumberStationFrom_0Forward,0,9",
            "NumberStationFrom_5Forward,5,4",
            "NumberStationFrom_9Forward,9,8"
    })
    public void NumberStationPrev(String name, int currentNumberStation, int expected) {
        Radio station = new Radio();
        station.setCurrentNumberStation(currentNumberStation);
        station.NumberStationPrev();
        int actual = station.getCurrentNumberStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "volumeUpFrom_0,0,1",
            "volumeUpFrom_5,5,6",
            "volumeUpFrom_max,10,10"

    })
    public void VolumeStationUp(String name, int currentSoundVolume, int expected) {
        Radio station = new Radio();
        station.setCurrentSoundVolume(currentSoundVolume);
        station.VolumeStationUp();
        int actual = station.getCurrentSoundVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "volumeDownFrom_10,10,9",
            "volumeDownFrom_6,6,5",
            "volumeDownFrom_min,0,0"
    })
    public void VolumeStationDoun(String name, int currentSoundVolume, int expected) {
        Radio station = new Radio();
        station.setCurrentSoundVolume(currentSoundVolume);
        station.VolumeStationDoun();
        int actual = station.getCurrentSoundVolume();
        assertEquals(expected, actual);
    }
}
