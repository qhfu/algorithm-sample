package qhfu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtils {
    public static List<String> getLinesFromFile(final String fileName) {
	List<String> resList = new ArrayList<String>();
	try {
	    InputStream in = FileReaderUtils.class.getClassLoader()
		    .getResourceAsStream(fileName);
	    InputStreamReader isReader = new InputStreamReader(in);
	    LineNumberReader lineReader = new LineNumberReader(isReader);
	    String line = lineReader.readLine();
	    while (line != null) {
		resList.add(line);
		line = lineReader.readLine();
	    }
	} catch (IOException ioe) {
	    // ignore it
	}
	return resList;
    }
}
