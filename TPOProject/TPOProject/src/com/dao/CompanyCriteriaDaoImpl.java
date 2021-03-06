package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Company;
import com.model.CompanyCriteria;

public class CompanyCriteriaDaoImpl implements CompanyCriteriaDao
{
	private static List<CompanyCriteria>allCompanyCriteriaList=new ArrayList<CompanyCriteria>();
	@Override
	public List<CompanyCriteria> getCompanyCriteria(int cid) {
		List<CompanyCriteria>companyCriteriaList=new ArrayList<CompanyCriteria>();
		try{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEcompanyCriteria+" where "+COLcid+"="+"?"+";";
			PreparedStatement pst;
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
		
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
		//if(rs.next()==false)return null;
		while(rs.next())
		{
			int yop=rs.getInt(COLyop);
			String branch=rs.getString(COLbranch);
			CompanyCriteria companyCriteria=new CompanyCriteria(new CompanyDaoImpl().getCompany(cid),rs.getInt(COLyop),rs.getString(COLbranch));
			companyCriteriaList.add(companyCriteria);
		}
		return companyCriteriaList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return companyCriteriaList;
	}

	@Override
	public List<CompanyCriteria> getAllCompanyCriteria() {
		try{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEcompanyCriteria+";";
			PreparedStatement pst;
			pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			//if(rs.next()==false)return null;
			while(rs.next())
			{
				int cid1=rs.getInt(COLcid);
				int yop=rs.getInt(COLyop);
				String branch = rs.getString(COLbranch);
				CompanyCriteria companyCriteria=new CompanyCriteria(new CompanyDaoImpl().getCompany(cid1), rs.getInt(COLyop),rs.getString(COLbranch));		
				allCompanyCriteriaList.add(companyCriteria);
			}
			return allCompanyCriteriaList;
		}
		
			catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e);
			}
		return allCompanyCriteriaList;
		
	}

	@Override
	public void addCompanyCriteria(CompanyCriteria c) {
		try
		{
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "insert into " + TABLEcompanyCriteria + " values (?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, c.getCompany().getCid());
			pst.setInt(2, c.getYop());
			pst.setString(3, c.getBranch());
			
			
			pst.executeUpdate();
			allCompanyCriteriaList.add(c);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateCompanyCriteria(CompanyCriteria c) {
		int cid = c.getCompany().getCid();
		int yop = c.getYop();
		String branch = c.getBranch();
		
		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="update "+ TABLEcompanyCriteria +" set "+COLyop+"=?, "+COLbranch+"=? where "+COLcid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,c.getYop());
			pst.setString(2,c.getBranch());
			pst.setInt(3,c.getCompany().getCid());
			 
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCompanyCriteria(CompanyCriteria c) {
		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEcompanyCriteria+" where "+COLcid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,c.getCompany().getCid());
			int executeUpdate = pst.executeUpdate();
		
			for(CompanyCriteria companycriteria:allCompanyCriteriaList)
			{
				if(companycriteria.getCompany().getCid()==c.getCompany().getCid())
				{
					allCompanyCriteriaList.remove(c);
				}
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
