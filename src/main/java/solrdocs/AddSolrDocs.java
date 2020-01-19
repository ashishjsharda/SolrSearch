package solrdocs;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;


/**
 * Add Documents to Solr
 * @author ashish
 *
 */
public class AddSolrDocs {

	public static void main(String[] args) throws SolrServerException, IOException {
		
		
		SolrClient client = new HttpSolrClient.Builder("http://localhost:8901/solr/").build();
	    for(int i=0;i<1000;++i) {
	      SolrInputDocument doc = new SolrInputDocument();
	      doc.addField("Java", "book");
	      doc.addField("id", "book-" + i);
	      doc.addField("name", "Complete Reference Java " + i);
	      client.add(doc);
	      if(i%100==0) client.commit();  
	    }
	    client.commit();
	}
}
