package pe.bbvacontinental.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pe.bbvacontinental.dao.CuentaDAO;
import pe.bbvacontinental.dao.PersonaDAO;
import pe.bbvacontinental.model.Cuenta;
import pe.bbvacontinental.model.Persona;
import pe.bbvacontinental.service.MailService;
import pe.bbvacontinental.util.Constantes;
import pe.bbvacontinental.util.MaestrosException;

@Service("retobackend.mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	private PersonaDAO personaDAO;
	
	@Autowired
	private CuentaDAO cuentaDAO;
	
	@Override
	public void enviarAlerta(Integer codigoPersona, Integer codigoCuenta) throws MaestrosException{
		try {
			Persona persona = personaDAO.findByPrimaryKey(codigoPersona);
			Cuenta cuenta = cuentaDAO.findByPrimaryKey(codigoCuenta);
			
			String mensaje = construirMensaje().toString();
			mensaje = mensaje.replaceAll("NOMBRE_REPLACE", persona.getNombre());
			mensaje = mensaje.replaceAll("CUENTA_REPLACE", cuenta.getNumeroCuenta());
			//Properties correoProperties = new Properties();
			//correoProperties.load(new FileReader(file));
			Properties correoProperties = new Properties();
			correoProperties.setProperty("host", Constantes.HOST);
			correoProperties.setProperty("user", Constantes.USER);
			correoProperties.setProperty("clave", Constantes.CLAVE);
			correoProperties.setProperty("authentication", Constantes.AUTHENTICATION);
			correoProperties.setProperty("enable", Constantes.ENABLE);
			correoProperties.setProperty("port", Constantes.PORT);

			Properties properties = System.getProperties();
			properties.put(Constantes.CORREO_HOST, correoProperties.getProperty("host"));
			properties.put(Constantes.CORREO_USER, correoProperties.getProperty("user"));
			properties.put(Constantes.CORREO_CLAVE, correoProperties.getProperty("clave"));
			properties.put(Constantes.CORREO_AUTENTICATION, correoProperties.getProperty("authentication"));
			properties.put(Constantes.CORREO_ENABLE, correoProperties.getProperty("enable"));
			properties.put(Constantes.CORREO_PUERTO, correoProperties.getProperty("port"));

			Session session = Session.getDefaultInstance(properties);
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress());
			message.addRecipients(javax.mail.Message.RecipientType.TO, persona.getEmail());
			message.setSubject(Constantes.CORREO_ASUNTO_ALERTA_AHORRO);
			message.setContent(mensaje, "text/html");
			Transport transport = session.getTransport(Constantes.CORREO_PROTOCOL);
			transport.connect(Constantes.CORREO_HOST_SMPT, correoProperties.getProperty("user"),
					correoProperties.getProperty("clave"));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			throw new MaestrosException(e.getMessage());
		}
	}
	
	private StringBuilder construirMensaje() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<h3><p style='color:blue'>Estimado NOMBRE_REPLACE</p></h3>");
		sb.append("<br/>");
		sb.append("<br/>");
		sb.append(
				"<p style='color:blue'><i>El presente es para comunicarle que su cuenta CUENTA_REPLACE mantiene un saldo menor al establecido como límite de saldo bajo.</i></p>");
		sb.append("<br/>");
		sb.append("<br/>");
		sb.append("<p style='color:blue'>Atte.</i></p>");
		sb.append("<p style='color:blue'>BBVA Continental</i></p>");
		sb.append("<body>");
		sb.append("</body>");
		sb.append("</html>");
		return sb;
	}

}
