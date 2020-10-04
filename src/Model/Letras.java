package Model;

public class Letras {
    private String palabra;
    private String[] listaPalabras;
    private char[] copiaPalabra;
    private int vida = 6;
    public Letras() {
        listaPalabras = new String[5];

        listaPalabras[0] = "politecnica";
        listaPalabras[1] = "manzana";
        listaPalabras[2] = "eutanasia";
        listaPalabras[3] = "murcielago";
        listaPalabras[4] = "victoria";
    }

    public void setPalabra() {
        palabra = listaPalabras[(int) (Math.random()*5)];
        System.out.println(palabra);
    }

    public String getPalabra() {
        return palabra;
    }

    public boolean buscarLetra(char letra) {
        char[] cadena = palabra.toCharArray();
        boolean bandera = false;

        for(int i=0; i<cadena.length;i++) {
            if(cadena[i] ==letra) {
                bandera =true;
                copiaPalabra[i] =letra;
            }
        }
        return bandera;
    }

    public boolean verificarLetra(char letra) {
        System.out.println("estoy en vereficar letra");
        copiaPalabra = palabra.toCharArray();
        boolean cadena = false;

        for(int j=0; j<copiaPalabra.length;j++) {
            if(copiaPalabra[j] == letra) {
                cadena = true;
                System.out.println("se repite");

            }
        }
        return cadena;
    }

    public void setMascara() {
        copiaPalabra = palabra.toCharArray();
        for(int x=0; x<copiaPalabra.length;x++) {
            copiaPalabra[x] = '_';
        }
    }

    public String getMascara() {
        return String.valueOf(copiaPalabra);
    }

    public boolean verificarPalabra() {
        return palabra.equals(getMascara());
    }

    public String setVida(char letra) {
        if(buscarLetra(letra) == false) {
            vida--;
        }
        return String.valueOf(vida);
    }

    public int getVida() {
        return vida;
    }

    public boolean verificarError() {
        return String.valueOf(vida).equals("0");
    }

}
