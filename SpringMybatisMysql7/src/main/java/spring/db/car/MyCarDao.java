package spring.db.car;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //dao를 bean에 등록
public class MyCarDao {
	
	@Autowired //sql세션을 모든 dao에서 자동주입
	private SqlSession session;
	
	//총갯수
	public int getTotalCount() {
		
		return session.selectOne("getTotalCountOfMyCar");
		//자동주입 받은 세션에서 mycarMapper의 select문 id 가져오기 
	}
	
	//전체데이터 조회
	public List<MyCarDto> getAllDatas(){
		
		return session.selectList("getAllDatasOfMyCar");
	}
	
	//insert
	public void insertMyCar(MyCarDto dto) {
		
		session.insert("insertOfMyCar", dto); //mycarMapper의 insert문 id와 파라메타값으로 넘어온 dto
	}
	
	//수정 할 num
	public MyCarDto getData(String num) {
		
		return session.selectOne("getOneDataOfMyCar", num);
	}
	
	//수정
	public void updateMyCar(MyCarDto dto) {
		
		session.update("updateOfMyCar", dto);
	}
	

	//삭제
	public void deleteMyCar(MyCarDto dto) {
		
		session.delete("deleteOfMyCar", dto);
	}

}
