package test;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.provider.ValueSource;
import org.gradle.api.provider.ValueSourceParameters;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.Optional;

import javax.inject.Inject;

public abstract class A {
    public abstract static class B {}

    public abstract static class Params implements ValueSourceParameters {
        public abstract Property<B> getB();
    }

    public abstract static class V implements ValueSource<String, Params> {}

    private final Provider<String> calculated;

    @Inject
    public A(ProviderFactory providers) {
        var source = providers.of(V.class, it -> {
            it.getParameters().getB().set(getB());
        });
        this.calculated = source;
    }

    @Nested
    public abstract B getB();
}
