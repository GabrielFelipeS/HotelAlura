package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import views.ReservasView;

public class ReservaController {
	Double diaria = 20.00;
	
	public void diasChange(JDateChooser txtDataE, JDateChooser txtDataS, JTextField txtValor) {
		if(ReservasView.txtDataE.getDate() != null && ReservasView.txtDataS.getDate() != null) {
			String value = new ReservaController().taxaDiaria(ReservasView.txtDataE.getDate(), ReservasView.txtDataS.getDate());
			txtValor.setText(value);
			System.err.println("Aqui: "+ ReservasView.txtValor.getText().isEmpty());
			
		}
	}
	
	public String taxaDiaria(Date dataInicio, Date dataFim) {
		System.out.println("Inicio: " + dataInicio);				
		System.out.println("Fim: " + dataFim);
		Long inicio = dataInicio.getTime();
		Long fim = dataFim.getTime();
//		System.out.println(TimeUnit.DAYS.convert((fim - inicio), TimeUnit.MILLISECONDS) + 1);	
		if(fim >= inicio) {
			Long dias = TimeUnit.DAYS.convert((fim - inicio), TimeUnit.MILLISECONDS) + 1;
			Double taxa = dias * this.diaria; 
			return "$" + taxa;
		} else {
			JOptionPane.showMessageDialog(null, "A data de inicio da reserva é maior do que a data de fim", "Alerta",JOptionPane.ERROR_MESSAGE);
			return "";
		}
		
	}


}
