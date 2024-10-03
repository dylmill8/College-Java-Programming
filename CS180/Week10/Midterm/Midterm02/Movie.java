import java.util.ArrayList;

public class Movie implements StudioProject {
    private String projectName;
    private int employeeCount;
    private boolean priority;

    public Movie(String projectName, int employeeCount, boolean priority) {
        if (projectName == null) { throw new NullPointerException(); }
        if (employeeCount < 0) { throw new IllegalArgumentException(); }
        this.projectName = projectName;
        this. employeeCount = employeeCount;
        this.priority = priority;
    }

    public String getProjectName() { return projectName; }

    public int getEmployeeCount() { return employeeCount; }

    public boolean hasPriority() { return priority; }

    public double calculateCostEstimate(double averageSalary, int months) {
        double calculation;
        calculation = (employeeCount * averageSalary) * months;
        if (priority) {
            calculation = calculation * 1.1;
        }
        return calculation;
    }

    public String[] findSimilarProjects(StudioProject[] studioProjects, int employeeThreshold) {
        ArrayList<String> tempProjects = new ArrayList<>();

        for (int i = 0; i < studioProjects.length; i++) {
            if (studioProjects[i] instanceof StudioProject) {
                if (Math.abs(studioProjects[i].getEmployeeCount() - employeeCount) < employeeThreshold) {
                    tempProjects.add(studioProjects[i].getProjectName());
                }
            }
        }

        String[] projects = new String[tempProjects.size()];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = tempProjects.get(i);
        }
        return projects;
    }
}
