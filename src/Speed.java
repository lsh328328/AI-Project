import java.util.ArrayList;

public class Speed {

    private float speed;
    private ArrayList<String> outPut;

    public Speed(float speed) {
        this.speed = speed;
        this.outPut = new ArrayList<String>();
    }

    public ArrayList<String> getOutPut() {
        if (speed < -60) {
            outPut.add(1 + " 느림(속도)");
        }

        if (speed >= -60 && speed < 0) {
            float value = (-1 * speed) / 60;

            outPut.add(String.format("%.1f 느림(속도)", value));
        }

        if (speed >= -60 && speed < -20) {
            float value = 0.025f * speed + 1.5f;

            outPut.add(String.format("%.1f 적당함(속도)", value));
        }

        if (speed >= -20 && speed < 20) {
            outPut.add((1 + " 적당함(속도)"));
        }

        if (speed >= 20 && speed < 60) {
            float value = -0.025f * speed + 1.5f;

            outPut.add(String.format("%.1f 적당함(속도)", value));
        }

        if (speed >= 0 && speed < 60) {
            float value = speed / 60;

            outPut.add(String.format("%.1f 빠름(속도)", value));
        }

        if (speed >= 60) {
            outPut.add(1 + " 빠름(속도)");
        }

        return outPut;
    }
}
