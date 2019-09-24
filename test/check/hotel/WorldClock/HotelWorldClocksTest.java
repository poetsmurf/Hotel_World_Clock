package check.hotel.WorldClock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelWorldClocksTest {
    private HotelWorldClocksSystem hotelWorldClocksSystem;
    private PhoneClock phoneClock;

    @BeforeEach
    public void initialize(){
        this.hotelWorldClocksSystem = new HotelWorldClocksSystem();
        this.phoneClock = new PhoneClock(8);
    }
    @Test
    public void the_time_of_clock_London_should_be_1_after_the_phone_clock_is_set_to_9_Beijing_time(){

        CityClock londonClock = new CityClock(0);
        hotelWorldClocksSystem.attach(londonClock);

        phoneClock.setHotelWorldClocksSystem(hotelWorldClocksSystem);
        phoneClock.setTime(9);

        assertEquals(1, londonClock.getTime());
    }

    @Test
    public void the_time_of_clock_NewYork_should_be_20_after_the_phone_clock_is_set_to_9_Beijing_time(){

        CityClock newYorkClock = new CityClock(-5);
        hotelWorldClocksSystem.attach(newYorkClock);

        phoneClock.setHotelWorldClocksSystem(hotelWorldClocksSystem);
        phoneClock.setTime(9);

        assertEquals(20, newYorkClock.getTime());
    }

    @Test
    public void the_time_of_clock_Moscow_should_be_20_after_the_phone_clock_is_set_to_9_Beijing_time(){
        CityClock moscowClock = new CityClock(4);
        hotelWorldClocksSystem.attach(moscowClock);

        phoneClock.setHotelWorldClocksSystem(hotelWorldClocksSystem);
        phoneClock.setTime(9);

        assertEquals(5, moscowClock.getTime());
    }

    @Test
    public  void the_time_of_clock_london_and_newYork_should_be_1_and_20_respectively_after_the_phone_clock_is_set_to_9_Beijing_time(){

        CityClock newYorkClock = new CityClock(-5);
        CityClock londonClock = new CityClock(0);
        hotelWorldClocksSystem.attach(londonClock);
        hotelWorldClocksSystem.attach(newYorkClock);

        phoneClock.setHotelWorldClocksSystem(hotelWorldClocksSystem);
        phoneClock.setTime(9);
        
        assertEquals(1, londonClock.getTime());
        assertEquals(20, newYorkClock.getTime());
    }

    @Test
    public void the_time_of_the_phone_clock_should_be_set_correctly_after_its_setTime_method_is_invoked(){

        phoneClock.setTime(9);

        assertEquals(9, phoneClock.getTime());
    }
}