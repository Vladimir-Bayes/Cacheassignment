package datastructure;
/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2018年1月5日 下午2:24:20 
* @Github https://github.com/Vladimir-Bayes
*/


import java.util.ArrayList;
import java.util.List;

import datastructure.Arrange;

public class ExplicitEnumeration {

//	每个节点的缓存的可能状态取决于CFG执行的顺序
//	从图上可知，B1→B2→(B3,B4,B5,B6,B7,B8)→B9，之一中间那6个顺序可能变化
//	考虑利用CFG的结构对其进行穷举
	public ExplicitEnumeration() {
		// TODO Auto-generated constructor stub
	}
	
	public static int hits=0;
	public static int miss=0;
	
	
	public static void main(String[] args) {
		CFG cfg = new CFG(1);
		String string ="345678";

		
		Arrange arrange = new Arrange();
		List<String> strings = arrange.Permutation(string);
		
//		System.out.println(strings);
//		System.out.println(strings.size());
		
		List<String> possobileresults_temp = new ArrayList<String>();
		int count=0;
		for (String str : strings) {
			if (checkorder(str,cfg)) {
				count+=1;
				System.out.println(str);
				possobileresults_temp.add(str);
			}
		}
		System.out.println("一共有 "+count+" 种可能性");
		System.out.println(possobileresults_temp.size());
		
		int[][] possobileresults = new int[possobileresults_temp.size()][9];
		for (int i = 0; i < possobileresults_temp.size(); i++) {
			String string_temp = possobileresults_temp.get(i);
			char[] stringArr = string_temp.toCharArray();
			int[] order = new int[6];

			for (int k = 0; k < order.length; k++) {
				String temString = String.valueOf(stringArr[k]);
				order[k] = Integer.valueOf(temString);
			}
//			for (int j = 0; j < order.length; j++) {
//				System.out.print(order[j]);
//			}
			
			
			for (int j = 0; j < 9; j++) {
//				用数组表示所有的可能结果
				if (j==0) {
					possobileresults[i][j] = 0;
				}
				if (j==1) {
					possobileresults[i][j] = 1;
				}
				if (j==8) {
					possobileresults[i][j] = 8;
				}
				if (j>1&&j<8) {	
					possobileresults[i][j] = order[j-2]-1;
				}	
			}
				
		}
		
		System.out.println("顺序执行（暂时没考虑多线程及其同步问题）: ");
		
		for (int i = 0; i < possobileresults.length; i++) {
			CacheState cacheState = new CacheState();
			for (int j = 0; j < 9; j++) {
				int temp=0;
				temp = possobileresults[i][j];
//				System.out.println("**********"+temp+"**********");
				@SuppressWarnings("unused")
				List<String> memoryList = new ArrayList<String>();
				memoryList = cfg.getCFGblocks().get(temp).getMemories();
				ExplicitEnumeration.Cache(temp, cacheState);
			}
			System.out.println("Hits: "+hits);
			System.out.println("Miss: "+miss);
			ExplicitEnumeration.hits=0;
			ExplicitEnumeration.miss=0;
			
		}
				
	}

	
	public static void Cache(int i, CacheState cacheState) {
//		CFG cfg = new CFG(1);
		
		
//		获得当前的所需要的memory列表
		List<String> memories =	TestExample1.cfg.getCFGblocks().get(i).getMemories();
		for (String string : memories) {
//			先找出该memory对应cache的哪一行
			int line = cacheline(string);
//			然后判断当前的cache状态是否存储了该memory，如果有则为hit.如果没有则为miss，并且，更新cache状态
			if (cacheState.getCachestate().get(line).equals(string)) {
				ExplicitEnumeration.hits=ExplicitEnumeration.hits+1;
								
			} else {
				ExplicitEnumeration.miss = ExplicitEnumeration.miss+1;
				cacheState.setCachestate(cacheState.changestate(line, string));
//				每次miss打印更新后的结果
				System.out.println("每次miss打印更新后的结果");
				System.out.println(cacheState);
			}
		}
		
		
	}
	
	
	public static int cacheline (String memory) {
//		Cache cache = new Cache(0);
//		查找memory对应cache的哪一行
		for (CacheLine cacheLine : TestExample1.cache.getCacheLines()) {
			List<String> temp = cacheLine.getMemoryblocks();
			
			if (temp.contains(memory)) {
				return cacheLine.getLine();
			}
		}
		return -1;
	}
	
	
	
	public static boolean checkorder(String string, CFG cfg) {
		char[] stringArr = string.toCharArray();
		int[] order = new int[6];

		for (int i = 0; i < order.length; i++) {
			String temString = String.valueOf(stringArr[i]);
			order[i] = Integer.valueOf(temString);
		}
		
//		for (int i = 0; i < order.length; i++) {
//			System.out.print(order[i]+" ");
//		}
//		
//		System.out.println("***");
		for (int i = 0; i < order.length; i++) {
//			后去该block的前置节点
//			System.out.println(order[i]);
			List<Integer> tempIntegers = cfg.getCFGblocks().get(order[i]-1).getFormer();
			
//			System.out.println(tempIntegers+"*");
			for (Integer integer : tempIntegers) {
//				获取元素i的former在该数组中的位置

				int position =-1; 
//				Arrays.binarySearch(order, integer);
				
				for (int j = 0; j < order.length; j++) {
					if (order[j]==integer) {
						position=j;
					}
				}

//				System.out.println(position);
//				System.out.println(integer);
//				System.out.println(i);
				if (position>i) {
//					System.out.println(position);
//					System.out.println(i);
					return false;
				}
			}			
		}
		return true;
	}
	
	
}
