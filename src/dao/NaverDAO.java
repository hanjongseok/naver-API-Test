package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import dto.NaverDTO;

public interface NaverDAO {
	
	public  void insert(NaverDTO dto);

	

}
