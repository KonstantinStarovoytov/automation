package services.ORMServices;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import static com.codeborne.selenide.Configuration.baseUrl;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory () {
        if (sessionFactory == null) {
            try {
                String connectionURL = String.format("jdbc:mysql%s:3306/sweater?autoReconnect=true", baseUrl.replace("https", ""));

                org.hibernate.cfg.Configuration conf = new org.hibernate.cfg.Configuration().configure()
                                                                                            .setProperty("hibernate.connection.url",
                                                                                                         connectionURL);

                registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown () {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
