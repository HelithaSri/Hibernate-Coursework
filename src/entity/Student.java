package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 9:13 PM
 * @project HibernateCW
 */

@Entity
public class Student implements SuperEntity {
    @Id
    private String regNum;
    private String name;
    private int age;
    private String address;
    private String email;
    private String dob;
    private String nic;
    private String contactNum;
    private String gender;


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

    @Override
    public String toString() {
        return "Student{" +
                "regNum='" + regNum + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", nic='" + nic + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
