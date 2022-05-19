import javax.swing.text.ChangedCharSetException;

public class Bus extends Vehicle implements ChangeSpeed {
    //최대 승객 수
    int maxPassenger;
    //현재 승객 수
    int currentPassenger;
    //버스 요금
    int busFee;
    // 운행 시작(true), 운행 종료(false)
    boolean isStart;
    //버스 번호
    int busNumber;


    //Constructor
    public Bus(int fuelLevel, int currentSpeed, int maxPassenger, int currentPassenger, int busFee, boolean isStart, int busNumber) {
        super(fuelLevel, currentSpeed, "운행");
        this.maxPassenger = maxPassenger;
        this.currentPassenger = currentPassenger;
        this.busFee = busFee;
        this.isStart = isStart;
        this.busNumber = busNumber;
    }

    // 속도 변경
    @Override
    public void speedChange(int currentSpeed, int speed) {
        if (this.fuelLevel >= 10) {
            this.currentSpeed = currentSpeed + speed;
            System.out.println("현재 속도는 " + this.currentSpeed + "입니다.");
        }else {
            System.out.println("주유량을 확인해주세요.");
        }
    }

    // 버스 상태 변경
    public void changeStatus(boolean isStart) {
        if (this.fuelLevel < 10 || !isStart) {
            System.out.println("연료량이 10 미만입니다. 주유가 필요합니다.");
            System.out.println("차고지로 이동하세요.");
            this.status = "차고지행";
        } else {
            System.out.println("연료가 충분합니다. 운행이 가능합니다.");
        }
    }

    // 승객 탑승
    public void passengerHop(int passenger) {
        if (this.status.equals("운행")) {
            if (currentPassenger + passenger <= maxPassenger) {
                currentPassenger += passenger;
                System.out.println("현재 탑승객 수는 " + currentPassenger + "명 입니다.");
            }else {
                System.out.println("최대 탑승인원을 초과하여 탑승이 불가합니다.");
            }
        }
    }

}
