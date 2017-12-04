import hibernate.HibernatePersonDb;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        HibernatePersonDb hibernatePersonDb = new HibernatePersonDb();
        hibernatePersonDb.create("test", "test");
        hibernatePersonDb.create("test2", "test2");
        System.out.println("// READ ALL //");
        System.out.println(hibernatePersonDb.readAll());
        System.out.println("// READ //");
        System.out.println(hibernatePersonDb.read(1));
        System.out.println("// DELETE //");
        System.out.println(hibernatePersonDb.delete(1));
        System.out.println("// UPDATE //");
        System.out.println(hibernatePersonDb.update(2, "testUpdate", "testUpdate"));
    }
}
