package reanswer.data.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReanswerDao implements ReanswerInter {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalAnswerCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfAnswer");
	}

	@Override
	public void insertReanswer(ReanswerDto dto) {
		// TODO Auto-generated method stub
		
		session.insert("insertOfAnswer", dto);
	}
	
	

}
