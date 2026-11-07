package Program_Java;

// Algoritma Sistem_Penyewaan_Kamera
import java.util.Scanner;
public class Sistem_Pembayaran_Sewa_Kamera_BackEnd {
    public static void main (String[] args) {
        // DEKLARASI
            //Scanner baru
            Scanner inputangka = new Scanner (System.in);

            //input variabel
            long DP;                    // Rp. 
            long HargaSewa;             // Rp. 
            byte JumlahKamera;          // kamera
            byte LamaHari;              // dalam hari
            byte Keterlambatan;         // dalam jam
            
            //variabel lainnya
            long denda;
            long totalSewa;
            long nominal_denda;
            long nominal_diskon;
            long Sewa_setelah_diskon;
            long Total_Pembayaran;
            String keterangan_denda = "";

            double diskon_persentase;



        // DESKRIPSI

            // input 5 variabel dari keyboard
                System.out.println("Masukkan nominal DP : ");
                    DP = inputangka.nextLong();
System.out.println();
                System.out.println("MMasukkan Harga Sewa : ");
                    HargaSewa = inputangka.nextLong();
System.out.println();
                System.out.println("Masukkan Jumlah Kamera : ");
                    JumlahKamera = inputangka.nextByte();
System.out.println();
                System.out.println("Masukkan Lama Hari : ");
                    LamaHari = inputangka.nextByte();
System.out.println();
                System.out.println("Masukkan Keterlambatan : ");
                    Keterlambatan = inputangka.nextByte();
System.out.println();
System.out.println();
System.out.println();
            
            

            // pengondisian
                //keterlambatan
                if (Keterlambatan > 0) {
                    denda = 15000;
                    nominal_denda = Keterlambatan * denda;
                    keterangan_denda = "Anda mendapat denda karena terlambat lebih dari ";
                } else {
                    denda = 0;
                    nominal_denda = Keterlambatan * denda;
                    keterangan_denda = "Kerja bagus, anda tidak dikenai denda, karena tidak terlambat selama ";
                }

                //perumusan total sewa setelah diketahui nominal denda
                totalSewa = (HargaSewa * JumlahKamera * LamaHari) + nominal_denda;

                //total sewa 
                if (totalSewa > 500000) {
                    diskon_persentase = 0.20;     
                } else if (totalSewa > 250000 && totalSewa <= 500000) {
                    diskon_persentase = 0.10;     
                } else {
                    diskon_persentase = 0;
                } 

                // rumus nominal diskon 
                nominal_diskon = (long) (totalSewa * diskon_persentase);


                //perumusan sewa setelah diskon setelah diketahui nominal diskon
                Sewa_setelah_diskon = totalSewa - nominal_diskon;

                //perumusan sisa pembayaran (Total_Pembayaran) setelah diketahui Sewa_setelah_diskon
                Total_Pembayaran = Sewa_setelah_diskon - DP;

System.out.println("");

                // OUTPUT
                System.out.println("=== RINCIAN PENYEWAAN KAMERA ===");
                System.out.println("DP                      = Rp. " +DP);
                System.out.println("Harga Sewa              = Rp. " +HargaSewa);
                System.out.println("Jumlah Kamera           = " +JumlahKamera+ " kamera");
                System.out.println("Lama Hari Penyewaan     = " +LamaHari+ " hari");
                System.out.println("Keterlambatan           = " +Keterlambatan+ " jam");
System.out.println();
                System.out.println("nominal denda                   = Rp. " +denda);
                System.out.println("keterangan denda        = " +keterangan_denda+ ", " +Keterlambatan+ "jam");
                System.out.println("Total Sewa              = Rp. " +totalSewa);
                System.out.println("Persentase diskon       = " + (diskon_persentase * 100) +" %");
                System.out.println("Potongan harga          = Rp. " +nominal_diskon);
                System.out.println("Sewa setelah diskon     = Rp. " +Sewa_setelah_diskon);
                System.out.println("Total Pembayaran akhir  = Rp.  " +Total_Pembayaran);
    }
}
