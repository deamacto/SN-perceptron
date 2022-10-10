public class Perceptron {

    double w1;
    double w2;
    double alpha;
    double wTheta;

    public Perceptron(double w1, double w2, double alpha, double wTheta) {
        this.w1 = w1;
        this.w2 = w2;
        this.alpha = alpha;
        this.wTheta = wTheta;
    }

    public boolean learn(Input input) {
        double sum = input.x1 * w1 + input.x2 * w2 + 1 * wTheta;

        int y = 0;
        if(sum > 0) {
            y = 1;
        }

        int delta = input.d - y;

        w1 = w1 + alpha * delta * input.x1;
        w2 = w2 + alpha * delta * input.x2;
        wTheta = wTheta + alpha * delta;

        return delta == 0;
    }
}
