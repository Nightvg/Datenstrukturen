package PVL2_Tobias;

public interface StudentAdministration {
    Integer matriculate(String firstName, String lastName);
    Boolean deregister(Integer matriculationNumber);
    String find(Integer matriculationNumber);
    String takeExam(Integer matriculationNumber, String courseID, Boolean passed);
    String dataBase();
}
