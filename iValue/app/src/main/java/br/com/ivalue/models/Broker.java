package br.com.ivalue.models;

/**
 * Created by arthur on 10/02/16.
 */
public class Broker {

    private Long id;
    private String title;
    private String photo;
    private String comission_type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getComission_type() {
        return comission_type;
    }

    public void setComission_type(String comission_type) {
        this.comission_type = comission_type;
    }
}
