package Lab3;

class User {

    String name;
    String login;
    String password;

    User () {}

    User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    boolean Enter (String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    String getLogin() {
        return this.login;
    }

    String getName() {
        return this.name;
    }
}