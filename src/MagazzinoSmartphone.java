import java.util.ArrayList;

public class MagazzinoSmartphone {
    private ArrayList<Smartphone> smartphones;
    private static final int LENGHT = 10;

    public MagazzinoSmartphone() {
        smartphones = new ArrayList<Smartphone>(LENGHT); // Assuming initial capacity of 10
        
    }

    public MagazzinoSmartphone(MagazzinoSmartphone other) {
        this();
        if (other != null) {
            for (int i = 0; i < other.smartphones.size(); i++) {
                addSmartphone(other.smartphones.get(i));
            }
        }
    }

    public void addSmartphone(Smartphone smartphone) {
        if (smartphone != null && smartphones.size() < LENGHT) {
            smartphones.add(new Smartphone(smartphone));
        }

    }
    //IL REMOVE DELLA CLASSE ARRAYLIST CERCA DI USARE L'EQUALS DELLA CLASSE DEL PARAMETRO PASSATO PER TROVARE L'OGGETTO, SE NON LO TROVA USA L'EQUALS DI DEFAULT
    public void removeSmartphone(Smartphone smartphone) {
        smartphones.remove(smartphone);
        
    }

    public Smartphone[] getSmartphonesArray() {
        Smartphone[] smartphoneArray = new Smartphone[smartphones.size()];
        System.arraycopy(smartphones, 0, smartphoneArray, 0, smartphones.size());
        return smartphoneArray;
    }

    public Smartphone getSmartphoneByBrand(String brand) {
        Smartphone smartphone = null;
        boolean trovato = false;
        int i = 0;
        while (i < smartphones.size() && !trovato) {
            if (smartphones.get(i).getBrand().equals(brand)) {
                smartphone = new Smartphone(smartphones.get(i));
            }
            i++;
        }

        return smartphone;
    }

    public MagazzinoSmartphone getSmartphonesByStorageCapacity(int storageCapacity) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        boolean trovato = false;

        for (int i = 0; i < smartphones.size(); i++) {
            if (smartphones.get(i).getStorageCapacity() == storageCapacity) {
                magazzinoSmartphone.addSmartphone(smartphones.get(i));
            }
        }

        return magazzinoSmartphone;
    }

    public MagazzinoSmartphone getSmartphonesByPriceRange(double minPrice, double maxPrice) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();

        for (int i = 0; i < smartphones.size(); i++) {
            if (smartphones.get(i).getPrice() >= minPrice && smartphones.get(i).getPrice() <= maxPrice) {
                magazzinoSmartphone.addSmartphone(smartphones.get(i));
            }
        }

        return magazzinoSmartphone;
    }

    @Override
    public String toString() {
        String result = "\nMagazzinoSmartphone:\n\n";

        for (int i = 0; i < smartphones.size(); i++) {
            result += smartphones.get(i).toString();
        }
        return result;
    }

    public boolean equals(Object obj) {
        boolean output = false;
        int i = 0;
        if (this == obj) {
            output = true;
        } else {
            if (obj instanceof MagazzinoSmartphone && ((MagazzinoSmartphone) obj).smartphones.size() == smartphones.size()) {
                output = true;
                while (i < ((MagazzinoSmartphone) obj).smartphones.size() && output) {
                    if (!((MagazzinoSmartphone) obj).smartphones.get(i).equals(smartphones.get(i))) {
                        output = false;
                    }
                    i++;
                }
            }
        }
        return output;
    }

}
