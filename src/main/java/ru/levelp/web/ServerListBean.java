package ru.levelp.web;

import ru.levelp.weld.AppServer;
import ru.levelp.weld.ApplicationServerManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("serverList")
@RequestScoped
public class ServerListBean {
    @Inject
    private ApplicationServerManager manager;

    public List<AppServer> getServers() {
        return manager.getAllServers();
    }
}
