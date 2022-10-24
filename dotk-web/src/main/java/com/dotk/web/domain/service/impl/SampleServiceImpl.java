package com.dotk.web.domain.service.impl;

import com.dotk.web.domain.service.SampleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dotk.web.infra.mapper.SampleMapper;
import com.dotk.web.domain.entity.Sample;

@Service
public class SampleServiceImpl implements SampleService {

  @Autowired
  private SampleMapper sampleMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param id 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public Sample selectSampleById(Integer id)
  {
    return sampleMapper.selectSampleById(id);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param sample 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<Sample> selectSampleList(Sample sample)
  {
    return sampleMapper.selectSampleList(sample);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param sample 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertSample(Sample sample)
  {
    return sampleMapper.insertSample(sample);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param sample 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updateSample(Sample sample)
  {
    return sampleMapper.updateSample(sample);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param ids 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deleteSampleByIds(Integer[] ids)
  {
    return sampleMapper.deleteSampleByIds(ids);
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param id 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deleteSampleById(Integer id)
  {
    return sampleMapper.deleteSampleById(id);
  }
}
