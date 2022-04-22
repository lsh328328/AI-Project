public class Brake {
    private float input;
    private String section;
    private String outPut;

    public Brake(float input, String section) {
        this.input = input;
        this.section = section;
        this.outPut = "";
    }

    public String getOutPut() {
        float result = 0;
        if (section == "안 밟음") {
            result = -2/7f * input + 2/7f;

            outPut += String.format("%.1f 브레이크", result);
        }

        if (section == "살살") {
            result = 2/7f * input + 3/14f;

            outPut += String.format("%.1f 브레이크", result);
        }

        if (section == "세게") {
            result = -2/7f * input + 11/14f;

            outPut += String.format("%.1f 브레이크", result);
        }

        if (section == "빡") {
            result = 2/7f * input + 5/7f;

            outPut += String.format("%.1f 브레이크", result);
        }

        return outPut;
    }
}
