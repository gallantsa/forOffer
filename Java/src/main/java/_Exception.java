public class _Exception {
    public static void main(String[] args) {
        try {
            int x = 1;
            int y = 0;
            if (y == 0){
                throw new MyCustomException("除数不能为0");
            }
            System.out.println(x / y);
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
