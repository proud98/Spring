package reanswer.data.model;

import java.util.List;

public interface ReanswerInter {
	
	public void insertReanswer(ReanswerDto dto);
	public List<ReanswerDto> getAnswerList(int num);
	public int getCheckPassAnswer(int idx,String pass);
	public void deleteAnswer(int idx);

}
