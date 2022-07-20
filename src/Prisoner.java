import java.util.ArrayList;
import java.util.List;

public class Prisoner {

    private int number;
    // private String name;
    private List<Box> boxHistory;
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Prisoner(int number) {
        this.boxHistory = new ArrayList<Box>();
        this.number = number;
    }

    public List<Box> getBoxHistory() {
        return boxHistory;
    }

    public void setBoxHistory(List<Box> boxHistory) {
        this.boxHistory = boxHistory;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
