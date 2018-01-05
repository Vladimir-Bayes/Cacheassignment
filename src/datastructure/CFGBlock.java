package datastructure;
/** 
* @author ����Vladimir E-mail: gyang.shines@gmail.com
* @version ����ʱ�䣺2018��1��5�� ����10:00:45 
* @Github https://github.com/Vladimir-Bayes
*/

import java.util.List;

public class CFGBlock {
	
//	����block�Ĵ洢
	private List<Integer> former;
	private List<Integer> latter;
	private List<String> memories;
	
	/**
	 * 
	 */
	public CFGBlock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Integer> getFormer() {
		return former;
	}
	public void setFormer(List<Integer> former) {
		this.former = former;
	}
	public List<Integer> getLatter() {
		return latter;
	}
	public void setLatter(List<Integer> latter) {
		this.latter = latter;
	}
	public List<String> getMemories() {
		return memories;
	}
	public void setMemories(List<String> memories) {
		this.memories = memories;
	}
	
	@Override
	public String toString() {
		return "CFGBlocks [former=" + former + ", latter=" + latter + ", memories=" + memories + "]";
	}

	
	
	
	
	
}
