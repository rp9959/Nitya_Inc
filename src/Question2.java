import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;


public class Question2 {
    private File directory;
    private int maxLineLength;
    private Map<Integer,Integer> groupData;
    
    public Question2(File directory){
    	
    	if(!directory.isDirectory()) {
            System.out.println("Given Path is not a Directory");
            System.exit(-1);
        }
    	
        this.directory = directory;
        this.groupData  = new TreeMap<>();
        this.maxLineLength = 15;
   
    }
 
    
    private void monthOfFiles() throws IOException {
    	
        for(File file : directory.listFiles()){
            if(file!=null && file.isFile()){

            	    BasicFileAttributes attrs;
        		    attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        		    FileTime time = attrs.creationTime(); 		    
        		    long createdDateInMillis= time.toMillis();
        		    Calendar cal = Calendar.getInstance();
        	        cal.setTimeInMillis(createdDateInMillis);
        	        int month=cal.get(Calendar.MONTH)+1;
                    groupData.put(month,groupData.getOrDefault(month,0)+1);
            }
        }
        
        
        System.out.print("MONTH");
        for(int j=0;j<maxLineLength-"count".length();j++) System.out.print(' ');
        System.out.println("FILE COUNT");
        System.out.println();
        
        for(int i = 1;i<=13;i++){
            if(groupData.containsKey(i)){
            	String month=Month.of(i).name();
            	System.out.print(month);
            	
            	for(int j=0;j<maxLineLength-month.length();j++) System.out.print(' ');
            	
            	System.out.println(groupData.get(i));}}
            	
    }
 
    public static void main(String[] args){
    	System.out.println("Paste the link to directory");
    	Scanner scan = new Scanner(System.in);
    	String directoryPath =  scan.nextLine();        
        File directory = new File(directoryPath);
        Question2 question2 = new Question2(directory);
    
        try {
            question2.monthOfFiles() ;
 
        } catch (IOException e) 
        {
        	   e.printStackTrace();
        }
    }
}
