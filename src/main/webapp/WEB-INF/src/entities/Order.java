package entities;




public class Order {
    private int id;
    private String person;
    private int dish_id;
    private int amount;

    public Order() {
    }

    public Order(int id, String person, int dish_id, int amount) {
        this.id = id;
        this.person = person;
        this.dish_id = dish_id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
