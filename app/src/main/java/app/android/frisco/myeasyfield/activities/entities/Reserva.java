package app.android.frisco.myeasyfield.activities.entities;

import com.orm.dsl.Table;

@Table
public class Reserva {

    private Long id;
    private String username;
    private double cost;
    private String time_init;
    private String name_comp;
    private String number_camp;

    public Reserva() {
    }

    public Reserva(String username, double cost, String time_init, String name_comp, String number_camp) {
        this.username = username;
        this.cost = cost;
        this.time_init = time_init;
        this.name_comp = name_comp;
        this.number_camp = number_camp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTime_init() {
        return time_init;
    }

    public void setTime_init(String time_init) {
        this.time_init = time_init;
    }

    public String getName_comp() {
        return name_comp;
    }

    public void setName_comp(String name_comp) {
        this.name_comp = name_comp;
    }

    public String getNumber_camp() {
        return number_camp;
    }

    public void setNumber_camp(String number_camp) {
        this.number_camp = number_camp;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cost=" + cost +
                ", time_init='" + time_init + '\'' +
                ", name_comp='" + name_comp + '\'' +
                ", number_camp=" + number_camp +
                '}';
    }
}
