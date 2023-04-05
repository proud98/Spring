package spring.db.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao {
	
	@Autowired
	private SqlSession session;
	
	//총 개수
	public int getTotalCount() {
		
		return session.selectOne("totalCountMember");
	}
	
	//조회
	public List<CarMemberDto> getAllDatas(){
		
		return session.selectList("selectOfMember");
	}
	
	//insert
	public void insertMember(CarMemberDto dto) {
		
		session.insert("insertOfMember",dto);
	}
	
	//num에 의한 데이터값
	public CarMemberDto getNum(String num) {
		
		return session.selectOne("getNumUpdate", num);
	}
	
	//수정
	public void updateMember(CarMemberDto dto) {
		
		session.update("updateOfMember",dto);
	}
	
	//삭제
	public void deleteMember(CarMemberDto dto) {
		
		session.delete("deleteOfMyMember", dto);
	}

}
