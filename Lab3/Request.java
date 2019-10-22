package Lab3;

public class Request {

    private Client requester;
    private String product;
    private int price;
    private int count;
    private int type;

    Request (Client requester, String product, int price, int count, int type) {
        this.requester = requester;
        this.product = product;
        this.price = price;
        this.count = count;
        this.type = type; //TODO: 0 - продажа, 1 - покупка (Поменять на ENUM?)
    }

    public Client getRequester() {
        return requester;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getType() {
        return type;
    }
}
