import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        GenerateData data = new GenerateData();
//        serializeData(data);
        ArrayList<Input> data = deserializeData();
        learn(data);
    }

    public static void learn(ArrayList<Input> data) {
        Perceptron perceptron = new Perceptron(0.1, 0.1, 0.01, 0.8);
        boolean hasLearned = false;
        int generationCounter = 0;

        while(!hasLearned) {
            generationCounter++;
            hasLearned = true;
            for(Input input : data) {
                if(!perceptron.learn(input)) {
                    hasLearned = false;
                }
            }
        }

        System.out.println("Final w1: " + perceptron.w1 + " Final w2: " + perceptron.w2);
        System.out.println(generationCounter);
    }

    public static void serializeData(GenerateData data) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            outputStream.writeObject(data);
        } catch(Exception e) {
            return;
        }
    }

    public static ArrayList<Input> deserializeData() {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.bin"))) {
            GenerateData data = (GenerateData) inputStream.readObject();
            return data.data;
        } catch(Exception e) {
            return null;
        }
    }
}
