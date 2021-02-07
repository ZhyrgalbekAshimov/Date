import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private String name;
    private Date birthDate;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat formatCurrentDay = new SimpleDateFormat("dd-MM");
    private SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");

    public Employee(String name, String birthDate) throws ParseException {
        this.name = name;
        this.birthDate = formatter.parse(birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }


    public SimpleDateFormat getFormatCurrentDay() {
        return formatCurrentDay;
    }


    public SimpleDateFormat getFormatYear() {
        return formatYear;
    }


}
