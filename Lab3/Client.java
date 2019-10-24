package Lab3;

class Client extends User {

    Client(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void takeRequest(Request request) {//TODO: Вывод в окно
        if (request.getType() == 0)
            System.out.printf("Уважаемый %s, ваша заявка на продажу продукта %s была удовлетворена\n",
                    request.getRequester().getName() , request.getProduct());
        else if (request.getType() == 1)
            System.out.printf("Уважаемый %s, ваша заявка на покупку продукта %s была удовлетворена\n",
                    request.getRequester().getName(), request.getProduct());
    }
}