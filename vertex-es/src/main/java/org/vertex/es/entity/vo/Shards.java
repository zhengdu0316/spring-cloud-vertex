package org.vertex.es.entity.vo;

import lombok.Data;

/**
 * @author zhengdu
 * @date 2019/5/19 16:13
 */
@Data
public class Shards {

    private String total;
    private String successful;
    private String failed;
}