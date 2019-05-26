package org.vertex.es.entity.vo;

import lombok.Data;

/**
 * @author zhengdu
 * @date 2019/5/19 15:56
 */
@Data
public class ESReturnVO {
    private String took;
    private String timed_out;
    private Shards _shards;
    private Hits hits;

}