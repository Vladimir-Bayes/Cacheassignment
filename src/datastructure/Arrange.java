package datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//���ڻ�ȡ���еĹ�����

public class Arrange{
	
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<String>();
		if(str == null || str.length() <= 0)
			return res;
		HashSet<String> set = new HashSet<String>(); //���ȥ��
		dfs(set, str.toCharArray(), 0);
		res.addAll(set);
		Collections.sort(res);
		return res;
	}

	public void dfs(HashSet<String> set, char [] str, int k){
		if(k == str.length){  //�õ����
			set.add(new String(str));
			return ;
		}
		for(int i = 0; i < str.length; i ++){
			swap(i, k, str);
			dfs(set, str, k + 1);
			swap(i, k, str);  //����
		}
	}

	public void swap(int i, int j, char [] str){
		if(i != j){
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp; 
		}
	}
}