
public class Smartphone implements Comparable<Smartphone> { //da un indicazione al compilatore che la compareTo si aspetta un arraylist di tipo smartphone
    private String brand;
    private String model;
    private int storageCapacity;
    private double price;

    public Smartphone() {
        storageCapacity = 0;
        price = 0;
    };

    public Smartphone(String brand, String model, int storageCapacity, double price) {
        this();
        setBrand(brand);
        setModel(model);
        setStorageCapacity(storageCapacity);
        setPrice(price);
    }

    public Smartphone(Smartphone other) {
        this(other.getBrand(), other.getModel(), other.getStorageCapacity(), other.getPrice());
    }

    public void setBrand(String brand) {
        this.brand = new String(brand);
    }

    public void setModel(String model) {
        this.model = new String(model);
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Brand: " + getBrand() + ", Model: " + getModel() + ", Storage Capacity: " + getStorageCapacity()
                + ", Price: " + getPrice() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        boolean output = false;
        if (this == obj) {
            output = true;
        } else {
            if (obj instanceof Smartphone) {
                if (this != null) {
                    if (((Smartphone) obj).getBrand() != null && this.getBrand() != null
                            && ((Smartphone) obj).getModel() != null && this.getModel() != null
                            && ((Smartphone) obj).getBrand().equals(this.getBrand())
                            && ((Smartphone) obj).getModel().equals(this.getModel())
                            && ((Smartphone) obj).getStorageCapacity() == this.getStorageCapacity()
                            && ((Smartphone) obj).getPrice() == this.getPrice()) {
                        output = true;
                    } else if (((Smartphone) obj).getStorageCapacity() == this.getStorageCapacity()
                            && ((Smartphone) obj).getPrice() == this.getPrice()
                            && this.getBrand() == ((Smartphone) obj).getBrand()
                            && this.getModel() == ((Smartphone) obj).getModel()) {
                        output = true;
                    }
                }
            }
        }

        return output;
    }
    //implementazione metodo compareTo(Smartphone a) poer confrontare due oggetti
    //il primo oggetto è più grande del secondo --> risultato 1
    //il primo oggetto è uguale al secondo --> risultato 0
    //il primo oggetto è minore del secondo --> risultato -1
    public int compareTo(Smartphone s){
        int risultato = 0;
            if (getPrice() > s.getPrice()){
                 risultato = 1;
            }
            else if (getPrice() < s.getPrice()){
                risultato = -1;
            }
        

        return risultato;

    }

}
