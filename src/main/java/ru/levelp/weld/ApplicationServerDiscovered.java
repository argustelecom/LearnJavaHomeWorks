package ru.levelp.weld;

public class ApplicationServerDiscovered {
    private AppServer server;

    public ApplicationServerDiscovered(AppServer server) {
        this.server = server;
    }

    public AppServer getServer() {
        return server;
    }
}
