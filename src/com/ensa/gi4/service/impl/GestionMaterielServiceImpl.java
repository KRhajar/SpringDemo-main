package com.ensa.gi4.service.impl;

import com.ensa.gi4.dao.MaterialDaoImp;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component("service")
public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here
    // need to inject the material dao
    private MaterialDaoImp materialDaoImp;
@Autowired
    public GestionMaterielServiceImpl(MaterialDaoImp materialDaoImp) {
        this.materialDaoImp = materialDaoImp;
    }
    // we can also use Field injection (inject the dependencies by setting the field values)
    // we need to just do that no Setter method or constructor
//    @Autowired
//    private MaterialDaoImp materialDaoImp;

//
//    private MaterialDAO materialDAO;
//
//
//    public GestionMaterielServiceImpl( MaterialDAO materialDAO) {
//
//        this.materialDAO = materialDAO;
//    }


    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        materialDaoImp.getMaterials();

    }

    @Override
    public void addMaterial() {
        Scanner inputFromConsole = new Scanner(System.in);


        System.out.println(" to add new livre , entrer L");
        System.out.println(" to add new  chaise,enter C");
        //input user
        String chose = inputFromConsole.next();
        switch (chose) {

            case "L":

                Materiel livre = new Livre();

                String livresInfo = inputFromConsole.next();
                try {
                    String[] infos = livresInfo.split(",");
                    livre.setId(Integer.parseInt(infos[0]));
                    livre.setName(infos[1]);
                    livre.setPrice(infos[2]);
                    materialDaoImp.addMaterial(livre);

                } catch (Exception e) {
                    System.err.println("error");
                }

                break;
            case "C":
                Materiel chaise = new Chaise();


                String chaiseInfo = inputFromConsole.next();
                try {
                    String[] infos = chaiseInfo.split(",");
                    chaise.setId(Integer.parseInt(infos[0]));
                    chaise.setName(infos[1]);
                    chaise.setPrice(infos[2]);
                    materialDaoImp.addMaterial(chaise);
                } catch (Exception e) {
                    System.err.println("error");
                }
                break;
        }
    }

    @Override
    public void deletMaterial() {
        System.out.println("delet livre; enter DV ");
        System.out.println("delet chaise ,enter DC");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("DV".equals(next)) {

            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
              materialDaoImp.deletMaterial(id);
        } else if ("DC".equals(next)) {
            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
                materialDaoImp.deletMaterial(id);
        }
    }

    @Override
    public void search() {
        System.out.println("delet livre; enter SV ");
        System.out.println("delet chaise ,enter SC");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("SV".equals(next)) {

            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
            materialDaoImp.search(id);
        } else if ("SC".equals(next)) {
            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
            materialDaoImp.search(id);
        }

    }

    @Override
    public void upDate() {

        System.out.println(" to modify livre , entrer ML");
        System.out.println(" to modify  chaise,enter MC");
        //input user
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("ML".equals(next)) {
            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
            materialDaoImp.upDate(id);
        } else if ("MC".equals(next)) {
            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
            materialDaoImp.upDate(id);

        }






    }

    @Override
    public void location() throws InterruptedException {
        System.out.println(" to loan livre , entrer LL");
        System.out.println(" to loan  chaise,enter LC");
        //input user
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("LL".equals(next)) {
            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
            materialDaoImp.louee(id);
        } else if ("LC".equals(next)) {
            System.out.println("entrer id");
            int id = Integer.parseInt(scanner.next());
            materialDaoImp.louee(id);

        }
    }
}








