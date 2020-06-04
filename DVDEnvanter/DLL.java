/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Batuhan Sevinç
 */

     class Node{
        int data;
        
        public Node prev;//önceki
        public Node next;//sonraki
        public DVD dvd;

        public Node(DVD dvd){
             this.dvd=dvd;

         }
        
        
        public Node(int d){
            data=d;
            prev=null;
            next=null;
        }
        public  Node(int object, Node node){
          data = object;    
          next= node;  
        } 
    
    }
public class DLL{

    boolean adsoyadkontrol;
    public  Node head;
    private Node ilk;
    private Node son;
    private int data;
     
    ArrayList<String> sarkılar =new ArrayList<String>();
  
    public Node lastNode(Node node){
        while(node.next!=null)
            node = node.next;
        return node;
    }
    //Doubly linked listte kullanılmak için yapılan silme metodu
     public int selectdelete(String adsoyad,String albümadi){
        Node bakılan=head;
        while (bakılan!=null) {            
            if (bakılan.dvd.getAdSoyad().toLowerCase().equals(adsoyad.toLowerCase()) && bakılan.dvd.getDvdBaslık().toLowerCase().equals(albümadi.toLowerCase())) {
                if (bakılan.prev==null) {
                    head=bakılan.next;
                    bakılan.next.prev=null;
                    data--;
                    return 1;
                } else if(bakılan.next==null) {
                    son=bakılan.prev;
                    bakılan.prev.next=null;
                    data--;
                    return 1;

                }else{
                    bakılan.prev.next=bakılan.next;
                    bakılan.next.prev=bakılan.prev;
                    data--;
                    return 1;
                }
            }
            bakılan=bakılan.next;
        }
        if (head==null) {
            return 0;
        }
        return -1;
    }
 //Doubly linked listte kullanılmak için yapılan ekleme metodu
    public void append(DVD new_data)
    {
        Node new_node = new Node(new_data);//eklencek
        Node last = head;//karşı
        new_node.next = null;

        if(last== null)
        {
            new_node.prev = null;
            head = new_node;
            sarkılar=new_node.dvd.getSarkılar();
            
            return;
        }
        while(last.next != null){
            last = last.next;
            sarkılar=new_node.dvd.getSarkılar();
            
        }
        last.next = new_node;
        new_node.prev = last;
        
        sarkılar=new_node.dvd.getSarkılar();
        
    }//Doubly linked listte kullanılmak için yapılan listeyi tersine çevirme  metodu
    public void reverse() {
        Node temp = null;
        Node current = head;
 
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
    //alfabetik sıralama içi gerekli olanlar.
    public Node partition(Node l,Node h)
    {
        int  x = h.data;
         
        Node i = l.prev;
         
        for(Node j=l; j!=h; j=j.next)
        {
            if(j.data <= x)
            {
                i = (i==null) ? l : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
       
        i = (i==null) ? l : i.next; 
        int temp = i.data;
        i.data = h.data;
        h.data = temp;
        return i;
    }
     
    public  void _quickSort(Node l,Node h)
    {
        if(h!=null && l!=h && l!=h.next){
            Node temp = partition(l,h);
            _quickSort(l,temp.prev);
            _quickSort(temp.next,h);
        }
    }
    //asıl kod
    public void quickSort(Node node)
    {
        Node head = lastNode(node);
        _quickSort(node,head);
    }
//Doubly linked listti yazdırmak için yapılan yazdırma metodu
    public String yazdırma2() {
        ArrayList<String> muzikler;
        Node farklı=head;
        String girdiler="";
        while (farklı!=null) { 
            girdiler+=farklı.dvd.getAdSoyad()+", "+farklı.dvd.getDvdBaslık()+", "+farklı.dvd.getCıkısTarih()+", "+farklı.dvd.getFiyat()+", ";
             muzikler=farklı.dvd.getSarkılar();
            for (int i = 0; i < muzikler.size(); i++) {
                if (i%6==0) {
                    girdiler+="\n";
                }
                if (i==muzikler.size()-1) {
                    girdiler+=muzikler.get(i)+".";
                }else{
                    girdiler+=muzikler.get(i)+", ";
                }                
            }
            if (farklı.next!=null) {
                girdiler+="\n";
            }
            farklı=farklı.next;
        }
        
        return  girdiler;
    }
    public void sarkılar(String sarki){
         sarkılar.add(sarki);
    }
    //Doubly linked listti 2000 öncesi dvdleri yazdırmak için yapılan  yazdırma metodu
    public String yazdırma4() {
         ArrayList<String> muzikler;   
        Node farklı=head;
            String girdiler="";
            while (farklı!=null) { 
                if(farklı.dvd.getCıkısTarih() <2000){
                girdiler+=farklı.dvd.getAdSoyad()+", "+farklı.dvd.getDvdBaslık()+", "+farklı.dvd.getCıkısTarih()+", "+farklı.dvd.getFiyat()+", ";
               muzikler=farklı.dvd.getSarkılar();
                for (int i = 0; i < muzikler.size(); i++) {
                    if (i==muzikler.size()-1) {
                        girdiler+=muzikler.get(i)+".";
                    }else{
                        girdiler+=muzikler.get(i)+", ";
                    }                
                }if (farklı.next!=null) {
                girdiler+="\n";
                }
                }

                farklı=farklı.next;
            }
            return  girdiler;
        }
    //Doubly linked listti dvd bul da aranan  dvdleri yazdırmak için yapılan  yazdırma metodu
    public String yazdırma4(String adsoyad) {
         ArrayList<String> muzikler;    
        Node farklı=head;
        String girdiler="";
        while (farklı!=null) { 
            if (farklı.dvd.getAdSoyad().toLowerCase().equals(adsoyad.toLowerCase())){
            girdiler+=farklı.dvd.getAdSoyad()+", "+farklı.dvd.getDvdBaslık()+", "+farklı.dvd.getCıkısTarih()+", "+farklı.dvd.getFiyat()+", ";
             muzikler=farklı.dvd.getSarkılar();
            for (int i = 0; i < muzikler.size(); i++) {
                if (i==muzikler.size()-1) {
                    girdiler+=muzikler.get(i)+".";
                }else{
                    girdiler+=muzikler.get(i)+", ";
                }                
            }if (farklı.next!=null) {
            girdiler+="\n";
            }
            }

            farklı=farklı.next;
        }
        return  girdiler;
    }
    //Doubly linked listti dvd bul da aranan  dvdleri yazdırmak için yapılan  hata kontrol metodu
    public boolean yazdırma5(String adsoyad) {
        Node farklı=head;
        String girdiler="";
        while (farklı!=null) { 
            if (farklı.dvd.getAdSoyad().toLowerCase().equals(adsoyad.toLowerCase())){
                return adsoyadkontrol=true;
            }
            else{
                adsoyadkontrol=false; 
            }
          farklı=farklı.next;  
        }

        return  adsoyadkontrol;
}
    
}





  



  




