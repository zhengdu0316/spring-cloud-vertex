package org.vertex.springcloudvertexclientb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.vertex.springcloudvertexclientb.config.domain.entity.StockDO;

@Mapper
public interface StockDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockDO record);

    int insertSelective(StockDO record);

    StockDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockDO record);

    int updateByPrimaryKey(StockDO record);
}