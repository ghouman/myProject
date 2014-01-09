package org.mybatis.weigao.Exception;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.exception.DefaultExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 14-1-5
 * Time: 下午9:10
 * To change this template use File | Settings | File Templates.
 */

public class MyDefaultExceptionHandler extends DefaultExceptionHandler {
    public Resolution handleDatabaseException(SQLException exc, HttpServletRequest request, HttpServletResponse response) {
        // do something to handle SQL exceptions
        request.setAttribute("exception", exc);
        return new ForwardResolution("/WEB-INF/jsp/common/Error.jsp");
    }

    public Resolution handleSQLServerException(SQLServerException exc, HttpServletRequest request, HttpServletResponse response) {
        // do something to handle SQL exceptions
        request.setAttribute("exception", exc);
        return new ForwardResolution("/WEB-INF/jsp/common/Error.jsp");
    }

    public Resolution handleGeneric(Exception exc, HttpServletRequest request, HttpServletResponse response) {
        // general exception handling
        request.setAttribute("exception", exc);
        return new ForwardResolution("/WEB-INF/jsp/common/Error.jsp");
    }
}
