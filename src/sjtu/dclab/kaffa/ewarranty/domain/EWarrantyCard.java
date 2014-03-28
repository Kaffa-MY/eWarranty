package sjtu.dclab.kaffa.ewarranty.domain;

public class EWarrantyCard extends AbstractCard{
	private long id;
	private String serialNum;	//SN
	private String Model;	//KY
	private long seller;	//SMM
	private long pointOfSells;	//SMD
	private long customer;	//MM
	//private BSON FPP;
	private String remark;	//BZ
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public long getSeller() {
		return seller;
	}
	public void setSeller(long seller) {
		this.seller = seller;
	}
	public long getPointOfSells() {
		return pointOfSells;
	}
	public void setPointOfSells(long pointOfSells) {
		this.pointOfSells = pointOfSells;
	}
	public long getCustomer() {
		return customer;
	}
	public void setCustomer(long customer) {
		this.customer = customer;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
