package com.briup.zhxypj.mapper.ex;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey2EX;

import java.util.List;

public interface Survey2EXMapper {
    List<Survey2EX> findAll();
    List<Survey2EX> selectByMessage(String word);

    Survey2EX startSurvey(int id);
    void updateCode(int code,int id);
    void updateStatus(String status,int id);

    List<Survey2EX> selectByDepart(String depart);
    List<Survey2EX> selectByClazz(String clazz);
    List<Survey2EX> selectByCourse(String course);
    List<Survey2EX> selectByQuest(String quest);

    List<Survey2EX> selectByWord(String word);
}
