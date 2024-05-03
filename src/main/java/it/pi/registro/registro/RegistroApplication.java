package it.pi.registro.registro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@SpringBootApplication
@EnableScheduling
public class RegistroApplication {

	public static void main(String[] args) {

		SpringApplication.run(RegistroApplication.class, args);
//		LocalDateTime ora = LocalDateTime.now();
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//		String formatDateTime = ora.format(format);
//		String folder = "./logs";
//		String zippedFile = "./zippedLogs" + File.separator + formatDateTime + ".zip";
//
//		try {
//			FileOutputStream fos = new FileOutputStream(zippedFile);
//			ZipOutputStream zipOut = new ZipOutputStream(fos);
//			Files.walk(Paths.get(folder))
//					.filter(Files::isRegularFile)
//					.forEach(filePath -> {
//						try {
//							String relativePath = folder + File.separator + filePath.getFileName();
//							zipFile(filePath.toFile(), relativePath, zipOut);
//							Files.delete(filePath);
//						} catch (IOException e) {
//							System.out.println("error " + e);
//						}
//					});
//		} catch (IOException e) {
//			System.out.println("error " + e);
//		}
//	}
//
//	private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
//		FileInputStream fis = new FileInputStream(fileToZip);
//		ZipEntry zipEntry = new ZipEntry(fileName);
//		zipOut.putNextEntry(zipEntry);
//		byte[] bytes = new byte[1024];
//		int length;
//		while ((length = fis.read(bytes)) >= 0) {
//			zipOut.write(bytes, 0, length);
//		}
//		fis.close();
//

	}



	}


