package br.com.guilherme.tcc.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.com.guilherme.tcc.utils.Constants;

public class Main {

	public static void main(String[] args) {

		FileReader fileReader = null;
		File csvFile = null;
		BufferedReader lerArq = null;
		FileWriter fileWriter = null;
		int count = 0;

		try {
			fileReader = new FileReader(
					Constants.FILE_DIRECTORY);
			lerArq = new BufferedReader(fileReader);
			
			csvFile = new File(
					Constants.FILE_CSV_DIRECTORY);
			
			if(csvFile.exists()) {
				csvFile.delete();
				csvFile.createNewFile();
			}
			fileWriter = new FileWriter(csvFile);
			
			String linha = lerArq.readLine();
			
			while (linha != null) {
				System.out.printf("%s\n", linha);
				String[] splits = linha.split(",");
				fileWriter.append(splits[0]).append(",");
				fileWriter.append(splits[1]).append(",");
				fileWriter.append(splits[2]).append(",");
				fileWriter.append(splits[3]).append(",");
				fileWriter.append(splits[4]).append(",");
				fileWriter.append(splits[5]).append(",");
				fileWriter.append(splits[6]);
				fileWriter.append("\n");
				
				count++;
				linha = lerArq.readLine();
			}
			fileWriter.flush();
			fileWriter.close();
			fileReader.close();
			System.out.printf("N�mero de Linhas: "+count);
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
	}
}
