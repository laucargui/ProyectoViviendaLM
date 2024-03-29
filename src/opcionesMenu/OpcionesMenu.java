package opcionesMenu;

import java.util.Collections;
import java.util.Comparator;
import controlador.Comparador;
import controlador.GestionLista;
import hospedaje.Hotel;
import hospedaje.Pension;
import tipos.TpCAS;
import tipos.TpEPO;
import tipos.TpPAGO;
import unifamiliar.Particular;
import unifamiliar.Vacacional;
import utilidades.Teclado;
import vivienda.Vivienda;

public class OpcionesMenu {
	


	public static void aniadirVivienda() {

		Integer opcion = 0;
		
		do {
			System.out.println("\n Elija el tipo de vivienda:");
			System.out.println("******************************************");
			System.out.println("1. Hotel.");
			System.out.println("2. Pensi�n.");
			System.out.println("3. Vacacional.");
			System.out.println("4. Particular.");
		
		try {
			System.out.println("***************");
		opcion = Teclado.pideDatoEntero("Opci�n Elegida: ");
		}
		catch(Exception e) {
		}
		if(opcion <1 || opcion >4) {
			System.out.println("Debe elegir un n�mero del 1 al 4.");
		}else {
		
}
		switch (opcion) {
		case 1:
			aniadirHotel();
			break;
		case 2:
			aniadirPension();
			break;
		case 3:
			aniadirVacacional();
			break;
		case 4:
			aniadirParticular();
			break;
		}
		}while (opcion ==0);
		
	}

	public static void aniadirHotel() {
		
		System.out.println("\nIntroduzca los siguientes datos para el Hotel");
		System.out.println("*********************************************");
		String numCatastro = Teclado.pideDatoCadena("Introduzca el n� de catastro: ");
		

		TpPAGO tipoPAGO = utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago: Tarjeta, Paypal, Efectivo, Todo: "));
		while (tipoPAGO == null) { 
			try {
				System.out.println("\nDebe elegir un tipo de pago v�lido.");
		tipoPAGO = utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago: Tarjeta, Paypal, Efectivo, Todo: "));
			}catch (Exception e) {
			}
		}
		
		Integer numHabitaciones = 0;
		do {
		try {
		numHabitaciones = Teclado.pideDatoEntero("Introduzca el n� de habitaciones: ");
		
		}catch (Exception e) {		
			System.out.println("\nDebe escribir un n�mero");
		}
		}while (numHabitaciones ==0);
		
		
		Integer numComedores = 0;
		do {
			try {
				numComedores = Teclado.pideDatoEntero("Introduzca el n� de comedores: ");
			}catch (Exception e) {
				System.out.println("\nDebe escribir un n�mero");		
			}
			}while (numComedores ==0);

		TpEPO tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual: "));
		while (tipoEPO == null) { 
			try {
				System.out.println("\nDebe escribir una �poca v�lida.");
		tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual: "));
			}catch (Exception e) {
			}
		}
			controlador.GestionLista.anadir(new Hotel(numCatastro, tipoPAGO, numHabitaciones, numComedores,tipoEPO));
			System.out.println("\nHa a�adido un nuevo HOTEL a la lista.");
			System.out.println("Para ver la lista de viviendas pulse la opci�n 4 en el Men� Principal.");
		
	}



