package pl.edu.wat.mspw_frontend.interfaces;

public class Item {
    private final int id;
    private final String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // Metoda toString zwraca tylko nazwę
    @Override
    public String toString() {
        return name;
    }
}
