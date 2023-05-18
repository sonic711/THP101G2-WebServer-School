package core.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;

import static core.util.Constants.*;

public class CommonUtil {
	public static Connection getConnection() throws NamingException, SQLException {
		if (DATASOURCE == null) {
			DATASOURCE = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/example");
		}
		return DATASOURCE.getConnection();
	}

	public static <B> B json2Bean(HttpServletRequest req, Class<B> classOfBean) {
		try (BufferedReader br = req.getReader()) {
			return GSON.fromJson(br, classOfBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static <B> B json2Beans(HttpServletRequest req, Type typeOfBean) {
		try (BufferedReader br = req.getReader()) {
			return GSON.fromJson(br, typeOfBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <B> void writeJsonBean(HttpServletResponse resp, B bean) {
		resp.setContentType(JSON_MIME_TYPE);
		try (PrintWriter pw = resp.getWriter()) {
			pw.print(GSON.toJson(bean));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
