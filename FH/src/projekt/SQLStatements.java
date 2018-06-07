package projekt;

//import jdbcTests.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SQLStatements {
	
	private static final Connect connect = new Connect();
	
/*	public Person selectStatement(String v, String n, String t) {
		Person o = null;
		Connection c = connect.getConnection();
		String sql = "select Vorname, Nachname, typ from Verwaltung where Vorname = '" + v + "'" + " and Nachname = '" + n + "' and typ = '" + t + "'";
		
		try {
			Statement st = c.createStatement();
			System.out.println("f�hre Statement aus: " + sql);
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String vn = rs.getString("Vorname");
				String nn = rs.getString("Nachname");
				String tt = rs.getString("Typ");
				
				
		
			o = new Person(vn, nn, tt);
			return o;
			}
		} 
		catch (Exception e) {
			fehlerAusgabe(e);
		}
		finally {
			Connect.closeConnection(c);
		}
		return null;
	}*/
	
	public Lektionen selectStatementLektion(String t) {
		Lektionen o = null;
		Connection c = connect.getConnection();
		String sql = "select Titel, Beschreibung, Hilfestellung, Lösung from Lektion where Titel = '" + t + "'";
		
		try {
			Statement st = c.createStatement();
			System.out.println("führe Statement aus: " + sql);
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String vn = rs.getString("Beschreibung");
				String nn = rs.getString("Hilfestellung");
				String tt = rs.getString("Lösung");
		
			o = new Lektionen (t,vn, nn, tt);
			return o;
			}
		} 
		catch (Exception e) {
			fehlerAusgabe(e);
		}
		finally {
			Connect.closeConnection(c);
		}
		return null;
	}
	
	public ArrayList<Lektionen> selectAll(){
		ArrayList<Lektionen> alleObjekte = new ArrayList<Lektionen>();
		
		Connection c = connect.getConnection();
		String sql = "select Titel, Beschreibung, Hilfestellung, Lösung from Lektion";
		
		try {
			Statement st = c.createStatement();
			System.out.println("führe Statement aus: " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String t = rs.getString("Titel"); 
				String b = rs.getString("Beschreibung"); 
				String h = rs.getString("Hilfestellung"); 
				String l = rs.getString("Lösung"); 
				
				Lektionen o = new Lektionen(t, b, h, l);
				alleObjekte.add(o); 
			}
			
		} 
		catch (Exception e) {
			fehlerAusgabe(e);
		}
		finally {
			Connect.closeConnection(c);
		}
		
		return alleObjekte;
	}
	
    public TableModel getResultAsTableModel(String befehl) {

        //sammle alle daten aus der Abfrage in einer ArrayList
        //jedes Element in der ArrayList entspricht einer Zeile in der Abfrage
        //und jede Zeile besteht aus mehreren Werten, so viele Spalten es gibt
        ArrayList<Object[]> data = new ArrayList<>();

        Object[] spaltennamen = null;

        Connection c = connect.getConnection();
        String sql = befehl;
        int spalten;
        try {
            Statement st = c.createStatement();
            System.out.println("f�hre Statement aus: " + sql);
            ResultSet rs = st.executeQuery(sql);

            //hier wissen wir nicht wie viele Spalten im Ergebnis sind
            //daher hole ich mir diese mit den MetaDaten
            ResultSetMetaData metadata = rs.getMetaData();
            spalten = metadata.getColumnCount();

            //alle Zeilen einlesen und als Object Arrays in der Liste speichern
            while (rs.next()) {
                Object[] zeilendaten = new Object[spalten];
                for (int i = 1; i <= spalten; i++) {
                    Object zelle = rs.getObject(i);
                    zeilendaten[i - 1] = zelle;
                }
                data.add(zeilendaten);
            }

            //speichere die Spaltennamen der Abfrage in einem weiteren Array
            spaltennamen = new Object[spalten];
            for (int i = 1; i <= spalten; i++) {
                Object spaltenname = metadata.getColumnName(i);
                //-1 weil im resultset bei 1 gez�hlt wird und im Array mit 0
                spaltennamen[i - 1] = spaltenname;
            }

        } catch (Exception e) {
            throw new RuntimeException(sql, e);
        } finally {
            // Connection immer schlie�en wenn sie nicht mehr ben�tigt wird;
            Connect.closeConnection(c);
        }

        //das defaulttablemodel erwartet die Daten in form eines 2-dimensionalen Object-Arrays;
        //deshalb wandeln wir die Arraylist in ein solches um:
        Object[] [] datenArray = new Object[data.size()][];
        for(int i = 0; i<data.size(); i++){
            Object[] zeile = data.get(i);
            datenArray[i] = zeile;
        }
        
        //nun k�nnen wir ein TableModel erstellen
        DefaultTableModel tdm = new DefaultTableModel(datenArray, spaltennamen);

        return tdm;

    }


	
	private static void fehlerAusgabe(Exception e) {
		System.out.println(" !!! FEHLER !!! - " + e.getLocalizedMessage());
	}
}
