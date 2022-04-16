package com.ensa.gi4.dao;

import com.ensa.gi4.datatabase.Dbclass;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
@Component
public class MaterialDaoImp implements MaterialDAO {
    // need to inject customer dao, we chould add in file.xml file
    private Dbclass dbclass;
@Autowired
    public MaterialDaoImp(Dbclass dbclass) {
        this.dbclass = dbclass;
    }
    //    private Dbclass dbclass = new Dbclass();

//    public void setDbclass(Dbclass dbclass) {
//        this.dbclass = dbclass;
//    }


    @Override
    public void getMaterials() {
        int livre = 0;
        int chaise = 0;
        for (Materiel materiel : dbclass.material) {

            if (materiel.getClass().getName().equals("com.ensa.gi4.modele.Livre")) {
                System.out.println(materiel.getClass().getName());
                livre++;
            }
            if (materiel.getClass().getName().equals("com.ensa.gi4.modele.Chaise")) {
                chaise++;
            }


        }
        System.out.println("Liste de matériel :\n" + livre + " Livres \n" + chaise + " chaises");
    }

    @Override
    public void addMaterial(Materiel theMateriel) {

        dbclass.material.add(theMateriel);
        System.out.println("the new material adding with id equals " + theMateriel.getId() + "and the name is " + theMateriel.getName() + "and the price is " + theMateriel.getPrice() + " DH");
    }

    @Override
    public void upDate(int id) {
        if (!dbclass.material.isEmpty()) {
            for (Materiel materiels : dbclass.material) {
                if (materiels.getId() == id) {

                    System.out.println("enter  the new name ");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.next();
                    materiels.setName(name);
                    System.out.println("enter  the new price ");
                    String price = scanner.next();
                    materiels.setPrice(price);
                    System.out.println("the Materiel with id " + id + " modifiy with seccess");
                    System.out.println(" the new name is " + materiels.getName() + " and the new price is " + materiels.getPrice() + " DH");

                    break;
                } else {
                    System.out.println("materiel with id " + id + "doesn't exist");
                    break;

                }
            }

        } else {
            System.out.println("the list is empty ");

        }
    }


    @Override
    public void deletMaterial(int theid) {
        if (!dbclass.material.isEmpty()) {
            for (Materiel materiel : dbclass.material) {
                if (materiel.getId() == theid) {
                    dbclass.material.remove(materiel);
                    System.out.println("Materiel with id " + theid + " deleted");

                    break;
                } else {
                    System.out.println("materiel with id " + theid + "doesn't exist");
                    break;
                }
            }
        } else {
            System.out.println("the list is empty ");

        }
    }

    @Override
    public void search(int theId) {
        int search = 0;

        for (Materiel materiel : dbclass.material) {
            if (materiel.getId() == theId) {
                search = 1;
                System.out.println("Materiel with id " + theId + " exists");
                System.out.println("the name of materiel is " + materiel.getName() + "and the price is"
                        + "the price is " + materiel.getPrice());
                break;
            }
        }
        if (search == 0) {
            System.out.println("Materiel with id " + theId + " does'nt exist");
        }


    }


    @Override
    public void louee(int theId) throws InterruptedException {
        Materiel meterielAlloue;
        if (!dbclass.material.isEmpty()) {
            for (Materiel materiels : dbclass.material) {
                if (materiels.getId() == theId) {
                    meterielAlloue = materiels;
                    dbclass.material.remove(materiels);
                    System.out.println("how mutch the time want to allocate the materiel ");
                    Scanner scanner = new Scanner(System.in);
                    String time = scanner.next();
                    new Thread(() -> {
                        try {
                            TimeUnit.SECONDS.sleep(
                                    Long.parseLong(time));
                            System.out.println("the Materiel with id " + theId + " allocate with seccess");
                            System.out.println(" the  name is " + materiels.getName() + " and the  price is " + materiels.getPrice() + "DH pendand " + time);
                            dbclass.material.add(meterielAlloue);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();


                    break;
                } else {
                    System.out.println("the Materiel with id " + theId + " is not exist");

                }

            }


        }

        System.out.println("materiel with id " + theId + "doesn't exist");

    }
}




