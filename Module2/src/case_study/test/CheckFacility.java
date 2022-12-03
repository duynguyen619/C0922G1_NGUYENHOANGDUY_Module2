package case_study.test;

import case_study.model.facility.Facility;
import case_study.util.ReadAndWriteCSV;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckFacility {
    private static final String PATH_FILE_VILLA = "src/case_study/data/Villa.csv";
    private static final String PATH_FILE_ROOM = "src/case_study/data/Room.csv";
    private static final String PATH_FILE_HOUSE = "src/case_study/data/House.csv";
    private static final String NAME_REGEX = "^[A-Za-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ ]{5,50}+$";
    private static final String ID_NAME_REGEX = "^(SVVL-)\\d{4}$";
    static final Map<Facility, Integer> facilityVillaIntegerMap = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
    private static final Map<Facility, Integer> facilityRoomIntegerMap = ReadAndWriteCSV.readListFacilityRoomToCSV(PATH_FILE_ROOM);
    private static final Map<Facility, Integer> facilityHouseIntegerMap = ReadAndWriteCSV.readListFacilityHouseToCSV(PATH_FILE_HOUSE);
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
    public static Boolean checkRoomName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityRoomIntegerMap.keySet();
            for (Facility key : keySet) {
                if (name.equals(key.getNameService())) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }
    public static Boolean checkHouseName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            Set<Facility> keySet = facilityHouseIntegerMap.keySet();
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
