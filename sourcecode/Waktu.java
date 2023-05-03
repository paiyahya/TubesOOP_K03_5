import java.util.concurrent.TimeUnit;
import java.util.Random;

public class   Waktu {
    private int day;
    private int time;

    public void doAksi(int x) {
        // lakukan aksi yang diinginkan
        // misalnya: upgrade rumah
        // catat waktu mulai aksi
        int startTime = this.time;

        // hitung waktu selesai aksi
        int endTime = startTime + x;

        // tunggu hingga waktu selesai aksi
        while (this.time < endTime) {
            try {
                TimeUnit.SECONDS.sleep(1);
                this.time++;
                System.out.println("Waktu: " + getTimeString(this.time%720));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // periksa sisa waktu
        int elapsedTime = this.time - startTime;

        if (this.time >= 720) {
            // waktu sudah habis, lanjut ke hari berikutnya
            this.day++;
            this.time = elapsedTime;
            System.out.println("Waktu habis, lanjut ke hari ke-" + this.day);
        } else {
            System.out.println("Waktu saat ini: " + getTimeString(this.time));
        }
    }

    public String getWaktuSaatIni() {
        return getTimeString(this.time);
    }

    public void printWaktu() {
        System.out.println("Waktu saat ini: " + getWaktuSaatIni());
    }

    private String getTimeString(int time) {
        int hours = time / 60;
        int minutes = time % 60;
        return String.format("%02d:%02d", hours, minutes);
    }
    public int getRandomWaktu() {
        Random random = new Random(System.currentTimeMillis());
        int[] durations = {30, 60, 90, 120, 150};
        int index = random.nextInt(durations.length);
        return durations[index];
    }

    // public static void main(String[] args) {
    //     Waktu waktu = new Waktu();
    //     waktu.printWaktu();
    //     waktu.doAksi(waktu.getRandomWaktu());
    //     waktu.printWaktu();
    // }
}