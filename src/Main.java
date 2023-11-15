import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество этажей в здании: ");
        int floorQuantity = scanner.nextInt();

        System.out.print("Введите количество подъездов в здании: ");
        int entranceQuantity = scanner.nextInt();

        System.out.print("Введите нужную квартиру: ");
        int apartment = scanner.nextInt();

        scanner.close();

        printLocation(floorQuantity, entranceQuantity, apartment);
    }

    static void printLocation(int floorQuantity, int entrancesQuantity, int apartment) {
        int apartmentsEntranceCount = floorQuantity * 4;
        int apartmentsCount = apartmentsEntranceCount * entrancesQuantity;
        int entrancesCount = (apartment - 1) / apartmentsEntranceCount + 1;
        final int apartmensQuantityFloor = 4;

        if (apartment > apartmentsCount) {
            System.out.println("err");
            return;
        }

        int floorCount;

        if (apartment % apartmensQuantityFloor == 0) {
            floorCount = (apartment / apartmensQuantityFloor) - floorQuantity * (entrancesCount - 1);
        } else {
            floorCount = (apartment / apartmensQuantityFloor + 1) - floorQuantity * (entrancesCount - 1);
        }

        String location = switch (apartment % apartmensQuantityFloor) {
            case (0) -> "справа от лифта, вправо";
            case (1) -> "слева от лифта, влево";
            case (2) -> "слева от лифта, вправо";
            case (3) -> "справа от лифта, влево";
            default -> "";
        };

        System.out.println(entrancesCount + " подъезд, " + floorCount + " этаж, " + location);
    }
}
