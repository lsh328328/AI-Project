import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SerializablePermission;

public class BrakeFuzzy {
    public static String speedSection(float speed) {
        String result = "";

        if (speed < -60) {
            result += 1 + " 느림(속도)\n";
        }

        if (speed >= -60 && speed < 0) {
            float value = (-1 * speed) / 60;

            result += String.format("%.1f 느림(속도)\n", value);
        }

        if (speed >= -60 && speed < -20) {
            float value = 0.025f * speed + 1.5f;

            result += String.format("%.1f 적당함(속도)\n", value);
        }

        if (speed >= -20 && speed < 20) {
            result += (1 + " 적당함(속도)\n");
        }

        if (speed >= 20 && speed < 60) {
            float value = -0.025f * speed + 1.5f;

            result += String.format("%.1f 적당함(속도)\n", value);
        }

        if (speed >= 0 && speed < 60) {
            float value = speed / 60;

            result += String.format("%.1f 빠름(속도)\n", value);
        }

        if (speed >= 60) {
            result += 1 + " 빠름(속도)\n";
        }

        return result;
    }

    public static String distanceSection(float distance) {
        String result = "";

        if (distance < 20) {
            result += 1 + " 가까움(거리)\n";
        }

        if (distance >= 20 && distance < 40) {
            float value = -distance / 20 + 2;

            result += String.format("%.1f 가까움(거리)\n", value);
        }

        if (distance >= 35 && distance < 45) {
            float value = distance / 15 - 2;

            result += String.format("%.1f 적당함(거리)\n", value);
        }

        if (distance >= 45 && distance < 55) {
            result += 1 + " 적당함(거리)\n";
        }

        if (distance >= 55 && distance < 70) {
            float value = -distance / 15 + (14f/3f);

            result += String.format("%.1f 적당함(거리)\n", value);
        }

        if (distance >= 60 && distance < 80) {
            float value = distance / 20 - 3;

            result += String.format("%.1f 멀다(거리)\n", value);
        }

        if (distance >= 80) {
            result += 1 + " 멀다(거리)\n";
        }

        return result;
    }

    public static String brakeSection(float brake) {
        String result = "";

        if (brake >= 0 && brake < 0.2f) {
            float value = -3.5f * brake + 1;

            result += String.format("%.1f 안밟는다(브레이크)\n", value);
        }

        if (brake >= 0.2f && brake < 0.25f) {
            result += 0.3f + " 안밟는다(브레이크)\n";
        }

        if (brake >= 0.25f && brake < 0.3f) {
            result += 0.3f + " 살살밟는다(브레이크)\n";
        }

        if (brake >= 0.3f && brake < 0.5f) {
            float value = 3.5f * brake - 0.75f;

            result += String.format("%.1f 살살밟는다(브레이크)\n", value);
        }

        if (brake >= 0.5f && brake < 0.7f) {
            float value = -3.5f * brake + 2.75f;

            result += String.format("%.1f 세게밟는다(브레이크)\n", value);
        }

        if (brake >= 0.7f && brake < 0.75f) {
            result += 0.3f + " 세게밟는다(브레이크)";
        }

        if (brake >= 0.75f && brake < 0.8f) {
            result += 0.3f + " 빡밟는다(브레이크)";
        }

        if (brake >= 0.8f && brake <=1) {
            float value = 3.5f * brake - 2.5f;

            result += String.format("%.1f 빡밟는다(브레이크)\n", value);
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String brakeSection = brakeSection(0.3f);
        System.out.println(brakeSection);

        while (true) {
            // 상대 속도 입력 값
            System.out.print("상대 속도를 입력해 주세요. (-100km/h ~ 100km/h) : ");
            float speed = Float.parseFloat(br.readLine());

            if (speed > 100 || speed < -100) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
                continue;
            }

            // 거리 입력 값
            System.out.print("거리를 입력해 주세요. (0m ~ 100m) : ");
            float distance = Float.parseFloat(br.readLine());

            if (speed == -1 && distance == -1) {
                break;
            }

            if (distance > 100 || distance < 0) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
                continue;
            }

            String speedResult = speedSection(speed);
            String distanceResult = distanceSection(distance);

            System.out.println(speedResult);
            System.out.println(distanceResult);
        }
    }
}
