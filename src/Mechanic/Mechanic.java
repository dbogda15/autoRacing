package Mechanic;
import Transport.Transport;
import Transport.Car;
import Transport.Bus;
import Transport.Truck;


import java.util.Arrays;
import java.util.Objects;

public class Mechanic  {


    private final String name;
    private final String lastName;
    private final String company;
    private final Access access;

    public enum Access {
        CAR ("mechanic can only work with passenger cars"),
        BUS ("mechanic can only work with buses"),
        TRUCK ("mechanic can only work with trucks"),
        ALL ("mechanic can work with all cars");

        private final String access;

        Access(String access) {
            this.access = access;
        }

        public String getAccess() {
            return access;
        }
    }


    public Mechanic (String name, String lastName, String company, Access access) {

        if (Objects.isNull(name) || name.isBlank()) {
            this.name = "*undetermined name*";
        } else {
            this.name = name;
        }

        if (Objects.isNull(lastName) || lastName.isBlank()) {
            this.lastName = "*undetermined lastname*";
        } else {
            this.lastName = lastName;
        }

        if (Objects.isNull(company) || company.isBlank()) {
            this.company = "Undetermined company";
        } else {
            this.company = company;
        }
        if (Objects.isNull(access)) {
            this.access = Access.ALL;
        } else {
            this.access = access;
        }
    }

//    public void performMaintenance(Transport ... transports) {
//        if (Objects.equals(access, Access.ALL)) {
//            System.out.println("\n\nMechanic " + getName() + " " + getLastName() + " can perform maintenance ");
//            System.out.print(Arrays.toString(transports));
//        }
//    }
//
//    public void performMaintenance(Car...cars) {
//        if (access == Access.CAR && Objects.equals(Car.class, Transport.class)) {
//            System.out.println("\nMechanic " + getName() + " " + getLastName() + " can perform maintenance ");
//            System.out.print(Arrays.toString(cars));
//        }
//        else {
//            System.out.println("\nMechanic " + getName() + " " + getLastName() + " can't perform maintenance, because there is only access to cars.");
//        }
//    }
//
//    public void performMaintenance(Bus...buses) {
//        if (Objects.equals(access, Access.BUS) && Objects.equals(Bus.class, Transport.class)) {
//            System.out.println("\n\nMechanic " + getName() + " " + getLastName() + " can perform maintenance ");
//            System.out.print(Arrays.toString(buses));
//        }else {
//            System.out.println("\n\nMechanic " + getName() + " " + getLastName() + " can't perform maintenance, because there is only access to buses. ");
//        }
//    }
//
//    public void performMaintenance(Truck... trucks) {
//        if (Objects.equals(access, Access.TRUCK) && Objects.equals(Truck.class, Transport.class)) {
//            System.out.println("\nMechanic " + getName() + " " + getLastName() + " can perform maintenance ");
//            System.out.print(Arrays.toString(trucks));
//        }else {
//            System.out.println("\n\nMechanic " + getName() + " " + getLastName() + " can't perform maintenance, because there is only access to trucks ");
//
//        }
//    }

    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public String getCompany() {
        return company;
    }


    public Access getAccess() {
        return access;
    }

    @Override
    public String toString() {
        return "Mechanic " + getName() + " " + getLastName() + ", works for company \"" + getCompany() + "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(lastName, mechanic.lastName) && Objects.equals(company, mechanic.company) && access == mechanic.access;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, company, access);
    }
}
