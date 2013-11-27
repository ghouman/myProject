package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.CustomerSurvey;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerSurveyMapper {

    public List<CustomerSurvey> getCustomerSurvey(CustomerSurvey customerSurvey);

    public void updateCustomerSurvey(CustomerSurvey customerSurvey);

    public void addCustomerSurvey(CustomerSurvey customerSurvey);

    public void updateCustomerSurveyStatus(CustomerSurvey customerSurvey);

    public String getSurveyNo();
}
