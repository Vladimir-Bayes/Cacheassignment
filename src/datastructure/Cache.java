package datastructure;
/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2018年1月5日 上午10:21:54 
* @Github https://github.com/Vladimir-Bayes
*/

import java.util.ArrayList;
import java.util.List;

public class Cache {

//	描述cache的存储
	List<CacheLine> cacheLines;

	/**
	 * 
	 */
	public Cache() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cache(int i) {
		this.cacheLines = new ArrayList<CacheLine>();
//		按照图b进行初始化
		CacheLine cacheLine0 = new CacheLine();
		List<String> memoryblocks_temp0 = new ArrayList<String>();
		int line0;
		memoryblocks_temp0.add(0, "m1");
		memoryblocks_temp0.add(1, "m5");
		line0=0;
		cacheLine0.setLine(line0);
		cacheLine0.setMemoryblocks(memoryblocks_temp0);
		System.out.println(cacheLine0);
		this.cacheLines.add(cacheLine0);
		
		CacheLine cacheLine1 = new CacheLine();
		List<String> memoryblocks_temp1 = new ArrayList<String>();
		int line1;
		memoryblocks_temp1.add(0, "m2");
		memoryblocks_temp1.add(1, "m6");
		line1=1;
		cacheLine1.setLine(line1);
		cacheLine1.setMemoryblocks(memoryblocks_temp1);
		System.out.println(cacheLine1);
		this.cacheLines.add(cacheLine1);
		
		CacheLine cacheLine2 = new CacheLine();
		List<String> memoryblocks_temp2 = new ArrayList<String>();
		int line2;
		memoryblocks_temp2.add(0, "m3");
		memoryblocks_temp2.add(1, "m7");
		line2=2;
		cacheLine2.setLine(line2);
		cacheLine2.setMemoryblocks(memoryblocks_temp2);
		System.out.println(cacheLine2);
		this.cacheLines.add(cacheLine2);
		
		CacheLine cacheLine3 = new CacheLine();
		List<String> memoryblocks_temp3 = new ArrayList<String>();
		int line3;
		memoryblocks_temp3.add(0, "m4");
		memoryblocks_temp3.add(1, "m8");
		line3=3;
		cacheLine3.setLine(line3);
		cacheLine3.setMemoryblocks(memoryblocks_temp3);	
		System.out.println(cacheLine3);
		this.cacheLines.add(cacheLine3);
		
		System.out.println("初始化Cache完成");

	}

	public List<CacheLine> getCacheLines() {
		return cacheLines;
	}

	public void setCacheLines(List<CacheLine> cacheLines) {
		this.cacheLines = cacheLines;
	}

	@Override
	public String toString() {
		return "Cache [cacheLines=" + cacheLines + "]";
	}
	
	
	
	
	
}
