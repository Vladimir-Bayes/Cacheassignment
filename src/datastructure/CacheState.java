package datastructure;
/** 
* @author ����Vladimir E-mail: gyang.shines@gmail.com
* @version ����ʱ�䣺2018��1��5�� ����10:44:32 
* @Github https://github.com/Vladimir-Bayes
*/

import java.util.ArrayList;
import java.util.List;

public class CacheState {
	
//	����cache�ĵ�ǰ״̬
	private List<String> cachestate;

	/**
	 * 
	 */
	public CacheState() {
		super();
		// TODO Auto-generated constructor stub
//		��cache��ǰ״̬���ϳ�ʼֵ
		List<String> templist = new ArrayList<String>();
		templist.add("default0");
		templist.add("default1");
		templist.add("default2");
		templist.add("default3");
		this.cachestate = templist;
	}

	public List<String> getCachestate() {
		return cachestate;
	}

	public void setCachestate(List<String> cachestate) {
		this.cachestate = cachestate;
	}

	@Override
	public String toString() {
		return "CacheState [cachestate=" + cachestate + "]";
	}
	
	public List<String> changestate(int i, String memory) {
		this.cachestate.set(i, memory);
		return cachestate;
	}
	
	
}
