package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

import java.util.List;

public interface GestionMaterielService {
    void init();
    public void  listerMateriel();
  public void addMaterial( );
   public void deletMaterial();
//   public  void upDate();
   public void search();

     public void upDate();
    public void location() throws InterruptedException;


}
