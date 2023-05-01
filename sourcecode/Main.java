import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        World world = new World(64, 64);
        Sim sim = new Sim(null, null, 100, 80, 80, "idle", 80);
        System.out.println("Masukkan nama sim: ");
        Scanner input = new Scanner(System.in);
        String nama = input.nextLine();
        sim.setNama(nama);
        // world.tambahRumah(null, null);
        System.out.println("Masukkan nama rumah: ");
        String namaRumah = input.nextLine();
        // world.tambahRumah(nama, null);
        System.out.println("Masukkan posisi x rumah: ");
        // Scanner inputRumah = new Scanner(System.in);
        int x = input.nextInt();
        System.out.println("Masukkan posisi y rumah: ");
        int y = input.nextInt();
        Rumah rumah = new Rumah(x, y);
        world.tambahRumah(nama, rumah);
        Barang barang = new Barang(x);
        input.nextLine();
        // boolean state = !sim.isSimDead();
        while(!sim.isSimDead()) { 
            System.out.println("Silahkan pilih aksi yang ingin dijalankan: ");
            System.out.println("1. View Sim info");
            System.out.println("2. View Current Location");
            System.out.println("3. View Inventory");
            System.out.println("4. Upgrade House");
            System.out.println("5. Move Room");
            System.out.println("6. Edit Room");
            System.out.println("7. Add SIM");
            System.out.println("8. Change SIM");
            System.out.println("9. List Object");
            System.out.println("10. Go To Object");
            System.out.println("11. Action");
            System.out.println("12. Help");
            System.out.println("13. Exit");

            Integer nomor = input.nextInt();
            if (nomor.equals(1)) {
                System.out.println("Nama SIM: " + sim.getNama());
                System.out.println("Kekenyangan anda: " + sim.getKekenyangan());
                System.out.println("Kesehatan anda: " + sim.getKesehatan());
                System.out.println("Mood anda: " + sim.getMood());
                System.out.println("Pekerjaan anda: " + sim.getPekerjaan());
                System.out.println("Status anda: " + sim.getAksi());
                input.nextLine();
            }
            else if (nomor.equals(2)) {
                world.printWorld();
                world.printRumah();
                System.out.println("Saat ini "+ sim.getNama() + " berada dalam " + namaRumah + " Pada koordinat " + rumah.getX() + "," + rumah.getY());
            }
            else if (nomor.equals(3)) {
                barang.printBarangInventory();
            }
            else if (nomor.equals(4)) {
                
            }
            else if (nomor.equals(5)) {
                
            }
            else if (nomor.equals(6)) {
                
            }
            else if (nomor.equals(7)) {
                
            }
            else if (nomor.equals(8)) {
                
            }
            else if (nomor.equals(9)) {
                
            }
            else if (nomor.equals(10)) {
                barang.printBarangRuangan();
            }
            else if (nomor.equals(11)) { 
                //Menu ini digunakan untuk Sim berjalan menuju suatu objek.
                //Jika menuju ke objek tersebut dapat melakukan aksi
                System.out.println("Pilih objek yang ingin dituju: ");
                barang.printBarangRuangan();
                int nomor1 = input.nextInt();
                
            }
            else if (nomor.equals(12)) {
                System.out.println(""); //arahan permainan
            } 
            else if (nomor.equals(13)) {
                // boolean sim.isSimDead() = true;
            }
            else {
                System.out.println("Input tidak valid");
            }
            input.nextLine();
        }
    }
}