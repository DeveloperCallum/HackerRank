package callum.hackerrank.problems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private boolean useConsole = true;
	private final String fileName;

	private String data = "";

	public Logger(boolean useConsole) {
		this.useConsole = useConsole;
		fileName = "Genetic Algorithm Output -" + System.currentTimeMillis();
	}

	public Logger() {
		fileName = "Genetic Algorithm Output -" + System.currentTimeMillis();
	}

	public void printMessage(String message) {
		if (useConsole) {
			System.out.println(message);
			return;
		}

		data += message + "\n";
		System.out.println(message);
	}

	public void flush() {
		File file = new File(fileName);

		if (!file.exists()) {
			try (FileWriter fileWriter = new FileWriter(file)) {
				file.createNewFile();
				fileWriter.write(data);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}