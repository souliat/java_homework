public class Taxi extends Vehicle implements ChangeSpeed{
    // 목적지
    String destination;
    // 목적지까지 거리
    int distToDestination;
    // 승객탑승 여부
    boolean isOccupied;
    //택시 번호
    int taxiNumber;
    //손님 수
    int currentPassenger;

    // 기본거리
    static int basicDistance = 5;
    // 기본요금
    static int basicPrice = 2500;
    // 거리당 요금
    static int distPrice = 100;


    // Constructor
    public Taxi(int fuelLevel, int currentSpeed, String destination,
                int distToDestination, boolean isOccupied, int taxiNumber, int currentPassenger) {
        super(fuelLevel, currentSpeed, "일반");
        this.destination = destination;
        this.distToDestination = distToDestination;
        this.isOccupied = isOccupied;
        this.taxiNumber = taxiNumber;
        this.currentPassenger = currentPassenger;
    }

    //운행 시작
    public void startOperation() {
        if (this.fuelLevel > 10) {
            System.out.println("연료가 충분하여 운행이 가능합니다.");
        }else {
            System.out.println("연료가 부족하여 운행이 어렵습니다.");
        }
    }

    //승객 탑승
    public void passengerHop(int passenger) {
        if (this.status.equals("일반")) {
            currentPassenger = passenger;
            System.out.println("현재 "+ currentPassenger+"명의 승객이 탑승하였습니다");
            this.status = "운행 중";
            System.out.println("택시 상태를 "+ this.status + "으로 변경합니다.");
        }else {
            System.out.println("택시가 운행 중 이므로 탑승이 불가합니다.");
        }
    }

    //속도 변경
    @Override
    public void speedChange(int currentSpeed, int speed) {
        if (this.fuelLevel >= 10) {
            this.currentSpeed = currentSpeed + speed;
        }else {
            System.out.println("주유량을 확인해주세요");
        }
    }

    // 거리당 요금 추가
    public void additionalFee() {
        int distanceDiff = distToDestination - basicDistance;

        if (distToDestination <= basicDistance) { // 목적지까지 거리가 기본거리 이하일 경우
            payment();
            return;
        }

        // 기본거리를 초과할 경우
        int i = 0;
        while(i < distanceDiff) {
            basicPrice += distPrice;
            i++;
        }
        payment();
    }

    // 최종 결제
    public void payment() {
        System.out.println("최종 목적지까지 요금은 "+ basicPrice + "원이고 결제를 하겠습니다.");
    }

}
