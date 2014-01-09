package org.mybatis.weigao.Exception;

import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.exception.ExceptionHandler;
import net.sourceforge.stripes.exception.StripesServletException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 14-1-5
 * Time: 下午8:44
 * To change this template use File | Settings | File Templates.
 */
public class MyExceptionHandler implements ExceptionHandler {
    /** Doesn't have to do anything... */
    public void init(Configuration configuration) throws Exception { }

    /** Do something a bit more complicated that just going to a view. */
    public void handle(Throwable throwable,
                       HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        //TransactionUtil.rollback(); // rollback any tx in progress
        /*if (AppProperties.isDevMode()) {
           throw new StripesServletException(throwable);
        }
        else {*/
            request.setAttribute("exception", throwable);
            request.getRequestDispatcher("/WEB-INF/jsp/common/Error.jsp").forward(request, response);
        //}
    }
}
