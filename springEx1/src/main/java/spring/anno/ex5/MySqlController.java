package spring.anno.ex5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mysqlcont")
public class MySqlController {
	
	@Autowired
	TestDao testDao;
	
	public void insert(String name) {
		testDao.insert(name);
	}
	
	public void delete(String num) {
		testDao.delete(num);
	}
	
	public void select(String name) {
		testDao.select(name);
	}

}
