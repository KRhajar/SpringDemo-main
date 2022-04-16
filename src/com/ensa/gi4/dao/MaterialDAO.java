package com.ensa.gi4.dao;

import com.ensa.gi4.modele.Materiel;


public interface MaterialDAO {
    public void getMaterials();

   public void addMaterial(Materiel theMateriel );
 public void upDate( int id );
    public void deletMaterial(int theid );
    public void search( int theId);
    public void louee( int theId) throws InterruptedException;

}
