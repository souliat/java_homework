public class Vehicle {
    // 주유량
    int fuelLevel;
    // 현재속도
    int currentSpeed;
    // 상태
    String status;

    public Vehicle(int fuelLevel, int currentSpeed, String status) {
        this.fuelLevel = fuelLevel;
        this.currentSpeed = currentSpeed;
        this.status = status;
    }
}
