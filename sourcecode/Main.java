import java.util.Scanner;

public class Main{

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
        world.printWorld();
        world.printRumah();
        input.nextLine();
        System.out.println("Saat ini "+ sim.getNama() + " berada dalam " + namaRumah + " Pada koordinat " + rumah.getX() + "," + rumah.getY());
        // boolean state = !sim.isSimDead();
        while(!sim.isSimDead()) { 
            System.out.println("Silahkan pilih aksi yang ingin dijalankan: ");
            System.out.println("1. View Sim info");
            System.out.println("2. View Current Location");
            System.out.println("3. View Inventory");
            System.out.println("4. Upgrade House");
            System.out.println("5. Move House");
            System.out.println("6. Edit Room");
            System.out.println("7. Add SIM");
            System.out.println("8. Change SIM");
            System.out.println("9. List Object");
            System.out.println("10. Go To Object");
            System.out.println("11. Action");
            System.out.println("12. Help");
            System.out.println("13. Exit");

            int nomor = input.nextInt();
            if (nomor == 1) {

            }
            else if (nomor == 2) {
                System.out.println(""); //arahan permainan
            }
            else if (nomor == 3) {
                
            }
            else if (nomor == 4) {
                
            }
            else if (nomor == 5) {
                
            }
            else if (nomor == 6) {
                
            }
            else if (nomor == 7) {
                
            }
            else if (nomor == 8) {
                
            }
            else if (nomor == 9) {
                
            }
            else if (nomor == 10) {
                
            }
            else if (nomor == 11) {
                
            }
            else if (nomor == 12) {
                
            } 
            else if (nomor == 13) {
                
            }
        }
    }
}