package com.zyj.wechartexam.weixin.message.requestMessage;

/**
 * 地理位置消息
 * @author Zhu YuJia
 * 
 */
public class RequestLocationMessage extends RequestBaseMessage {

	private static final long serialVersionUID = 421081311871300766L;
	//地理位置纬度
	private String location_x;
	private String location_y;
	private String scale;
	private String label;

	@Override
	public String toString() {
		return "LocationMessage [location_x=" + location_x + ", location_y="
				+ location_y + ", scale=" + scale + ", label=" + label
				+ ", toString()=" + super.toString() + "]";
	}

	public String getLocation_x() {
		return location_x;
	}

	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}

	public String getLocation_y() {
		return location_y;
	}

	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
