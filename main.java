import java.util.Random;
import java.util.*;


class QueueSimulation {
    public static void main(String[] args) {
        ArrayList<Double> outPut = new ArrayList<Double>();
        ArrayList<Double> aRate = new ArrayList<>(Arrays.asList(.2,.4,.5,0.6, 0.65, 0.7, 0.72, 0.74, 0.745));
        double sRate = 0.75;
        int queue = 0;
        double avgQueue = 0.0;
        int iterations = 20000000;

        Random rand = new Random();
        for (double arrival:aRate){
            for (int i = 0; i < iterations; i++) {
                double rand_num = rand.nextDouble(1);
                if (rand_num <= arrival) {
                    queue++;
                }
            
                if (queue > 0 && rand.nextDouble(1) <= sRate) {
                    queue--;
                }
                avgQueue += queue;
            }
            avgQueue /= iterations;
            outPut.add(avgQueue/arrival);
        }    
        System.out.print(outPut);
    }
}
