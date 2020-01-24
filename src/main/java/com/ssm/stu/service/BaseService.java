package com.ssm.stu.service;

import java.util.List;

/**
 * ClassName:BaseServce
 * Function:公共service
 * Reason:
 *
 */
public class BaseService {

    /**
     * 把list<String>  转换成  '1','2','3','4'
     * @param list
     * @return
     */
    protected String listToMysqlInString(List<String> list){
        StringBuilder builder = new StringBuilder();
        for (String s:
             list) {
            builder.append(String.format("\'%s\',",s));
        }
        builder.setLength(builder.length()-1);
        return builder.toString();
    }
}
