package datastructure;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author 作者Vladimir E-mail: gyang.shines@gmail.com
 * @version 创建时间：2018年1月5日 上午9:57:03 
 * @Github https://github.com/Vladimir-Bayes
 */
public class TestExample1 {

	public static final CFG cfg = new CFG(1);

	public static final Cache cache = new Cache(1);

	public static int hits=0;
	public static int miss=0;

	public static void main(String[] args) {
		CacheState cacheState = new CacheState();
		System.out.println("顺序执行（暂时没考虑多线程及其同步问题）: ");
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
