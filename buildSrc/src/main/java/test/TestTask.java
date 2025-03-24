package test;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;

public abstract class TestTask extends DefaultTask {
    @Input
    public abstract Property<String> getStringProperty();
}
