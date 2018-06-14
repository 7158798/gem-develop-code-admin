package com.manage.bus.entity;

public class GIdentityAuthImage extends GIdentityAuth{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 证件背面图片url
	 */
	private String reverse_img;
	/**
	 * 证件正面图片url
	 */
	private String front_img;
	/**
	 * 手持证件图片
	 */
	private String in_hand_img;
	public String getReverse_img() {
		return reverse_img;
	}
	public void setReverse_img(String reverse_img) {
		this.reverse_img = reverse_img;
	}
	public String getFront_img() {
		return front_img;
	}
	public void setFront_img(String front_img) {
		this.front_img = front_img;
	}
	public String getIn_hand_img() {
		return in_hand_img;
	}
	public void setIn_hand_img(String in_hand_img) {
		this.in_hand_img = in_hand_img;
	}
	
}
