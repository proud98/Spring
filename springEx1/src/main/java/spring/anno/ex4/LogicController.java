package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //이름 지정 안하면 LogicController가 logicController로 지정
public class LogicController {
	
	@Autowired
   DaoInter daoInter;
   
   public LogicController(MyDao dao) {
      this.daoInter=dao;
   }
   
   //insert
   public void insert(String str) {
	   daoInter.insertData(str);
   }
   
   //delete
   public void delete(String num) {
	   daoInter.deleteData(num);
   }
}