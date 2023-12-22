class MyFirstClass {

    public static void main(String[] s) {

        MySecClass o = new MySecClass();

        int i, j;
        for(i=1;i<=8;i++) {
            for (j = 1; j <= 8; j++) {
                o.setX(i);
                o.setY(j);
                System.out.print(o.Sum());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
};

class MySecClass{

    private int x;
    private int y;
    public MySecClass(){
        this.x = x; this.y = y;
    }
    public void setX(int value) {
        this.x = value;
    }
    public void setY(int value) {
        this.y = value;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int Sum()
    {
        return this.x + this.y;
    }

}