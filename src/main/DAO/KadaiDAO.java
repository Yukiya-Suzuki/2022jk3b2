import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.SampleDataBean;
import conn.Conn;

public class KadaiDAO extends Conn implements Serializable{
	private static final long serialVesionUID = 1L;
		
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = null;
	private static final int MAXROW = 10;
		
	public KadaiDAO() {
		con = conn();
	}
		
	public int getMaxPage(String keyword) {
		if(keyword == null || keyword == "") {
			keyword = "";
		}
		int allPage = -1;
		try {
		    sql = "select count(*) as cnt from sample where name like ?";
		    pst = con.prepareStatement(sql);
		    pst.setString(1, "%" + keyword + "%");
		    rs = pst.executeQuery();
		    rs.next();
		    int records = rs.getInt("cnt");
		    allPage = (records - 1) / MAXROW + 1;
		} catch (Exception e) {
		    e.printStackTrace();
		    allPage = 0;
		}
		return allPage;
	}
	
	public List<SampleDataBean> getAllData(int page , String keyword) {
		List<SampleDataBean> data = new ArrayList<SampleDataBean>();
		try {
			if(keyword == null || keyword == "") {
				keyword = "";
			}
			sql = "select * from sample where name like ? limit ? , ?";
			pst = con.prepareStatement(sql);
			int baseRow = (page - 1) * MAXROW;
			pst.setString(1,"%" + keyword + "%");
			pst.setInt(2, baseRow);
			pst.setInt(3, MAXROW);
			rs = pst.executeQuery();
				
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				SampleDataBean b = new SampleDataBean();
				b.setId(id);
				b.setName(name);
				data.add(b);
			}
		} catch(Exception e) {
			data = null;
		}
		return data;
	}
	
	
		
}
