package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;
import model.excecoes.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Nº do quarto: ");
			int numeroQuarto = sc.nextInt();
	
			System.out.print("Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
	
			System.out.print("Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
	
			Reservas reservas = new Reservas(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
	
			System.out.println("------------");
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservas.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
		} catch (ParseException e) {
			System.out.println("Erro no formato da data!");
		} catch(IllegalAccessError e) {
			System.out.println("Erro ilegal: "+e.getMessage());
		} catch(DomainException e) {
			System.out.println("Erro ilegal: "+e.getMessage());
		}

		sc.close();

	}

}
