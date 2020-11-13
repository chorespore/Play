package juc;

import java.util.stream.IntStream;

public class ThreadLocalTest {

    ThreadLocal<String> tl = new ThreadLocal<>();
    String content;

    public String getContent() {
//        return content;
        return tl.get();
    }

    public void setContent(String content) {
//        this.content = content;
        tl.set(content);
    }

    public static void main(String[] args) {
        ThreadLocalTest demo = new ThreadLocalTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                demo.setContent(" -> data of " + Thread.currentThread().getName());
                System.out.println("----");
                System.out.println(Thread.currentThread().getName() + demo.getContent());

            });
            thread.setName("T-" + i);
            thread.start();
        }
    }
}

