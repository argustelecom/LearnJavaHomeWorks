package ru.levelp.weld;

@HttpCheck(version = HttpVersion.HTTP11)
public class HttpRequestChecker implements ApplicationChecker {
    public void check(AppServer server) {
        System.out.println("Try HTTP request");
    }
}
