/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje2;

import java.util.ArrayList;


/**
 *
 * @author Batuhan Sevinç
 */
public class DVD {

   private String adSoyad;
   private String dvdBaslık;
   private int cıkısTarih;
   private int fiyat;
   private ArrayList<String> sarkılar=new ArrayList<>();
   
   
   
   
  
  
    public DVD(){
        
        this(null, null,0, 0);
    }
     public DVD(String adSoyad, String dvdBaslık, int cıkısTarih, int fiyat, ArrayList<String> sarkılar) {
        this.adSoyad = adSoyad;
        this.dvdBaslık = dvdBaslık;
        this.cıkısTarih = cıkısTarih;
        this.fiyat = fiyat;
        this.sarkılar=sarkılar;
    }
     DVD(String adSoyad, String dvdBaslık, int cıkısTarih){
        this.adSoyad = adSoyad;
        this.dvdBaslık = dvdBaslık;
        this.cıkısTarih = cıkısTarih;
     }
    
    public DVD(String adSoyad, String dvdBaslık, int cıkısTarih, int fiyat) {
        this.adSoyad = adSoyad;
        this.dvdBaslık = dvdBaslık;
        this.cıkısTarih = cıkısTarih;
        this.fiyat = fiyat;
    }

   

    
    public String getAdSoyad() {
        return adSoyad;
    }

  
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

  
    public String getDvdBaslık() {
        return dvdBaslık;
    }

    public void setDvdBaslık(String dvdBaslık) {
        this.dvdBaslık = dvdBaslık;
    }

 
    public int getCıkısTarih() {
        return cıkısTarih;
    }

   
    public void setCıkısTarih(int cıkısTarih) {
        this.cıkısTarih = cıkısTarih;
    }

    public int getFiyat() {
        return fiyat;
    }

    
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

  
    public ArrayList<String> getSarkılar() {
        return sarkılar;
    }

   
    public void setSarkılar(ArrayList<String> sarkılar) {
        this.sarkılar = sarkılar;
    }

    

   
}
