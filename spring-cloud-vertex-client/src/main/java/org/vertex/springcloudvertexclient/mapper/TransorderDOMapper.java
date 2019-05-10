package org.vertex.springcloudvertexclient.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.vertex.springcloudvertexclient.config.domain.entity.TransorderDO;

@Mapper
public interface TransorderDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransorderDO record);

    int insertSelective(TransorderDO record);

    TransorderDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransorderDO record);

    int updateByPrimaryKey(TransorderDO record);
}