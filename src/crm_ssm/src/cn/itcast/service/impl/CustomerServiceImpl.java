package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.domain.Customer;
import cn.itcast.domain.CustomerExample;
import cn.itcast.domain.CustomerExample.Criteria;
import cn.itcast.mapper.CustomerMapper;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;
import cn.itcast.vo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Page<Customer> queryCustomerListByCondition(QueryVo vo) {
		//判断分页条件，设置查询起始页
		if(vo.getPage()!=null){
			vo.setStartPage((vo.getPage()-1)*vo.getPageSize());
		}
		//查询客户信息
		List<Customer> cList = customerMapper.queryCustomerListByCondition(vo);
		//创建page对象，封装查询结果
		Page<Customer> page = new Page<Customer>();
		page.setRows(cList);
		page.setPage(vo.getPage());
		page.setSize(vo.getPageSize());
		
		//根据条件查询总记录数
		int customerNo = customerMapper.queryCustomerListByConditionCount(vo);
		page.setTotal(customerNo);
		
		return page;
	}

	@Override
	public Customer queryCustomerById(Long id) {
		//创建example对象
		CustomerExample example = new CustomerExample();
		//创建criteria对象
		Criteria createCriteria = example.createCriteria();
		//设置参数查询
		createCriteria.andCustIdEqualTo(id);
		//执行查询
		List<Customer> list = customerMapper.selectByExample(example);
		Customer customer = null;
		if(list!=null && list.size()>0){
			customer = list.get(0);
		}
		return customer;
	}

	//更新信息
	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
	}

	@Override
	public void delete(Long id) {
		customerMapper.deleteByPrimaryKey(id);
	}
	

}
