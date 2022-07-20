public class Box {

    private int number;
    private int innerNum;

    public Box(int number, int innerNum) {
        this.number = number;
        this.innerNum = innerNum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getInnerNum() {
        return innerNum;
    }

    public void setInnerNum(int innerNum) {
        this.innerNum = innerNum;
    }

    @Override
    public String toString() {
        return "Box{}";
    }
}
