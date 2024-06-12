package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;

public class GetInfoData {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Integer dataInfoId = 0;
		String dataInfoName = "Testes";
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from atendente");
			List<String> lines = new ArrayList<>();
			while(rs.next()) {
				dataInfoId = rs.getInt("Id");
				dataInfoName = rs.getString("Name");
				System.out.println("Id: " + dataInfoId);
				System.out.println("Name: " + dataInfoName);
				lines.add(Integer.toString(dataInfoId));
				lines.add(dataInfoName);
			}
			
			String path = "D:\\Trabalho\\BetGreen\\dataFile\\out.txt";
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
				for(String line : lines) {
					System.out.println(line);
					bw.write(line);
					bw.newLine();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
