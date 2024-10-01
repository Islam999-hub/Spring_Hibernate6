package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "users_cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Car(String model, int series, User user) {
        this.id = id;
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }



    @Column(name = "model")
    private String model;


    @Column(name = "series")
    private int series;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @OneToOne(mappedBy = "car")
    private User user;




}
