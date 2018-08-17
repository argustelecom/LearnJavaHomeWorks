package ru.levelp.web;

import ru.levelp.weld.AppServer;
import ru.levelp.weld.ApplicationServerDiscovered;
import ru.levelp.weld.ApplicationServerManager;
import ru.levelp.weld.ApplicationServerUpdated;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named("addServerBean")
@RequestScoped
public class AddServerFormBean {
    private String title;
    private String hostPort;
    private String resultMessage;
    private String id;

    @Inject
    private ApplicationServerManager manager;

    @Inject
    private Event<ApplicationServerDiscovered> discovered;

    @Inject
    private Event<ApplicationServerUpdated> updated;

    public boolean isAdding() {
        return id == null;
    }

    public void init() {
        if (id != null) {
            int serverId = Integer.parseInt(id);

            manager.getAllServers().stream()
                    .filter(appServer -> appServer.getId() == serverId)
                    .findFirst()
                    .ifPresent(appServer -> {
                        title = appServer.getName();
                        hostPort = appServer.getHostPort();
                        resultMessage = "";
                    });
        }
    }

    public void init2() {
        System.out.println("init2");
    }

    public String onAddButtonClicked() {
        try {
            AppServer server = new AppServer(title, hostPort);
            if (id != null) {
                server.setId(Integer.parseInt(id));
                updated.fire(new ApplicationServerUpdated(server));
            } else {
                discovered.fire(new ApplicationServerDiscovered(server));
            }

            resultMessage = "Server added";
            return "server-list?faces-redirect=true";
        } catch (Throwable t) {
            resultMessage = "Failed to add server";
            return "add-server";
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
