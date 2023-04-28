import java.util.concurrent.TimeUnit;

public class Waktu {
    private int day;
    private int time;

    public Waktu() {
        this.day = 1;
        this.time = 720; // 12 menit
    }

    public void checkTime() {
        System.out.println("Hari ke-" + this.day);
        System.out.println("Waktu tersisa: " + getTimeString(this.time));
        // tambah aksi aksi
    }

    public void doAksi() {
        // lakukan aksi yang diinginkan
        // misalnya: upgrade rumah
        // catat waktu mulai aksi
        int startTime = this.time;

        // tunggu selama waktu yang ditentukan
        try {
            TimeUnit.MINUTES.sleep(18); // contoh: upgrade rumah membutuhkan 18 menit
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // periksa sisa waktu
        int elapsedTime = startTime - this.time;
        if (elapsedTime >= 720) {
            // waktu sudah habis, lanjut ke hari berikutnya
            this.day++;
            this.time = 720;
            System.out.println("Waktu habis, lanjut ke hari ke-" + this.day);
        } else {
            System.out.println("Upgrade rumah berhasil dilakukan");
            System.out.println("Waktu tersisa: " + getTimeString(this.time));
        }
    }

    public void startGame() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.time > 0) {
                this.time--;
            } else {
                // waktu habis, lanjut ke hari berikutnya
                this.day++;
                this.time = 720;
                System.out.println("Waktu habis, lanjut ke hari ke-" + this.day);
            }
        }
    }

    private String getTimeString(int seconds) {
        int minute = seconds / 60;
        int second = seconds % 60;

        String minuteString = (minute < 10 ? "0" : "") + minute;
        String secondString = (second < 10 ? "0" : "") + second;

        return minuteString + ":" + secondString;
    } // buat waktu

    public static void main(String[] args) {
        Waktu game = new Waktu();

        // mulai game di thread baru
        Thread gameThread = new Thread(() -> game.startGame());
        gameThread.start();

        // lakukan aksi di thread utama
        game.checkTime();
        game.doAksi();
        game.checkTime();
    }
}

