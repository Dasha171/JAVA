 class MySecondClass {
    private int num1;
    private int num2;

    public MySecondClass(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public int getNum1(){
        return num1;
     }

     public int getNum2(){
        return num2;
     }
     public static void main(String[] args){
          MySecondClass num1 = new MySecondClass(60,30);
          int initial = num1.getNum1();
          int initial2 = num1.getNum2();
          int result = initial%initial2;
          System.out.println("Остаток от деления: " + result);

     }

}

