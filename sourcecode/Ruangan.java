import java.util.Scanner;

public class Ruangan {
    private String nama;
    private String[][] matriks;

    public Ruangan(String nama) {
        this.nama = nama;
        this.matriks = new String[6][6];
        // mengisi matriks dengan 0 yang menandakan posisi kosong
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriks[i][j] = ".";
            }
        }
    }

    public void print() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                //matriks[i][j] = angka++;
                System.out.print(String.format("%2s ", matriks[i][j]));
            }
            System.out.println();
        }
        // for (int i = 0; i < 6; i++) {
        //     for (int j = 0; j < 6; j++) {
        //         if (matriks[i][j] == 0) {
        //             System.out.print(" . ");
        //         } else {
        //             System.out.print(String.format("%2d ", matriks[i][j]));
        //         }
        //     }
        //     System.out.println();
        // }
    }

    public void tambahObjek(int x, int y, String objek) {
        if (x < 0 || x >= 6 || y < 0 || y >= 6) {
            System.out.println("Posisi tidak valid!");
        } else if (!(this.matriks[x][y].equals("."))) {
            System.out.println("Posisi sudah terisi!");
        } else {
            this.matriks[x][y] = objek;
        }
    }

    public void hapusObjek(int x, int y) {
        if (x < 0 || x >= 6 || y < 0 || y >= 6) {
            System.out.println("Posisi tidak valid!");
        } else if (matriks[x][y].equals(".")) {
            System.out.println("Posisi kosong!");
        } else {
            matriks[x][y] = ".";
        }
    }

    public String getNama() {
        return nama;
    }

    public Ruangan getKoneksi(int arah) {
        return null;
    }

    public void setKoneksi(int arah, Ruangan ruanganTerhubung) {
    }


    public void mintaInputLokasi(int panjang, int lebar, String barang, String posisi){
        Scanner input = new Scanner(System.in);
        //int inc = 1;
        // for (int i = 0; i < 6; i++) {
        //     for (int j = 0; j < 6; j++) {
        //         System.out.print(String.format("%2d ", inc));
        //         inc++;
        //     }
        //     System.out.print("\n");
        // }
        print();
        System.out.print("Masukkan x: ");
        int x = input.nextInt();
        System.out.print("Masukkan y: ");
        int y = input.nextInt();
        String simbolOBJ = "";
        if( (x+panjang <= 5) && (y+lebar <= 5) && checkRuangan(x, y, panjang, lebar, posisi) ){
            switch (barang) {
                case "Kasur Single":
                    simbolOBJ = "S";
                    break;
                case "Kasur Queen Size":
                    simbolOBJ = "Q";
                    break;
                case "Kasur King Size":
                    simbolOBJ = "K";
                    break;
                case "Toilet":
                    simbolOBJ = "W";
                    break;
                case "Kompor Gas":
                    simbolOBJ = "G";
                    break;
                case "Kompor Listrik":
                    simbolOBJ = "L";
                    break;
                case "Meja dan Kursi":
                    simbolOBJ = "M";
                    break;
                case "Jam":
                    simbolOBJ = "J";
                    break;
                case "Treadmill":
                    simbolOBJ = "T";
                    break;
                case "Gitar":
                    simbolOBJ = "G";
                    break;
                case "Sapu":
                    simbolOBJ = "P";
                    break;
                case "Tv":
                    simbolOBJ = "V";
                    break;
                case "Sajadah":
                    simbolOBJ = "D";
                    break;
                case "Buku":
                    simbolOBJ = "B";
                    break;
                case "Baju":
                    simbolOBJ = "U";
                    break;
            
                default:
                    break;
            }
            for(int i =  x; i <  x+panjang; i++){
                for(int j = y; j < y+lebar; j++){
                    if(posisi.equals("horizontal")) tambahObjek(i,j , simbolOBJ);
                    if(posisi.equals("vertikal"))  tambahObjek(j,i , simbolOBJ);
                }
            }
        }else{
            System.out.println("Lokasi tidak valid");
        }
        
    }

    public Boolean checkRuangan(int x, int y, int panjang, int lebar, String posisi){
    
        for(int i =  x; i <  x+panjang; i++){
            for(int j = y; j < y+lebar; j++){
                if(posisi.equals("horizontal")) if(!matriks[i][j].equals(("."))) return false;
                if(posisi.equals("vertikal"))  if(!matriks[j][i].equals(("."))) return false;
                
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ruangan kamar = new Ruangan("Kamar");
        kamar.mintaInputLokasi(1,4,"Kasur Single", "horizontal");
        kamar.mintaInputLokasi(3, 3, "Meja dan Kursi", "horizontal");
        kamar.print();
    }
}