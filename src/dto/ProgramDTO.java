package dto;

/**
 * @author HelithaSri
 * @created 12/24/2021 - 11:16 PM
 * @project HibernateCW
 */
public class ProgramDTO {
    private
    String programId;
    private String programName;
    private String duration;
    private double fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String programId, String programName, String duration, double fee) {
        this.programId = programId;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
    }

    public ProgramDTO(String programName, String duration, double fee) {
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
}
