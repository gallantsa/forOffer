import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        System.out.println("---");
        E e = context.getBean(E.class);
        System.out.println(e.getF1().getClass());
        System.out.println(e.getF1());
        System.out.println(e.getF1());
        System.out.println(e.getF1());

        System.out.println(e.getF2().getClass());
        System.out.println(e.getF2());
        System.out.println(e.getF2());
        System.out.println(e.getF2());

        System.out.println(e.getF3().getClass());
        System.out.println(e.getF3());
        System.out.println(e.getF3());
        System.out.println(e.getF3());

        System.out.println(e.getF4().getClass());
        System.out.println(e.getF4());
        System.out.println(e.getF4());
        System.out.println(e.getF4());
        context.close();
    }

    @Component
    static class E {
        @Lazy
        @Autowired
        private F1 f1;

        @Lazy
        @Autowired
        private F2 f2;

        @Lazy
        @Autowired
        private F3 f3;

        @Autowired
        private F4 f4;

        public F1 getF1() {
            return f1;
        }

        public F2 getF2() {
            return f2;
        }

        public F3 getF3() {
            return f3;
        }

        public F4 getF4() {
            return f4;
        }
    }

    @Component
    static class F1 {
        public F1() {
            System.out.println("new F1()");
        }
    }

    @Lazy
    @Component
    static class F2 {
        public F2() {
            System.out.println("new F2()");
        }
    }

    @Scope("prototype")
    @Component
    static class F3 {
        public F3() {
            System.out.println("new F3()");
        }
    }

    @Scope("prototype")
    @Component
    static class F4 {
        public F4() {
            System.out.println("new F4()");
        }
    }
}
