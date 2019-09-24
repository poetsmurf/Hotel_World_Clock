package check.hotel.WorldClock;

import java.util.ArrayList;

public class HotelWorldClocksSystem {

    private ArrayList<CityClock> cityClocks = new ArrayList<CityClock>();

    public void attach(CityClock cityClock) {
        this.cityClocks.add(cityClock);
    }

    public ArrayList<CityClock> getClocks() {
        return this.cityClocks;
    }
}