	public static void aniadirPension() {

		System.out.println("\nIntroduzca los siguientes datos para la Pensi�n");
		System.out.println("***********************************************");
		String numCatastro = Teclado.pideDatoCadena("Introduzca el n� de catastro: ");
		
		TpPAGO tipoPAGO = utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago posible: Tarjeta, Paypal, Efectivo, Todo: "));
		while (tipoPAGO == null) { 
			try {
				System.out.println("\nDebe escribir un tipo de pago v�lido.");
		tipoPAGO = utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago: Tarjeta, Paypal, Efectivo, Todo: "));
			}catch (Exception e) {
			}
		}
		
		String opinionViajeros = Teclado.pideDatoCadena("Introduzca su opini�n: ");
		
		Integer paxPorHabitacion = 0;
		do {
			try {
				paxPorHabitacion = Teclado.pideDatoEntero("Introduzca n�mero de personas por habitaci�n: ");
			}catch (Exception e) {
				System.out.println("\nDebe escribir un n�mero");	
			}
		}while (paxPorHabitacion ==0);
		
		TpEPO tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual: "));
		while (tipoEPO == null) { 
			try {
				System.out.println("\nDebe escribir un tipo de �poca v�lido.");
		tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual: "));
			}catch (Exception e) {
			}
		}
		
		controlador.GestionLista.anadir(new Pension(numCatastro, tipoPAGO, opinionViajeros, paxPorHabitacion, tipoEPO));
		System.out.println("\nHa a�adido una nueva PENSI�N a la lista.");
		System.out.println("Para ver el listado de viviendas pulse la opci�n 4 en el Men� Principal.");
	
	}
	
	public static void aniadirVacacional() {

		System.out.println("\nIntroduzca los siguientes datos para la vivienda Vacacional");
		System.out.println("***********************************************************");
		String numCatastro = Teclado.pideDatoCadena("Introduzca el n� de catastro: ");
		
		Integer superficie =0;
		do {
			try {
				superficie = Teclado.pideDatoEntero("Introduzca la superficie, en metros: ");
			}catch (Exception e) {
				System.out.println("\nDebe escribir un n�mero");
			}
		}while (superficie ==0);
		
		Integer numAireAcond =0;
		do {
			try {
				numAireAcond =  Teclado.pideDatoEntero("Introduzca el n� de aparatos de aire acondicionado: ");
			}catch (Exception e) {
				System.out.println("\nDebe escribir un n�mero");
			}
		}while (numAireAcond ==0);
		
		Integer diasOcupado=0;
		do {
			try {
				diasOcupado = Teclado.pideDatoEntero("Introduzca los d�as de cocupaci�n: ");
			}catch (Exception e) {
				System.out.println("\nDebe escribir un n�mero");
			}
		}while (diasOcupado ==0);
		
		Integer distanciaPlaya=0;
		do {
			try {
				distanciaPlaya = Teclado.pideDatoEntero("Introduzca la distacia a la playa, en metros: ");
			}catch (Exception e) {
				System.out.println("\nDebe escribir un n�mero");
			}
		}while (distanciaPlaya ==0);
		
		TpEPO tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual "));
		while (tipoEPO == null) { 
			try {
				System.out.println("\nDebe escribir un tipo de �poca v�lido.");
		tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual: "));
			}catch (Exception e) {
			}
		}
		controlador.GestionLista.anadir(new Vacacional(numCatastro, superficie,numAireAcond, diasOcupado,distanciaPlaya, tipoEPO));
		System.out.println("\nHa a�adido una nueva VIVIENDA VACACIONAL a la lista.");
		System.out.println("Para ver el listado de viviendas pulse la opci�n 4 en el Men� Principal.");
	}
	


public static void aniadirParticular() {

	System.out.println("\nIntroduzca los siguientes datos para la vivienda Particular");
	System.out.println("**********************************************************");
	String numCatastro = Teclado.pideDatoCadena("Introduzca el n� de catastro: ");		
	Integer superficie =0;
	do {
		try {
			superficie = Teclado.pideDatoEntero("Introduzca la superficie, en metros: ");
		}catch (Exception e) {
			System.out.println("\nDebe escribir un n�mero");
		}
	}while (superficie ==0);
	
	Integer numAireAcond =0;
	do {
		try {
			numAireAcond =  Teclado.pideDatoEntero("Introduzca el n� de aparatos de aire acondicionado: ");
		}catch (Exception e) {
			System.out.println("\nDebe escribir un n�mero");
		}
	}while (numAireAcond ==0);
	
	Integer numBanos=0;
	do {
		try {
			numBanos = Teclado.pideDatoEntero("Introduzca el n� de ba�os: ");
		}catch (Exception e) {
			System.out.println("\nDebe escribir un n�mero");
		}
	}while (numBanos ==0);
	
	TpCAS tipoCASA = utilidades.ConvertirTipo.toTpCAS(Teclado.pideDatoCadena("Introduzca el tipo de casa: ADOSADO, PAREADO, PISO ")); 
	while (tipoCASA == null) { 
		try {
			System.out.println("\nDebe escribir un tipo de casa v�lido.");
	tipoCASA = utilidades.ConvertirTipo.toTpCAS(Teclado.pideDatoCadena("Introduzca el tipo de casa: ADOSADO, PAREADO, PISO "));
		}catch (Exception e) {
		}
	}
	
	controlador.GestionLista.anadir(new Particular(numCatastro, superficie, numAireAcond, numBanos, tipoCASA));
	System.out.println("\nHa a�adido una nueva VIVIENDA PARTICULAR a la lista.");
	System.out.println("Para ver el listado de viviendas pulse la opci�n 4 en el Men� Principal.");
}

