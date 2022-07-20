import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileManagement {
    private final String FILE_PATH = "../log/";
    private final String DATE_FORMAT = "dd-MM-yyyy";

    public String getDate() {
        LocalDate myObj = LocalDate.now(); // Create a date object
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(this.DATE_FORMAT);
        return myObj.format(myFormatObj);
    }

    public void createFile(String fileName) {
        try {
            File myObj = new File(this.FILE_PATH + fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void makeDir(String dirName) {
        File theDir = new File(this.FILE_PATH + dirName);
        if (!theDir.exists()){
            theDir.mkdirs();
            System.out.println("Dir created: " + theDir.getName());
        } else {
            System.out.println("Dir already exists.");
        }
    }

    public void writeToFile() {

    }
}
