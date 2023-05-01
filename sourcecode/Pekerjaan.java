import java.util.Random;
import java.util.Scanner;

public class Pekerjaan {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan jumlah sim: ");
            final int jumlahSims = scanner.nextInt();
            // Inisialisasi nilai konstanta
            final int jumlahPekerjaan = 5;
            final int waktuKerja = 720; // 12 jam kerja

            // Inisialisasi data pekerjaan
            String[] jobs = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter"};
            int[] gajiHarian = {15, 30, 35, 45, 50};
            int[] waktuganti = {-1, -1, -1, -1, -1};
            String[] Pekerjaan = new String[jumlahSims];
            int[] gajiSim = new int[jumlahSims];
            int[] gantiHari = new int[jumlahSims];

            // Inisialisasi pekerjaan acak untuk setiap sim
            Random random = new Random();
            for (int i = 0; i < jumlahSims; i++) {
                int jobIndex = random.nextInt(jumlahPekerjaan);
                Pekerjaan[i] = jobs[jobIndex];
                gajiSim[i] = gajiHarian[jobIndex];
            }

            // Simulasi pekerjaan
            for (int minute = 1; minute <= waktuKerja; minute++) {
                for (int i = 0; i < jumlahSims; i++) {
                    // Jika sim bisa mengganti pekerjaan, lakukan penggantian pekerjaan
                    if (gantiHari[i] == -1 && minute >= 720) {
                        int currentJobIndex = -1;
                        for (int j = 0; j < jumlahPekerjaan; j++) {
                            if (Pekerjaan[i].equals(jobs[j])) {
                                currentJobIndex = j;
                                break;
                            }
                        }
                        int newJobIndex = random.nextInt(jumlahPekerjaan);
                        while (newJobIndex == currentJobIndex) {
                            newJobIndex = random.nextInt(jumlahPekerjaan);
                        }
                        int newJobSalary = gajiHarian[newJobIndex];
                        int changeCost = newJobSalary / 2;
                        if (gajiSim[i] >= changeCost) {
                            Pekerjaan[i] = jobs[newJobIndex];
                            gajiSim[i] = newJobSalary;
                            gantiHari[i] = minute / 1440 + 1; // Jumlah hari + 1
                        }
                    }
                    // Jika sim tidak bisa mengganti pekerjaan, kurangi hari sebelum bisa mengganti pekerjaan
                    else if (gantiHari[i] != -1) {
                        gantiHari[i]--;
                    }
                }
            }

            // Output hasil pekerjaan
            for (int i = 0; i < jumlahSims; i++) {
                System.out.println("Sim " + (i + 1) + " bekerja sebagai" + Pekerjaan[i] + " dengan gaji " + gajiSim[i]);
            }
        }
    }
}

