package com.utn;

public class ListaPremium implements IReproducir{

    private Cancion array[]= new Cancion[50];




    public ListaPremium(Cancion array[]) {
        this.array = array;
    }


    @Override
    public void eliminaLista(String nombre) {
        boolean flag=false;
        int i=0,eliminado =-1;
        while(!flag && i<array.length) {
            if(array[i].getNombre().equals(nombre)) {
                flag=true;
                eliminado = i;
            }
            i++;
        }

        if(eliminado!=-1) {
            while(i<array.length) {
                array[i] = array[i+1];
            }
        }


    }
	/*
	public void ordenaLista() {
		Cancion aux;
		for (int i = 0; i < array.length - 1; i++) {
	        for (int j = i + 1; j < array.length; j++) {
	        	if(array[i].getNombre().compareTo( array[j].getNombre())>0) {// segunda cadena es mas grande

	                aux = array[i];
	                array[i] = array[j];
	                array[j] = aux;
	            }
	        }
	    }


		System.out.println("\n");
		for(int i=0;i<array.length;i++) {

				System.out.print(array[i]+" - ");


		}
	}


	public float duracionTotal() {
		float total=0;

		for(int i=0; i<array.length;i++) {
			total =total+ array[i].getDuracion();
		}

		return total;
	}
	*/

    @Override
    public void reproducirLista() {
        //float duracion = duracionTotal();
        System.out.println("Lista se reproduce a gusto del usuario");
        //System.out.println("La duracion total de la lista es: "+ duracion);
        //muestra lista
		/*
				for(int i=0;i<array.length;i++) {
					array[i].toString();
				}
		*/
    }

}