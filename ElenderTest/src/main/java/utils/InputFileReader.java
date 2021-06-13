package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputFileReader {

    public List<String> extractCarRegs(String filename) {

        String filePath = "src/test/input/"+filename+".txt";
        String fileText = null;

        try {
            fileText = Files.lines(Paths.get(filePath)).collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("([A-Z]{2}[0-9]{2} [A-Z]{3})|([A-Z]{2}[0-9]{2}[A-Z]{3})");
        Matcher match = pattern.matcher(fileText);

        List<String> matches = new ArrayList<String>();
        while (match.find()) {
            matches.add(match.group());
        }

        return matches;
    }
}
