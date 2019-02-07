package com.casestudy.solvian_test;

import java.util.Date;

public class CertificateUpdate {

	private Date date;
	private String isin;
	private float bidPrice;
	private int bidSize;
	private float askPrice;
	private int askSize;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public float getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(float bidPrice) {
		this.bidPrice = bidPrice;
	}
	public int getBidSize() {
		return bidSize;
	}
	public void setBidSize(int bidSize) {
		this.bidSize = bidSize;
	}
	public float getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(float askPrice) {
		this.askPrice = askPrice;
	}
	public int getAskSize() {
		return askSize;
	}
	public void setAskSize(int askSize) {
		this.askSize = askSize;
	}
	@Override
	public String toString() {
		return  date.getTime() +","+  isin +","+ bidPrice +","+ bidSize
				+ ","+askPrice  + ","+askSize ;
	}
	
	
}
