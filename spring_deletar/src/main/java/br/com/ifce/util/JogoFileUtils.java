package br.com.ifce.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class JogoFileUtils {
	
	public static void salvarImagem(String caminho, MultipartFile imagem) {
		File file = new File(caminho);
		
		//ta dando erro nesse 'FileUtils'
		/*
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
	}
}
