package dto;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:12 PM
 * @project HibernateCW
 */
public class StudentDTO {
    private String regNum;
    private String name;
    private int age;
    private String address;
    private String email;
    private String dob;
    private String nic;
    private String contactNum;
    private String gender;

    public StudentDTO() {
    }

    public StudentDTO(String regNum, String name, int age, String address, String email, String dob, String nic, String contactNum, String gender) {
        this.regNum = regNum;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.nic = nic;
        this.contactNum = contactNum;
        this.gender = gender;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
