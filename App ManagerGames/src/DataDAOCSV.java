import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataDAOCSV extends DataDAO {
	private String filePath;
	
	public DataDAOCSV(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void load() {
		String line = "";
        String cvsSplitBy = ",";        
        
        ArrayList<String[]> csvData = new ArrayList<String[]>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

        	while ((line = br.readLine()) != null) {             
                String[] dataSample = line.split(cvsSplitBy);
                csvData.add(dataSample);
            }
        	
        	features = new int[csvData.size()][csvData.get(0).length -1]; 
        	labels = new int[csvData.size()]; 
     	
        	for (int i = 0; i < csvData.size() - 1; i++) {
            	for (int j = 0; j < csvData.get(i).length - 1; j++) {            		
            		features[i][j] = Integer.parseInt(csvData.get(i)[j]); 	
            	}
            	labels[i] = Integer.parseInt(csvData.get(i)[csvData.get(i).length - 1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}	
}