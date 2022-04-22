import java.util.ArrayList;

public class Distance {

    private float distance;
    private ArrayList<String> outPut;

    public Distance(float distance) {
        this.distance = distance;
        this.outPut = new ArrayList<String>();
    }

    public ArrayList<String> getOutPut() {
        if (distance < 20) {
            outPut.add(1 + " 가까움(거리)");
        }

        if (distance >= 20 && distance < 40) {
            float value = -distance / 20 + 2;

            outPut.add(String.format("%.1f 가까움(거리)", value));
        }

        if (distance >= 35 && distance < 45) {
            float value = distance / 15 - 2;

            outPut.add(String.format("%.1f 적당함(거리)", value));
        }

        if (distance >= 45 && distance < 55) {
            outPut.add(1 + " 적당함(거리)");
        }

        if (distance >= 55 && distance < 70) {
            float value = -distance / 15 + (14f/3f);

            outPut.add(String.format("%.1f 적당함(거리)", value));
        }

        if (distance >= 60 && distance < 80) {
            float value = distance / 20 - 3;

            outPut.add(String.format("%.1f 멀다(거리)", value));
        }

        if (distance >= 80) {
            outPut.add(1 + " 멀다(거리)");
        }

        return outPut;
    }
}
