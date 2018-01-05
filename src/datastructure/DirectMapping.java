package datastructure;

import java.util.List;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2018年1月5日 上午9:57:44 
* @Github https://github.com/Vladimir-Bayes
*/
public class DirectMapping {

	public static void Cache(int i, CacheState cacheState) {
//		CFG cfg = new CFG(1);
		
		
//		获得当前的所需要的memory列表
		List<String> memories =	TestExample1.cfg.getCFGblocks().get(i).getMemories();
		for (String string : memories) {
//			先找出该memory对应cache的哪一行
			int line = cacheline(string);
//			然后判断当前的cache状态是否存储了该memory，如果有则为hit.如果没有则为miss，并且，更新cache状态
			if (cacheState.getCachestate().get(line).equals(string)) {
				TestExample1.hits=TestExample1.hits+1;
								
			} else {
				TestExample1.miss = TestExample1.miss+1;
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
}
