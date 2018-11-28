import java.io.*;
import java.sql.*;
import java.util.StringTokenizer;

public class TesterMysql {

	public static void main(String args[]) {
		// chama o outro lado pra contar
		Cronometro contar = new Cronometro();
		contar.start();
		int cont = 0;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esse", "root", "root");
			Statement stm = con.createStatement();

			BufferedReader reader = new BufferedReader(new FileReader("arquivo/9211.txt")); //9211 100 9277 1k  8525 9k
			String dados[] = new String[4]; // coloca na array de 4
			String linha = reader.readLine(); // le a linha
			while (linha != null) {
				cont++;
				StringTokenizer st = new StringTokenizer(linha, ",\"");
				dados[0] = st.nextToken();
				dados[1] = st.nextToken();
				dados[2] = st.nextToken();
				dados[3] = st.nextToken();

				stm.executeUpdate("insert into dados (dati,longitude,latitude) values ('" + dados[1] + "','" + dados[2]
						+ "','" + dados[3] + "'	);");
				linha = reader.readLine();

			}
			/* String query = "SELECT * FROM dados";
	     	
	         // execute the query, and get a java resultset
	         ResultSet rs = stm.executeQuery(query);
	         
	         // iterate through the java resultset
	         while (rs.next())
	         {
	           int id = rs.getInt("id");
	           String data = rs.getString("dati");
	           String longitude = rs.getString("longitude");
	           String latitude = rs.getString("latitude");

	           // print the results
	           System.out.format("%s, %s, %s, %s\n", id, data, longitude, latitude);
	         }
	*/

			System.out.println("Inserido: " + cont);
			contar.stop();

		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
}