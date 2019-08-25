package ThreadTest;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable task = new TestTask();
        Thread t = new Thread(task);
        t.start();
        TestTask tt = (TestTask) task;
        System.out.println(tt.getNum());
        Thread t2 = new Thread(task);
        t2.start();
        System.out.println(tt.getNum());
    }
}

class TestTask implements Runnable{

    private int num;
    @Override
    public void run() {
        num++;
        System.out.println("num:"+num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}