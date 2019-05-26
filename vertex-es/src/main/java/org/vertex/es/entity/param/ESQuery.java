package org.vertex.es.entity.param;

import lombok.Data;

import java.util.Map;

/**
 * @author zhengdu
 * @date 2019/5/19 15:23
 */
@Data
public class ESQuery {
    private String index;
    private String type;

}