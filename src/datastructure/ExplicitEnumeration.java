package datastructure;
/** 
* @author ����Vladimir E-mail: gyang.shines@gmail.com
* @version ����ʱ�䣺2018��1��5�� ����2:24:20 
* @Github https://github.com/Vladimir-Bayes
*/


import java.util.ArrayList;
import java.util.List;

import datastructure.Arrange;

public class ExplicitEnumeration {

//	ÿ���ڵ�Ļ���Ŀ���״̬ȡ����CFGִ�е�˳��
//	��ͼ�Ͽ�֪��B1��B2��(B3,B4,B5,B6,B7,B8)��B9��֮һ�м���6��˳����ܱ仯
//	��������CFG�Ľṹ����������
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
		System.out.println("һ���� "+count+" �ֿ�����");
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
//				�������ʾ���еĿ��ܽ��
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
		
		System.out.println("˳��ִ�У���ʱû���Ƕ��̼߳���ͬ�����⣩: ");
		
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
		
		
//		��õ�ǰ������Ҫ��memory�б�
		List<String> memories =	TestExample1.cfg.getCFGblocks().get(i).getMemories();
		for (String string : memories) {
//			���ҳ���memory��Ӧcache����һ��
			int line = cacheline(string);
//			Ȼ���жϵ�ǰ��cache״̬�Ƿ�洢�˸�memory���������Ϊhit.���û����Ϊmiss�����ң�����cache״̬
			if (cacheState.getCachestate().get(line).equals(string)) {
				ExplicitEnumeration.hits=ExplicitEnumeration.hits+1;
								
			} else {
				ExplicitEnumeration.miss = ExplicitEnumeration.miss+1;
				cacheState.setCachestate(cacheState.changestate(line, string));
//				ÿ��miss��ӡ���º�Ľ��
				System.out.println("ÿ��miss��ӡ���º�Ľ��");
				System.out.println(cacheState);
			}
		}
		
		
	}
	
	
	public static int cacheline (String memory) {
//		Cache cache = new Cache(0);
//		����memory��Ӧcache����һ��
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
//			��ȥ��block��ǰ�ýڵ�
//			System.out.println(order[i]);
			List<Integer> tempIntegers = cfg.getCFGblocks().get(order[i]-1).getFormer();
			
//			System.out.println(tempIntegers+"*");
			for (Integer integer : tempIntegers) {
//				��ȡԪ��i��former�ڸ������е�λ��

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
