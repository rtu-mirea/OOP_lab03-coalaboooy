package Lab3;

class User {

    private String name;
    private String login;
    private String password;

    //TODO: Наследовать класс администратора?

    User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    private boolean Enter (String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    String getLogin() {
        return login;
    }

    String getName() {
        return name;
    }
}
