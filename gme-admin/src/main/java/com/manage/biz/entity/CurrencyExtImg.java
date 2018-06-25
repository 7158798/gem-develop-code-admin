package com.manage.biz.entity;

/**
 * 
 * @Project：gme-admin   
 * @Class：CurrencyExtImg 币种图片扩展   
 * @Description    
 * @Author：zhou   
 * @Date：2018年6月25日 下午4:46:00   
 * @version V1.0
 */
public class CurrencyExtImg extends Currency {

	private static final long serialVersionUID = 1L;

	/**
	 * 币种预览url
	 */
	private String iconPreviewUrl;

	/**
	 * 币种url
	 */
	private String iconUrl;

	public String getIconPreviewUrl() {
		return iconPreviewUrl;
	}

	public void setIconPreviewUrl(String iconPreviewUrl) {
		this.iconPreviewUrl = iconPreviewUrl;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

}
