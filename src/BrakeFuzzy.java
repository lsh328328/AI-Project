import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BrakeFuzzy {
    public static void rule(ArrayList<String> speed, ArrayList<String> distance) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Float> inputResult = new ArrayList<>();
        for (int i = 0; i < speed.size(); i++) {
            for (int j = 0; j < distance.size(); j++) {

                float speedSize = Float.parseFloat(speed.get(i).split(" ")[0]);
                float distanceSize = Float.parseFloat(distance.get(j).split(" ")[0]);

                float maxResult = Math.max(speedSize, distanceSize);
                float minResult = Math.min(speedSize, distanceSize);

                String speedSection = speed.get(i).split(" ")[1];
                String distanceSection = distance.get(j).split(" ")[1];
                String brakeSection = "";

                if (speedSection.equals("느림(속도)") || distanceSection.equals("가까움(거리)")) {
                    inputResult.add(maxResult);
                    brakeSection = "빡";
                    Brake brake = new Brake(maxResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("느림(속도)") && distanceSection.equals("적당함(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "세게";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("느림(속도)") && distanceSection.equals("멀다(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "살살";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("적당함(속도)") && distanceSection.equals("가까움(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "세게";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("적당함(속도)") && distanceSection.equals("적당함(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "살살";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("적당함(속도)") && distanceSection.equals("멀다(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "안 밟음";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("빠름(속도)") && distanceSection.equals("가까움(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "살살";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("빠름(속도)") && distanceSection.equals("적당함(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "안 밟음";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }

                if (speedSection.equals("빠름(속도)") || distanceSection.equals("멀다(거리)")) {
                    inputResult.add(minResult);
                    brakeSection = "안 밟음";
                    Brake brake = new Brake(minResult, brakeSection);

                    result.add(brake.getOutPut());
                }
            }
        }

        System.out.println(calculate(result, inputResult));
    }

    public static String calculate(ArrayList<String> brake, ArrayList<Float> input) {
        float x = 0;
        float y = 0;
        for (int i = 0; i < brake.size(); i++) {
            x += input.get(i);
            y += input.get(i) * Float.parseFloat(brake.get(i).split(" ")[0]);
        }

        return String.format("%.1f 브레이크", y/x);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

            Speed speedObject = new Speed(speed);
            Distance distanceObject = new Distance(distance);

            rule(speedObject.getOutPut(), distanceObject.getOutPut());
        }
    }
}
