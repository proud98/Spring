package reboard.data.model;

import java.util.List;

public interface ReBoardDaoInter {
	
	public int getTotalCount();
	public int getMaxNum();
	public void updateRestep(int regroup, int restep);
	public void insertReboardDto(ReBoardDto dto);
	public List<ReBoardDto> getliList(int start,int perpage);

}
