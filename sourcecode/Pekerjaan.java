import java.util.ArrayList;
import java.util.Random;

public class Pekerjaan{
    public String [] pekerjaan;
    private static String [] namaPekerjaan =
    {
        "Badut Sulap",
        "Koki",
        "Polisi",
        "Programmer",
        "Dokter",
        "Penulis",
        "Arsitek",
        "Barista",
        "Wartawan",
        "Hakim"
    };
    private static int [] gajis = {
        15,
        30,
        35,
        45,
        50,
        30,
        40,
        20,
        40,
        45
    };

    public Pekerjaan(){
        this.pekerjaan = new String [1];
        this.pekerjaan[0] = getRandomPekerjaan();
    }

    public String getPekerjaan(){
        return pekerjaan[0];
    }
    public int getGaji(){
        int index = getIndexPekerjaan(pekerjaan[0]);
        return gajis[index];
    }
    public void setGantiPekerjaan (String pekerjaanBaru){
        int index = getIndexPekerjaan(pekerjaanBaru);
        if (index != -1){
            pekerjaan[0] = pekerjaanBaru;
        } else {
            System.out.println("Pekerjaan tidak tersedia");
        }
    }

    String getRandomPekerjaan(){
        int randomIndex = (int) (Math.random() * namaPekerjaan.length);
        return namaPekerjaan[randomIndex];
    }

    public void printPekerjaan() {
        System.out.println("pekerjaan: " + getPekerjaan());
    }

    public void printDaftarPekerjaan() {
        System.out.println("Daftar pekerjaan:");
        System.out.println("1. Badut Sulap");
        System.out.println("2. Koki");
        System.out.println("3. Polisi");
        System.out.println("4. Programmer");
        System.out.println("5. Dokter");
        System.out.println("6. Penulis");
        System.out.println("7. Arsitek");
        System.out.println("8. Barista");
        System.out.println("9. Wartawan");
        System.out.println("10. Hakim");
    }

    public void printGaji() {
        System.out.println("Gaji: " + getGaji());
    }
    
    private int getIndexPekerjaan(String pekerjaan){
        for( int i = 0; i < namaPekerjaan.length; i++){
            if (namaPekerjaan[i].equals(pekerjaan)){
                return i;
            }
        }
        return -1;
    }


    public static void main (String[] args) {
        Pekerjaan pekerjaan = new Pekerjaan();
        pekerjaan.getRandomPekerjaan();
        pekerjaan.printPekerjaan();
        pekerjaan.printGaji();
        pekerjaan.setGantiPekerjaan("Hakim");
        pekerjaan.printPekerjaan();
        pekerjaan.printGaji();
    }
}
