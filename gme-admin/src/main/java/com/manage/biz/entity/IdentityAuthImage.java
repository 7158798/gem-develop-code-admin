package com.manage.biz.entity;

public class IdentityAuthImage extends IdentityAuth{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 证件背面图片 预览地址
	 */
	private String reverseImgPreview;
	/**
	 * 证件背面图片 引用地址
	 */
	private String reverseImgUrl;
	/**
	 * 证件正面图片 预览地址
	 */
	private String frontImgPreview;
	/**
	 * 证件正面图片 引用地址
	 */
	private String frontImgUrl;
	/**
	 * 手持证件图片 预览地址
	 */
	private String inHandImgPreview;
	/**
	 * 手持证件图片 引用地址
	 */
	private String inHandImgUrl;
	public String getReverseImgPreview() {
		return reverseImgPreview;
	}
	public void setReverseImgPreview(String reverseImgPreview) {
		this.reverseImgPreview = reverseImgPreview;
	}
	public String getReverseImgUrl() {
		return reverseImgUrl;
	}
	public void setReverseImgUrl(String reverseImgUrl) {
		this.reverseImgUrl = reverseImgUrl;
	}
	public String getFrontImgPreview() {
		return frontImgPreview;
	}
	public void setFrontImgPreview(String frontImgPreview) {
		this.frontImgPreview = frontImgPreview;
	}
	public String getFrontImgUrl() {
		return frontImgUrl;
	}
	public void setFrontImgUrl(String frontImgUrl) {
		this.frontImgUrl = frontImgUrl;
	}
	public String getInHandImgPreview() {
		return inHandImgPreview;
	}
	public void setInHandImgPreview(String inHandImgPreview) {
		this.inHandImgPreview = inHandImgPreview;
	}
	public String getInHandImgUrl() {
		return inHandImgUrl;
	}
	public void setInHandImgUrl(String inHandImgUrl) {
		this.inHandImgUrl = inHandImgUrl;
	}
}