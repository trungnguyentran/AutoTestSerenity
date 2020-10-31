package ecomerce;

public class InforProduct {
	
	private String NameWebsite;
	private String NameProduct;
	private String PriceProduct;
	private String LinkProduct;

	public void setNameWebsite(String inputNameWebsite) {
		
		this.NameWebsite = inputNameWebsite;
	}
	
	public String getNameWebsite() {
		
		return NameWebsite;
		
	}
	
	public void setNameProduct(String inputNameProduct) {
		
		this.NameProduct = inputNameProduct;
		
	}
	
	public String getNameProduct() {
		
		return NameProduct;
		
	}
	
	public void setPriceProduct(String inputPriceProduct) {
		
		this.PriceProduct = inputPriceProduct;
		
	}
	
	public String getPriceProduct() {
		
		return PriceProduct;
		
	}
	
	public void setLinkProduct(String inputLinkProduct) {
		
		this.LinkProduct = inputLinkProduct;
		
	}
	
	public String getLinkProduct() {
		
		return LinkProduct;
		
	}
}
