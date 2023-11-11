package gmail.dchizhova68;

public class LessonJavaQA {
    public static void main (String args[]) {
        //boolean, byte, short,int, long, float, double, char, String

        int aInt = 9;
        int bInt = 4;
        int divisionInt = aInt / bInt;
        System.out.printf("Деление целочисленных значений: %s / %s = %s \n", aInt, bInt, divisionInt);

        double aDouble = 9;
        double bDouble = 4.3;
        double divisionDouble = aDouble / bDouble;
        System.out.printf("Деление чисел с плавающей точкой : %s / %s = %s \n", aDouble, bDouble, divisionDouble);

        int n = 7;
        boolean isIvenNumber = (n % 2 == 0) ? true : false;
        if (isIvenNumber) {
            System.out.printf("Число %s - четное \n", n);
        } else {
            System.out.printf("Число %s - нечетное \n", n);
        }

        System.out.println("Сумма целого числа " + aInt + " и числа с плавающей точкой " + bDouble + " равно " + (aInt +bDouble));
        System.out.println("Приведение с целому типу данных суммы целого числа " + aInt + " и числа с плавающей точкой " + bDouble + " = " + (int)(aInt +bDouble));

        short aShort = 32767;
        short bShort = 10;

        System.out.println("Пример переполнения: " + (short)(aShort + bShort));


    }

}
