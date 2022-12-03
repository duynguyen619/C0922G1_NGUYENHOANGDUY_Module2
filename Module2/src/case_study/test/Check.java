package case_study.test;


import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.util.ReadAndWriteCSV;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    private static final String PATH_FILE_EMPLOYEE = "src/case_study/data/Employee.csv";
    private static final String PATH_FILE_CUSTOMER = "src/case_study/data/Customer.csv";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String PHONE_REGEX = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    private static final String IDNAME_REGEX =  "[0-9]{9}";
    private static final String SAlARY_REGEX = "^\\d+$";
    private static final String NAME_REGEX = "^[A-Za-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ ]{5,50}+$";
    private static final String NAME_FACILITY_REGEX = "^[A-Za-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ ]{5,50}+$";
    private static final List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE_EMPLOYEE);
    private static final List<Customer> customerList = ReadAndWriteCSV.readCustomerList(PATH_FILE_CUSTOMER);


    public static Boolean checkEmployeeEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Employee employee : employeeList) {
                if (email.equals(employee.getEmail())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkEmployeePhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Employee employee : employeeList) {
                if (phone.equals(employee.getPhoneNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkEmployeeIdName(String name) {
        Pattern pattern = Pattern.compile(IDNAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Employee employee : employeeList) {
                if (name.equals(employee.getIdNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkEmployeeName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Employee employee : employeeList) {
                if (name.equals(employee.getName())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkRegexSalary(String name) {
        Pattern pattern = Pattern.compile(SAlARY_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static Boolean checkCustomerEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Customer customer : customerList) {
                if (email.equals(customer.getEmail())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkCustomerPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Customer customer : customerList) {
                if (phone.equals(customer.getPhoneNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkCustomerIdName(String idname) {
        Pattern pattern = Pattern.compile(IDNAME_REGEX);
        Matcher matcher = pattern.matcher(idname);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Customer customer : customerList) {
                if (idname.equals(customer.getIdNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkCustomerName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (Customer customer : customerList) {
                if (name.equals(customer.getName())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

}
