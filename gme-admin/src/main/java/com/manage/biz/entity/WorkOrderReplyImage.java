package com.manage.biz.entity;

public class WorkOrderReplyImage extends WorkOrderReply{
	private static final long serialVersionUID = 1L;

	public String[] getImages() {
		String image = getReplyImg();
		if (image != null) {
			String[] images = image.split(";");
			return images;
		}
		return null;
	}

}
