package app.android.frisco.myeasyfield.activities.entities;

import com.orm.dsl.Table;

@Table
public class Complejo {

    private Long id;
    private String name;
    private String address;
    private String district;
    private String phone;

    public Complejo() {
    }

    public Complejo(String name, String address, String district, String phone) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistict(String distict) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Complejo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
