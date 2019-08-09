package services.ORMServices;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class DBPredicate {
    public String fieldName;
    public String value;
    public int intValue;
    public Operation operation;
    public List<String> values;

    public DBPredicate(String fieldName, String value, Operation operation) {
        super();
        this.fieldName = fieldName;
        this.value = value;
        this.operation = operation;
    }

    public DBPredicate(String fieldName, int value, Operation operation) {
        super();
        this.fieldName = fieldName;
        this.intValue = value;
        this.operation = operation;
    }

    public DBPredicate(String fieldName, List<String> values, Operation operation) {
        super();
        this.fieldName = fieldName;
        this.values = values;
        this.operation = operation;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Predicate get(CriteriaBuilder builder, Root root) {
        return switch (operation) {
            case EQUALS -> builder.equal(root.get(fieldName), value);
            case MORE_THAN -> builder.greaterThan(root.get(fieldName), value);
            case NOT_EQUALS -> builder.notEqual(root.get(fieldName), value);
            case NOT_CONTAINS -> root.get(fieldName).in(values).not();
            case LESS_THAN -> builder.lessThan(root.get(fieldName), value);
            case IN -> root.get(fieldName).in(values);
            default -> throw new IllegalArgumentException("Can't create predicate with root = " + root.toString());
        };
    }

    public static DBPredicate idEqual(String id) {
        return new DBPredicate("id", id, Operation.EQUALS);
    }

    public static DBPredicate nameEqual(String name) {
        return new DBPredicate("username", name, Operation.EQUALS);
    }

    public static DBPredicate emailEqual(String email) {
        return new DBPredicate("email", email, Operation.EQUALS);
    }

    public enum Operation {
        EQUALS, MORE_THAN, LESS_THAN, NOT_EQUALS, IN, NOT_CONTAINS
    }
}
