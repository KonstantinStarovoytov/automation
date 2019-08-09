package services.ORMServices;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DBFinder<T> {
    private Class<T> returnClass;

    public DBFinder(Class<T> returnClass) {
        super();
        this.returnClass = returnClass;
    }

    public List<DBPredicate> list = new ArrayList<>();

    public static <T> DBFinder find(Class<T> returnClass) {
        return new DBFinder(returnClass);
    }

    public DBFinder where(DBPredicate predicate) {
        list.add(predicate);
        return this;
    }

    public DBFinder and(DBPredicate predicate) {
        return where(predicate);
    }

    <S> Optional<S> getFieldValue(String field, Class<S> fieldClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<S> query = builder.createQuery(fieldClass);

        Root<T> root = query.from(returnClass);

        query.select(root.get(field));

        List<Predicate> predicateList = list.stream().map(crit -> crit.get(builder, root)).collect(Collectors.toList());

        Predicate[] predicates = new Predicate[predicateList.size()];

        predicates = predicateList.toArray(predicates);
        query.where(predicates);
        var value = Optional.of(
                session.getEntityManagerFactory().createEntityManager().createQuery(query).setMaxResults(1).getSingleResult());

        session.getTransaction().commit();
        session.clear();
        return value;
    }

    List<T> getResultList() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(returnClass);

        Root<T> root = query.from(returnClass);

        query.select(root);

        List<Predicate> predicateList = list.stream().map(crit -> crit.get(builder, root)).collect(Collectors.toList());

        Predicate[] predicates = new Predicate[predicateList.size()];

        predicates = predicateList.toArray(predicates);
        query.where(predicates);
        List<T> ids = session.getEntityManagerFactory().createEntityManager().createQuery(query).getResultList();

        session.getTransaction().commit();
        session.clear();
        return ids;
    }
}
