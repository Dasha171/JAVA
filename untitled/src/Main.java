import java.util.Arrays;
import java.util.Scanner;
class Car {
    String model;
    String regNumber;
    int year;
    double probeg; // Изменено на probeg
    double price;

    public Car(String model, String regNumber, int year, double probeg, double price) {
        this.model = model;
        this.regNumber = regNumber;
        this.year = year;
        this.probeg = probeg; // Изменено на probeg
        this.price = price;
    }

    public String toString() {
        return "Модель: " + model + ", Рег. номер: " + regNumber + ", Год выпуска: " + year + ", Пробег: " + probeg
                + " км, Стоимость: $" + price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество автомобилей: ");
        int count = sc.nextInt();
        sc.nextLine();

        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Введите информацию о " + (i + 1) + "-м автомобиле:");

            System.out.print("Модель: ");
            String model = sc.nextLine();

            System.out.print("Рег. номер: ");
            String regNumber = sc.nextLine();

            System.out.print("Год выпуска: ");
            int year = sc.nextInt();
            sc.nextLine();

            System.out.print("Пробег (км): ");
            double probeg = sc.nextDouble(); // Изменено на probeg
            sc.nextLine();

            System.out.print("Стоимость ($): ");
            double price = sc.nextDouble();
            sc.nextLine();

            cars[i] = new Car(model, regNumber, year, probeg, price); // Изменено на probeg
        }
        Car cheapestCar = findCheapestCar(cars);
        System.out.println("\nСамый дешевый автомобиль:\n" + cheapestCar);
        Arrays.sort(cars, (a, b) -> b.year - a.year);
        System.out.println("\nАвтомобили, упорядоченные по году выпуска (по убыванию):");
        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.print("\nВведите регистрационный номер для поиска: ");
        String searchRegNumber = sc.nextLine();
        Car foundCar = findCarByRegNumber(cars, searchRegNumber);
        if (foundCar != null) {
            System.out.println("Найден автомобиль:\n" + foundCar);
        } else {
            System.out.println("Автомобиль с указанным регистрационным номером не найден.");
        }

        sc.close();
    }

    public static Car findCheapestCar(Car[] cars) {
        Car cheapestCar = cars[0];
        for (Car car : cars) {
            if (car.price < cheapestCar.price) {
                cheapestCar = car;
            }
        }
        return cheapestCar;
    }

    public static Car findCarByRegNumber(Car[] cars, String regNumber) {
        for (Car car : cars) {
            if (car.regNumber.equalsIgnoreCase(regNumber)) {
                return car;
            }
        }
        return null;
    }
}
