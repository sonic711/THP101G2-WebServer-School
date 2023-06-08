package web.point.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import static core.util.CommonUtil.*;

import web.member.member.bean.Member;
import web.point.bean.PointChanged;
import web.point.dao.pointChangedDao;

public class pointChangedDaoImpl implements pointChangedDao {

	@Override
	public int insertForSC() {

		// STUDENT_COURSES的UPDATETIME的default必須設為NOT NULL DEFAULT CURRENT_TIMESTAMP ON
		// UPDATE CURRENT_TIMESTAMP 才能運作
		String sql1 = "select STUDENT_COURSES_ID, MEMBER_NO "
				+ "from STUDENT_COURSES where COURSES_PROGRESS = 1 order by UPDATETIME desc limit 1";
		String sql2 = "insert into "
				+ "POINTS_CHANGED(MEMBER_NO,COMMENT_ID,SHOP_ORDER_ID,STUDENT_COURSES_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING) values(?,?,?,?,?,?)";

		String sql3 = "update MEMBER set REWARD_POINTS = REWARD_POINTS + ? where MEMBER_NO = ? ";
		try (Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);

		) {
			conn.setAutoCommit(false);
			PointChanged PC = new PointChanged();
			try (ResultSet rs1 = pstmt1.executeQuery();) {
				if (rs1.next()) {
					int SCI = rs1.getInt("STUDENT_COURSES_ID");
					int MNO = rs1.getInt("MEMBER_NO");
					PC.setStudentCoursesId(SCI);
					PC.setMemberNo(MNO);
				}

				pstmt2.setObject(1, PC.getMemberNo());
				pstmt2.setObject(2, null);
				pstmt2.setObject(3, null);
				pstmt2.setObject(4, PC.getStudentCoursesId());
				pstmt2.setObject(5, null);
				pstmt2.setInt(6, 20);
				int rs2 = pstmt2.executeUpdate();
				if (rs2 < 1) {
					return -21;
				}
				pstmt3.setInt(1, 20);
				pstmt3.setInt(2, PC.getMemberNo());
				int rs3 = pstmt3.executeUpdate();
				if (rs3 < 1) {
					return -31;
				}
				conn.commit();
				return rs3;
			}

			catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -71;
	}

