package ru.levelp.weld;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ApplicationServerManager {
    private ArrayList<AppServer> servers =
            new ArrayList<AppServer>();

    @PostConstruct
    public void init() {
        servers.add(
                new AppServer("test", "testhost"));
    }

    @PreDestroy
    public void destroy() {
        servers.clear();
    }

    @Inject
    @MyDatabase
    private EntityManager em;

    @Inject
    @Push(channel = "updates")
    private PushContext updates;

    public List<AppServer> getAllServers() {
        return servers;
    }

    @Transactional
    public void onServerDiscovered(
            @Observes ApplicationServerDiscovered event) {
        servers.add(event.getServer());
        em.persist(event.getServer());

        updates.send("updateServerList");
    }
}
