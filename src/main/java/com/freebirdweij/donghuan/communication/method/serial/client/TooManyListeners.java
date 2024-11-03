package com.freebirdweij.donghuan.communication.method.serial.client;

public class TooManyListeners extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooManyListeners() {}

	@Override
	public String toString() {
		return "串口监听类数量过多！添加操作失败！";
	}
	
}
