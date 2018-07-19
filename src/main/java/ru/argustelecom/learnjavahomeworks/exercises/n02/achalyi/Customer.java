import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "jira_name", nullable = false)
    private String jiraName;

    @Column(name = "jira_project")
    private String jiraProject;

    @Column(name = "product") // тут д.б. отношение
    private String product;

    @ManyToOne
    private  AppServer appServer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJiraName() {
        return jiraName;
    }

    public void setJiraName(String jiraName) {
        this.jiraName = jiraName;
    }

    public String getJiraProject() {
        return jiraProject;
    }

    public void setJiraProject(String jiraProject) {
        this.jiraProject = jiraProject;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public AppServer getAppServer() {
        return appServer;
    }

    public void setAppServer(AppServer appServer) {
        this.appServer = appServer;
    }
}
