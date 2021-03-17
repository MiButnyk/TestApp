package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class MyService {
    private final DAO dao;

    @Autowired
    public MyService(@Qualifier("oracle") DAO dao) {
        this.dao = dao;
    }

    public void head(String str) {
        dao.head(str);
    }

    public void salary(String str) {
        dao.salary(str);
    }

    public void quantity(String str) {
        dao.quantity(str);
    }

    public void statistics(String str) {
        dao.statistics(str);
    }

    public void search(String str) {
        dao.search(str);
    }
}
