import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrakeFuzzy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 상대 속도 입력 값
            System.out.print("상대 속도를 입력해 주세요. (-100km/h ~ 100km/h) : ");
            int speed = Integer.parseInt(br.readLine());

            // 거리 입력 값
            System.out.print("거리를 입력해 주세요. (0m ~ 100m) : ");
            int distance = Integer.parseInt(br.readLine());

            if (speed > 100 || speed < -100 || distance < 0 || distance > 100) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }

            if (speed >= 60) {
                System.out.println("1fast");
            } else if (speed > 0) {
                int belongTo = 0;
            }
        }
    }
}
