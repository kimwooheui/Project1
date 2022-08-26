package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBExpert {
	DBExpert(){}
	final String name = "oracle.jdbc.OracleDriver";
	final String db = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	Connection con ; Statement stmt; PreparedStatement pstmt;
	ResultSet rs;	//ArrayList al;
	
	int selectTotalCount() {
		String select = "select count(*) from notice_tbl";
		int count = -1;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(db,"hr","hr");
			stmt=con.createStatement();
			rs=stmt.executeQuery(select);
			if(rs.next()) count = rs.getInt(1);
			else count = 0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); stmt.close();rs.close();
			}catch(Exception e) {}
		}
		return count;
	}
	
	ArrayList<Notice> selectAllNotice(){
		ArrayList<Notice> al = new ArrayList<Notice>();
		//��ȸ����� Notice�� ���
		try {
			Class.forName(name);
			con = DriverManager.getConnection(db,"hr","hr");
			String select = "select seqno,id,title,d "//1,2,3,(�Ʒ��� get��Ʈ���̳� int
							+"from (select seqno,id,title,d,rownum rn "//4��°
							+"from (select seqno,id, title,to_char(input_date,'yy/mm/dd hh:mm:ss') d "
							+"from notice_tbl order by seqno desc)) "
							+"where rn > ? and rn < ?";
			//stmt = con.createStatement();
			pstmt = con.prepareStatement(select);
			Integer pageNo = 1;
			int start = (pageNo - 1) * 5;
			int end = ((pageNo - 1) * 5) + 6;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
//			rs = stmt.executeQuery(select);
			while (rs.next()) {
				Notice notice = new Notice();//DTO����
				notice.setSeqno(rs.getInt(1));
				notice.setId(rs.getString(2));
				notice.setTitle(rs.getString(3));
				notice.setDatt(rs.getString(4));
				al.add(notice);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();con.close();stmt.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Notice�� ArrayList�� ��´�. ���� Ÿ������ ���ϵǴ°�.
		return al;
	}
	
	void insertNotice(Notice n) {
		try {
			Class.forName(name);
			con = DriverManager.getConnection(db,"hr","hr");
			String insert = "insert into notice_tbl values("+
					"?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, n.getSeqno());//�۹�ȣ ����
			pstmt.setString(2, n.getId());//���̵�
			pstmt.setString(3, n.getTitle());//����
			pstmt.setString(4, n.getContent());//����
			pstmt.executeUpdate();//insert ����
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			} catch (Exception e) {
				}
		}
	}
	int getSeqno() {
		int maxSeqno = -1;//���� ū �۹�ȣ�� ����� ����
		try {
			Class.forName(name);
			con = DriverManager.getConnection(db,"hr","hr");
			String select = 
					"select max(seqno) from notice_tbl";
			stmt = con.createStatement();
			rs = stmt.executeQuery(select);
			if (rs.next()) {//�˻� ����� �̵��� �Ǵ� ���
				maxSeqno = rs.getInt(1);
			}else {//�˻� ����� �̵��� �� �Ǵ� ���
				maxSeqno = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch(Exception e) {}
		}
		return maxSeqno;
	}
	
}
