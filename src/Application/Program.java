package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Nº do quarto: ");
		int numeroQuarto = sc.nextInt();

		System.out.print("Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out precisa ser maior que a data de check-in!");
		} else {
			Reservas reservas = new Reservas(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);

			System.out.println("------------");
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: as datas de atualização não podem ser anteiores a data atual!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out precisa ser maior que a data de check-in!");
			} else {
				reservas.atualizarDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reservas);
			}
		}

		sc.close();

	}

}
