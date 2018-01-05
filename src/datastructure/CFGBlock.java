package datastructure;
/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2018年1月5日 上午10:00:45 
* @Github https://github.com/Vladimir-Bayes
*/

import java.util.List;

public class CFGBlock {
	
//	描述block的存储
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
