package com.manage.biz.entity;

public class GIdentityAuthImage extends GIdentityAuth{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 证件背面图片 预览地址
	 */
	private String reverse_img_preview;
	/**
	 * 证件背面图片 引用地址
	 */
	private String reverse_img_url;
	/**
	 * 证件正面图片 预览地址
	 */
	private String front_img_preview;
	/**
	 * 证件正面图片 引用地址
	 */
	private String front_img_url;
	/**
	 * 手持证件图片 预览地址
	 */
	private String in_hand_img_preview;
	/**
	 * 手持证件图片 引用地址
	 */
	private String in_hand_img_url;
	public String getReverse_img_preview() {
		return reverse_img_preview;
	}
	public void setReverse_img_preview(String reverse_img_preview) {
		this.reverse_img_preview = reverse_img_preview;
	}
	public String getReverse_img_url() {
		return reverse_img_url;
	}
	public void setReverse_img_url(String reverse_img_url) {
		this.reverse_img_url = reverse_img_url;
	}
	public String getFront_img_preview() {
		return front_img_preview;
	}
	public void setFront_img_preview(String front_img_preview) {
		this.front_img_preview = front_img_preview;
	}
	public String getFront_img_url() {
		return front_img_url;
	}
	public void setFront_img_url(String front_img_url) {
		this.front_img_url = front_img_url;
	}
	public String getIn_hand_img_preview() {
		return in_hand_img_preview;
	}
	public void setIn_hand_img_preview(String in_hand_img_preview) {
		this.in_hand_img_preview = in_hand_img_preview;
	}
	public String getIn_hand_img_url() {
		return in_hand_img_url;
	}
	public void setIn_hand_img_url(String in_hand_img_url) {
		this.in_hand_img_url = in_hand_img_url;
	}
}
