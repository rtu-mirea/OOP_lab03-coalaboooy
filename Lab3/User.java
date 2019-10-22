package Lab3;

import java.util.Arrays;

class User {

    protected String name;
    protected String login;
    protected String password;

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
        return login;
    }

    String getName() {
        return name;
    }
}
