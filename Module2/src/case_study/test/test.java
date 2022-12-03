package case_study.test;

import case_study.model.facility.Facility;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static case_study.test.CheckFacility.facilityVillaIntegerMap;

public class test {
    private static final String PATH_FILE_VILLA = "src/case_study/data/Villa.csv";
    private static final String PATH_FILE_ROOM = "src/case_study/data/Room.csv";
    private static final String NAME_REGEX = "^[A-Za-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]{5,50}$";

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ádasdf");
        String name = scanner.nextLine();
        checkVillaName(name);
    }
    public static Boolean checkVillaName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityVillaIntegerMap.keySet();
            for (Facility key : keySet) {
                if (name.equals(key.getNameService())) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }
}
