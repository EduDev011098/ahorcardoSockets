package Model;

public class Letras {
    private String palabra;
    private String[] listaPalabras;
    private char[] copiaPalabra;
    private int vida = 6;
    public Letras() {
        listaPalabras = new String[5];

        listaPalabras[0] = "palabra";
        listaPalabras[1] = "modular";
        listaPalabras[2] = "camaleon";
        listaPalabras[3] = "murcielago";
        listaPalabras[4] = "escarabajo";
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

    public boolean verificarLetra(char str) {
        boolean repetido = false;
        for(int i=0; i<copiaPalabra.length;i++) {
            System.out.println(" "+copiaPalabra[i]);
            if(copiaPalabra[i] == str) {
                repetido = true;
            }
        }
        System.out.println(repetido);
        return repetido;
    }

    public void setMascara() {
        copiaPalabra = palabra.toCharArray();
        for(int x=0; x<copiaPalabra.length;x++) {
            copiaPalabra[x] = 'x';
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
