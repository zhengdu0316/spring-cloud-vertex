package org.vertex.es.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zhengdu
 * @date 2019/5/19 16:14
 */
@Data
public class SubHits {

    private String _index;
    private String _type;
    private String _id;
    private String _score;
    private Object _source;
}