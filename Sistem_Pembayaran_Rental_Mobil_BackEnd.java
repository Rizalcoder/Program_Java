package Program_Java;

import java.util.Scanner;
public class Sistem_Pembayaran_Rental_Mobil_BackEnd {
  public static void main (String[] AlgoritmaUtama) {
    // DEKLARASI
            // deklarasi scanner
            Scanner angka = new Scanner (System.in);
            Scanner jenisvariabelstr = new Scanner (System.in);

            // input dari keyboard
            long DP;
            long HargaSewa;
            byte LamaHari;
            char JenisMobil;
            int StatusMember;
            int Keterlambatan;

            // input lainnya
            long Biaya_Keterlambatan;
            long Denda;
            long Total_Sewa;
            long Nominal_Diskon;
            long Sewa_Setelah_Kena_Diskon;
            long Total_Tagihan;
            long Total_Bayar;

            float Persentase_Diskon;

            String Keterangan_Member = "";
            String Keterangan_Jenis_Mobil = "";
            String jawab = "";

            

        // DESKRIPSI
            // read 6 variabel
            do {

                 System.out.println("Masukkan nominal uang muka atau DP : ");
                    DP = angka.nextLong();
    System.out.println();
                System.out.println("Masukkan nominal harga sewa : ");
                    HargaSewa = angka.nextLong();
    System.out.println();
                
                // pengulangan lama hari harus lebih dari 0
                do {
                    System.out.println("Masukkan lama hari : ");
                        LamaHari = angka.nextByte();
                } while (LamaHari <= 0); 
                
    System.out.println();

                // tabel pemilihan jenis mobil
                do {
                    System.out.println("------------------------------------");
                    System.out.println("        J E N I S  M O B I L        ");
                    System.out.println("------------------------------------");
            System.out.println();
                    System.out.println("A = city car");
                    System.out.println("B = MPV");
            System.out.println();
                        System.out.println("Masukkan jenis mobil : ");
                            JenisMobil = jenisvariabelstr.next().charAt(0);
                } while (JenisMobil != 'A' && JenisMobil != 'a' && JenisMobil != 'B' && JenisMobil != 'b');

                    // percabangan jenis mobil
                        if (JenisMobil == 'A' || JenisMobil == 'a') {
                            Keterangan_Jenis_Mobil = "A (citi car)";
                        } else if (JenisMobil == 'B' || JenisMobil == 'b') {
                            Keterangan_Jenis_Mobil = "B (MPV)";
                        } else {
                            Keterangan_Jenis_Mobil = "Anda salah input hannya A atau B";
                        }
            
             


                // tabel pemilihan jenis member
                do {
                    System.out.println("----------------------------------------");
                    System.out.println("        J E N I S  M E M B E R          ");
                    System.out.println("----------------------------------------");
                System.out.println();
                    System.out.println("1 = member");
                    System.out.println("0 = nonmember");
            System.out.println();
                        System.out.println("Masukkan jenis member anda : ");
                            StatusMember = angka.nextInt();
                } while (StatusMember != 1 && StatusMember != 0);
System.out.println();

                // keterlambatan tidak boleh negatif
                do {
                    System.out.println("berapa jam keterlambatannya? gunakan bilangan [+]");
                        Keterlambatan = angka.nextInt();
                } while (Keterlambatan < 0);

                    // percabangan jenis member
                        if (StatusMember == 1) {
                            Keterangan_Member = "1 (Member)";
                        } else {
                            Keterangan_Member = "0 (Non Member)";
                        }
                    

                
                // perhitungan
                    // biaya keterlambatan 
                    if (Keterlambatan > 0) {
                        Biaya_Keterlambatan = Keterlambatan * 25000;
                    } else {
                        Biaya_Keterlambatan = 0;
                    }
                    
                    // biaya denda
                    Denda = Biaya_Keterlambatan;

                    // total sewa
                    Total_Sewa = HargaSewa * LamaHari;

                    // jenis diskon berdasarkan member
                    if (StatusMember == 1) {
                        if (Total_Sewa > 1000000) {
                            Persentase_Diskon = 0.20f;
                        } else if (Total_Sewa > 500000 && Total_Sewa <= 1000000) {
                            Persentase_Diskon = 0.15f;
                        } else if (Total_Sewa <= 500000) {
                            Persentase_Diskon = 0.05f;
                        } else {
                            Persentase_Diskon = 0f;
                        }
                    } else {
                        if (Total_Sewa > 1000000) {
                            Persentase_Diskon = 0.10f;
                        } else if (Total_Sewa > 500000 && Total_Sewa <= 1000000) {
                            Persentase_Diskon = 0.05f;
                        } else if (Total_Sewa <= 500000) {
                            Persentase_Diskon = 0f;
                        } else {
                            Persentase_Diskon = 0f;
                        }
                    }

                    // cari nominal diskon
                    Nominal_Diskon = (long) (Total_Sewa * Persentase_Diskon);
                    Sewa_Setelah_Kena_Diskon = Total_Sewa - Nominal_Diskon;
                    Total_Tagihan = Sewa_Setelah_Kena_Diskon + Denda;
                    Total_Bayar = Total_Tagihan - DP;


                    // OUTPUT
                    System.out.println("======================================================");
                    System.out.println("|        R I N C I A N  P E M B A Y A R A N          |");
                    System.out.println("======================================================");
                System.out.println();
                    System.out.println("Nominal DP                              = Rp. " +DP);
                    System.out.println("Harga sewa per hari                     = Rp. " +HargaSewa);
                    System.out.println("Lama hari                               = " +LamaHari+" hari");
                    System.out.println("Jenis mobil                             = " +Keterangan_Jenis_Mobil);
                    System.out.println("Status member                           = " +Keterangan_Member);
                    System.out.println("berapa jam keterlambatan                = " +Keterlambatan+" jam");
                System.out.println();
                    System.out.println("total biaya keterlambatan               = Rp. " +Biaya_Keterlambatan);
                    System.out.println("nominal denda                           = Rp. " +Denda);
                    System.out.println("total sewa                              = Rp. " +Total_Sewa);
                    System.out.println("persentase dikon                        = " +(long) (Persentase_Diskon * 100)+ " %");
                    System.out.println("nominal potongan harga atau diskon      = Rp. " +Nominal_Diskon);
                    System.out.println("biaya sewa setelah diskon               = Rp. " +Sewa_Setelah_Kena_Diskon);
                    System.out.println("total tagihan                           = Rp. " +Total_Tagihan);
                    System.out.println("total pembayaran                        = Rp. " +Total_Bayar);


                System.out.println("Apakah anda ingin menambahkan data baru?? [ y / t ]");
                jenisvariabelstr.nextLine();
                    jawab = jenisvariabelstr.nextLine();
System.out.println();
System.out.println();
            } while (jawab.equals("y") || jawab.equals("Y"));
               

            // Close Scanner
            // angka.close();
            // jenisvariabelstr.close();
  }
  
}
