package ru.levelp.weld;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

public class SmokeTest {
    @Rule
    public WeldInitiator weld = WeldInitiator
            .from(WeldInitiator.createWeld().enableDiscovery()
                    .enableInterceptors(LoggerInterceptor.class))
            .inject(this)
            .build();

    @Inject
    private ApplicationServerManager manager;

    @Inject
    private ApplicationServersChecker pinger;

    @Test
    public void test1() {
        System.out.println(manager);
        System.out.println(manager.getAllServers());

//        ApplicationServerManager manager =
//                weld.select(ApplicationChecker.class).get();

        pinger.pingAll();
    }
}
