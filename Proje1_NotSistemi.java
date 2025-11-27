/*
Öğrenci Adı Soyadı: Mehmet Ali Kırımlı
Öğrenci No: 250542027
Ödev: Not Sistemi
*/

import java.util.Scanner;

public class odev_6_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Kullanıcıdan değerleri aldığımız kod bloğu.
		System.out.print("Vize Notunu Girin: ");
		double vizeNot = scanner.nextDouble();
		System.out.print("Final Notunu Girin: ");
		double finalNot = scanner.nextDouble();
		System.out.print("Ödev Notunu Girin: ");
		double odevNot = scanner.nextDouble();
		
		//Metotların geriye döndürdüğü değerleri değişkenlere atayan kod bloğu.
		double notOrtalama = ort(vizeNot, finalNot, odevNot);
		String gectiKaldi = gectiMi(notOrtalama);
		String harfNot = harfNotu(notOrtalama);
		String onurListesi = onurListe(notOrtalama, vizeNot, finalNot, odevNot);
		String butunlemeHakki = butHakki(notOrtalama);
		
		
		//Formatlama ile çıktıların düzgün bir şekilde ekrana yazdırılması.
		System.out.println("\n=== ÖĞRENCİ NOT RAPORU ===");
		System.out.printf("Vize Notu    : %.1f", vizeNot);
		System.out.printf("\nFinal Notu   : %.1f", finalNot);
		System.out.printf("\nÖdev Notu    : %.1f", odevNot);
		System.out.println("\n--------------------------");
		System.out.printf("Ortalama     : %.1f\n", notOrtalama);
		System.out.println("Harf Notu    : " + harfNot);
		System.out.println("Durum        : " + gectiKaldi);
		System.out.println("Onur Listesi : " + onurListesi);
		System.out.println("Bütünleme    : " + butunlemeHakki);
		
		scanner.close();
	}
	
	//Girilen Notların Ortalamasını Hesaplayan ve Geriye Double Değer Döndüren Metot.
	public static double ort(double vize, double finalNot, double odev) {
		double ortalama = (vize*0.3)+(finalNot*0.4)+(odev*0.3);
		return ortalama;
	}
	
	//Girilen Notların Ortalamasına Göre Geçtiğine Yada Kaldığına Karar Veren ve Geriye String Değer Döndüren Metot.
	public static String gectiMi(double ortalama) {
		if (ortalama>=50) {
			return "Geçti";
		}
		else {
			return "Kaldı";
		}
	}
	
	//Girilen Notların Ortalamasına Göre Harf Notunu Hesaplayan ve Geriye String Değer Döndüren Metot.
	public static String harfNotu(double ortalama) {
		if (ortalama>=90) {
			return "A";
		}
		else if (ortalama>=80 && ortalama<90) {
			return "B";
		}
		else if (ortalama>=70 && ortalama<80) {
			return "C";
		}
		else if (ortalama>=60 && ortalama<70) {
			return "D";
		}
		else{
			return "F";
		}
	}
	
	//Girilen Notların Ortalamasına ve Girilen Notlara Göre Öğrencinin Onur Listesini Hak Edip Etmediğini Hesaplayan Metot.
	public static String onurListe(double ortalama, double vize, double finalNot, double odev) {
		if (ortalama >= 85 && vize > 70 && finalNot > 70 && odev > 70) {
			return "Evet";
		}
		else {
			return "Hayır";
		}
	}
	
	//Girilen Notların Ortalamasına Göre Öğrencinin Büte Kalıp Kalmadığını Hesaplayıp Geriye String Değer Döndüren Method.
	public static String butHakki(double ortalama) {
		if (ortalama>=40 && ortalama<=50) {
			return "Var";
		}
		else {
			return "Yok";
		}
	}

}
