package com.manage.biz.entity;

public class WorkOrderImage extends WorkOrder{
	private static final long serialVersionUID = 1L;

	public String[] getImages() {
		String image = getWorkImg();
		if (image != null) {
			String[] images = image.split(";");
			return images;
		}
		return null;
	}
}
