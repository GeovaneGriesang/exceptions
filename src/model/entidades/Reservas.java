package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DomainException;

public class Reservas {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva: a data de check-out precisa ser maior que a data de check-in!");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public long duracaoDias() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void atualizarDatas(Date checkIn, Date checkOut) throws DomainException {		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalAccessError("Erro na reserva: as datas de atualiza��o n�o podem ser anteiores a data atual!");

		} else if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva: a data de check-out precisa ser maior que a data de check-in!");
		} else {
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		}
	}

	@Override
	public String toString() {
		return "Reservas [numeroQuarto=" + numeroQuarto + ", checkIn=" + sdf.format(checkIn) + ", checkOut="
				+ sdf.format(checkOut) + ", " + duracaoDias() + " noites]";
	}

}
