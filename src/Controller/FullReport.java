package autosaleandpurchasemanagmentsystemfull;


public class FullReport {
    String type;
    String part;
    String Mechanic;
    String task;
    String comm;

    public FullReport(String type, String part, String Mechanic, String task, String comm) {
        this.type = type;
        this.part = part;
        this.Mechanic = Mechanic;
        this.task = task;
        this.comm = comm;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setMechanic(String Mechanic) {
        this.Mechanic = Mechanic;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    
    
    
    
    public String getType() {
        return type;
    }

    public String getPart() {
        return part;
    }

    public String getMechanic() {
        return Mechanic;
    }

    public String getTask() {
        return task;
    }

    public String getComm() {
        return comm;
    }
    
    

}
