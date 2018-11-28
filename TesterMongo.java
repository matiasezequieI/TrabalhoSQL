
/*
		 * MongoClient mongoClient = new MongoClient("localhost", 27017); DB db =
		 * mongoClient.getDB("mitienda"); DBCollection coll =
		 * db.getCollection("usuarios"); System.out.println("conectado");
		 * 
		 * BasicDBObject document = new BasicDBObject(); document.put("name",
		 * "Shubhamssda"); document.put("company", "Baeldung");
		 * coll.insert(document);//inserir
		

		DBCursor cursorDoc = coll.find();
		while (cursorDoc.hasNext()) {
			System.out.println(cursorDoc.next());// print
		}*/
//DBObject document = new BasicDBObject("data", "latitude")
//      .append("languages", Arrays.asList(""+dados[1], "C"+dados[2], "C++"+dados[3]));
// Creates a document to be stored in the teachers collections.
/*BasicDBObject document = new BasicDBObject();
document.put("data", "Longitude");
document.put(""+dados[1], ""+dados[2]);*/

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.StringTokenizer;

public class TesterMongo {

	public static void main(String[] args) {

		// chama o outro lado pra contar
		Cronometro contar = new Cronometro();
		contar.start();
		int cont = 0;
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("mitienda");
			DBCollection coll = db.getCollection("usuarios");
			System.out.println("conectado");

			BufferedReader reader = new BufferedReader(new FileReader("arquivo/8.txt")); // 9277 1k 9211 100 8525 9k

			String dados[] = new String[4]; // Coloca em uma array de 4
			String linha = reader.readLine(); // Le a linha

			while (linha != null) {
				cont++;
				StringTokenizer st = new StringTokenizer(linha, ",\"");
				dados[0] = st.nextToken();
				dados[1] = st.nextToken();
				dados[2] = st.nextToken();
				dados[3] = st.nextToken();
				// inserir
				DBObject document = new BasicDBObject("Dados", new BasicDBObject("Data", "" + dados[1])
						.append("Latitude", "" + dados[2]).append("Longitude", "" + dados[3]));
				coll.insert(document);// insere o documento na coleção

				// print
				// System.out.println(document.toString());\
				linha = reader.readLine();
			}
			System.out.println("Inserido");
			System.out.println(cont);
			contar.stop();
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
}
