package br.com.ivalue.models;

import java.util.List;

/**
 * Created by arthur on 10/02/16.
 */
public class Data {

    private String url;
    private Long id;
    private String reference;
    private String reference_auxiliar;
    private String type;
    private String category;
    private String status;
    private String address;
    private String additional;
    private String district;
    private String city;
    private String zone;
    private String enterprise_id;
    private String enterprise;
    private String enterprise_stage;
    private Long price_sale;
    private Long price_rent;
    private Long price_sale_area;
    private Long price_rent_area;
    private Long bedrooms;
    private Long suites;
    private Long garages;
    private Long area;
    private String area_label;
    private Long area_total;
    private Long area_util;
    private String photo_small;
    private String photo;
    private String created;
    private String updated;
    private Long condominium_fee;
    private Long agency_id;
    private String agency_title;
    private String agency_logo;
    private Boolean is_exclusive;
    private String exclusivity_end;
    private List<Broker> brokers;
    private Boolean is_gaiainc;
    private Long property_developer_id;
    private String property_developer;
    private String property_developer_logo;
    private Boolean has_proposal;
    private Boolean is_provisory;
    private String scope;
    private List<String> permissions;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference_auxiliar() {
        return reference_auxiliar;
    }

    public void setReference_auxiliar(String reference_auxiliar) {
        this.reference_auxiliar = reference_auxiliar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getEnterprise_stage() {
        return enterprise_stage;
    }

    public void setEnterprise_stage(String enterprise_stage) {
        this.enterprise_stage = enterprise_stage;
    }

    public Long getPrice_sale() {
        return price_sale;
    }

    public void setPrice_sale(Long price_sale) {
        this.price_sale = price_sale;
    }

    public Long getPrice_rent() {
        return price_rent;
    }

    public void setPrice_rent(Long price_rent) {
        this.price_rent = price_rent;
    }

    public Long getPrice_sale_area() {
        return price_sale_area;
    }

    public void setPrice_sale_area(Long price_sale_area) {
        this.price_sale_area = price_sale_area;
    }

    public Long getPrice_rent_area() {
        return price_rent_area;
    }

    public void setPrice_rent_area(Long price_rent_area) {
        this.price_rent_area = price_rent_area;
    }

    public Long getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Long bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Long getSuites() {
        return suites;
    }

    public void setSuites(Long suites) {
        this.suites = suites;
    }

    public Long getGarages() {
        return garages;
    }

    public void setGarages(Long garages) {
        this.garages = garages;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public String getArea_label() {
        return area_label;
    }

    public void setArea_label(String area_label) {
        this.area_label = area_label;
    }

    public Long getArea_total() {
        return area_total;
    }

    public void setArea_total(Long area_total) {
        this.area_total = area_total;
    }

    public Long getArea_util() {
        return area_util;
    }

    public void setArea_util(Long area_util) {
        this.area_util = area_util;
    }

    public String getPhoto_small() {
        return photo_small;
    }

    public void setPhoto_small(String photo_small) {
        this.photo_small = photo_small;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Long getCondominium_fee() {
        return condominium_fee;
    }

    public void setCondominium_fee(Long condominium_fee) {
        this.condominium_fee = condominium_fee;
    }

    public Long getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(Long agency_id) {
        this.agency_id = agency_id;
    }

    public String getAgency_title() {
        return agency_title;
    }

    public void setAgency_title(String agency_title) {
        this.agency_title = agency_title;
    }

    public String getAgency_logo() {
        return agency_logo;
    }

    public void setAgency_logo(String agency_logo) {
        this.agency_logo = agency_logo;
    }

    public Boolean getIs_exclusive() {
        return is_exclusive;
    }

    public void setIs_exclusive(Boolean is_exclusive) {
        this.is_exclusive = is_exclusive;
    }

    public String getExclusivity_end() {
        return exclusivity_end;
    }

    public void setExclusivity_end(String exclusivity_end) {
        this.exclusivity_end = exclusivity_end;
    }

    public List<Broker> getBrokers() {
        return brokers;
    }

    public void setBrokers(List<Broker> brokers) {
        this.brokers = brokers;
    }

    public Boolean getIs_gaiainc() {
        return is_gaiainc;
    }

    public void setIs_gaiainc(Boolean is_gaiainc) {
        this.is_gaiainc = is_gaiainc;
    }

    public Long getProperty_developer_id() {
        return property_developer_id;
    }

    public void setProperty_developer_id(Long property_developer_id) {
        this.property_developer_id = property_developer_id;
    }

    public String getProperty_developer() {
        return property_developer;
    }

    public void setProperty_developer(String property_developer) {
        this.property_developer = property_developer;
    }

    public String getProperty_developer_logo() {
        return property_developer_logo;
    }

    public void setProperty_developer_logo(String property_developer_logo) {
        this.property_developer_logo = property_developer_logo;
    }

    public Boolean getHas_proposal() {
        return has_proposal;
    }

    public void setHas_proposal(Boolean has_proposal) {
        this.has_proposal = has_proposal;
    }

    public Boolean getIs_provisory() {
        return is_provisory;
    }

    public void setIs_provisory(Boolean is_provisory) {
        this.is_provisory = is_provisory;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
