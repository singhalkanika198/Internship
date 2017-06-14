import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.*;

// program to search
public class practodoctorsearch1 {

    private practodoctorsearch1() {}

    /** Simple command-line based search demo. */
    public static void main(String[] args) throws Exception {
      
      String index = "/home/practo/Desktop/Indexfiles_practosearch1";
      String field = "location";
      String queries = null;
      int repeat = 0;
      boolean raw = false;
      int hitsPerPage = 100;
      IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));
      IndexSearcher searcher = new IndexSearcher(reader);
      Analyzer analyzer = new StandardAnalyzer();
      
//      Scanner sc=new Scanner(System.in);
//      System.out.println("Enter the parameter to search");
//      String p=sc.nextLine();
//      System.out.println("Enter "+p+" : ");
//      String q=sc.nextLine();
      
      
      
        BufferedReader in = null;
	    QueryParser parser = new QueryParser(field, analyzer);
          
	      // term query
	      //Query tquery= new TermQuery(new Term(p,q));
	      
	      // Fuzzy query
	      //Query tquery= new FuzzyQuery(new Term(p,q));
	      
	      // Boolean query
	      BooleanQuery.Builder bquery=new BooleanQuery.Builder();
	      Query tquery1= new TermQuery(new Term("location","Bangalore"));
	      Query tquery2= new TermQuery(new Term("speciality","Dentist"));
	      bquery.add(tquery1,BooleanClause.Occur.MUST);
	      bquery.add(tquery2,BooleanClause.Occur.MUST_NOT);
	      BooleanQuery qw=bquery.build();
     
	      //prefix query
//	      System.out.println("Returning all those locations whose prefix matches with bangalore");
//	      Query tquery=new PrefixQuery(new Term("location" , "Kol"));
//	      doSearch(in, searcher, tquery, hitsPerPage, false, false); 
	      
	      
	      // term range query
	      Query   q2 = TermRangeQuery.newStringRange("experience", "0", "10", true, true);
	      doSearch(in, searcher, q2, hitsPerPage, false, false); 
	      reader.close();
  
      
    }// end of main
    
    
    


public static void doSearch(BufferedReader in, IndexSearcher searcher, Query query, 
              int hitsPerPage, boolean raw, boolean interactive) throws IOException 
{

// Collect enough docs to show 5 pages
    TopDocs results = searcher.search(query, hitsPerPage);
    ScoreDoc[] hits = results.scoreDocs;
    System.out.println(hits.length);

    int numTotalHits = results.totalHits;
    System.out.println(numTotalHits + " total matching documents");

    int start = 0;
    int end = Math.min(numTotalHits, hitsPerPage);
    System.out.println("kanika");
    System.out.println(end);
    
    
    
   for (int i = start; i < end; i++) 
    {
    Document doc = searcher.doc(hits[i].doc);
    //String path = doc.get("path");
    String name=doc.get("name");
    System.out.println(name);
  }

}

}



































