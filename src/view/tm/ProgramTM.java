package view.tm;

/**
 * @author HelithaSri
 * @created 12/27/2021 - 4:33 PM
 * @project HibernateCW
 */
public class ProgramTM {
    private String programId;
    private String programName;
    private String duration;
    private double fee;

    public ProgramTM() {
    }

    public ProgramTM(String programId, String programName, String duration, double fee) {
        this.programId = programId;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
    }

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
        return "ProgramTM{" +
                "programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
