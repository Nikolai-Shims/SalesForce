package models;

public class Account {

    String fax;
    String phone;
    String website;
    String employee;
    String billingCity;
    String accountName;
    String shippingCity;
    String annualRevenue;
    String billingCountry;
    String shippingCountry;
    String billingZipPostalCode;
    String billingStateProvince;
    String shippingZipPostalCode;
    String shippingStateProvince;
    String billingStreet;
    String shippingStreet;
    String description;
    String type;
    String industry;


    public Account(String fax, String phone, String website, String employee, String billingCity, String accountName, String shippingCity, String annualRevenue, String billingCountry, String shippingCountry, String billingZipPostalCode, String billingStateProvince, String shippingZipPostalCode, String shippingStateProvince, String billingStreet, String shippingStreet, String description, String type, String industry) {
        this.fax = fax;
        this.phone = phone;
        this.website = website;
        this.employee = employee;
        this.billingCity = billingCity;
        this.accountName = accountName;
        this.shippingCity = shippingCity;
        this.annualRevenue = annualRevenue;
        this.billingCountry = billingCountry;
        this.shippingCountry = shippingCountry;
        this.billingZipPostalCode = billingZipPostalCode;
        this.billingStateProvince = billingStateProvince;
        this.shippingZipPostalCode = shippingZipPostalCode;
        this.shippingStateProvince = shippingStateProvince;
        this.billingStreet = billingStreet;
        this.shippingStreet = shippingStreet;
        this.description = description;
        this.type = type;
        this.industry = industry;
    }

    public Account() {

    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getBillingZipPostalCode() {
        return billingZipPostalCode;
    }

    public void setBillingZipPostalCode(String billingZipPostalCode) {
        this.billingZipPostalCode = billingZipPostalCode;
    }

    public String getBillingStateProvince() {
        return billingStateProvince;
    }

    public void setBillingStateProvince(String billingStateProvince) {
        this.billingStateProvince = billingStateProvince;
    }

    public String getShippingZipPostalCode() {
        return shippingZipPostalCode;
    }

    public void setShippingZipPostalCode(String shippingZipPostalCode) {
        this.shippingZipPostalCode = shippingZipPostalCode;
    }

    public String getShippingStateProvince() {
        return shippingStateProvince;
    }

    public void setShippingStateProvince(String shippingStateProvince) {
        this.shippingStateProvince = shippingStateProvince;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

}
