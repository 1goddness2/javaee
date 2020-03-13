package db;

public class homework {
    public static final int SUBMIT_STATUS_DOING = 0;
    public static final int SUBMIT_STATUS_SUBMITTED = 1;

    private int id;
    private String title;
    private String requirement;
    private String deadline;

    public homework(){}

    public homework(int id, String title, String requirement,String deadline) {
        this.id = id;
        this.title = title;
        this.requirement = requirement;
        this.deadline=deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getDeadline(){ return deadline;}

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
