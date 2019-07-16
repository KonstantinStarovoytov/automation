package anatations;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Target (TYPE)
@Retention (RetentionPolicy.RUNTIME)
@org.springframework.stereotype.Service
@Scope ("thread")
public @interface Service {}