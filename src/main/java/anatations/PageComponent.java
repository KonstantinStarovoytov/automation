package anatations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target (TYPE)
@Retention (RUNTIME)
@Service
@Scope ("thread")
public @interface PageComponent {}