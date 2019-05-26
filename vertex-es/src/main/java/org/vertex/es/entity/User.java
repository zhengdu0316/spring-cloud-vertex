package org.vertex.es.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengdu
 * @date 2019/5/18 18:53
 */
@Data
public class User {


        private String userId;
        private String name;
        private Date creationDate = new Date();
        private Map<String, String> userSettings = new HashMap<>();


}