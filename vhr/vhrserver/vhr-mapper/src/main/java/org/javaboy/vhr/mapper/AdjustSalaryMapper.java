package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaboy.vhr.model.AdjustSalary;

@Mapper
public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);
}