	public static void modificarVivienda() {
		
		System.out.println("\nHa elegido la opci�n de modificar vivienda");
		System.out.println("******************************************");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		listadoVivienda();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		
		for(Vivienda v : controlador.GestionLista.getLista()) {
				
			Teclado.pideDatoEntero("Introduzca el n� de la vivienda a modificar: ");	
			
							
				if (v instanceof Hotel) {
					System.out.println("Seleccione el atributo que desee modificar: ");
					System.out.println("****************************************");
					System.out.println("1. N�mero de catastro ");
					System.out.println("2. Tipo de pago ");
					System.out.println("3. N�mero de habitaciones ");
					System.out.println("4. N�mero de comedores ");
					System.out.println("5. �poca");
					
					Integer opcionH = 0;
					
					try {
					opcionH = Teclado.pideDatoEntero("Opci�n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcionH <1 || opcionH >5) {
						System.out.println("Debe elegir un n�mero del 1 al 5.");
					}else {
					
					switch (opcionH) {
				case 1:
					((Hotel)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n� de catastro: "));
					break;
				case 2:
				    ((Hotel)v).setTpPAGOHospedaje(utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago posible: Tarjeta, Paypal, Efectivo, Todo: ")));
					break;
				case 3:
				   ((Hotel)v).setNumHabitaciones(Teclado.pideDatoEntero("Introduzca el nuevo número de habitaciones: "));
					break;
				case 4:
				  ((Hotel)v).setNumComedores(Teclado.pideDatoEntero("Introduzca el nuevo n�mero de comedores: "));	
					break;
				case 5:
				  ((Hotel)v).setTipoEPO(utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual ")));	
					break;
			     	}	      
				  }
				}
				
				
				if (v instanceof Pension) {
						
					
					System.out.println("Seleccione el atributo que desee modificar: ");
					System.out.println("****************************************");
					System.out.println("1. N�mero de catastro ");
					System.out.println("2. Tipo de pago ");
					System.out.println("3. Opinion de viajeros ");
					System.out.println("4. Personas por habitaci�n ");
					System.out.println("5. �poca");
						
					Integer opcionP = 0;
					
					try {
					opcionP = Teclado.pideDatoEntero("Opci�n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcionP <1 || opcionP >4) {
					System.out.println("Debe elegir un número del 1 al 5.");
					}else {
						
					switch (opcionP) {
					case 1:
						((Pension)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n� de catastro: "));
						break;
					case 2:
					  ((Pension)v).setTipoPAGO(utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago posible: Tarjeta, Paypal, Efectivo, Todo: ")));
						break;
					case 3:
					    ((Pension)v).setOpinionViajeros(Teclado.pideDatoCadena("Introduzca la opini�n de los viajeros: "));
						break;
					case 4:
						((Pension)v).setPaxPorHabitacion(Teclado.pideDatoEntero("Introduzca el nuevo n�mero de personas por habitaci�n: "));	
						break;
					case 5:
				        ((Pension)v).setEpoca(utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual ")));	
					      break;
					}    
				}
				}
			
					
				if (v instanceof Particular) {
						
					
					System.out.println("Seleccione el atributo que desee modificar: ");
					System.out.println("****************************************");
					System.out.println("1. N�mero de catastro ");
					System.out.println("2. Superficie ");
					System.out.println("3. N� de aires acondicionados ");
					System.out.println("4. N�mero de ba�os ");
					System.out.println("5. Tipo de casa ");
						
					Integer opcion = 0;
					
					try {
					opcion = Teclado.pideDatoEntero("Opci�n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcion <1 || opcion >5) {
					System.out.println("Debe elegir un n�mero del 1 al 5.");
					}else {
						
					switch (opcion) {
					case 1:
						((Particular)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n� de catastro: "));
						break;
					case 2:
					  ((Particular)v).setSuperficie(Teclado.pideDatoEntero("Introduzca la superficie: "));
						break;
					case 3:
					  ((Particular)v).setNumAireAcond(Teclado.pideDatoEntero("Introduzca el n�mero de aires acondicionados: "));
						break;
					case 4:
						 ((Particular)v).setNumBanos(Teclado.pideDatoEntero("Introduzca el n�mero de ba�os: "));	
						break;
					case 5:
						((Particular)v).setTipoCASA(utilidades.ConvertirTipo.toTpCAS(Teclado.pideDatoCadena("Introduzca el tipo de casa: Adosado, Pareado, Piso ")));
						break;
				}	   
					
							
			    }
			}	
			    	if (v instanceof Vacacional) {
			    		
			    	
				    System.out.println("****************************************");
					System.out.println("1. N�mero de catastro ");
					System.out.println("2. Superficie ");
					System.out.println("3. N�mero de aires acondicionados  ");
					System.out.println("4. D�as Ocupado ");
					System.out.println("5. Distancia a la playa ");
					System.out.println("6. �poca");
								
					Integer opcionV = 0;
								
					try {
						opcionV = Teclado.pideDatoEntero("Opci�n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcionV <1 || opcionV >6) {
					System.out.println("Debe elegir un n�mero del 1 al 6.");
					}else {
					
					switch (opcionV) {
					case 1:
					((Vacacional)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n� de catastro: "));
					     break;
					case 2:
				        ((Vacacional) v).setSuperficie(Teclado.pideDatoEntero("Introduzca la superficie: "));
					     break;
					case 3:
					((Vacacional) v).setNumAireAcond(Teclado.pideDatoEntero("Introduzca el n�mero de Aires Acondicionados: "));
					      break;
					case 4:
					 ((Vacacional)v).setDiasOcupado(Teclado.pideDatoEntero("Introduzca el n�mero de dias ocupado: "));	
					break;
					case 5:
					 ((Vacacional)v).setDistanciaPlaya(Teclado.pideDatoEntero("Introduzca la distancia a la playa: "));
					break;
					case 6:
				        ((Vacacional)v).setTipoEPO(utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la �poca de uso: Verano, Invierno, Anual ")));	
					      break;
			       }    		
			}
		}
			
			    	
		else{
		}	
			    	
		listadoVivienda();				
	 }
			
	}

	public static void borrarVivienda() {

		System.out.println("\nHa elegido la opci�n borrar vivienda");
		System.out.println("************************************");
		
		if(GestionLista.tamanio()==0) {
			System.out.println("La lista de viviendas est� vacia");
		}else {
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
			listadoVivienda();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
			int num=0;
			try {
			num = Teclado.pideDatoEntero("\nIntroduzca el n� de la vivienda a borrar: ");
			}catch(Exception e) {
			}
			if(num<1 || num>GestionLista.tamanio()) {
				System.out.println("Debe elegir un elemento de la lista.");	
			}else {	
			
			controlador.GestionLista.borrar(num-1);
			listadoVivienda();
			}
		}
	}
	
	
	
	
	/*try {
		opcion = Teclado.pideDatoEntero("Opci�n escogida: ");
		}
		catch(Exception e) {
		}
		if(opcion <1 || opcion >4) {
			System.out.println("Debe escoger un n�mero del 1 al 4.");
		}else {*/ 
	
	public static void listarVivienda() {

		System.out.println("\nHa elegido la opci�n listar el contenido de vivienda");
		System.out.println("****************************************************");
		
		if(GestionLista.tamanio()==0) {
			System.out.println("La lista de viviendas est� vacia");
		}else {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		listadoVivienda();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		}
	}


	public static void listadoVivienda() {
		

		Comparator <Vivienda> comparador = new Comparador();
		Collections.sort(controlador.GestionLista.getLista(), comparador);


		int cont = 0;
		for (Vivienda v : controlador.GestionLista.getLista()) {
			if (v instanceof Hotel) {
				Hotel h = (Hotel) v;
				System.out.println((++cont) + " Hotel con [n� Catastro: " + h.getNumCatastro() + "," + " Pago con: "
						+ h.getTipoPAGO() + ", n� habitaciones: " + h.getNumHabitaciones()
						+ ", n� de comedores: " + h.getNumComedores()+ ", Para la �poca: "+ h.getEpoca()+"]");
			}
			
			if (v instanceof Pension) {
				Pension p = (Pension) v;
				System.out.println((++cont) + " Pensi�n con [n� Catastro: " + p.getNumCatastro() + "," + " Pago con: "
							+ p.getTipoPAGO() + ", Opini�n de Viajeros: " + p.getOpinionViajeros()
							+ ", n� de Personas por Habitaci�n:  " + p.getPaxPorHabitacion()+ ", Para la �poca: "+ p.getEpoca()+"]") ;
				}
			
			
					
		if (v instanceof Vacacional) {
			Vacacional c = (Vacacional) v;
			System.out.println((++cont) + " Vivienda vacacional con [n� Catastro: " + c.getNumCatastro() + "," + " Superficie:  "
						+ c.getSuperficie() + " metros cuadrados, n� de aires acondicionados: " + c.getNumAireAcond()
						+ ", D�as de ocupaci�n:  " + c.getDiasOcupado()+ ", Distancia a la playa: "+ c.getDistanciaPlaya() + " metros, Para la �poca: " + c.getEpoca()+"]") ;
			}
		
		if (v instanceof Particular) {
			Particular t = (Particular) v;
			System.out.println((++cont) + " Vivienda particular con [n� Catastro: " + t.getNumCatastro() + "," + " Superficie:  "
						+ t.getSuperficie() + " metros cuadrados, n� de aires acondicionados: " + t.getNumAireAcond()
						+ ", n� de ba�os:  " + t.getNumBanos()+ ", Tipo de casa: "+ t.getTipoCASA()+"]") ;
			}
		
		
		
		}
	}
}

// ver cuando modificamos tipo de pago porque el problema es que es de la clase hospedaje

/*

public static List<Vivienda>getViviendasPorTipo(String tipo){
	Stream<Vivienda> v = null;
	List<Vivienda> list = GestionLista.getLista();
	Collections.sort(list, (i1,i2) -> i1.getNumCatastro().compareTo(i2.getNumCatastro()));		
			
	switch(tipo.toUpperCase()){
	   case "HOTELES":
		v = list.stream().filter(p-> p instanceof Hotel);
		break;
			
	   case "PENSIONES":
	         v = list.stream().filter(p-> p instanceof Pension);
		break;
					
	   case "PARTICULAR":
		  v = list.stream().filter(p-> p instanceof Particular);
		break;
	
	   case "VACACIONAL":
		   v = list.stream().filter(p->p instanceof Vacacional);
		break;
		default:
		   v = list.stream();
	}
					
	return	v.collect(Collectors.toList());	
    }	
	
	*/



