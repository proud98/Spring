package reboard.data.model;

import java.util.List;

public interface ReBoardDaoInter {
	
	public int getTotalCount();
	public int getMaxNum();
	public void updateRestep(int regroup, int restep);
	public void insertReboardDto(ReBoardDto dto);
	public List<ReBoardDto> getliList(int start,int perpage);
	
	//0410 이어서
	public void updateReadCount(int num); //조회수
	public ReBoardDto getData(int num); //num에 해당하는 dto조회
	public int getCheckPass(int num,int pass);
	public void deleteReboard(int num);
	public void updateReboard(ReBoardDto dto);
	
	//과제 
	//그냥 리스트 출력
	public List<ReBoardDto> selectTestBoard();
}

