public class Main {

    public static void main(String[] args) {
        Employee[] employeeArr = new Employee[5];

        employeeArr[0] = new Employee("Ivan Vanov", "Engineer", "e@mail.com", "8090979", 60000, 25);
        employeeArr[1] = new Employee("Gena NeVanov", "Analyst", "gena@mail.com", "8095679", 90000, 41);
        employeeArr[2] = new Employee("Sergey Genov", "Engineer", "sg@mail.com", "8090979", 60000, 34);
        employeeArr[3] = new Employee("Alex Ivanov", "DevOps", "e@mail.com", "8090979", 60000, 50);
        employeeArr[4] = new Employee("Igor Sergev", "TeamLead", "is@mail.com", "8099999", 100000, 45);

        for (int i = 0; i < employeeArr.length; i++) {
            if (employeeArr[i].getAge() > 40) {
                employeeArr[i].printEmployeeInfo();
            }
        }
    }

}
