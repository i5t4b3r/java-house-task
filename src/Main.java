import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество этажей в здании: ");
        int floor = scanner.nextInt();

        System.out.print("Введите количество подъездов в здании: ");
        int entrance = scanner.nextInt();

        System.out.print("Введите нужную квартиру: ");
        int apartment = scanner.nextInt();

        scanner.close();

        getLocation(floor, entrance, apartment);
    }

    static void getLocation(int floors, int entrances, int apartment) {

        int apartmentsOnEntrance = floors * 4;
        int apartmentsCount = apartmentsOnEntrance * entrances;
        int entrancesCount = (apartment - 1) / apartmentsOnEntrance + 1;

        if (apartment > apartmentsCount) {
            System.out.println("err");
        }

        int floorCount;

        if (apartment % 4 == 0) {
            floorCount = (apartment / 4) - floors * (entrancesCount - 1);
        } else {
            floorCount = (apartment / 4 + 1) - floors * (entrancesCount - 1);
        }

        String location = switch (apartment % 4) {
            case (1) -> "слева от лифта, влево";
            case (2) -> "слева от лифта, вправо";
            case (3) -> "справа от лифта, влево";
            case (0) -> "справа от лифта, вправо";
            default -> "";
        };

        System.out.println(entrancesCount + " подъезд, " + floorCount + " этаж, " + location);

    }
}
