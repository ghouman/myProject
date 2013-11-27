package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.SurveyDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface SurveyDetailMapper {

    public void updateSurveyDetail(SurveyDetail surveyDetail);

    public void addSurveyDetail(SurveyDetail surveyDetail);

    public List<SurveyDetail> getSurveyDetail(int uid);
}
