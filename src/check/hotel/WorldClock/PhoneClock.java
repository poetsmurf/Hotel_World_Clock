package check.hotel.WorldClock;

public class PhoneClock extends Clock{

    private HotelWorldClocksSystem hotelWorldClocksSystem;
    private int time;

    public PhoneClock(int utcOffset) {
        super.utcOffset = utcOffset;
    }

    public void setTime(int time) {
        this.time = time;
        if(this.hotelWorldClocksSystem == null) return;
        for(CityClock cityClock : this.hotelWorldClocksSystem.getClocks()){
            cityClock.setUtcZeroTime(time - super.utcOffset);
        }
    }

    public void setHotelWorldClocksSystem(HotelWorldClocksSystem hotelWorldClocksSystem) {
        this.hotelWorldClocksSystem = hotelWorldClocksSystem;
    }

    @Override
    public int getTime() {
        return this.time;
    }
}
