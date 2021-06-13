package utils;

import java.io.*;

public class OutputFileReader {

    public String getCarData(String filename, String carReg) {

        String filePath = "src/test/output/"+filename+".txt";

        String carRecord = null;
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = file.readLine()) != null)
            {
                if (line.contains(carReg)) {
                    carRecord = line;
                    break;
                }
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carRecord;
    }
}
