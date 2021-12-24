package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 9:28 PM
 * @project HibernateCW
 */

@Entity
public class Program {
    @Id
    private
    String programId;
    private String programName;
    private String duration;
    private double fee;


    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
