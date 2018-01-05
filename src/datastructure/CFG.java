package datastructure;
/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2018年1月5日 上午9:57:32 
* @Github https://github.com/Vladimir-Bayes
*/

import java.util.ArrayList;
import java.util.List;

public class CFG {
	
//	描述图a的结构
	private List<CFGBlock> CFGblocks;
	
	/**
	 * 
	 */
	public CFG() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public CFG(int i) {
		super();
		this.CFGblocks = new ArrayList<CFGBlock>();
		// TODO Auto-generated constructor stub
		CFGBlock cfgBlocks1 = new CFGBlock();
		List<Integer> former1 = new ArrayList<Integer>();
		former1.add(0);
		List<Integer> latter1 = new ArrayList<Integer>();
		latter1.add(2);
		List<String> memory1 = new ArrayList<String>();
		memory1.add("m1");
		memory1.add("m2");
		memory1.add("m3");
		memory1.add("m4");
		cfgBlocks1.setFormer(former1);
		cfgBlocks1.setLatter(latter1);
		cfgBlocks1.setMemories(memory1);
		System.out.println(cfgBlocks1);
		CFGblocks.add(cfgBlocks1);
		
		CFGBlock cfgBlocks2 = new CFGBlock();
		List<Integer> former2 = new ArrayList<Integer>();
		former2.add(1);
		List<Integer> latter2 = new ArrayList<Integer>();
		latter2.add(3);
		latter2.add(6);
		latter2.add(7);
		List<String> memory2 = new ArrayList<String>();
		memory2.add("m5");
		cfgBlocks2.setFormer(former2);
		cfgBlocks2.setLatter(latter2);
		cfgBlocks2.setMemories(memory2);
		System.out.println(cfgBlocks2);
		this.CFGblocks.add(cfgBlocks2);
		
		CFGBlock cfgBlocks3 = new CFGBlock();
		List<Integer> former3 = new ArrayList<Integer>();
		former3.add(2);
		List<Integer> latter3 = new ArrayList<Integer>();
		latter3.add(4);
		latter3.add(5);
		List<String> memory3 = new ArrayList<String>();
		memory3.add("m1");
		cfgBlocks3.setFormer(former3);
		cfgBlocks3.setLatter(latter3);
		cfgBlocks3.setMemories(memory3);
		System.out.println(cfgBlocks3);
		this.CFGblocks.add(cfgBlocks3);
		
		CFGBlock cfgBlocks4 = new CFGBlock();
		List<Integer> former4 = new ArrayList<Integer>();
		former4.add(3);
		List<Integer> latter4 = new ArrayList<Integer>();
		latter4.add(5);
		List<String> memory4 = new ArrayList<String>();
		memory4.add("m3");
		memory4.add("m4");
		cfgBlocks4.setFormer(former4);
		cfgBlocks4.setLatter(latter4);
		cfgBlocks4.setMemories(memory4);
		System.out.println(cfgBlocks4);
		this.CFGblocks.add(cfgBlocks4);
		
		CFGBlock cfgBlocks5 = new CFGBlock();
		List<Integer> former5 = new ArrayList<Integer>();
		former5.add(3);
		former5.add(4);
		List<Integer> latter5 = new ArrayList<Integer>();
		latter5.add(9);
		List<String> memory5 = new ArrayList<String>();
		memory5.add("m2");
		cfgBlocks5.setFormer(former5);
		cfgBlocks5.setLatter(latter5);
		cfgBlocks5.setMemories(memory5);
		System.out.println(cfgBlocks5);
		this.CFGblocks.add(cfgBlocks5);
		
		CFGBlock cfgBlocks6 = new CFGBlock();
		List<Integer> former6 = new ArrayList<Integer>();
		former6.add(2);
		List<Integer> latter6 = new ArrayList<Integer>();
		latter6.add(8);
		List<String> memory6 = new ArrayList<String>();
		memory6.add("m2");
		memory6.add("m3");
		memory6.add("m4");
		cfgBlocks6.setFormer(former6);
		cfgBlocks6.setLatter(latter6);
		cfgBlocks6.setMemories(memory6);
		System.out.println(cfgBlocks6);
		this.CFGblocks.add(cfgBlocks6);
		
		CFGBlock cfgBlocks7 = new CFGBlock();
		List<Integer> former7 = new ArrayList<Integer>();
		former7.add(2);
		List<Integer> latter7 = new ArrayList<Integer>();
		latter7.add(8);
		List<String> memory7 = new ArrayList<String>();
		memory7.add("m6");
		memory7.add("m7");
		memory7.add("m8");
		cfgBlocks7.setFormer(former7);
		cfgBlocks7.setLatter(latter7);
		cfgBlocks7.setMemories(memory7);
		System.out.println(cfgBlocks7);
		this.CFGblocks.add(cfgBlocks7);
		
		CFGBlock cfgBlocks8 = new CFGBlock();
		List<Integer> former8 = new ArrayList<Integer>();
		former8.add(6);
		former8.add(7);
		List<Integer> latter8 = new ArrayList<Integer>();
		latter8.add(9);
		List<String> memory8 = new ArrayList<String>();
		memory8.add("m3");
		memory8.add("m4");
		memory8.add("m6");
		cfgBlocks8.setFormer(former8);
		cfgBlocks8.setLatter(latter8);
		cfgBlocks8.setMemories(memory8);
		System.out.println(cfgBlocks8);
		this.CFGblocks.add(cfgBlocks8);
		
		CFGBlock cfgBlocks9 = new CFGBlock();
		List<Integer> former9 = new ArrayList<Integer>();
		former9.add(5);
		former9.add(8);
		List<Integer> latter9 = new ArrayList<Integer>();
		latter9.add(2);
		List<String> memory9 = new ArrayList<String>();
		memory9.add("m8");
		cfgBlocks9.setFormer(former9);
		cfgBlocks9.setLatter(latter9);
		cfgBlocks9.setMemories(memory9);
		System.out.println(cfgBlocks9);
		this.CFGblocks.add(cfgBlocks9);
		
		System.out.println("初始化CFG完成");
		
	}
	
	

	public List<CFGBlock> getCFGblocks() {
		return CFGblocks;
	}

	public void setCFGblocks(List<CFGBlock> cFGblocks) {
		CFGblocks = cFGblocks;
	}

	@Override
	public String toString() {
		return "CFG [CFGblocks=" + CFGblocks + "]";
	}
	
	
	

}
