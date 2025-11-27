/*
Öğrenci Adı Soyadı: Mehmet Ali Kırımlı
Öğrenci No: 250542027
Ödev: Not Sistemi
*/

import java.util.Scanner;

public class odev_6_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Kullanıcıdan switch case ile gün değerini alan kod bloğu.
		System.out.println("1-Pazartesi");
		System.out.println("2-Salı");
		System.out.println("3-Çarşamba");
		System.out.println("4-Perşembe");
		System.out.println("5-Cuma");
		System.out.println("6-Cumartesi");
		System.out.println("7-Pazar");
		System.out.print("Gün Seçiniz: ");
		int gun = scanner.nextInt();
		System.out.println("");
		int secilenGun = 0;
		
		switch (gun) {
		case 1:
			secilenGun=1;
			break;
		case 2:
			secilenGun=2;
			break;
		case 3:
			secilenGun=3;
			break;
		case 4:
			secilenGun=4;
			break;
		case 5:
			secilenGun=5;
			break;
		case 6:
			secilenGun=6;
			break;
		case 7:
			secilenGun=7;
			break;
		default:
			System.out.println("Lütfen Geçerli Bir Sayı Girin.");
		}
		
		//Kullanıcıdan saat bilgisini alan kod bloğu.
		System.out.print("Bilet Saatini Giriniz: ");
		int saat = scanner.nextInt();
		System.out.println("");
		
		//Kullanıcıdan switch case ile meslek değerini alan kod bloğu.
		System.out.println("1-Öğrenci");
		System.out.println("2-Öğretmen");
		System.out.println("3-Diğer");
		System.out.print("Meslek Seçiniz: ");
		int meslek = scanner.nextInt();
		System.out.println("");
		int meslekSecilen = 0;
		
		switch (meslek) {
		case 1:
			meslekSecilen=1;
			break;
		case 2:
			meslekSecilen=2;
			break;
		case 3:
			meslekSecilen=3;
			break;
		default:
			System.out.println("Lütfen Geçerli Bir Değer Girin");
		}
		
		System.out.print("Lütfen Yaşınızı Girin: ");
		int yas = scanner.nextInt();
		System.out.println("");
		
		//Kullanıcıdan switch case ile film türü değerini alan kod bloğu.
		System.out.println("1-2D");
		System.out.println("2-3D");
		System.out.println("3-IMAX");
		System.out.println("4-4DX");
		System.out.print("Lütfen Film Türü Seçiniz: ");
		int film = scanner.nextInt();
		System.out.println("");
		int filmSecimi = 0;
		
		switch (film) {
		case 1:
			filmSecimi=1;
			break;
		case 2:
			filmSecimi=2;
			break;
		case 3:
			filmSecimi=3;
			break;
		case 4:
			filmSecimi=4;
			break;
		default:
			System.out.println("Lütfen Geçerli Bir Değer Girin.");
		}
		
		//Metotları çalıştırığp değerleri değişknelere atıyan kod blokları.
		double temelUcret = temelUcretHesapla(secilenGun, saat);
		double indirimOrani = indirimHesapla(yas, meslekSecilen, secilenGun);
		double filmFormatUcret = filmFormatUcreti(filmSecimi);
		double toplamBiletFiyat = toplamFiyat(indirimOrani, filmFormatUcret, temelUcret);
		biletBilgisi(secilenGun, saat, yas, meslekSecilen, filmSecimi, temelUcret, indirimOrani, filmFormatUcret, toplamBiletFiyat);
		
		scanner.close();

	}
	
	//Girilen gün ve saat değerlerine göre temel ücreti hesaplayan metot.
	public static double temelUcretHesapla(int gun, int saat) {
		double biletUcret;
		if (gun<=5 && saat<=12) {
			biletUcret = 45;
		}
		else if (gun<=5 && saat>12) {
			biletUcret = 65;
		}
		else if (gun>5 && saat<=12) {
			biletUcret = 55;
		}
		else {
			biletUcret = 85;
		}
		return biletUcret;
	}
	
	//Yaş, meslek ve seçilen güne göre indirimi hesaplayan metot.
	public static double indirimHesapla(int yas, int meslek, int gun) {
		double indirim = 0;
		if (meslek == 1 && (gun == 1 || gun == 4)) {
			indirim = 0.2;
		}
		else if (meslek == 1 && (gun == 6 || gun == 7)) {
			indirim = 0.15;
		}
		else if (yas>=65) {
			indirim = 0.3;
		}
		else if (yas<=12) {
			indirim = 0.25;
		}
		else if (meslek == 2 && gun ==3) {
			indirim = 0.35;
		}
		return indirim;
	}
	
	//Film formatına göre ekstra ücreti belirleyen metot.
	public static double filmFormatUcreti(int filmsecimi) {
		double ekstraUcret=0;
		if (filmsecimi == 2) {
			ekstraUcret = 25;
		}
		else if (filmsecimi == 3) {
			ekstraUcret = 35;
		}
		else if(filmsecimi == 4) {
			ekstraUcret = 50;
		}
		else {
			ekstraUcret = 0;
		}
		return ekstraUcret;
	}
	
	//İndirim ve film formatına göre en son ödenecek fiyatı hesaplayan metot.
	public static double toplamFiyat(double indirim, double ekstraUcret, double temelFiyat) {
		double indirimUcreti = temelFiyat*indirim;
		double biletFinalUcret = temelFiyat-indirimUcreti+ekstraUcret;
		return biletFinalUcret;
	}
	
	//Bilgileri ekrana yazdıran geriye değer döndürmeyen metot.
	public static void biletBilgisi(int gun, int saat, int yas, int meslek, int filmTuru, double temelUcret, double indirimOrani, double filmFormatUcret, double toplamUcret) {
		System.out.println("Gün (1-7)          : " + gun);
		System.out.println("Saat (08:00-23:00) : " + saat);
		System.out.println("Yaş                : " + yas);
		System.out.println("Meslek             : " + meslek);
		System.out.println("Film Türü          : " + filmTuru);
		System.out.println("======= Hesaplama =======");
		System.out.printf("Temel Ücret = %.2f Tl\n", temelUcret);
		System.out.printf("Uygulanan İndirim = %.2f Tl \n", (temelUcret*indirimOrani));
		System.out.printf("Seçilen Film Türü Ekstra Ücret = %.2f Tl\n", filmFormatUcret);
		System.out.printf("Toplam Fiyat = %.2f Tl\n", toplamUcret);
	}

}
