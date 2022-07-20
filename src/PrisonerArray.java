import java.util.ArrayList;
import java.util.List;

public class PrisonerArray {

    private List<Prisoner> prisonerArray;

    public PrisonerArray(List<Integer> prisonerCount) {
        this.prisonerArray = new ArrayList<Prisoner>();
        for (int i = 0; i < prisonerCount.size(); i++) {
            this.prisonerArray.add(new Prisoner(prisonerCount.get(i)));
        }
    }

    public List<Prisoner> getPrisonerArray() {
        return prisonerArray;
    }

    public void setPrisonerArray(List<Prisoner> prisonerArray) {
        this.prisonerArray = prisonerArray;
    }
}
