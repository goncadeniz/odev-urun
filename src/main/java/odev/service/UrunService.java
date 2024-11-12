package odev.service;

import odev.entity.Urun;
import odev.repository.VeriDeposu;

public class UrunService {

    public void urunEkle( String ad,String marka,String model,int  stok)
    {
        Urun urun=new Urun();
        urun.siraNo= VeriDeposu.sayac+1;
        urun.ad= ad;
        urun.marka= marka;
        urun.model= model;
        urun.stok=stok;
        urun.isActive=true;
        VeriDeposu.urunListesi[VeriDeposu.sayac++]=urun;


    }

    public void urunSatistanKaldir(int siraNo)
    {
        VeriDeposu.urunListesi[siraNo-1].isActive = false;
    }

    public void urunBul(String ad)
    {
        for(int i=0;i<VeriDeposu.sayac;i++){
           Urun urun=VeriDeposu.urunListesi[i];
            if(urun.isActive && urun.ad.toLowerCase().contains(ad.toLowerCase())){
                urunYazdir(urun);
            }
        }
    }
    public void urunListeleAktif(){
       urunListele(true);
    }
    public void urunListelePasif(){
        urunListele(false);
    }


    public void urunListele(boolean isActive)
    {
        System.out.println("""
                ****** ürün  Listesi ******
                """);
        for(int i=0;i<VeriDeposu.sayac;i++){
            Urun urun= VeriDeposu. urunListesi[i];
            if(urun.isActive == isActive){
                urunYazdir(urun);
            }
        }

    }

    public void urunSatildi(int siraNo,int sayi){
      int stokSayisi= VeriDeposu.urunListesi[siraNo-1].stok;
      if(stokSayisi-sayi>=0)
      {
          VeriDeposu.urunListesi[siraNo-1].stok -= sayi;

      }

    }

    public void urunYazdir(Urun urun)
    {
        System.out.println("Ürün sıra no.......: "+ urun.siraNo );
        System.out.println("Ürün ad......: "+ urun.ad );
        System.out.println("Ürün marka.........: "+ urun.marka );
        System.out.println("Ürün model.......: "+ urun.model );
        System.out.println("Ürün stok..........: "+ urun.stok );

    }

    public void  urunGiris(int siraNo,int sayi)
    {
        VeriDeposu.urunListesi[siraNo-1].stok += sayi;

    }
}
