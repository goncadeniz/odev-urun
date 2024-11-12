package odev.controller;

import odev.entity.Urun;
import odev.repository.VeriDeposu;
import odev.service.UrunService;

import java.util.Scanner;

public class UrunController {
    private UrunService urunService=new UrunService();
    public void basla()
    {
        int secim;

        do {
            secim=secimYap();
            switch (secim)
            {

                case 1:urunEkle(); break;
                case 2:urunSatistanKaldir(); break;
                case 3:urunBul(); break;
                case 4: urunListele(); break;
                case 5: urunSatildi(); break;
                case 6:urunGiris(); break;
                case 0:
                    System.out.println("Çıkış yapıldı");
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız ");
            }

        }while(secim!=0);
    }


    private int secimYap()
    {
        System.out.println("ürün takip sistemi");
        System.out.println("""
                1-ürün ekle 
                2- ürün satistan kaldır 
                3-ürün bul 
                4-ürün listele 
                5-ürün satildi
                6-ürün girişi
                0-çıkış
         
                """);
        System.out.println("Lütfen seçiniz ......");
        int secim=new Scanner(System.in).nextInt();
        return secim;
    }

    public void urunEkle()
    {
        System.out.println("Ürünün adı ");
        String ad=new Scanner(System.in).nextLine();
        System.out.println( "Ürünün markası ");
        String marka=new Scanner(System.in).nextLine();
        System.out.println("Ürünün modeli  :");
        String model=new Scanner(System.in).nextLine();
        System.out.println("Ürünün stok sayısı ");
        int stok=new Scanner(System.in).nextInt();
       urunService.urunEkle(ad,marka,model,stok);

    }

    public void urunSatistanKaldir()
    {
        System.out.println("ürünün sıra numarası ");
        int siraNo=new Scanner(System.in).nextInt();
        urunService.urunSatistanKaldir(siraNo);

    }

    public void urunBul()
    {
        System.out.println("ürünün müşteri bilgisi ");
        String ad=new Scanner(System.in).nextLine();
        urunService.urunBul(ad);
    }



    public void urunListele()
    {
        urunService.urunListeleAktif();
    }

    public void urunSatildi()
    {
        System.out.println("Sıra numarasını giriniz ");
        int siraNo=new Scanner(System.in).nextInt();
        System.out.println("Ürün adetini giriniz ");
        int adet=new Scanner(System.in).nextInt();
        urunService.urunSatildi(siraNo, adet);
    }
    public void urunGiris()
    {
        System.out.println("Eklencek ürünün sıra numarasını  giriniz ");
        int siraNo=new Scanner(System.in).nextInt();
        System.out.println("Eklenecek ürün miktarı ");
        int sayi=new Scanner(System.in).nextInt();
       urunService.urunGiris(siraNo, sayi);
    }
}