	@Override
	public int insertForCMT() {
		String sql1 = "select COMMENT_ID, MEMBER_NO from COMMENT order by UPDATETIME desc limit 1 ";
		String sql2 = "insert into POINTS_CHANGED(MEMBER_NO,COMMENT_ID,SHOP_ORDER_ID,STUDENT_COURSES_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING) values(?,?,?,?,?,?)";
		String sql3 = "update MEMBER set REWARD_POINTS = REWARD_POINTS + ? where MEMBER_NO = ?;";
		try (Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);

		) {
			conn.setAutoCommit(false);
			PointChanged PC = new PointChanged();
			try (ResultSet rs1 = pstmt1.executeQuery();) {
				if (rs1.next()) {
					int CMTI = rs1.getInt("COMMENT_ID");
					int MNO = rs1.getInt("MEMBER_NO");
					PC.setCommentId(CMTI);
					PC.setMemberNo(MNO);
				}
				pstmt2.setObject(1, PC.getMemberNo());
				pstmt2.setObject(2, PC.getCommentId());
				pstmt2.setObject(3, null);
				pstmt2.setObject(4, null);
				pstmt2.setObject(5, null);
				pstmt2.setInt(6, 5);
				int rs2 = pstmt2.executeUpdate();
				if (rs2 < 1) {
					return -22;
				}
				pstmt3.setInt(1, 5);
				pstmt3.setInt(2, PC.getMemberNo());
				int rs3 = pstmt3.executeUpdate();
				if (rs3 < 1) {
					return -32;
				}
				conn.commit();
				return rs3;
			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -72;
	}

	@Override
	public int insertForMLR(Integer MId) {
		String sql0 = "insert into MEMBER_LOGIN_RECORD(MEMBER_NO, LOGIN_TIME, CREATE_AT) values(?, now(), now())";
		// MEMBER_LOGIN_RECORD(table)的LOGIN_TIME的Default須為now() => 可能不用改??
		String sql1 = "select LOGIN_RECORD_ID,MEMBER_NO,DATE(LOGIN_TIME) as T1 from MEMBER_LOGIN_RECORD order by LOGIN_TIME desc limit 1 ";
		String sqlDay = "select DATE(LOGIN_TIME) as T2 from MEMBER_LOGIN_RECORD where MEMBER_NO = ? order by LOGIN_TIME desc limit 1,1";
		String sql2 = "insert into POINTS_CHANGED(MEMBER_NO,COMMENT_ID,SHOP_ORDER_ID,STUDENT_COURSES_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING) values(?,?,?,?,?,?)";
		String sql3 = "update MEMBER set REWARD_POINTS = REWARD_POINTS + ? where MEMBER_NO = ?";
		PointChanged PC = new PointChanged();

		try (Connection conn = getConnection(); PreparedStatement pstmt0 = conn.prepareStatement(sql0);) {
			pstmt0.setInt(1, MId);
			int rs0 = pstmt0.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return -13;
		}

		try (Connection conn = getConnection();

				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				PreparedStatement pstmtD = conn.prepareStatement(sqlDay);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);) {
			conn.setAutoCommit(false);

			try (ResultSet rs1 = pstmt1.executeQuery();

			) {
				if (rs1.next()) {
					LocalDate T1 = rs1.getDate("T1").toLocalDate();

					pstmtD.setObject(1, rs1.getInt("MEMBER_NO"));
					try (ResultSet rsD = pstmtD.executeQuery();) {
						if (rsD.next()) {
							LocalDate T2 = rsD.getDate("T2").toLocalDate();

							long diffInDays = ChronoUnit.DAYS.between(T1, T2);
							if (diffInDays == 0) {
								return 0;
							}
						}

					}

					PC.setLoginRecordId(rs1.getInt("LOGIN_RECORD_ID"));
					PC.setMemberNo(rs1.getInt("MEMBER_NO"));
				}
				pstmt2.setObject(1, PC.getMemberNo());
				pstmt2.setObject(2, null);
				pstmt2.setObject(3, null);
				pstmt2.setObject(4, null);
				pstmt2.setObject(5, PC.getLoginRecordId());
				pstmt2.setInt(6, 1);
				int rs2 = pstmt2.executeUpdate();
				if (rs2 < 1) {
					return -23;
				}
				pstmt3.setInt(1, 1);
				pstmt3.setInt(2, PC.getMemberNo());
				int rs3 = pstmt3.executeUpdate();
				if (rs3 < 1) {
					return -33;
				}
				conn.commit();
				return rs3;
			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return -73;
	}

//	@Override
//	public int insertForMLR(Integer MId) {
//		String sql0 = "insert into MEMBER_LOGIN_RECORD(MEMBER_NO, LOGIN_TIME, CREATE_AT) values(?, now(), now())";
//		// MEMBER_LOGIN_RECORD(table)的LOGIN_TIME的Default須為now() => 可能不用改??
//		String sql1 = "select LOGIN_RECORD_ID,MEMBER_NO,DATE(LOGIN_TIME) as T1 from MEMBER_LOGIN_RECORD order by LOGIN_TIME desc limit 1 ";
//		String sqlDay = "select DATE(LOGIN_TIME) as T2 from MEMBER_LOGIN_RECORD where MEMBER_NO = ? order by LOGIN_TIME desc limit 1,1";
//		String sql2 = "insert into POINTS_CHANGED(MEMBER_NO,COMMENT_ID,SHOP_ORDER_ID,STUDENT_COURSES_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING) values(?,?,?,?,?,?)";
//		String sql3 = "update MEMBER set REWARD_POINTS = REWARD_POINTS + ? where MEMBER_NO = ?";
//		
//		
//		try (Connection conn = getConnection();
//				PreparedStatement pstmt0 = conn.prepareStatement(sql0);
//				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
//				PreparedStatement pstmtD = conn.prepareStatement(sqlDay);
//				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//				PreparedStatement pstmt3 = conn.prepareStatement(sql3);) {
//			conn.setAutoCommit(false);
//			PointChanged PC = new PointChanged();
//			pstmt0.setObject(1, MId);
//			int rs0 = pstmt0.executeUpdate();
//			
//			
//			
//			
//			try (ResultSet rs1 = pstmt1.executeQuery();
//
//			) {
//				if (rs1.next()) {
//					LocalDate T1 = rs1.getDate("T1").toLocalDate();
//
//					pstmtD.setObject(1, rs1.getInt("MEMBER_NO"));
//					try (ResultSet rsD = pstmtD.executeQuery();) {
//						if (rsD.next()) {
//							LocalDate T2 = rsD.getDate("T2").toLocalDate();
//
//							long diffInDays = ChronoUnit.DAYS.between(T1, T2);
//							if (diffInDays == 0) {
//								return 0;
//							}
//						}
//
//					}
//
//					PC.setLoginRecordId(rs1.getInt("LOGIN_RECORD_ID"));
//					PC.setMemberNo(rs1.getInt("MEMBER_NO"));
//				}
//				pstmt2.setObject(1, PC.getMemberNo());
//				pstmt2.setObject(2, null);
//				pstmt2.setObject(3, null);
//				pstmt2.setObject(4, null);
//				pstmt2.setObject(5, PC.getLoginRecordId());
//				pstmt2.setInt(6, 1);
//				int rs2 = pstmt2.executeUpdate();
//				if (rs2 < 1) {
//					return -23;
//				}
//				pstmt3.setInt(1, 1);
//				pstmt3.setInt(2, PC.getMemberNo());
//				int rs3 = pstmt3.executeUpdate();
//				if (rs3 < 1) {
//					return -33;
//				}
//				conn.commit();
//				return rs3;
//			} catch (SQLException e) {
//				conn.rollback();
//				e.printStackTrace();
//			}
//
//		} catch (
//
//		Exception e) {
//			e.printStackTrace();
//		}
//
//		return -73;
//	}

//	@Override
//	public int insertForMLR() {
//
//		// MEMBER_LOGIN_RECORD(table)的LOGIN_TIME的Default須為now()
//		String sql1 = "select LOGIN_RECORD_ID,MEMBER_NO,DATE(LOGIN_TIME) as T1 from MEMBER_LOGIN_RECORD order by LOGIN_TIME desc limit 1 ";
//		String sqlDay = "select DATE(LOGIN_TIME) as T2 from MEMBER_LOGIN_RECORD where MEMBER_NO = ? order by LOGIN_TIME desc limit 1,1";
//		String sql2 = "insert into POINTS_CHANGED(MEMBER_NO,COMMENT_ID,SHOP_ORDER_ID,STUDENT_COURSES_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING) values(?,?,?,?,?,?)";
//		String sql3 = "update MEMBER set REWARD_POINTS = REWARD_POINTS + ? where MEMBER_NO = ?";
//		try (Connection conn = getConnection();
//				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
//				PreparedStatement pstmtD = conn.prepareStatement(sqlDay);
//				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//				PreparedStatement pstmt3 = conn.prepareStatement(sql3);) {
//			conn.setAutoCommit(false);
//			PointChanged PC = new PointChanged();
//			try (ResultSet rs1 = pstmt1.executeQuery();
//
//			) {
//				if (rs1.next()) {
//					LocalDate T1 = rs1.getDate("T1").toLocalDate();
//
//					pstmtD.setObject(1, rs1.getInt("MEMBER_NO"));
//					try (ResultSet rsD = pstmtD.executeQuery();) {
//						if (rsD.next()) {
//							LocalDate T2 = rsD.getDate("T2").toLocalDate();
//
//							long diffInDays = ChronoUnit.DAYS.between(T1, T2);
//							if (diffInDays == 0) {
//								return 0;
//							}
//						}
//
//					}
//
//					PC.setCommentId(rs1.getInt("LOGIN_RECORD_ID"));
//					PC.setMemberNo(rs1.getInt("MEMBER_NO"));
//				}
//				pstmt2.setObject(1, PC.getMemberNo());
//				pstmt2.setObject(2, null);
//				pstmt2.setObject(3, null);
//				pstmt2.setObject(4, null);
//				pstmt2.setObject(5, PC.getLoginRecordId());
//				pstmt2.setInt(6, 1);
//				int rs2 = pstmt2.executeUpdate();
//				if (rs2 < 1) {
//					return -23;
//				}
//				pstmt3.setInt(1, 1);
//				pstmt3.setInt(2, PC.getMemberNo());
//				int rs3 = pstmt3.executeUpdate();
//				if (rs3 < 1) {
//					return -33;
//				}
//				conn.commit();
//				return rs3;
//			} catch (SQLException e) {
//				conn.rollback();
//				e.printStackTrace();
//			}
//
//		} catch (
//
//		Exception e) {
//			e.printStackTrace();
//		}
//
//		return -73;
//	}

	@Override
	public int insertForSO() {
		String sql1 = "select SHOP_ORDER_ID, MEMBER_NO,SHOP_POINT_DISCOUNT from SHOP_ORDER order by SHOP_ORDERPAY_TIME desc limit 1";
		String sql2 = "insert into POINTS_CHANGED(MEMBER_NO,COMMENT_ID,SHOP_ORDER_ID,STUDENT_COURSES_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING) values(?,?,?,?,?,?)";
		String sql3 = "update MEMBER set REWARD_POINTS = REWARD_POINTS + ? where MEMBER_NO = ?";
		try (Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);) {
			conn.setAutoCommit(false);
			PointChanged PC = new PointChanged();
			int SPD = 0;
			try (ResultSet rs1 = pstmt1.executeQuery();) {
				if (rs1.next()) {
					int SOI = rs1.getInt("SHOP_ORDER_ID");
					int MNO = rs1.getInt("MEMBER_NO");
					SPD = SPD + rs1.getInt("SHOP_POINT_DISCOUNT");
					PC.setShopOrderId(SOI);
					PC.setMemberNo(MNO);

				}
				pstmt2.setObject(1, PC.getMemberNo());
				pstmt2.setObject(2, null);
				pstmt2.setObject(3, PC.getShopOrderId());
				pstmt2.setObject(4, null);
				pstmt2.setObject(5, null);
				pstmt2.setInt(6, -(SPD));
				int rs2 = pstmt2.executeUpdate();
				if (rs2 < 1) {
					return -24;
				}
				pstmt3.setInt(1, -(SPD));
				pstmt3.setInt(2, PC.getMemberNo());
				int rs3 = pstmt3.executeUpdate();
				if (rs3 < 1) {
					return -34;
				}
				conn.commit();
				return rs3;
			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -74;
	}

	@Override
	public List<PointChanged> selectAllByMId(Integer id) {
		String sql = "SELECT PC.POINTS_CHANGED_ID, PC.MEMBER_NO, PC.COMMENT_ID, PC.SHOP_ORDER_ID, "
				+ "PC.STUDENT_COURSES_ID, PC.LOGIN_RECORD_ID, PC.VALUE_OF_CHANGING, " + "PC.CREATE_AT, M.REWARD_POINTS "
				+ "FROM POINTS_CHANGED PC " + "INNER JOIN MEMBER M ON PC.MEMBER_NO = M.MEMBER_NO "
				+ "WHERE M.MEMBER_NO = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				List<PointChanged> list = new ArrayList<>();
				while (rs.next()) {
					PointChanged PC = new PointChanged();
					PC.setPointChangedId(rs.getInt("POINTS_CHANGED_ID"));
					PC.setMemberNo(rs.getInt("MEMBER_NO"));
					PC.setCommentId(rs.getInt("COMMENT_ID"));
					PC.setShopOrderId(rs.getInt("SHOP_ORDER_ID"));
					PC.setStudentCoursesId(rs.getInt("STUDENT_COURSES_ID"));
					PC.setLoginRecordId(rs.getInt("LOGIN_RECORD_ID"));
					PC.setValueOfChanged(rs.getInt("VALUE_OF_CHANGING"));
					PC.setCreatAt(rs.getTimestamp("CREATE_AT"));
					PC.setRewardPoints(rs.getInt("REWARD_POINTS"));
					list.add(PC);
				}

				return list;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
