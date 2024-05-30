public class CasiUsoArrayList {
    public static void main(String[] args) throws Exception {
        //casi d'uso con il mio equals (utilizzato dalla classe ArrayList) e senza il mio equals (PER TESTARE)
        MagazzinoSmartphone prova = new MagazzinoSmartphone();
        Smartphone provaSmart = new Smartphone("Apple", "G502", 105, 300);
        prova.addSmartphone(provaSmart);
        System.out.println(prova);
        prova.removeSmartphone(provaSmart);
        System.out.println(prova);



    }
}
