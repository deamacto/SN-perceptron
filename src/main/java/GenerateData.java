import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateData implements Serializable {
    ArrayList<Input> data = new ArrayList<>();

    public GenerateData() {
        data.add(new Input(1, 1, 1));
        data.add(new Input(1, 0, 0));
        data.add(new Input(0, 1, 0));
        data.add(new Input(0, 0, 0));

        while(data.size() <= 50) {
            Input input = generateInput();

            if(input != null) {
                data.add(input);
            }
        }
    }

    private Input generateInput() {
        double x1 = Math.random();
        double x2 = Math.random();

        if(x1 > 0.8 && x2 > 0.8) {
            return new Input(x1, x2, 1);
        } else if(x1 > 0.8 && x2 < 0.2) {
            return new Input(x1, x2, 0);
        } else if(x1 < 0.2 && x2 > 0.8) {
            return new Input(x1, x2, 0);
        } else if(x1 < 0.2 && x2 < 0.2) {
            return new Input(x1, x2, 0);
        } else {
            return null;
        }
    }
}
