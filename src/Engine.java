import java.util.*;
import java.util.stream.IntStream;

public class Engine {

    public void random(List<Integer> range, Integer attempts, PrisonerArray prisons, BoxArray boxes) {
        for (Prisoner prisoner: prisons.getPrisonerArray()) {
            List<Integer> randomOrder = new ArrayList<Integer>(range);
            Collections.shuffle(randomOrder);

            for (int i = 0; i < attempts; i++) {
                Box box = boxes.getBoxArray().get((randomOrder.get(i) - 1));
                prisoner.getBoxHistory().add(box);
                System.out.print("Prisoner N." + prisoner.getNumber() + " search box N." + box.getNumber() + " with inner number " + box.getInnerNum());
                if (prisoner.getNumber() == box.getInnerNum()) {
                    prisoner.setSuccess(true);
                    System.out.println(" -> Success!");
                    break;
                } else {
                    System.out.println(" -> Keep looking...");
                    prisoner.setSuccess(false);
                }
            }
        }
        this.checkWin(prisons, attempts);
    }

    public void loop(List<Integer> range, Integer attempts, PrisonerArray prisons, BoxArray boxes) {
        Random rand = new Random();
        List<Integer> loopLength = new ArrayList<Integer>();

        for (Prisoner prisoner: prisons.getPrisonerArray()) {
            Integer randomFirstNumber = rand.nextInt(attempts) + 1;
            Integer loopCount = 0;
            int prevIndex = 0;

            for (int i = 0; i < attempts; i++) {
                if (i == 0) {
                    Box box = boxes.getBoxArray().get(randomFirstNumber - 1);
                    prisoner.getBoxHistory().add(box);
                    prevIndex = box.getInnerNum() - 1;
                    System.out.print("Prisoner N." + prisoner.getNumber() + " search box N." + box.getNumber() + " with inner number " + box.getInnerNum());
                    loopCount++;
                    if (prisoner.getNumber() == box.getInnerNum()) {
                        prisoner.setSuccess(true);
                        System.out.println(" -> Success!");
                        break;
                    } else {
                        System.out.println(" -> Keep looking...");
                        prisoner.setSuccess(false);
                    }
                } else {
                    Box box = boxes.getBoxArray().get(prevIndex);
                    prisoner.getBoxHistory().add(box);
                    prevIndex = box.getInnerNum() - 1;
                    System.out.print("Prisoner N." + prisoner.getNumber() + " search box N." + box.getNumber() + " with inner number " + box.getInnerNum());
                    loopCount++;
                    if (prisoner.getNumber() == box.getInnerNum()) {
                        prisoner.setSuccess(true);
                        System.out.println(" -> Success!");
                        break;
                    } else {
                        System.out.println(" -> Keep looking...");
                        prisoner.setSuccess(false);
                    }
                }
                loopLength.add(loopCount);
                System.out.println(loopCount);
            }
        }
        this.checkWin(prisons, attempts);
        this.findBiggestLoop(loopLength);
    }

    public void checkWin(PrisonerArray prisons, Integer attempts) {
        double successCount = 0.0;
        double failedCount = 0.0;
        for (Prisoner prisoner: prisons.getPrisonerArray()) {
            if (prisoner.getSuccess()) {
                successCount++;
            } else {
                failedCount++;
            }
        }
        if (failedCount > 0.0) {
            System.out.println("FAIL: success " + successCount + " failed " + failedCount);
        }
        if (!(successCount == 0.0)) {
            double probability = successCount / attempts;
            System.out.println(probability);
        }
        if (failedCount > 0) {
            System.out.println("This rescue attempts FAILED!");
        } else {
            System.out.println("This rescue attempts SUCCESS!");
        }
    }

    public void findBiggestLoop(List<Integer> loopArray) {
        // Integer max = Collections.max(loopArray);

        Integer max = 0;
        for (int i = 1; i < loopArray.size(); i++) {
            if (loopArray.get(i) > max) {
                max = loopArray.get(i);
            }
        }
        System.out.println("Largest loop is " + max);
    }
}
