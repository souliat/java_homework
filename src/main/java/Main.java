import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int randomNumberBus = randomNumber();
        int randomNumberTaxi = randomNumber();
        Bus bus = new Bus(100, 0, 30, 0, 1200, true, randomNumberBus);
        Taxi taxi = new Taxi(100, 0, "연희동", 4, false, randomNumberTaxi, 0);


        System.out.println("----- 버스 테스트 시작 -----");

        // 랜덤한 버스 번호
        System.out.println("버스 객체 고유번호 : " + bus.busNumber);

        //버스 상태 변경 테스트 isStart = true>> 운행 시작
        bus.changeStatus(true);
        System.out.println("현재 상태 : "+ bus.status);

        // 승객 탑승 테스트
        bus.passengerHop(10);
        bus.passengerHop(10);
        bus.passengerHop(10);
        bus.passengerHop(1); //max 인원인 30명이 초과하는 순간 탑승이 불가하다는 멘트가 나옴.

        //속도변경 테스트
        bus.speedChange(10, 5);

        System.out.println(" ");
        System.out.println("----- 택시 테스트 시작 -----");

        // 랜덤한 택시 번호
        System.out.println("택시 객체 고유번호 : " + taxi.taxiNumber);

        // 운행 시작 테스트
        taxi.startOperation();

        // 승객탑승 테스트
        taxi.passengerHop(3);
        taxi.passengerHop(3); // 위에서 이미 3명이 탑승했기 때문에 status가 "운행중"으로 변경되어서 탑승이 불가함.

        // 거리당 요금 추가 및 요금결제 테스트(기본거리 이하 / 기본거리 초과)
        taxi.additionalFee();

    }
    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(100000);
    }
}