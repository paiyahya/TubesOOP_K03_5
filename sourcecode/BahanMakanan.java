public class BahanMakanan {
    private String bahanMakanan;
    private int harga;
    private int kekenyangan;

    public BahanMakanan(String bahanMakanan, int harga, int kekenyangan) {
        this.bahanMakanan = bahanMakanan;
        this.harga = harga;
        this.kekenyangan = kekenyangan;
    }

    public String getBahanMakanan() {
        return bahanMakanan;
    }

    public void setBahanMakanan(String bahanMakanan) {
        this.bahanMakanan = bahanMakanan;
    }

    public int getHarga() {
        return harga;
    }

    public int getKekenyangan() {
        return kekenyangan;
    }

    public void masakBahanMakanan() {
        System.out.println("Memasak " + bahanMakanan);
    }

    public void showJenisBahanMakanan() {
        System.out.println("Bahan Makanan: " + bahanMakanan + ", Harga: " + harga + ", Kekenyangan: " + kekenyangan);
    }
}
