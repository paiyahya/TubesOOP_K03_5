import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rumah {
    private int x;
    private int y;
    private int panjangRumah;
    private int lebarRumah;
    // private Ruangan ruanganUtama;
    private String namaRuangan;
    private static List<Ruangan> listRuanganRumah;

    public Rumah(int x, int y) {
        this.x = x;
        this.y = y;
        this.listRuanganRumah = new ArrayList<>();
        setDefaultRuangan();
        // Membuat ruangan pertama berukuran 6x6
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNamaRuangan(){
        return namaRuangan;
    }

    public void setPanjangRumah(int panjangRumah){
        this.panjangRumah = panjangRumah;
    }

    public void setLebarRumah(int lebarRumah){
        this.lebarRumah = lebarRumah;
    }
    
    public int getPanjangRumah() {
        return panjangRumah;
    }

    public int getLebarRumah(){
        return lebarRumah;
    }

    public static List<Ruangan> getListRuanganRumah() {
        return listRuanganRumah;
    }

    // public void tambahRuangan(String namaRuangan, int x, int y) {
    //     // Menambahkan ruangan baru ke dalam listRuanganRumah
    //     Ruangan ruangan = new Ruangan(namaRuangan, 6, 6);
    //     listRuanganRumah.add(ruangan);
    // }

    public static void printListRuanganRumah(){
        int i = 1;
        
        System.out.println("Daftar ruangan yang ada di rumah: ");
         for(Ruangan ruangan : listRuanganRumah){
            System.out.println(i+". "+ruangan.getNamaRuangan());
            i++;
         }
    }

    public static void setRuangan(){
        String namaRuangan;
        System.out.print("Masukkan nama ruangan : ");
        Scanner scan2 = new Scanner(System.in);
        namaRuangan = scan2.nextLine();
        Ruangan ruanganPertama = new Ruangan(namaRuangan,6, 6);
        getListRuanganRumah().add(ruanganPertama);
    }

    public void setDefaultRuangan(){
        Ruangan ruanganPertama = new Ruangan("Kamar",6, 6);
        getListRuanganRumah().add(ruanganPertama);
    }

    public void PilihRuangan(){
        int pilihan;
        System.out.print("Pilih ruangan yang ingin diakses : ");
        Scanner scan3 = new Scanner(System.in);
        pilihan = scan3.nextInt();
        getListRuanganRumah().get(pilihan-1).tampilkanRuangan();
    }

    public void tambahRuangan(Sim sim){
        Ruangan currentRoom = sim.getRuangan();
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan arah ruangan yang ingin dibuat: ");
        System.out.println("1. Atas");
        System.out.println("2. Bawah");
        System.out.println("3. Kanan");
        System.out.println("4. Kiri");
        int arah = scan.nextInt();
        if(arah == 1){
            //misal nama variable untuk nyimpen nama ruangan itu "currentRoom"
            if(currentRoom.getRuanganTetangga().get(0) == null) // bikin getter ruangan tetangga yg ngereturn ruangan 
            {
                System.out.print("Masukkan nama ruangan: ");
                String namaRuangan = scan.nextLine();
                // System.out.print("Masukkan panjang ruangan: ");
                // int panjang = scan.nextInt();
                // System.out.print("Masukkan lebar ruangan: ");
                // int lebar = scan.nextInt();
                Ruangan ruanganBaru = new Ruangan(namaRuangan, 6, 6);
                currentRoom.addRoom(0, ruanganBaru);
                ruanganBaru.addRoom(0, currentRoom);
            }
            else
            {
                System.out.println("Sudah terdapat ruangan di lokasi tersebut. Silakan pilih lokasi lain!"); //bisa tinggal diganti
            }
        }
        else if(arah == 2){
            //misal nama variable untuk nyimpen nama ruangan itu "currentRoom"
            if(currentRoom.getRuanganTetangga().get(1) == null)
            {
                System.out.print("Masukkan nama ruangan: ");
                String namaRuangan = scan.nextLine();
                // System.out.print("Masukkan panjang ruangan: ");
                // int panjang = scan.nextInt();
                // System.out.print("Masukkan lebar ruangan: ");
                // int lebar = scan.nextInt();
                Ruangan ruanganBaru = new Ruangan(namaRuangan, 6, 6);
                currentRoom.addRoom(1, ruanganBaru);
                ruanganBaru.addRoom(1, currentRoom);
            }
            else
            {
                System.out.println("Ruangan sudah ada");
            }
        }
        if(arah == 3){
            //misal nama variable untuk nyimpen nama ruangan itu "currentRoom"
            if(currentRoom.getRuanganTetangga().get(2) == null)
            {
                System.out.print("Masukkan nama ruangan: ");
                String namaRuangan = scan.nextLine();
                // System.out.print("Masukkan panjang ruangan: ");
                // int panjang = scan.nextInt();
                // System.out.print("Masukkan lebar ruangan: ");
                // int lebar = scan.nextInt();
                Ruangan ruanganBaru = new Ruangan(namaRuangan, 6, 6);
                currentRoom.addRoom(2, ruanganBaru);
                ruanganBaru.addRoom(2, currentRoom);
            }
            else
            {
                System.out.println("Ruangan sudah ada");
            }
        }
        if(arah == 4){
            //misal nama variable untuk nyimpen nama ruangan itu "currentRoom"
            if(currentRoom.getRuanganTetangga().get(3) == null)
            {
                System.out.print("Masukkan nama ruangan: ");
                String namaRuangan = scan.nextLine();
                // System.out.print("Masukkan panjang ruangan: ");
                // int panjang = scan.nextInt();
                // System.out.print("Masukkan lebar ruangan: ");
                // int lebar = scan.nextInt();
                Ruangan ruanganBaru = new Ruangan(namaRuangan, 6, 6);
                currentRoom.addRoom(3, ruanganBaru);
                ruanganBaru.addRoom(3, currentRoom);
            }
            else
            {
                System.out.println("Ruangan sudah ada");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan X: ");
        int x = scan.nextInt();
        System.out.print("Masukkan Y: ");
        int y = scan.nextInt();
        while(x < 6 || y < 6)
        {
            System.out.println("Rumah terlalu kecil! Masukkan kembali x dan y");
            System.out.print("Masukkan X: ");
            x = scan.nextInt();
            System.out.print("Masukkan Y: ");
            y = scan.nextInt();
        }
        Rumah rumah = new Rumah(x, y);
        // setRuangan();
        // rumah.printListRuanganRumah();
        // setRuangan();
        // Ruangan ruangan = new Ruangan("Kamar Tidur", 6, 6);
        // getListRuanganRumah().add(ruangan);
        rumah.printListRuanganRumah();
        rumah.PilihRuangan();
        // ruangan.tambahBarang("Kasur Single");
        // ruangan.tampilkanRuangan();
        // ruangan.tambahBarang("Meja dan Kursi");
        // ruangan.tampilkanRuangan();
        // ruangan.tambahBarang("Jam");
        // ruangan.tampilkanRuangan();
        // ruangan.printBarangRuangan();
    } 
}