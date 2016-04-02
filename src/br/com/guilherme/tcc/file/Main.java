package br.com.guilherme.tcc.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		FileReader fileReader = null;
		File csvFile = null;
		BufferedReader lerArq = null;
		FileWriter fileWriter = null;
		int count = 0;

		try {
			fileReader = new FileReader(
					"C:/Users/Guilherme Andrade/Desktop/TestesTCC/data.txt");
			lerArq = new BufferedReader(fileReader);
			
			csvFile = new File("C:/Users/Guilherme Andrade/Desktop/TestesTCC/saida.csv");
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
			System.out.printf("Número de Linhas: "+count);
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
	}
}
