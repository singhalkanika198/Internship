package lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.*;

public class SearchFiles {

	  private SearchFiles() {}

	  /** Simple command-line based search demo. */
	  public static void main(String[] args) throws Exception {
	    String usage =
	      "Usage:\tjava org.apache.lucene.demo.SearchFiles [-index dir] [-field f] [-repeat n] [-queries file] [-query string] [-raw] [-paging hitsPerPage]\n\nSee http://lucene.apache.org/java/4_0/demo.html for details.";
	    if (args.length > 0 && ("-h".equals(args[0]) || "-help".equals(args[0]))) {
	      System.out.println(usage);
	      System.exit(0);}
	    
	    String index = "/home/practo/Desktop/Lucene-Tutorials-master/index";
	    String field = "contents";
	    String queries = null;
	    int repeat = 0;
	    boolean raw = false;
	    //String queryString = "computer";
	    int hitsPerPage = 100;
	    IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));
	    IndexSearcher searcher = new IndexSearcher(reader);
	    Analyzer analyzer = new StandardAnalyzer();
	    BufferedReader in = null;
	    QueryParser parser = new QueryParser(field, analyzer);

	    Query tquery= new TermQuery(new Term("contents", "The"));
	      searcher.search(tquery, 100);
      
	      System.out.println("Searching for: " + tquery.toString());
	      searcher.search(tquery, 100);
	      doSearch(in, searcher, tquery, hitsPerPage, raw, false);    
	      reader.close();
	    
	  }// end of main
	  
	  
	  
	  public static void doSearch(BufferedReader in, IndexSearcher searcher, Query query, 
              int hitsPerPage, boolean raw, boolean interactive) throws IOException 
{

// Collect enough docs to show 5 pages
    TopDocs results = searcher.search(query, 5 * hitsPerPage);
    ScoreDoc[] hits = results.scoreDocs;

   int numTotalHits = results.totalHits;
    System.out.println(numTotalHits + " total matching documents");

    int start = 0;
    int end = Math.min(numTotalHits, hitsPerPage);
    System.out.println(end);
    
    
    
   for (int i = start; i < end; i++) 
    {
    Document doc = searcher.doc(hits[i].doc);
   String path = doc.get("path");
    String update=doc.get("modified");
   
    
   if (path != null) 
  {
    System.out.println((i+1) + ". " + path);
    String title = doc.get("title");
    if (title != null) 
    System.out.println("   Title: " + doc.get("title"));
   }
   
   else System.out.println((i+1) + ". " + "No path for this document");
//    if(update!=null)
//    {
//    	System.out.println((update));
//    }

            
}

}// end of class

}



































