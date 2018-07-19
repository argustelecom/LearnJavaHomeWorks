import javax.persistence.*;

@Entity
@Table(name = "command")
public class Command {
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "jira_project")
	private String jiraProject;

	@Column(name = "jira_component")
	private String jiraComponent;

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

	public String getJiraProject() {
		return jiraProject;
	}

	public void setJiraProject(String jiraProject) {
		this.jiraProject = jiraProject;
	}

	public String getJiraComponent() {
		return jiraComponent;
	}

	public void setJiraComponent(String jiraComponent) {
		this.jiraComponent = jiraComponent;
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
