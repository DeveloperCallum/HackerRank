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
		fileName = "Genetic Algorithm Output -" + (System.currentTimeMillis() / 1000);
	}

	public Logger() {
		fileName = "Genetic Algorithm Output -" + (System.currentTimeMillis() / 1000);
	}

	public void printMessage(String message) {
		if (!message.isEmpty()){
			if (!useConsole) {
				data += Thread.currentThread().getName() + ": " + message + "\n";
			}

			System.out.println(Thread.currentThread().getName() + ": " + message);
		}else{
			if (!useConsole) {
				data += message + "\n";
			}

			System.out.println(message);
		}
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