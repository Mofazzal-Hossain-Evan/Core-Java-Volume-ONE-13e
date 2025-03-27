package UniversityStaffStudentHierarchySimulator;

public class Administrator extends Staff{
    private String adminRole;

    public Administrator(String name, int age, String address, int staffID, String department, String role, String adminRole) {
        super(name, age, address, staffID, department, role);
        this.adminRole = adminRole;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Admin Role: " + adminRole);
    }

    public void changeAdminRole(String newRole){
        adminRole = newRole;
        System.out.println(name + " has been assigned the new admin role: " + adminRole);
    }
}
