package com.manage.bus.entity;

public class GWorkOrderReplyImage extends GWorkOrderReply{
	private static final long serialVersionUID = 1L;

	public String[] getImages() {
		String image = getReply_img();
		if (image != null) {
			String[] images = image.split(";");
			return images;
		}
		return null;
	}

}
