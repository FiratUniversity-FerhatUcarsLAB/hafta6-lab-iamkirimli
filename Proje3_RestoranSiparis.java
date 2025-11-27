/*
Öğrenci Adı Soyadı: Mehmet Ali Kırımlı
Öğrenci No: 250542027
Ödev: Not Sistemi
*/

import java.util.Scanner;

public class odev_6_3_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AKILLI RESTORAN SİPARİŞ SİSTEMİ ===");
        
        //Ana yemek seçimi yapılmak için bilgilerin yer aldığı kod bloğu
        System.out.println("\n1. Ana Yemekler:");
        System.out.println("1: Izgara Tavuk - 85 TL");
        System.out.println("2: Adana Kebap - 120 TL");
        System.out.println("3: Levrek - 110 TL");
        System.out.println("4: Manti - 65 TL");
        System.out.print("Ana Yemek Secimi (1-4): ");
        int anaYemekSecim = scanner.nextInt();
        
        //Başlangıç seçimi yapılmak için bilgilerin yer aldığı kod bloğu
        System.out.println("\n2. Baslangiclar:");
        System.out.println("1: Corba - 25 TL");
        System.out.println("2: Humus - 45 TL");
        System.out.println("3: Sigara Boregi - 55 TL");
        System.out.print("Baslangic Secimi (1-3): ");
        int baslangicSecim = scanner.nextInt();
        
        //İçecek seçimi yapılmak için bilgilerin yer aldığı kod bloğu
        System.out.println("\n3. Icecekler:");
        System.out.println("1: Kola - 15 TL");
        System.out.println("2: Ayran - 12 TL");
        System.out.println("3: Taze Meyve Suyu - 35 TL");
        System.out.println("4: Limonata - 25 TL");
        System.out.print("Icecek Secimi (1-4): ");
        int icecekSecim = scanner.nextInt();

        //Tatlı seçimi yapılmak için bilgilerin yer aldığı kod bloğu
        System.out.println("\n4. Tatlilar:");
        System.out.println("1: Kunefe - 65 TL");
        System.out.println("2: Baklava - 55 TL");
        System.out.println("3: Sutlac - 35 TL");
        System.out.print("Tatli Secimi (1-3): ");
        int tatliSecim = scanner.nextInt();

        //Saat seçimi yapılan kod bloğu
        System.out.print("\nSaat (8-23): ");
        int saat = scanner.nextInt();

        //Kullanıcıdan öğrenci değeri alınan kod bloğu
        System.out.print("Ogrenci misiniz? (E/H): ");
        String ogrenciCevap = scanner.next();
        boolean ogrenciMi = ogrenciCevap.equalsIgnoreCase("E");

        //Kullanıcıdan gün değeri alınan kod bloğu
        System.out.print("Hangi gun? (1-7): ");
        int gun = scanner.nextInt();

        //Yemek seçimlerinin yapıldığı metot kod bloğu
        double anaYemekFiyat = getMainDishPrice(anaYemekSecim);
        double baslangicFiyat = getAppetizerPrice(baslangicSecim);
        double icecekFiyat = getDrinkPrice(icecekSecim);
        double tatliFiyat = getDessertPrice(tatliSecim);
        
        //Combo menu hesabi indirim için boolean değişkenleri
        boolean anaYemekVar = anaYemekFiyat > 0;
        boolean icecekVar = icecekFiyat > 0;
        boolean tatliVar = tatliFiyat > 0;

        double araToplam = anaYemekFiyat + baslangicFiyat + icecekFiyat + tatliFiyat;
        
        System.out.println("\nHesaplama:");
        System.out.printf("- Ara toplam: %.2f TL\n", araToplam);
        
        //Combo indirimi hesaplayan metot kod bloğu
        boolean comboVar = isComboOrder(anaYemekVar, icecekVar, tatliVar);
        double comboIndirimi = calculateDiscount(araToplam, comboVar, false, 0);
        
        //İndirimlere göre ekranlara çıktıları yazdıran kod blokları
        if (comboIndirimi > 0) {
            System.out.printf("- Combo indirimi: %%15 -> -%.2f TL\n", comboIndirimi);
        }
        
        //İndirimlere göre ekranlara çıktıları yazdıran kod blokları
        double happyHourIndirimi = calculateDiscount(icecekFiyat, false, false, saat);
        
        //İndirimlere göre ekranlara çıktıları yazdıran kod blokları
        if (happyHourIndirimi > 0) {
            System.out.printf("- Happy hour (icecek): %%20 -> -%.2f TL\n", happyHourIndirimi);
        }
        
        double kalanTutar = araToplam - comboIndirimi - happyHourIndirimi;

        //Öğrenci İndirimini doğrulayan ve hesaplayan kod bloğu
        boolean haftaIci = gun <= 5;
        boolean ogrenciIndirimiHakki = ogrenciMi && haftaIci;
        
        double ogrenciIndirimi = calculateDiscount(kalanTutar, false, ogrenciIndirimiHakki, 0);
        
        if (ogrenciIndirimi > 0) {
            System.out.printf("- Ogrenci indirimi: %%10 -> -%.2f TL\n", ogrenciIndirimi);
        }

        double toplamTutar = kalanTutar - ogrenciIndirimi;

        if (!comboVar && !ogrenciIndirimiHakki && happyHourIndirimi == 0 && araToplam > 200) {
             double indirim200 = calculateDiscount(araToplam, false, false, 0); 
             if(indirim200 > 0) {
                 System.out.printf("- 200 TL üzeri indirimi: %%10 -> -%.2f TL\n", indirim200);
                 toplamTutar -= indirim200;
             }
        }

        System.out.printf("- Toplam: %.2f TL\n", toplamTutar);

        double bahsis = calculateServiceTip(toplamTutar);
        System.out.printf("- Bahsis onerisi: %.2f TL (%%10)\n", bahsis);
    }

    
    //Ana yemek secimi metotu
    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            default: return 0;
        }
    }
    
    //Başlangıç yemek secimi metotu
    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            default: return 0;
        }
    }
    
    //İçecek secimi metotu
    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;
            case 2: return 12;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }
    //Tatlı secimi metotu
    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            default: return 0;
        }
    }

    //Combo sipariş indirimi kontrol eden metot
    public static boolean isComboOrder(boolean anaVar, boolean icecekVar, boolean tatliVar) {
        if (anaVar && icecekVar && tatliVar) {
            return true;
        } else {
            return false;
        }
    }

    
    //Happy hour sipariş indirimi kontrol eden metot
    public static boolean isHappyHour(int saat) {
        if (saat >= 14 && saat <= 17) {
            return true;
        } else {
            return false;
        }
    }

    //Toplam indirimleri hesaplayan metot
    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat) {
        if (combo) {
            return tutar * 0.15;
        } else if (isHappyHour(saat)) { 
            return tutar * 0.20;
        } else if (ogrenci) {
            return tutar * 0.10;
        } else if (tutar > 200 && saat == 0) { 
            return tutar * 0.10;
        } else {
            return 0;
        }
    }

    //Bahşiş değerini hesaplayan metot
    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }
}
