import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongPoint;


import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.*;

// program to build the index
public class practodoctorsearch 
{
	private practodoctorsearch(){} // whats the use of it ?
	public static void main(String args[]) throws IOException
	{
		  String indexPath = "/home/practo/Desktop/Indexfiles_practosearch1";
		  Directory dir = FSDirectory.open(Paths.get(indexPath)); 
	      Analyzer analyzer = new StandardAnalyzer();
	      IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
	      
	      iwc.setOpenMode(OpenMode.CREATE);
	      IndexWriter writer = new IndexWriter(dir, iwc);
	  
		
		indexDoc(writer, "Dr. Alex" , "Bangalore" , 0, "Dentist");
		indexDoc(writer, "Dr. Bore" , "Bangalore" , 1 , "Dentist");
		indexDoc(writer, "Dr. Joe" , "Bangalore" , 1 , "Pathologist") ;
		indexDoc(writer, "Dr. Chandler" , "Bangalore" , 1 , "Pathologist");
		indexDoc(writer, "Dr. Monika" , "Mumbai" , 1 , "Pathologist");
		indexDoc(writer, "Dr. Riddhi" , "Jammu and Kashmir" , 10 ,"Cancer");
		indexDoc(writer, "Dr. Raechel" , "Kolkata" , 3 , "Opthalmologist");
		indexDoc(writer, "Dr. Kanika", "Kolkata" , 3 , "Pediatrics");
		indexDoc(writer, "Dr. Riya" , "Pune" , 4 ,"Pediatrics");
		indexDoc(writer, "Dr. Ritu", "Pune" , 4 , "Cancer");
		writer.close();
	}

	
	
	
	
	
	
	
	
	static void indexDoc(IndexWriter writer, String nameofdoc , String loc, int experienc , String special)
			throws IOException {

	  
	    	
          Document doc = new Document();
          
          Field name = new StringField("name", nameofdoc , Field.Store.YES);
          doc.add(name);
          
          Field location = new StringField("location", loc, Field.Store.YES);
	      doc.add(location);
	     
	      Field experience=new StringField("experience" , Integer.toString(experienc), Field.Store.YES);
	      doc.add(experience);
	      
	      Field speciality= new StringField("speciality", special , Field.Store.YES);
          doc.add(speciality);
          
          writer.addDocument(doc);
          System.out.println("Incremented");
         }
	
}
	
