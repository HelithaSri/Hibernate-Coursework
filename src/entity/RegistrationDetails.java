package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 9:39 PM
 * @project HibernateCW
 */
@Entity
public class RegistrationDetails implements SuperEntity {
    @Id
    private
    String programId;
    @ManyToOne
    @JoinColumn(name = "regNum", referencedColumnName = "regNumber")
    private
    String regNum;
    private String registerDate;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "RegistrationDetails{" +
                "programId='" + programId + '\'' +
                ", regNum='" + regNum + '\'' +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}
