package pe.bbvacontinental.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.bbvacontinental.bean.CatalogoBean;
import pe.bbvacontinental.bean.CuentaBean;
import pe.bbvacontinental.bean.HabitoAhorroBean;
import pe.bbvacontinental.bean.MovimientoBean;
import pe.bbvacontinental.bean.PersonaBean;
import pe.bbvacontinental.service.CatalogoService;
import pe.bbvacontinental.service.CuentaService;
import pe.bbvacontinental.service.HabitoAhorroService;
import pe.bbvacontinental.service.MailService;
import pe.bbvacontinental.service.PersonaService;
import pe.bbvacontinental.service.TransferenciaService;
import pe.bbvacontinental.util.ComboBean;
import pe.bbvacontinental.util.Constantes;
import pe.bbvacontinental.util.MaestrosException;
import pe.bbvacontinental.util.Mensajes;
import pe.bbvacontinental.util.Util;

@Controller
@RequestMapping(value = "/cuenta")
public class CuentaController {

	@Autowired
	@Qualifier("retobackend.personaService")
	private PersonaService personaService;

	@Autowired
	@Qualifier("retobackend.cuentaService")
	private CuentaService cuentaService;
	
	@Autowired
	@Qualifier("retobackend.catalogoService")
	private CatalogoService catalogoService;
	
	@Autowired
	@Qualifier("retobackend.transferenciaService")
	private TransferenciaService transferenciaService;
	
	@Autowired
	@Qualifier("retobackend.habitoAhorroService")
	private HabitoAhorroService habitoAhorroService;
	
	@Autowired
	@Qualifier("retobackend.mailService")
	private MailService mailService;

	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public ModelAndView principal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String stringView = "cuentas";
		ModelAndView view = new ModelAndView(stringView);	
		
		String codigoPersona = "1";
		PersonaBean personaBean = personaService.get(Util.toInt(codigoPersona));

		view.addObject("persona", personaBean);
		return view;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listar(@RequestBody Map<String, Object> parametros, HttpServletRequest request) throws MaestrosException{
		Map<String, Object> resultado = new HashMap<String, Object>();
		String codigoPersona = ObjectUtils.toString(parametros.get("codigoPersona"));
		List<CuentaBean> lstCuentaBeans = cuentaService.buscar(Util.toInt(codigoPersona));
		if (Util.isNullOrEmpty(lstCuentaBeans)) {
			resultado.put(Mensajes.PARAM_MESSAGE, Mensajes.MSG_SEARCH_NOFOUND_MAESTROS);
		} else {
			resultado.put(Mensajes.PARAM_DATA, lstCuentaBeans);
		}
		return resultado;
	}

	@RequestMapping(value = "/mostrarTransferencia", method = RequestMethod.POST)
	public ModelAndView mostrarTransferencia(HttpServletRequest request) throws Exception {
		String codigoPersona = ObjectUtils.toString(request.getParameter("codigoPersona")); 
		String stringView = "transferencia";
		ModelAndView view = new ModelAndView(stringView);
		List<CuentaBean> lstCuentaBeans = cuentaService.buscar(Util.toInt(codigoPersona));
		List<ComboBean> lstCuentas = listarComboBean(lstCuentaBeans);
		List<CatalogoBean> lstMonedas = catalogoService.buscar(Constantes.COD_CATOLOGO_MONEDA);
		view.addObject("lstCuentas", lstCuentas);
		view.addObject("lstMonedas", lstMonedas);
		view.addObject("codigoPersona", codigoPersona);
		return view;
	}
	
	@RequestMapping(value = "/realizarTransferencia", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> realizarTransferencia(@Valid @RequestBody MovimientoBean movimientoBean, HttpServletRequest request, HttpServletResponse response) throws MaestrosException{
		
		transferenciaService.realizarTransferencia(movimientoBean);
		
		Map<String, Object> resultado = new HashMap<String, Object>();
		return resultado;
	}
	
	@RequestMapping(value = "/mostrarHabitosAhorro", method = RequestMethod.POST)
	public ModelAndView mostrarHabitosAhorro(HttpServletRequest request) throws Exception {
		String codigoPersona = ObjectUtils.toString(request.getParameter("codigoPersona")); 
		String stringView = "habitosAhorro";
		ModelAndView view = new ModelAndView(stringView);
		List<CuentaBean> lstCuentaBeans = cuentaService.buscar(Util.toInt(codigoPersona));
		List<ComboBean> lstCuentas = listarComboBean(lstCuentaBeans);
		view.addObject("lstCuentas", lstCuentas);
		view.addObject("codigoPersona", codigoPersona);
		return view;
	}
	
	@RequestMapping(value = "/registrarHabitoAhorro", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> registrarHabitoAhorro(@Valid @RequestBody HabitoAhorroBean habitoAhorroBean, HttpServletRequest request, HttpServletResponse response) {
		habitoAhorroService.registrarHabito(habitoAhorroBean);
		
		Map<String, Object> resultado = new HashMap<String, Object>();
		return resultado;
	}

	private List<ComboBean> listarComboBean(List<CuentaBean> lstCuentas) {
		List<ComboBean> lstComboBeans = new ArrayList<ComboBean>();
		lstComboBeans.add(ComboBean.SELECCIONE);
		for (CuentaBean cuentaBean : lstCuentas) {
			lstComboBeans
					.add(new ComboBean(ObjectUtils.toString(cuentaBean.getCodigoCuenta()), cuentaBean.getNumeroCuenta()
							+ " - " + cuentaBean.getDescTipoCuenta() + " - " + cuentaBean.getDescMoneda()));
		}
		return lstComboBeans;
	}

}
