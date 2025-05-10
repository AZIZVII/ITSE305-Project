// Data Layer: Manages staff data storage
public class Staff {
    private String id;
    private String name;
    private String role;
    private double performanceScore;
    
    public Staff(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.performanceScore = 0.0;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public double getPerformanceScore() { return performanceScore; }
    
    public void setRole(String role) { this.role = role; }
    public void setPerformanceScore(double score) { this.performanceScore = score; }
}
