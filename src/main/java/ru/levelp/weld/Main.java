package ru.levelp.weld;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {
    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            container.select(ApplicationServersChecker.class).get().pingAll();
        }
    }
}
