package web.community.classes.dao.impl;

import web.community.classes.bean.CommunityClass;
import web.community.classes.bean.MainClass;
import web.community.classes.bean.SecClass;
import web.community.classes.dao.ClassDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class ClassDaoImpl implements ClassDao {
    /**
     * 只找主分類 目前沒用到
     */
    @Override
    public List<MainClass> selectAllMainClass() {
        final String SQL = "SELECT * FROM COM_MAINCLASS;";
        List<MainClass> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                MainClass mainClass = new MainClass();
                mainClass.setComMainClassId(rs.getInt("COM_MAINCLASS_ID"));
                mainClass.setComMainClassName(rs.getString("COM_MAINCLASS_NAME"));
                resultList.add(mainClass);
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 只找次分類 目前沒用到
     */
    @Override
    public List<SecClass> selectAllSecClass() {
        final String SQL = "SELECT * FROM COM_SECCLASS;";
        List<SecClass> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                SecClass secClass = new SecClass();
                secClass.setComSecClassId(rs.getInt("COM_SECCLASS_ID"));
                secClass.setComMainClassId(rs.getInt("COM_MAINCLASS_ID"));
                secClass.setComSecClassName(rs.getString("COM_SECCLASS_NAME"));
                resultList.add(secClass);
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 找所有包含次分類 + 主分類
     */
    @Override
    public List<CommunityClass> selectAllClass() {
        final String SQL =
                "SELECT csc.COM_SECCLASS_ID, csc.COM_SECCLASS_NAME, csc.COM_MAINCLASS_ID, cmc.COM_MAINCLASS_NAME FROM COM_SECCLASS csc INNER JOIN COM_MAINCLASS cmc ON csc.COM_MAINCLASS_ID = cmc.COM_MAINCLASS_ID";
        List<CommunityClass> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                CommunityClass allClass = new CommunityClass();
                allClass.setComSecClassId(rs.getInt("COM_SECCLASS_ID"));
                allClass.setComMainClassId(rs.getInt("COM_MAINCLASS_ID"));
                allClass.setComSecClassName(rs.getString("COM_SECCLASS_NAME"));
                allClass.setComMainClassName(rs.getString("COM_MAINCLASS_NAME"));

                resultList.add(allClass);
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
