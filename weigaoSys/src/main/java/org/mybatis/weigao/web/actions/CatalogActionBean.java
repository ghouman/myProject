package org.mybatis.weigao.web.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.apache.log4j.Logger;
import org.mybatis.weigao.common.util.CommonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@SessionScope
public class CatalogActionBean extends AbstractActionBean {

  private static final long serialVersionUID = 5849523372175050635L;
    private static Logger logger = Logger.getLogger (CatalogActionBean.class);
  private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
  private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
  private static final String VIEW_PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";
  private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
  private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    private static final String SIGNON = "/login.jsp";

  @DefaultHandler
  public ForwardResolution viewMain() {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      Collection collectionAuth = auth.getAuthorities();
      logger.info("用户："+auth.getName()+" ,角色："+collectionAuth+ " ,访问时间："+ CommonUtil.getCurrentTime()+",auth:"+auth);
      return new ForwardResolution(MAIN);

  }

  public void clear() {
  }

}
