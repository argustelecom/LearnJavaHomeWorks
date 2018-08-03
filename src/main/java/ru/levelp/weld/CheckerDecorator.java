package ru.levelp.weld;

import org.jboss.weld.context.http.Http;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class CheckerDecorator implements ApplicationChecker {
    @Delegate
    @Inject
    @Any
    private ApplicationChecker delegate;

    public void check(AppServer server) {
        if (System.currentTimeMillis() < 100) throw new SecurityException();
        System.out.println("decorated...");
        delegate.check(server);
    }
}
