import java.util.ArrayList;
import java.util.List;

public class BoxArray {

    private List<Box> boxArray;

    public BoxArray(List<Integer> boxNumbers, List<Integer> innerNumbers) {
        this.boxArray = new ArrayList<Box>();
        for (int i = 0; i < boxNumbers.size(); i++) {
            this.boxArray.add(new Box(boxNumbers.get(i), innerNumbers.get(i)));
        }
    }

    public List<Box> getBoxArray() {
        return boxArray;
    }

    public void setBoxArray(List<Box> boxArray) {
        this.boxArray = boxArray;
    }
}
