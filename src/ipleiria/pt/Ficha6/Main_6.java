package ipleiria.pt.Ficha6;
import ipleiria.pt.*;

public class Main_6 {

        public static void main(String[] args) {
            System.out.println();
            for (Aula aula : GestorSemanaAulas.INSTANCIA.getAulas()) {
                System.out.println(aula);
                System.out.println("\n----------------------------------------\n");
            }
        }
    }

