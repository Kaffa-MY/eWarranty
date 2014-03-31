package sjtu.dclab.kaffa.ewarranty.domain;

public class EWarrantyCard extends AbstractCard{
	private String serialNum;	//SN
	private String Model;	//KY
	private String customer;	//MM
	private String creator;
	
	private String note;	//BZ
	private long seller;	//SMM
	private long shop;	//SMD
	private String createTime;
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getSeller() {
		return seller;
	}
	public void setSeller(long seller) {
		this.seller = seller;
	}
	public long getShop() {
		return shop;
	}
	public void setShop(long shop) {
		this.shop = shop;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
}
