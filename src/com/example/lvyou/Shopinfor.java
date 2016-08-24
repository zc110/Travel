package com.example.lvyou;

import java.util.ArrayList;
import java.util.List;

public class Shopinfor {
	int backId;
	String text_xian;
	String text_jieshao;
	int imageid;
	String text_haoyou;
	String text_jingqu;
	int image_wodezuji;
	String text_riqi;
	//int [] numb={R.drawable.jinianbei,R.drawable.madeli,R.drawable.dajiaotang};
	int []numb=new int[3];
	public int[] getNumb() {
		return numb;
	}
	public void setNumb(int[] numb) {
		this.numb = numb;
	}
	List<String> lists=new ArrayList<String>();
	
	public String getText_riqi() {
		return text_riqi;
	}
	public void setText_riqi(String text_riqi) {
		this.text_riqi = text_riqi;
	}
	public List<String> getLists() {
		return lists;
	}
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	
	public int getImage_wodezuji() {
		return image_wodezuji;
	}
	public void setImage_wodezuji(int image_wodezuji) {
		this.image_wodezuji = image_wodezuji;
	}
	public String getText_wdzuji1() {
		return text_wdzuji1;
	}
	public void setText_wdzuji1(String text_wdzuji1) {
		this.text_wdzuji1 = text_wdzuji1;
	}
	public String getText_wdzuji2() {
		return text_wdzuji2;
	}
	public void setText_wdzuji2(String text_wdzuji2) {
		this.text_wdzuji2 = text_wdzuji2;
	}
	String text_wdzuji1;
	String text_wdzuji2;
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getText_haoyou() {
		return text_haoyou;
	}
	public void setText_haoyou(String text_haoyou) {
		this.text_haoyou = text_haoyou;
	}
	public String getText_jingqu() {
		return text_jingqu;
	}
	public void setText_jingqu(String text_jingqu) {
		this.text_jingqu = text_jingqu;
	}
	
	public int getBackId() {
		return backId;
	}
	public void setBackId(int backId) {
		this.backId = backId;
	}
	public String getText_xian() {
		return text_xian;
	}
	public void setText_xian(String text_xian) {
		this.text_xian = text_xian;
	}
	public String getText_jieshao() {
		return text_jieshao;
	}
	public void setText_jieshao(String text_jieshao) {
		this.text_jieshao = text_jieshao;
	}
	
}
