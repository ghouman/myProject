package org.mybatis.weigao.service;

import org.hsqldb.lib.StringUtil;
import org.mybatis.weigao.common.util.JsonUtil;
import org.mybatis.weigao.domain.CustomerSurvey;
import org.mybatis.weigao.domain.SurveyDetail;
import org.mybatis.weigao.persistence.CustomerSurveyMapper;
import org.mybatis.weigao.persistence.SurveyDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-17
 * Time: 下午10:00
 * To change this template use File | Settings | File Templates.
 */

@Service
public class CustomerSurveyService {
    @Autowired
    private CustomerSurveyMapper customerSurveyMapper;
    @Autowired
    private SurveyDetailMapper surveyDetailMapper;

    public List<CustomerSurvey> getCustomerSurvey(CustomerSurvey customerSurvey) {
        return customerSurveyMapper.getCustomerSurvey(customerSurvey);
    }

    public int countSurveySize(CustomerSurvey customerSurvey) {
        return customerSurveyMapper.countSurveySize(customerSurvey);
    }

    public List<SurveyDetail> getSurveyDetail(int uid) {
        return surveyDetailMapper.getSurveyDetail(uid);
    }

    @Transactional
    public void updateCustomerSurveyStatus(CustomerSurvey customerSurvey) {
        customerSurveyMapper.updateCustomerSurveyStatus(customerSurvey);
    }

    //更新调研产品明细， 先删除在增加
    @Transactional
    public void updateCustomerSurvey(CustomerSurvey customerSurvey,String userName) {
        customerSurveyMapper.updateCustomerSurvey(customerSurvey);
        surveyDetailMapper.delAllDetailBySurveyNo(customerSurvey.getSurveyNo());
        this.saveSurveyDetail(customerSurvey.getJsonString(),userName);
    }

    //保存调研产品明细
    private void saveSurveyDetail(String jsonString,String userName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!StringUtil.isEmpty(jsonString)) {
            List<SurveyDetail> surveyDetailList = JsonUtil.getDTOList(jsonString, SurveyDetail.class);
            for (int i = 0; i < surveyDetailList.size(); i++) {
                SurveyDetail surveyDetail = surveyDetailList.get(i);
                surveyDetail.setCreator(userName);
                surveyDetail.setOperator(userName);
                surveyDetailMapper.addSurveyDetail(surveyDetail);//保存调研产品明细
            }
        }
    }

    @Transactional
    public void addCustomerSurvey (CustomerSurvey customerSurvey,String userName) throws DataAccessException {
        CustomerSurvey customerSurvey1 = new CustomerSurvey();
        customerSurvey1.setSurveyNo(customerSurvey.getSurveyNo());
        int size = customerSurveyMapper.countSurveySize(customerSurvey1);
        if(size>0){ //数据库已经存在，重新获取
            String surveyNo = this.getSurveyNo();
            customerSurvey.setSurveyNo(surveyNo);
        }
        customerSurveyMapper.addCustomerSurvey(customerSurvey);//保存调研信息
        this.saveSurveyDetail(customerSurvey.getJsonString(),userName);
    }



    //获取该年 最大调研编号
    public String getSurveyNo() {
        String surveyNo = customerSurveyMapper.getSurveyNo();
        if (surveyNo == null) { //跨年的第一次为空
            surveyNo = "0001";
        } else {
            surveyNo = Integer.toString(Integer.parseInt(surveyNo) + 1);
            if (surveyNo.length() == 3) {
                surveyNo = "0" + surveyNo;
            } else if (surveyNo.length() == 2) {
                surveyNo = "00" + surveyNo;
            } else if (surveyNo.length() == 1) {
                surveyNo = "000" + surveyNo;
            }
        }
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return "VES" + year + surveyNo;
    }

}
