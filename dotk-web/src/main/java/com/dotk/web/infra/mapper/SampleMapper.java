package com.dotk.web.infra.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dotk.web.domain.entity.Sample;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-09-13
 */
@Mapper
public interface SampleMapper
{
  /**
   * 查询【请填写功能名称】
   *
   * @param id 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  public Sample selectSampleById(Integer id);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param sample 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  public List<Sample> selectSampleList(Sample sample);

  /**
   * 新增【请填写功能名称】
   *
   * @param sample 【请填写功能名称】
   * @return 结果
   */
  public int insertSample(Sample sample);

  /**
   * 修改【请填写功能名称】
   *
   * @param sample 【请填写功能名称】
   * @return 结果
   */
  public int updateSample(Sample sample);

  /**
   * 删除【请填写功能名称】
   *
   * @param id 【请填写功能名称】主键
   * @return 结果
   */
  public int deleteSampleById(Integer id);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param ids 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteSampleByIds(Integer[] ids);
}
