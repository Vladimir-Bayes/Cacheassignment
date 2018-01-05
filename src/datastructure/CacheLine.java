package datastructure;
/** 
* @author ����Vladimir E-mail: gyang.shines@gmail.com
* @version ����ʱ�䣺2018��1��5�� ����10:22:28 
* @Github https://github.com/Vladimir-Bayes
*/

import java.util.List;

public class CacheLine {
	
//	����ÿһ�е�cache�Ĵ洢
	private int line;
	private List<String> memoryblocks;
	/**
	 * @param line
	 * @param memoryblocks
	 */
	public CacheLine(int line, List<String> memoryblocks) {
		super();
		this.line = line;
		this.memoryblocks = memoryblocks;
	}
	/**
	 * 
	 */
	public CacheLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public List<String> getMemoryblocks() {
		return memoryblocks;
	}
	public void setMemoryblocks(List<String> memoryblocks) {
		this.memoryblocks = memoryblocks;
	}
	@Override
	public String toString() {
		return "CacheLine [line=" + line + ", memoryblocks=" + memoryblocks + "]";
	}
	
	
	
}
