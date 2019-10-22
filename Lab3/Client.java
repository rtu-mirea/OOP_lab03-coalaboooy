package Lab3;

class Client extends User {

    Client(String name, String login, String password) {
        super(name, login, password);
    }

    public void takeRequest(Request request) {//TODO: Вывод в окно
        if (request.getType() == 0)
            System.out.printf("Уважаемый %s, ваша заявка на продажу продукта %s была (не)удовлетворена",
                    request.getRequester().getName() , request.getProduct());
        else if (request.getType() == 1)
            System.out.printf("Уважаемый %s, ваша заявка на покупку продукта %s была (не)удовлетворена",
                    request.getRequester().getName(), request.getProduct());
    }

    //TODO: Сделать окно входа и добавления заявки
}