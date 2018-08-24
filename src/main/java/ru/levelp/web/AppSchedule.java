package ru.levelp.web;

import ru.levelp.weld.ApplicationServersChecker;

import javax.ejb.*;
import javax.inject.Inject;

@Singleton
@Startup
public class AppSchedule {
    @Inject
    private ApplicationServersChecker checker;

    @Schedules(
        @Schedule(hour = "*", minute = "*/5", second = "0")
    )
    public void pingServers() {
        checker.pingAll();
    }

    public void setChecker(ApplicationServersChecker checker) {
        this.checker = checker;
    }
}
