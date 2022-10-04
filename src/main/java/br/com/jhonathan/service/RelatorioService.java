package br.com.jhonathan.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class RelatorioService {

	@Value("classpath:reports/relatorio.jrxml")
	private Resource relatorio;
	
	public byte[] gerarRelatorio() {
		
		try {
			JasperReport comipledReport = JasperCompileManager.compileReport(relatorio.getInputStream());
			
			Map<String, Object> parametros = new HashMap<>();
			
			JasperPrint print = JasperFillManager.fillReport(comipledReport, parametros, new JREmptyDataSource());
			
			return JasperExportManager.exportReportToPdf(print);
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}