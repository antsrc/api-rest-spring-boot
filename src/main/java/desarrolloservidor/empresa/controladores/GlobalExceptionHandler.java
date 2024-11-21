package desarrolloservidor.empresa.controladores;

import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	private static final String NO_ENCONTRADO = "Recurso no encontrado";
//    private static final String ERROR_TRANSACION = "Problema al procesar la solicitud, es posible que contuviera datos no válidos";
//    private static final String ERROR_GENERICO = "Error inesperado, consulte con el soporte técnico";
//
//	@ExceptionHandler(NoResourceFoundException.class)
//	public String handleNoResourceFound(NoResourceFoundException ex, Model model) {
//		model.addAttribute("mensaje", NO_ENCONTRADO);
//		return "error";
//	}
//
//	@ExceptionHandler(TransactionSystemException.class)
//	public String handleTransactionSystemException(TransactionSystemException ex, Model model) {
//		model.addAttribute("mensaje", ERROR_TRANSACION);
//		return "error";
//	}
//
//	@ExceptionHandler(Exception.class)
//	public String handleGenericException(Exception ex, Model model) {
//		model.addAttribute("mensaje", ERROR_GENERICO);
//		return "error";
//	}

}
