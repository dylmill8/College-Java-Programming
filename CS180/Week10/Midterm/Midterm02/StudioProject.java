public interface StudioProject {
    public String getProjectName();

    public int getEmployeeCount();

    public boolean hasPriority();

    public double calculateCostEstimate(double averageSalary, int months);

    public String[] findSimilarProjects(StudioProject[] studioProjects, int employeeThreshold);
}
