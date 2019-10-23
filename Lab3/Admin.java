package Lab3;

class Admin extends User {

    private static String login;
    private static String password;

    Admin () {}

    public void setLogin() {
        Admin.login = "SanyaKochan";
    }

    public void setPassword() {
        Admin.password = "s0s1skA";
    }

    String getLogin() {
        return Admin.login;
    }

    String getPassword() {
        return Admin.password;
    }
}
