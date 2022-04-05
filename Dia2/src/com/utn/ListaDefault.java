package com.utn;


public class ListaDefault implements IReproducir{

    private Cancion array[]= new Cancion[50];


    public ListaDefault(Cancion array[]) {
        this.array = array;
    }



    @Override
    public void eliminaLista(String nombre) {
        System.out.println("Debe comprar Premium para esta funcion");
    }



    @Override
    public void reproducirLista() {

        System.out.println("Lista se reproduce en forma ordenada");
		/*
		//muestra lista
		for(int i=0;i<array.length;i++) {
			array[i].toString();
		}

		*/
    }

}