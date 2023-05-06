import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Waktu {
    private int day;
    private int time;
    private int day1;
    private int time1;
    private boolean isIdle;
    private int trackTidur;
    private int trackToilet;
    private int trackBarang;

    public Waktu() {
        this.isIdle = false;
    }
    public int day(){
        return this.day;
    }
    
    public int getDay(){
        return this.day;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return this.time;
    }

    public void setDay(int day){
        this.day = day;
    }

    public boolean getIsIdle(){
        return this.isIdle;
    }

    public void setIsIdle(boolean isIdle){
        this.isIdle = isIdle;
    }

    public int getDay1(){
        return this.day1;
    }

    public void setDay1(int day1){
        this.day1 = day1;
    }

    public int getTime1(){
        return this.time1;
    }

    public void setTime1(int time1){
        this.time1 = time1;
    }

    public void trackKirimBarang(){
        getRandomWaktu();
        if (getTime() == getRandomWaktu()) {
            System.out.println("Barang sudah diterima");
        }
    }

    public void cekTime() {
        
    }

    public void doAksi() {
        Thread threadBekerja = new Thread() {
            @Override
            public void run() {
                int randomWaktu = getRandomWaktu();
                int startTime = getTime1();
                int endTime = startTime + randomWaktu;

                // Tunggu hingga waktu selesai aksi
                while (getTime() != randomWaktu) (

                )
                if(getTime() == randomWaktu){
                    System.out.println("Barang telah sampai dan dimasukkan ke dalam inventory");
                }
                // while (getTime1() < endTime) {
                //     try {
                //         TimeUnit.SECONDS.sleep(1);
                //         setTime1(getTime1() + 1);
                //         // System.out.println("Waktu: " + getTimeString(waktu.getTime() % 720));
                //     } catch (InterruptedException e) {
                //         e.printStackTrace();
                //     }
                // }

                // Periksa sisa waktu
                // int elapsedTime = getTime1() - startTime;

                // if (getTime1() >= 720) {
                //     // Waktu sudah habis, lanjut ke hari berikutnya
                //     setDay1(getDay1() + 1);
                //     setTime1(elapsedTime);
                //     // System.out.println("Waktu habis, lanjut ke hari ke-" + waktu.getDay());
                // } else {
                //     if (getTime() == randomWaktu) {
                //         System.out.println("Barang telah sampai dan dimasukkan ke dalam inventory");

                //     }
                // }

                // Set isIdle to true
                setIsIdle(true);
            }
        };
        threadBekerja.start();
    }
    public void doAksi1(int x) {
        int startTime = getTime();
        int endTime = startTime + x;
        // tunggu hingga waktu selesai aksi
        while (getTime() < endTime) {
            try {
                TimeUnit.SECONDS.sleep(1);
                setTime(getTime()+1);
                System.out.println("Waktu: " + getTimeString(getTime()%720));
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // periksa sisa waktu
        int elapsedTime = getTime() - startTime;

        if (getTime() >= 720) {
            // waktu sudah habis, lanjut ke hari berikutnya
            setDay(getDay()+1);
            setTime(elapsedTime);
            System.out.println("Waktu habis, lanjut ke hari ke-" + getDay());
        } else {
            System.out.println("Waktu saat ini: " + getTimeString(getTime()));
        }
                // set isIdle to true
        setIsIdle(true);
    }

    public void idle() {
        if (this.isIdle) return;

        int startTime = this.time;

        while (this.isIdle) {
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
            // System.out.println("Waktu saat ini: " + getTimeString(this.time));
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
        int randomWaktu = durations[index];
        System.out.println("Waktu paket akan sampai " + randomWaktu + " detik");
        return randomWaktu;
    }
}
