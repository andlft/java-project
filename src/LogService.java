import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogService {
    private static LogService instance;
    private static final String[] CSVHeader = {"Action", "Model", "Timestamp"};
    private SimpleDateFormat dateFormat;

    private LogService(){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        initializeCSVFile();
    }

    public static LogService getInstance(){
        if (instance == null){
            instance = new LogService();
        }
        return instance;
    }

    private void initializeCSVFile() {
        File file = new File("log.csv");

        if (!file.exists() || file.length() == 0) {
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                if (file.length() == 0) {
                    printWriter.println(String.join(",", CSVHeader));
                }

                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logAction(String action, String model) {
        Date timestamp = new Date();
        String formattedTimestamp = dateFormat.format(timestamp);
        String[] logRecord = {action, model, formattedTimestamp};
        writeLogRecord(logRecord);
    }


    private void writeLogRecord(String[] logRecord) {
        try {
            FileWriter fileWriter = new FileWriter("log.csv", true);
            StringBuilder sb = new StringBuilder();
            for (String field : logRecord) {
                sb.append(escapeSpecialCharacters(field)).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            fileWriter.append(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String escapeSpecialCharacters(String value) {
        if (value.contains("\"")) {
            value = value.replace("\"", "\"\"");
        }
        return value;
    }
}
