package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.domain.BaseDict;
import cn.itcast.domain.BaseDictExample;
import cn.itcast.domain.BaseDictExample.Criteria;
import cn.itcast.mapper.BaseDictMapper;
import cn.itcast.service.BaseDictService;
@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper baseDictMapper;
	
	@Override
	public List<BaseDict> queryCustomerListByTypeCode(String typeCode) {
		// 创建example对象
		BaseDictExample example = new BaseDictExample();
		//创建criteria对象，才能设置参数
		Criteria criteria = example.createCriteria();
		//根据类别code查询
		criteria.andDictTypeCodeEqualTo(typeCode);
		//执行查询
		List<BaseDict> baseList = baseDictMapper.selectByExample(example);
		return baseList;
	}

}
