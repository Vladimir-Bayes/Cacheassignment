package datastructure;

import java.util.List;

/** 
* @author ����Vladimir E-mail: gyang.shines@gmail.com
* @version ����ʱ�䣺2018��1��5�� ����9:57:44 
* @Github https://github.com/Vladimir-Bayes
*/
public class DirectMapping {

	public static void Cache(int i, CacheState cacheState) {
//		CFG cfg = new CFG(1);
		
		
//		��õ�ǰ������Ҫ��memory�б�
		List<String> memories =	TestExample1.cfg.getCFGblocks().get(i).getMemories();
		for (String string : memories) {
//			���ҳ���memory��Ӧcache����һ��
			int line = cacheline(string);
//			Ȼ���жϵ�ǰ��cache״̬�Ƿ�洢�˸�memory���������Ϊhit.���û����Ϊmiss�����ң�����cache״̬
			if (cacheState.getCachestate().get(line).equals(string)) {
				TestExample1.hits=TestExample1.hits+1;
								
			} else {
				TestExample1.miss = TestExample1.miss+1;
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
}
