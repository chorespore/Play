package inter;


import java.io.IOException;
import java.util.Properties;

/**
 * 1.构造器私有化
 * 2.自行创建
 * <p>
 * 静态代码块
 */
public class Singleton {


    public static final Singleton INSTANCE;

    private String name;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton.class.getClassLoader().getResourceAsStream("play.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        INSTANCE = new Singleton(properties.getProperty("name"));

    }

    private Singleton(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Singleton{" +
                "name='" + name + '\'' +
                '}';
    }
}
