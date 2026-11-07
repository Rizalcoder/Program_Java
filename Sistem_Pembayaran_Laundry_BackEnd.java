package Program_Java;
/*
Studi kasus

Sebuah usaha laundry ingin membuat program untuk menghitung biaya pencucian, biaya tambahan layanan ekspres, diskon berdasarkan total transaksi, dan sisa pembayaran setelah uang muka.


Ketentuan soal
Buatlah program Java Non-OOP yang menerima 5 input dari keyboard:
1. DP — uang muka pembayaran.
2. HargaPerKg — harga laundry per kilogram.
3. BeratLaundry — berat pakaian dalam kilogram.
4. LayananEkspres — masukkan 1 jika menggunakan layanan ekspres atau 0 jika tidak.
5. LamaHari — lama pengerjaan laundry dalam hari.
Gunakan ketentuan berikut:

Biaya layanan ekspres
- Jika LayananEkspres == 1, tambahkan biaya ekspres sebesar Rp20.000.
- Jika LayananEkspres == 0, tidak ada biaya tambahan.
Diskon berdasarkan total biaya sebelum diskon
Kondisi	Ketentuan
Total biaya lebih dari Rp300.000	Diskon 15%
Total biaya lebih dari Rp150.000 sampai Rp300.000	Diskon 5%
Total biaya Rp150.000 atau kurang	Tidak mendapat diskon

Rumus perhitungan
- Total biaya = harga per kg × berat laundry + biaya ekspres.
- Nominal diskon = total biaya × persentase diskon.
- Biaya setelah diskon = total biaya − nominal diskon.
- Sisa pembayaran = biaya setelah diskon − DP.
Tugas kamu
- Buat deklarasi variabel dengan tipe data yang sesuai.
- Input kelima data menggunakan Scanner.
- Tampilkan tabel DATA MASUKAN.
- Gunakan percabangan untuk menentukan biaya ekspres.
- Gunakan percabangan bertingkat if-else if-else untuk menentukan diskon.
- Hitung semua nominal pembayaran.
- Tampilkan RINCIAN PEMBAYARAN LAUNDRY, termasuk status layanan ekspres, nominal diskon dalam rupiah, dan sisa pembayaran.

*/


import java.util.Scanner;

// Algoritma Menghitung_Biaya_Pencucian_Laundry
public class Sistem_Pembayaran_Laundry_BackEnd {
  public static void main (String[] AlgoritmaUTama) {
    // DEKLARASI
            // Scanner baru
            Scanner inputangka = new Scanner (System.in);


            // variabel Input dari piranti masukan
                long DP;
                long HargaPerKg;
                byte BeratLaundry;
                byte LayananEkspres;
                byte LamaHari;

            // variabel lainnya
                long TotalBiaya;
                long BiayaEkspres;
                long nominal_diskon;
                long Biaya_setelah_diskon;
                long Total_Pembayaran;          // sisa pembayaran pada soal\
                String Keterangan_Layanan = "";

                double persentase_diskon;





        // DESKRIPSI
            // read 5 variabel
            System.out.println("==============================================================");
            System.out.println("|                    D A T A  M A S U K K A N                |");
            System.out.println("==============================================================");
System.out.println();
            System.out.println("Masukkan Biaya Muka : ");
                System.out.print("Rp. "); DP = inputangka.nextLong();
System.out.println();
            System.out.println("Masukkan Harga Per Kg : "); 
                System.out.print("Rp. "); HargaPerKg = inputangka.nextLong();
System.out.println();
            System.out.println("Masukkan Berat kg Laundry : ");
                System.out.print("dalam satuan kg = ");BeratLaundry = inputangka.nextByte();  
System.out.println();

        // tipe layanan ekspress = 
        System.out.println("--- layanan ekspress ---");
        System.out.println("1. ya (ada tambahan biaya 20k)");
        System.out.println("2. tidak");

        do {
            System.out.println("Masukkan Tipe layanan ekspress = ");
                LayananEkspres = inputangka.nextByte();
        } while (LayananEkspres <= 0 || LayananEkspres > 2);

System.out.println();
            System.out.println("Masukkan lama hari : ");
                LamaHari = inputangka.nextByte();
            System.out.println("==============================================================");

            // Pengondisian semua
                // biaya ekspress
                    if (LayananEkspres == 1) {
                        BiayaEkspres = 20000;
                        Keterangan_Layanan = "Anda memimilih layanan ekspres dan dikenai charge biaya tambahan";
                    } else if (LayananEkspres ==0) {
                        BiayaEkspres = 0;
                        Keterangan_Layanan = "Anda tidak memimilih layanan ekspres";
                    } else {
                        BiayaEkspres = 0;
                        Keterangan_Layanan = "Anda tidak memimilih layanan ekspres";
                    }

                    // rumus Total biaya = 
                        TotalBiaya = HargaPerKg * BeratLaundry + BiayaEkspres;

                // total biaya diskon
                    if (TotalBiaya > 300000) {
                        persentase_diskon = 0.15;
                    } else if (TotalBiaya > 150000 && TotalBiaya <= 300000) {
                        persentase_diskon = 0.05;
                    } else if (TotalBiaya <= 150000) {
                        persentase_diskon = 0;
                    } else {
                        persentase_diskon = 0;
                    }

                    // rumus nominal diskon = 
                        nominal_diskon = (long) (TotalBiaya * persentase_diskon);

                    // rumus biaya setelah diskon = 
                        Biaya_setelah_diskon = TotalBiaya - nominal_diskon;

                    // rumus sisa pembayaran =  
                        Total_Pembayaran = Biaya_setelah_diskon - DP;


                    
                    // OUTPUT

                    System.out.println("=======================================================================");
                    System.out.println("            R I N C I A N  P E M B A Y A R A N  L A U N D R Y          ");
                    System.out.println("=======================================================================");
System.out.println();
                    System.out.println("nominal DP                              =Rp. " +DP);
                    System.out.println("nominal harga per kg                    =Rp. "+HargaPerKg);
                    System.out.println("berat laundry dalam kg                  =" +BeratLaundry+ " kg" );
                    System.out.println("status layanan ekspres                  =" +LayananEkspres);
                    System.err.println("keterangan layanan ekspres              =" +Keterangan_Layanan);
                    System.out.println("durasi waktu pencucian dalam hari       =" +LamaHari+ " hari");
System.out.println();
                    System.out.println("persentase diskon                       =" +persentase_diskon+ "%");
                    System.out.println("nominal diskon                          =Rp. "+nominal_diskon);
                    System.out.println("biaya setelah diskon                    =Rp. "+Biaya_setelah_diskon);
                    System.out.println("TOTAL KESELURUHAN PEMBAYARAN            =Rp. "+Total_Pembayaran);
  }
}
