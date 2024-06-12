package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;

public class InsertInfoData {

	public static void main(String[] args) {

		String path = "D:\\Trabalho\\BetGreen\\dataFile\\in.txt";
		Connection conn = null;
		PreparedStatement st = null;
		File file = new File(path);
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			FileReader fr = null;
			BufferedReader br = null;
			br = new BufferedReader(fr = new FileReader(path));
			conn = DB.getConnection();
			while (sc.hasNextLine()) {
				String line = br.readLine();
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				st = conn.prepareStatement("INSERT INTO atendente" + "(Id, Name)" + "VALUES" + "(?, ?)");
				st.setInt(1, id);
				st.setString(2, name);

				int rowsAffected = st.executeUpdate();

				System.out.println("Done! Rows affected: " + rowsAffected);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
