import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);

/*
    1. Дан массив дат из 10 элементов. Добавить в массив даты с командной строки. Часы: минуты
       Найти среди этих дат минимальное
*/

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

        Date[] date = new Date[4];

        for(int i = 0; i < date.length; i++){

            System.out.print("Please enter HH:mm for element #" + i + ": ");

            date[i] = formatter.parse(scan.next());

        }

        Date minimalHour = formatter.parse("23:59");

        for (Date item : date) {

            if (minimalHour.after(item)) {

                minimalHour = item;

            }
        }

        System.out.println("Minimal hour is: " + formatter.format(minimalHour));

        System.out.println("**************************************");

/*
2. Дан массив типа Employee, где есть поле birthDate.
    а. Вывести, у кого сегодня, завтра день рождения
    Сегодня:
    Завтра:
*/

                Employee[] employee = new Employee[5];

                employee[0] = new Employee("Ormonov Azat", "06-06-1989");
                employee[1] = new Employee("Tashmatov Bakyt", "09-02-1985");
                employee[2] = new Employee("Orozaliev Mirbek", "10-02-1956");
                employee[3] = new Employee("Boronchiev Nurbek", "18-11-1985");
                employee[4] = new Employee("Arapov Marat", "11-02-1989");

                Date currentDate = new Date();

                SimpleDateFormat formatCurrentDay = new SimpleDateFormat("dd-MM");
                String currentDay = formatCurrentDay.format(currentDate);
                String tomorrowDate = formatCurrentDay.format(currentDate.getTime() + 86400000);

                SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
                int currentYear = Integer.parseInt(formatYear.format(currentDate));

                boolean employeesHaveBirthdayToday = false;
                boolean employeesHaveBirthdayTomorrow = false;

                System.out.println("Employees who's birthday today:");

                for (Employee item : employee) {
                 String EmployeeBirthDate = item.getFormatCurrentDay().format(item.getBirthDate());

                     if (EmployeeBirthDate.equals(currentDay)) {

                            System.out.print(item.getName() + ", ");
                            System.out.println(item.getFormatter().format(item.getBirthDate()));
                            employeesHaveBirthdayToday = true;

                     }

                }

                if (!employeesHaveBirthdayToday){

                    System.out.println("NOBODY");

                }

                System.out.println("Employees who's birthday tomorrow:");

                for (Employee item : employee) {

                    String EmployeeBirthDate = item.getFormatCurrentDay().format(item.getBirthDate());

                    if (EmployeeBirthDate.equals(tomorrowDate)) {

                        System.out.print(item.getName() + ", ");
                        System.out.println(item.getFormatter().format(item.getBirthDate()));
                        employeesHaveBirthdayTomorrow = true;

                    }

                }

                if (!employeesHaveBirthdayTomorrow){

                    System.out.println("NOBODY");

                }

                System.out.println("**************************************");

/*
b. Вывести средний возраст персонала
*/

                int employeeCount = 0;
                int employeeAverageAge = 0;

                 for (Employee item : employee) {

                    int employeeBirthYear = Integer.parseInt(item.getFormatYear().format(item.getBirthDate()));
                    employeeAverageAge += currentYear - employeeBirthYear;
                    employeeCount++;
                 }

                employeeAverageAge /= employeeCount;

                System.out.println("Employees average age: "  +  employeeAverageAge);

                System.out.println("**************************************");

/*
   с. Вывести самого старшего сотрудника
*/

         Employee oldestEmployee = employee[0];
         int employeeAge = 0;
         int temporaryAge;

            for (Employee item : employee) {

                int employeeBirthYear = Integer.parseInt(item.getFormatYear().format(item.getBirthDate()));

                temporaryAge = currentYear - employeeBirthYear;
                if (temporaryAge > employeeAge){

                    employeeAge = temporaryAge;
                    oldestEmployee = item;

                }
        }

        System.out.println("The oldest employee is: " + oldestEmployee.getName());

        System.out.println("**************************************");

/*
   d. Найти ровестников
*/
        boolean newLine = true;
        for (int i = 0; i < 150; i++) {
            if (!newLine) System.out.println();
            newLine = true;
            for (Employee item : employee) {

                int employeeBirthYear = Integer.parseInt(item.getFormatYear().format(item.getBirthDate()));

                if (currentYear - employeeBirthYear == i){
                    if (newLine) System.out.println(i + " years old employees: ");
                    System.out.println(item.getName());
                    newLine = false;

                }

            }

        }

    }
}
