package opcionesMenu;

import java.util.Collections;
import java.util.Comparator;

import controlador.Comparador;
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
	
	public static void escogerTipoVivienda() {
		

		System.out.println("\n Elija el tipo de vivienda:");
		System.out.println("******************************************");
		System.out.println("1. Hotel.");
		System.out.println("2. PensiÛn.");
		System.out.println("3. Vacacional.");
		System.out.println("4. Particular.");
		
	}
	

	public static void aniadirVivienda() {

		Integer opcion = 0;
		
		do {
			escogerTipoVivienda();
		
		try {
		opcion = Teclado.pideDatoEntero("OpciÛn escogida: ");
		}
		catch(Exception e) {
		}
		if(opcion <1 || opcion >4) {
			System.out.println("Debe escoger un n˙mero del 1 al 4.");
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
		}while (opcion !=0);
		
	}

	public static void aniadirHotel() {
		
		System.out.println("\nIntroduzca los siguientes datos para el Hotel");
		System.out.println("*********************************************");
		String numCatastro = Teclado.pideDatoCadena("Introduzca el n∫ de catastro: ");
		
		TpPAGO tipoPAGO = utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago: Tarjeta, Paypal, Efectivo, Todo: "));
		if (tipoPAGO == null) {
			do {
				System.out.println("Debe escribir un tipo v·lido de pago.");
				tipoPAGO = utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago: Tarjeta, Paypal, Efectivo, Todo: "));
			} while (tipoPAGO == null);
		
		Integer numHabitaciones = 0;
		do {
		try {
		numHabitaciones = Teclado.pideDatoEntero("Introduzca el n∫ de habitaciones: ");
		
		}catch (Exception e) {
			System.out.println("Debe escribir un n˙mero");		
		}
		}while (numHabitaciones ==0);
		
		
		Integer numComedores = 0;
		do {
			try {
				numComedores = Teclado.pideDatoEntero("Introduzca el n∫ de comedores: ");
			}catch (Exception e) {
				System.out.println("Debe escribir un n˙mero");		
			}
			}while (numComedores ==0);

		TpEPO tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la Època de uso: Verano, Invierno, Anual: "));
		if (tipoEPO ==null) {
			do {
				System.out.println("Debe escoger una Època v·lida.");
				 tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la Època de uso: Verano, Invierno, Anual: "));
			}while(tipoPAGO ==null);
		}
		controlador.GestionLista.anadir(new Hotel(numCatastro, tipoPAGO, numHabitaciones, numComedores,tipoEPO));
		listadoVivienda();

	}
	}
	

	public static void aniadirPension() {

		System.out.println("\nIntroduzca los siguientes datos para la PensiÛn");
		System.out.println("***********************************************");
		String numCatastro = Teclado.pideDatoCadena("Introduzca el n∫ de catastro: ");
		TpPAGO tipoPAGO = utilidades.ConvertirTipo.toTpPAGO(Teclado.pideDatoCadena("Introduzca el tipo de pago posible: Tarjeta, Paypal, Efectivo, Todo: "));
		String opinionViajeros = Teclado.pideDatoCadena("Introduzca su opiniÛn: ");
		Integer paxPorHabitacion = Teclado.pideDatoEntero("Introduzca n˙mero de personas por habitaciÛn: ");
		TpEPO tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la Època de uso: Verano, Invierno, Anual: "));
		
		
		controlador.GestionLista.anadir(new Pension(numCatastro, tipoPAGO, opinionViajeros, paxPorHabitacion, tipoEPO));
		listadoVivienda();
		
	}
	
	public static void aniadirVacacional() {

		System.out.println("\nIntroduzca los siguientes datos para la vivienda Vacacional");
		System.out.println("***********************************************************");
		String numCatastro = Teclado.pideDatoCadena("Introduzca el n∫ de catastro: ");
		Integer superficie = Teclado.pideDatoEntero("Introduzca la superficie, en metros: ");
		Integer numAireAcond =  Teclado.pideDatoEntero("Introduzca el n∫ de aparatos de aire acondicionado: ");
		Integer diasOcupado = Teclado.pideDatoEntero("Introduzca los dÌas de cocupaciÛn: ");
		Integer distanciaPlaya = Teclado.pideDatoEntero("Introduzca la distacia a la playa, en metros: ");
		TpEPO tipoEPO = utilidades.ConvertirTipo.toTpEPO(Teclado.pideDatoCadena("Introduzca la Època de uso: Verano, Invierno, Anual "));
				
		controlador.GestionLista.anadir(new Vacacional(numCatastro, numAireAcond,superficie, diasOcupado,distanciaPlaya, tipoEPO));
		listadoVivienda();
		
	}
	


public static void aniadirParticular() {

	System.out.println("\nIntroduzca los siguientes datos para la vivienda Particular");
	System.out.println("**********************************************************");
	String numCatastro = Teclado.pideDatoCadena("Introduzca el n∫ de catastro: ");		
	Integer superficie = Teclado.pideDatoEntero("Introduzca la superficie: ");
	Integer numAireAcond =  Teclado.pideDatoEntero("Introduzca n∫ de aparatos de aire acondicionado: ");
	Integer numBanos = Teclado.pideDatoEntero("Introduzca el n∫ de ba√±os: ");
	TpCAS tipoCASA = utilidades.ConvertirTipo.toTpCAS(Teclado.pideDatoCadena("Introduzca el tipo de casa: ADOSADO, PAREADO, PISO ")); 
	
	controlador.GestionLista.anadir(new Particular(numCatastro, superficie, numAireAcond, numBanos, tipoCASA));
	listadoVivienda();
}

	public static void modificarVivienda() {
		
		System.out.println("\n Ha elegido la opciÛn de modificar vivienda");
		System.out.println("******************************************");
		
		/*
		for(Vivienda v : controlador.GestionLista.getLista()) {
				
			Teclado.pideDatoEntero("Introduzca el n¬∫ de la vivienda a modificar: ");	
			
							
				if (v instanceof Hotel) {
					System.out.println("Seleccione el atributo que desee modificar: ");
					System.out.println("****************************************");
					System.out.println("1. NumCatastro ");
					System.out.println("2. TipoPAGO ");
					System.out.println("3. NumHabitaciones ");
					System.out.println("4. NumComedores ");
					
					Integer opcion = 0;
					
					try {
					opcion = Teclado.pideDatoEntero("Opci√≥n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcion <1 || opcion >4) {
						System.out.println("Debe elegir un n√∫mero del 1 al 4.");
					}else {
					
					switch (opcion) {
				case 1:
					((Hotel)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n¬∫ de catastro: "));
					break;
				case 2:
				    //((Hotel)v).setTipoEPO(Teclado.pideDatoCadena("Introduzca el neuvo m√©todo de pago: "));
					break;
				case 3:
				   ((Hotel)v).setNumHabitaciones(Teclado.pideDatoEntero("Introuzca el nuevo n√∫mero de habitaciones: "));
					break;
				case 4:
				  ((Hotel)v).setNumComedores(Teclado.pideDatoEntero("Introduzca el nuevo n√∫mero de comedores: "));	
					break;
				}	   
				
								
				     
				  }
			
				}
				
				if (v instanceof Pension) {
						
					
					System.out.println("Seleccione el atributo que desee modificar: ");
					System.out.println("****************************************");
					System.out.println("1. NumCatastro ");
					System.out.println("2. TipoPAGO ");
					System.out.println("3. OpinionViajeros ");
					System.out.println("4. PaxPorHabitaci√≥n ");
						
					Integer opcion = 0;
					
					try {
					opcion = Teclado.pideDatoEntero("Opci√≥n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcion <1 || opcion >4) {
					System.out.println("Debe elegir un n√∫mero del 1 al 4.");
					}else {
						
					switch (opcion) {
					case 1:
						((Pension)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n¬∫ de catastro: "));
						break;
					case 2:
					  //  ((Pension)v).setTipoPAGO(Teclado.pideDatoCadena("Introduzca el neuvo m√©todo de pago: "));
						break;
					case 3:
					    ((Pension)v).setOpinionViajeros(Teclado.pideDatoCadena("Introuzca la opini√≥n de los viajeros: "));
						break;
					case 4:
						((Pension)v).setPaxPorHabitacion(Teclado.pideDatoEntero("Introduzca el nuevo tipo de PaxPorHabitaci√≥n: "));	
						break;
					}    
					
					
				}
			}
					
				if (v instanceof Particular) {
						
					
					System.out.println("Seleccione el atributo que desee modificar: ");
					System.out.println("****************************************");
					System.out.println("1. NumCatastro ");
					System.out.println("2. Superficie ");
					System.out.println("3. NumeAireAcond ");
					System.out.println("4. NumBa√±os ");
					System.out.println("5. TipoCasa ");
						
					Integer opcion = 0;
					
					try {
					opcion = Teclado.pideDatoEntero("Opci√≥n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcion <1 || opcion >5) {
					System.out.println("Debe elagir un n√∫mero del 1 al 5.");
					}else {
						
					switch (opcion) {
					case 1:
						((Particular)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n¬∫ de catastro: "));
						break;
					case 2:
					  ((Particular)v).setSuperficie(Teclado.pideDatoEntero("Introduzca la superficie: "));
						break;
					case 3:
					  ((Particular)v).setNumAireAcond(Teclado.pideDatoEntero("Introuzca el n√∫mero de Aires Acondicionados: "));
						break;
					case 4:
						 ((Particular)v).setNumBa√±os(Teclado.pideDatoEntero("Introduzca el n√∫mero de ba√±os: "));	
						break;
					case 5:
						//((Particular)v).setTipoCasa(Teclado.pideDatoCadena("Introduzca el tipo de casa: "));
						break;
				}	   
					
							
			    }
			}	
			    	if (v instanceof Vacacional) {
			    		
			    	
				    System.out.println("****************************************");
					System.out.println("1. NumCatastro ");
					System.out.println("2. Superficie ");
					System.out.println("3. NumeAireAcond ");
					System.out.println("4. Dias Ocupado ");
					System.out.println("5. Distancia a la playa ");
								
					Integer opcion = 0;
								
					try {
					    opcion = Teclado.pideDatoEntero("Opci√≥n elegida: ");
					}
					catch(Exception e) {
					}
					if(opcion <1 || opcion >5) {
					System.out.println("Debe elegir un n√∫mero del 1 al 5.");
					}else {
					
					switch (opcion) {
					case 1:
					((Vacacional)v).setNumCatastro(Teclado.pideDatoCadena("Introduzca el n¬∫ de catastro: "));
					     break;
					case 2:
				        ((Vacacional) v).setSuperficie(Teclado.pideDatoEntero("Introduzca la superficie: "));
					     break;
					case 3:
					((Vacacional) v).setNumAireAcond(Teclado.pideDatoEntero("Introuzca el n√∫mero de Aires Acondicionados: "));
					      break;
					case 4:
					 ((Vacacional)v).setDiasOcupado(Teclado.pideDatoEntero("Introduzca el n√∫mero dias ocupado: "));	
					break;
					case 5:
					 ((Vacacional)v).setDistanciaPlaya(Teclado.pideDatoEntero("Introduzca la distancia a la playa: "));
					break;
			       }    
							
					
			}
		}		
		else{
		}	
		listadoVivienda();				
	 }
	 
	 */
	}

	public static void borrarVivienda() {

		System.out.println("\nHa elegido la opciÛn borrar vivienda");
		System.out.println("************************************");
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		listadoVivienda();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		int num = Teclado.pideDatoEntero("\nIntroduzca el n∫ de la vivienda a borrar: ");
		controlador.GestionLista.borrar(num-1);
		listadoVivienda();
	}

	public static void listarVivienda() {

		System.out.println("\nHa elegido la opciÛn listar el contenido de vivienda");
		System.out.println("****************************************************");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		listadoVivienda();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
	}


	public static void listadoVivienda() {
		

		Comparator <Vivienda> comparador = new Comparador();
		Collections.sort(controlador.GestionLista.getLista(), comparador);


		int cont = 0;
		for (Vivienda v : controlador.GestionLista.getLista()) {
			if (v instanceof Hotel) {
				Hotel h = (Hotel) v;
				System.out.println((++cont) + " Hotel con n∫ Catastro: " + h.getNumCatastro() + "," + " Pago con: "
						+ h.getTipoPAGO() + ", n∫ habitaciones: " + h.getNumHabitaciones()
						+ ", n∫ de comedores: " + h.getNumComedores()+ ", Para la Època: "+ h.getEpoca()+"]");
			}
			
			if (v instanceof Pension) {
				Pension p = (Pension) v;
				System.out.println((++cont) + " PensiÛn con n∫ Catastro: " + p.getNumCatastro() + "," + " Pago con: "
							+ p.getTipoPAGO() + ", OpiniÛn de Viajeros: " + p.getOpinionViajeros()
							+ ", n∫ de Personas por Habitaci√≥n:  " + p.getPaxPorHabitacion()+ ", Para la Època: "+ p.getEpoca()+"]") ;
				}
			
			
					
		if (v instanceof Vacacional) {
			Vacacional c = (Vacacional) v;
			System.out.println((++cont) + " Vivienda vacacional con n∫ Catastro: " + c.getNumCatastro() + "," + " Superficie:  "
						+ c.getSuperficie() + " metros cuadrados, n∫ de aires acondicionados: " + c.getNumAireAcond()
						+ ", DÌas de ocupaci√≥n:  " + c.getDiasOcupado()+ ", Distancia a la playa: "+ c.getDistanciaPlaya() + " metros, Para la Època: " + c.getEpoca()+"]") ;
			}
		
		if (v instanceof Particular) {
			Particular t = (Particular) v;
			System.out.println((++cont) + " Vivienda particular con n∫ Catastro: " + t.getNumCatastro() + "," + " Superficie:  "
						+ t.getSuperficie() + " metros cuadrados, n∫ de aires acondicionados: " + t.getNumAireAcond()
						+ ", n∫ de ba√±os:  " + t.getNumBanos()+ ", Tipo de casa: "+ t.getTipoCASA()+"]") ;
			}
		
		
		
		}
	}

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
}


