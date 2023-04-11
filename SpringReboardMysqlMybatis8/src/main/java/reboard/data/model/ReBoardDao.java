package reboard.data.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReBoardDao implements ReBoardDaoInter {
	
	@Autowired
	private SqlSession session;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		
		return session.selectOne("getTotalCountOfReboard");
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("MaxNumOfReboard");
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		
		//int regroup, int restep 다 int여서 value에는 integer로 넘기기
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		session.update("updateStepOfReboard",map);
	}

	@Override
	public void insertReboardDto(ReBoardDto dto) {
		// TODO Auto-generated method stub
		
		int num=dto.getNum(); //0:새글 , 1보다 큰 값:답글
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		//새글일경우
		if(num==0) {
			regroup=getMaxNum()+1; //num의 최대값에 +1
			restep=0;
			relevel=0;
		}else {
			//답글일경우
			//같은 그룹중에서 전달받은 restep보다 큰 글들은 모두 +1
			updateRestep(regroup, restep);
			//전달받은 step과 level은 +1
			restep++;
			relevel++;
		}
		
		//바뀐 데이터값들을 다시 dto에 담아주기
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//dto에 담은 후 insert
		session.insert("insertOfReboard", dto);
	}

	@Override
	public List<ReBoardDto> getliList(int start, int perpage) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return session.selectList("getAllPagingOfReboard", map);
	}
	
	//조회수
	@Override
	public void updateReadCount(int num) {
		// TODO Auto-generated method stub
		
		session.update("UpdateReadCountOfReboard", num);
		
	}
	
	//num에 해당하는 dto
	@Override
	public ReBoardDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("getDataOfReboard", num);
	}

	@Override
	public int getCheckPass(int num, int pass) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("checkEqualPassOfReboard", map);
	}

	@Override
	public void deleteReboard(int num) {
		// TODO Auto-generated method stub
		session.delete("deleteReborad", num);
	}

	@Override
	public void updateReboard(ReBoardDto dto) {
		// TODO Auto-generated method stub
		
		session.update("updateOfReboard", dto);
		
	}
	
	//그냥 리스트 출력
	@Override
	public List<ReBoardDto> selectTestBoard() {
		// TODO Auto-generated method stub
		return session.selectList("listReboardTest");
	}




	
	
	

}
