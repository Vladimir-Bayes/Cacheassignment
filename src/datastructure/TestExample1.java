package datastructure;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author ����Vladimir E-mail: gyang.shines@gmail.com
 * @version ����ʱ�䣺2018��1��5�� ����9:57:03 
 * @Github https://github.com/Vladimir-Bayes
 */
public class TestExample1 {

	public static final CFG cfg = new CFG(1);

	public static final Cache cache = new Cache(1);

	public static int hits=0;
	public static int miss=0;

	public static void main(String[] args) {
		CacheState cacheState = new CacheState();
		System.out.println("˳��ִ�У���ʱû���Ƕ��̼߳���ͬ�����⣩: ");
		for (int i = 0; i < 9; i++) {
			@SuppressWarnings("unused")
			List<String> memoryList = new ArrayList<String>();
			memoryList = cfg.getCFGblocks().get(i).getMemories();
			DirectMapping.Cache(i, cacheState);
		}
		System.out.println("Hits: "+hits);
		System.out.println("Miss: "+miss);

	}
}
