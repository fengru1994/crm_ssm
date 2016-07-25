package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> queryCustomerListByTypeCode(String sourceCode);
	
}
