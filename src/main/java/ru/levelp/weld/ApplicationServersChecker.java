package ru.levelp.weld;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class ApplicationServersChecker {
    @Inject
    private ApplicationServerManager manager;

    @Inject
//    @PortCheck
    @HttpCheck(version = HttpVersion.HTTP11)
    private ApplicationChecker checker;

    @Inject
    private Event<ApplicationServerDiscovered> discovered;

    @Logged
    public void pingAll() {
        for (AppServer appServer : manager.getAllServers()) {
            ping(appServer);
        }

        discovered.fire(new ApplicationServerDiscovered(
            new AppServer("dyn-host", "host:9090")
        ));
    }

    private void ping(AppServer server) {
        checker.check(server);
    }
}
