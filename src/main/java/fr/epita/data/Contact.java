package fr.epita.data;


public class Contact {
    private String name;
    private String last_name;
    private String company_name;
    private String address;
    private String city;
    private String county;
    private String state;
    private int zip;
    private String phone1;
    private String phone;
    private String email;

    

    public Contact(String name, String last_name, String company_name, String address, String city, String county,
            String state, int zip, String phone1, String phone, String email) {
        this.name = name;
        this.last_name = last_name;
        this.company_name = company_name;
        this.address = address;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zip = zip;
        this.phone1 = phone1;
        this.phone = phone;
        this.email = email;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getLast_name() {
        return last_name;
    }



    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



    public String getCompany_name() {
        return company_name;
    }



    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public String getCity() {
        return city;
    }



    public void setCity(String city) {
        this.city = city;
    }



    public String getCounty() {
        return county;
    }



    public void setCounty(String county) {
        this.county = county;
    }



    public String getState() {
        return state;
    }



    public void setState(String state) {
        this.state = state;
    }



    public int getZip() {
        return zip;
    }



    public void setZip(int zip) {
        this.zip = zip;
    }



    public String getPhone1() {
        return phone1;
    }



    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Contact [address=" + address + ", city=" + city + ", company_name=" + company_name + ", county="
                + county + ", email=" + email + ", last_name=" + last_name + ", name=" + name + ", phone=" + phone
                + ", phone1=" + phone1 + ", state=" + state + ", zip=" + zip + "]";
    }

    


}
