import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;
    
    public JobRole(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    
    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }
    
    public String getCandidateName() {
        return candidateName;
    }
    
    public T getJobRole() {
        return jobRole;
    }
    
    @Override
    public String toString() {
        return "Candidate: " + candidateName + ", Role: " + jobRole;
    }
}

class ResumeScreening {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("Processing resume for: " + resume);
        }
    }
}

public class AIResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> resumePipeline = new ArrayList<>();
        
        resumePipeline.add(new SoftwareEngineer());
        resumePipeline.add(new DataScientist());
        resumePipeline.add(new ProductManager());
        
        System.out.println("Resumes in Screening Pipeline:");
        ResumeScreening.processResumes(resumePipeline);
        
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Charlie", new ProductManager());
        
        System.out.println("\nProcessed Resumes:");
        System.out.println(resume1);
        System.out.println(resume2);
        System.out.println(resume3);
    }
}
