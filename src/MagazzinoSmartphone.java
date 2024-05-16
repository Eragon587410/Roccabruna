public class MagazzinoSmartphone {
    private Smartphone[] smartphones;
    private int count;

    public MagazzinoSmartphone() {
        smartphones = new Smartphone[10]; // Assuming initial capacity of 10
        count = 0;
    }

    public MagazzinoSmartphone(MagazzinoSmartphone other) {
        this();
        if (other != null) {
            for (int i = 0; i < other.getCount(); i++) {
                addSmartphone(other.smartphones[i]);
            }
        }
    }

    public void addSmartphone(Smartphone smartphone) {
        if (smartphone != null && getCount() < smartphones.length) {
            smartphones[getCount()] = new Smartphone(smartphone);
            count++;
        }

    }

    public void removeSmartphone(Smartphone smartphone) {
        boolean trovato = false;
        int posizione = 0;
        int i = 0;
        if (smartphone != null) {
            while (i < getCount() && !trovato) {
                if (this.smartphones[i].equals(smartphone)) {
                    trovato = true;
                    posizione = i;

                }
                i++;
            }
            if (trovato) {
                for (int j = posizione; j < getCount() - 1; j++) {
                    smartphones[j] = smartphones[j + 1];
                }
                smartphones[getCount() - 1] = null;
                count--;
            }
        }
    }

    public Smartphone[] getSmartphonesArray() {
        Smartphone[] smartphoneArray = new Smartphone[count];
        System.arraycopy(smartphones, 0, smartphoneArray, 0, count);
        return smartphoneArray;
    }

    public Smartphone getSmartphoneByBrand(String brand) {
        Smartphone smartphone = null;
        boolean trovato = false;
        int i = 0;
        while (i < getCount() && !trovato) {
            if (smartphones[i].getBrand().equals(brand)) {
                smartphone = new Smartphone(smartphones[i]);
            }
            i++;
        }

        return smartphone;
    }

    public MagazzinoSmartphone getSmartphonesByStorageCapacity(int storageCapacity) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        boolean trovato = false;

        for (int i = 0; i < getCount(); i++) {
            if (smartphones[i].getStorageCapacity() == storageCapacity) {
                magazzinoSmartphone.addSmartphone(smartphones[i]);
            }
        }

        return magazzinoSmartphone;
    }

    public MagazzinoSmartphone getSmartphonesByPriceRange(double minPrice, double maxPrice) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        boolean trovato = false;

        for (int i = 0; i < getCount(); i++) {
            if (smartphones[i].getStorageCapacity() >= minPrice && smartphones[i].getStorageCapacity() <= maxPrice) {
                magazzinoSmartphone.addSmartphone(smartphones[i]);
            }
        }

        return magazzinoSmartphone;
    }

    @Override
    public String toString() {
        String result = "\nMagazzinoSmartphone:\n";

        for (int i = 0; i < getCount(); i++) {
            result += smartphones[i].toString() + "\n";
        }
        return result;
    }

    public int getCount() {
        return count;
    }

    public boolean equals(Object obj) {
        boolean output = false;
        int i = 0;
        if (this == obj) {
            output = true;
        } else {
            if (obj instanceof MagazzinoSmartphone && ((MagazzinoSmartphone) obj).getCount() == getCount()) {
                output = true;
                boolean trovato = false;
                while (i < ((MagazzinoSmartphone) obj).getCount() && !trovato) {
                    if (!((MagazzinoSmartphone) obj).smartphones[i].equals(smartphones[i])) {
                        output = false;
                        trovato = true;
                    }
                    i++;
                }
            }
        }
        return output;
    }

}
