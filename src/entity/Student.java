package entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL)
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Program> programList = new ArrayList<>();

    public Student() {
    }

    public Student(String regNum, String name, int age, String address, String email, String dob, String nic, String contactNum, String gender) {
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

    public Student(String regNum, String name, int age, String address, String email, String dob, String nic, String contactNum, String gender, List<Program> programList) {
        this.regNum = regNum;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.nic = nic;
        this.contactNum = contactNum;
        this.gender = gender;
        this.programList = programList;
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

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
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
                ", programList=" + programList +
                '}';
    }
}
