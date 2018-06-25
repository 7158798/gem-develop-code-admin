package com.manage.biz.entity;

public class IdentityAuthImage extends IdentityAuth{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 证件背面图片 预览地址
	 */
	private String reverseImgPreviewUrl;
	/**
	 * 证件背面图片 引用地址
	 */
	private String reverseImgUrl;
	/**
	 * 证件正面图片 预览地址
	 */
	private String frontImgPreviewUrl;
	/**
	 * 证件正面图片 引用地址
	 */
	private String frontImgUrl;
	/**
	 * 手持证件图片 预览地址
	 */
	private String inHandImgPreviewUrl;
	/**
	 * 手持证件图片 引用地址
	 */
	private String inHandImgUrl;
	public String getReverseImgPreviewUrl() {
		return reverseImgPreviewUrl;
	}
	public void setReverseImgPreviewUrl(String reverseImgPreviewUrl) {
		this.reverseImgPreviewUrl = reverseImgPreviewUrl;
	}
	public String getReverseImgUrl() {
		return reverseImgUrl;
	}
	public void setReverseImgUrl(String reverseImgUrl) {
		this.reverseImgUrl = reverseImgUrl;
	}
	public String getFrontImgPreviewUrl() {
		return frontImgPreviewUrl;
	}
	public void setFrontImgPreviewUrl(String frontImgPreviewUrl) {
		this.frontImgPreviewUrl = frontImgPreviewUrl;
	}
	public String getFrontImgUrl() {
		return frontImgUrl;
	}
	public void setFrontImgUrl(String frontImgUrl) {
		this.frontImgUrl = frontImgUrl;
	}
	public String getInHandImgPreviewUrl() {
		return inHandImgPreviewUrl;
	}
	public void setInHandImgPreviewUrl(String inHandImgPreviewUrl) {
		this.inHandImgPreviewUrl = inHandImgPreviewUrl;
	}
	public String getInHandImgUrl() {
		return inHandImgUrl;
	}
	public void setInHandImgUrl(String inHandImgUrl) {
		this.inHandImgUrl = inHandImgUrl;
	}
	
}