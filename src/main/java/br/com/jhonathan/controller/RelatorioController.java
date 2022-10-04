package br.com.jhonathan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhonathan.service.RelatorioService;

@RestController
@RequestMapping("/api")
public class RelatorioController {

	@Autowired
	RelatorioService relatorioService;
	
	@GetMapping("/relatorio")
	public ResponseEntity<byte[]> gerarRelatorio() {
		byte[] relatorioGerado = relatorioService.gerarRelatorio();
		
		HttpHeaders heders = new HttpHeaders();
		var fileName = "relatorio.pdf";
		
		heders.setContentDispositionFormData("inline; filename=\"" + fileName + "\"", fileName);
		heders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		
		var responseentity = new ResponseEntity<>(relatorioGerado, heders, HttpStatus.OK);
		
		return responseentity;
		
		
		
		
	}
}
