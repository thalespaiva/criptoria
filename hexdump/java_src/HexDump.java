/*                      HexDump.java
 *
 * Thales Paiva <thalespaiva em gmail>
 *  
 * Simples hexdump para ilustrar como ler um arquivo binário para um vetor.
 * Escreve no arquivo_saida e arquivo_entrada XOR FF, byte a byte.
 *
 * Para compilar:
 *  javac HexDump.java 
 *
 * Para rodar:
 *  java HexDump <arquivo_entrada> <arquivo_saida>
 *
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;


public class HexDump {
  
    public static void main(String[] args) throws IOException{
        
        if (args.length != 2) {
            System.out.println("Usage: java HexDump <input_file_name> <output_file_name>");
            System.exit(1);
        }

        String inputFileName = args[0];
        String outputFileName = args[1];
        byte[] fileBytes = readFile(inputFileName);

        System.out.printf("%02x ", fileBytes[0]);
        for (int i = 1; i < fileBytes.length; i++) {
            if (i % 16 == 0)
                System.out.printf("\n");
            else if (i % 4 == 0)
                System.out.printf(" ");
            System.out.printf("%02X ", fileBytes[i]);
        }
        System.out.printf("\n");

        for (int i = 0; i < fileBytes.length; i++)
            fileBytes[i] ^= 0xFF; 
        
        writeFile(outputFileName, fileBytes);
    }

    public static byte[] readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllBytes(filePath);
    }
  
    public static void writeFile(String fileName, byte[] fileBytes) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, fileBytes);
    }
    
}  
