package com.manage.biz.entity;

public class GWorkOrderImage extends GWorkOrder{
	private static final long serialVersionUID = 1L;

	public String[] getImages() {
		String image = getWork_img();
		if (image != null) {
			String[] images = image.split(";");
			return images;
		}
		return null;
	}
}
