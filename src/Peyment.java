import java.util.Objects;

public class Peyment {
    private String type;
    private Double id;
    private Long order;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public Double getId() {
        return id;
    }

    public Long getOrder() {
        return order;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(Double id) {
        if (id < 0){
            System.out.println("Id can not be negative");
        }
        this.id = id;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Peyment(String type, Double id, Long order, String password) {
        this.type = type;
        this.id = id;
        this.order = order;
        this.password = password;
    }

    public Peyment() {
        System.out.println("empty constructor");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Peyment peyment = (Peyment) o;
        return password == peyment.password && Objects.equals(type, peyment.type) && Objects.equals(id, peyment.id) && Objects.equals(order, peyment.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, order, password);
    }

    @Override
    public String toString() {
        return "Peyment{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", order=" + order +
                ", password=" + password +
                '}';
    }
}
