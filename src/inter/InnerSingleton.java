package inter;

public class InnerSingleton {


    private InnerSingleton() {

    }

    private static class Inner {
        public static final InnerSingleton INSTANCE = new InnerSingleton();
    }

    public static InnerSingleton getSingleton() {
        return Inner.INSTANCE;
    }
}
