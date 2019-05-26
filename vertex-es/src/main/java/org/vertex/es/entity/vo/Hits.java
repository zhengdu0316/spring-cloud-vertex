package org.vertex.es.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zhengdu
 * @date 2019/5/19 16:13
 */
@Data
public class Hits {

    private String total;
    private String max_score;
    private List<SubHits> hits;
}