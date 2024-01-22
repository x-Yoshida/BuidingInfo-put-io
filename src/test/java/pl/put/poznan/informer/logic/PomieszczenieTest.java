package pl.put.poznan.informer.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PomieszczenieTest {

    private Pomieszczenie pomieszczenie;
    private Poziom p_mock;

    @BeforeEach
    void setup(){
        p_mock = mock(Poziom.class);
        when(p_mock.getId()).thenReturn(1);
        pomieszczenie = new Pomieszczenie(1,"pomieszczenie");
    }
    @Test
    void getPowierzchnia() {
        assertNotNull(pomieszczenie.getPowierzchnia());
    }

    @Test
    void getKubatura() {
        assertNotNull(pomieszczenie.getKubatura());
    }

    @Test
    void getLight() {
        assertEquals(pomieszczenie.getLightPower()/ pomieszczenie.getKubatura(), pomieszczenie.getLight());
    }

    @Test
    void getLightPower() {
        assertNotNull(pomieszczenie.getLightPower());
    }

    @Test
    void getHeating() {
        assertEquals(pomieszczenie.getHeatingPower()/ pomieszczenie.getKubatura(), pomieszczenie.getHeating());
    }

    @Test
    void mocktest(){
        assertEquals(p_mock.getId(), 1);
    }
}