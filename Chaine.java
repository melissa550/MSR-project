/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chainemarkov;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mohammedi m?lissa selssabill
 */
public class Chaine {

    static double AddvecMul;
    boolean Stop= true;

    public static void main(String[] args) {
        Methodes meth = new Methodes();
        Scanner clavier = new Scanner(System.in);
        System.out.println("Please specify Matrice ==>[Rows][Columns]");
        System.out.println();

        System.out.println("Please specify number of rows?:");
        int nbrRows = clavier.nextInt();

        System.out.println();
        System.out.println("Please specify number of columns?:");
        int nbrcolumns = clavier.nextInt();

        //reading our Matrice[nbrRows by user][nbrRows by user]
        double Matrice[][] = meth.readMatrice(nbrRows, nbrcolumns);

        //We gona need this tables later size (nbr of columns)

        double[] vector1 = new double[Matrice[0].length];
        double[] vector2 = new double[Matrice[0].length];
        double[] vectMul = new double[Matrice[0].length];

        //Show the matrice (output) = elemets entred by the user
        System.out.println();

        System.out.println("Analysing the matric!");
        System.out.println("Matrice rows = " + Matrice.length);
        System.out.println("Matrice columns = " + Matrice[0].length);
        System.out.println();
        System.out.println("You have entred the folowing elements to the matrice");
        System.out.println("Matrice[][]=");
        System.out.println();
        meth.showMatrice(Matrice);
        //Check if the matrice is stochastic or not
        Boolean matriceStatus = meth.checkStochastic(Matrice);
        System.out.println();

        /*for (int i = 0; i < vectMul.length; i++) {
            AddvecMul = AddvecMul + vectMul[i];
        }
        System.out.println("Somme = " + AddvecMul);*/

        if (matriceStatus) {
            System.out.println("the matrice you entred IS STOCHASTIC");
            System.out.println();
            int rowIndice = meth.eteration(Matrice[0], Matrice);
            //rowIndice not equals nbr of rows
            while (rowIndice != Matrice.length - 1) {

                if (rowIndice == 0 ) {
                    meth.getVictor(Matrice[0], vector1);
                    System.out.println(Arrays.toString(vector1)
                            + " * Matrice[" + Matrice.length + "][" + Matrice[0].length + "]");
                    meth.multiple(vector1, Matrice, rowIndice, vectMul);

                    //ouput table multiplication of Matrice[1]*Matrice[i][j]
                    System.out.println(Arrays.toString(vectMul));
                    rowIndice = meth.eteration(vectMul, Matrice);
                }

                if (rowIndice == 1 ) {
                    meth.getVictor(Matrice[1], vector1);
                    System.out.println(Arrays.toString(vector1)
                            + " * Matrice[" + Matrice.length + "][" + Matrice[0].length + "]");
                    meth.multiple(vector1, Matrice, rowIndice, vectMul);

                    //ouput table multiplication of Matrice[1]*Matrice[i][j]
                    System.out.println(Arrays.toString(vectMul));
                    rowIndice = meth.eteration(vectMul, Matrice);
                }

                if (rowIndice == 2) {
                    meth.getVictor(vectMul, vector2);
                    System.out.println(Arrays.toString(vector2)
                            + " * Matrice[" + Matrice.length + "][" + Matrice[0].length + "]");
                    meth.multiple(vector2, Matrice, rowIndice, vectMul);

                    //ouput table multiplication of Matrice[i]*Matrice[i][j]
                    System.out.println(Arrays.toString(vectMul));
                    rowIndice = meth.eteration(vectMul, Matrice);
                }

                if (rowIndice == 3 ) {
                    meth.getVictor(vectMul, vector2);
                    System.out.println(Arrays.toString(vector2)
                            + " * Matrice[" + Matrice.length + "][" + Matrice[0].length + "]");
                    meth.multiple(vector2, Matrice, rowIndice, vectMul);

                    //ouput table multiplication of Matrice[i]*Matrice[i][j]
                    System.out.println(Arrays.toString(vectMul));
                    rowIndice = meth.eteration(vectMul, Matrice);
                }

                if (rowIndice == 4 ) {
                    meth.getVictor(vectMul, vector2);
                    System.out.println(Arrays.toString(vector2)
                            + " * Matrice[" + Matrice.length + "][" + Matrice[0].length + "]");
                    meth.multiple(vector2, Matrice, rowIndice, vectMul);

                    //ouput table multiplication of Matrice[i]*Matrice[i][j]
                    System.out.println(Arrays.toString(vectMul));
                    rowIndice = meth.eteration(vectMul, Matrice);
                }
            }
        } else {
            System.out.println("the matrice you entred IS NOT STOCHASTIC");
        }
    }
}
