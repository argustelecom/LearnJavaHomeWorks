package ru.levelp.weld;

@PortCheck
public class PortConnectChecker implements ApplicationChecker {
    public void check(AppServer server) {
        System.out.println("try to connect to " + server.getHostPort());
    }
}
