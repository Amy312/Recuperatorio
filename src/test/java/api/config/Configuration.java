package api.config;

public class Configuration {
    public static String user="ambarrojasm@gmail.com";
    public static String password="Amys4n23";
    public static String token="https://todo.ly/api/authentication/token.json" ;
    public static String host= "https://todo.ly/";
    public static String tokenValue;

    public static void setUser(String user) {
        Configuration.user = user;
    }

    public static void setPassword(String password) {
        Configuration.password = password;
    }
}
