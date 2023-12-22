/*Налоги. Определить множество и сумму налоговых выплат физического лица за
        год с учетом доходов с основного и дополнительного мест работы, авторских
        вознаграждений, продажи имущества, получения в подарок денежных сумм и имущества,
        переводов из-за границы, льгот на детей и материальной помощи. Провести сортировку
        налогов по сумме.*/

/*Корабль. Определить иерархию корабля. Создать несколько объектов-кают.
        Собрать корабль. Провести сортировку кают в букете на основе количества коек. Найти
        каюту на коробе, соответствующую заданному числу коек.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        System.out.printf("\n1 задание!\n");
        List<Nalog> taxes = new ArrayList<>();

        taxes.add(new Nalog("Зарплата", 300000));
        taxes.add(new Nalog("Авторские вознаграждения", 1000000));
        taxes.add(new Nalog("Продажа имущества", 100000));
        taxes.add(new Nalog("Подарок", 7000));
        taxes.add(new Nalog("Перевод из-за границы", 9000));
        taxes.add(new Nalog("Льготы на детей", -4000));
        taxes.add(new Nalog("Материальная помощь", -1000));

        double kol = 0;
        for (Nalog tax : taxes) {
            kol += tax.getAmount();
        }
        Collections.sort(taxes, Comparator.comparing(Nalog::getAmount));
        System.out.println("Наибольшие налоги:");
        for (Nalog tax : taxes) {
            System.out.println(tax);
        }
        System.out.println("Общая сумма налоговых выплат: " + kol);

        System.out.printf("\n2 задание!\n");
        Komnata bed1 = new Komnata(1);
        Komnata bed2 = new Komnata(2);
        Komnata bed3 = new Komnata(3);
        Komnata bed4 = new Komnata(4);
        Komnata bed5 = new Komnata(5);
        Cabin cabin1 = new Cabin(10);
        cabin1.addBed(bed1);
        cabin1.addBed(bed2);
        Cabin cabin2 = new Cabin(12);
        cabin2.addBed(bed3);
        Ship ship = new Ship();
        ship.addCabin(cabin1);
        ship.addCabin(cabin2);
        Collections.sort(ship.getCabins(), (c1, c2) -> Integer.compare(c1.getNumberOfBeds(), c2.getNumberOfBeds()));
        System.out.println("Каюты отсортированные по количеству коек:");

        for (Cabin cabin : ship.getCabins()) {
            System.out.println("Каюта номер " + cabin.getCabinNumber() + ": " + cabin.getNumberOfBeds() + " койки");
        }
        int desiredBedCount = 3;
        for (Cabin cabin : ship.getCabins()) {
            if (cabin.getNumberOfBeds() == desiredBedCount) {
                System.out.println("Каюта с " + desiredBedCount + " койками найдена: Каюта номер " + cabin.getCabinNumber());
                break;
            }
        }
    }
}
class Nalog {
    private String type;
    private double amount;

    public Nalog(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return type + ": " + amount;
    }
}

class Komnata{
    private int bedNumber;

    public Komnata(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public int getBedNumber() {
        return bedNumber;
    }
}
class Cabin{
    private int cabinNumber;
    private List<Komnata> beds;

    public Cabin(int cabinNumber) {
        this.cabinNumber = cabinNumber;
        this.beds = new ArrayList<>();
    }

    public void addBed(Komnata bed) {
        beds.add(bed);
    }

    public int getCabinNumber() {
        return cabinNumber;
    }
    public int getNumberOfBeds() {
        return beds.size();
    }
}
class Ship {
    private List<Cabin> cabins;
    public Ship() {
        this.cabins = new ArrayList<>();
    }
    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
    }
    public List<Cabin> getCabins() {
        return cabins;
    }
}




