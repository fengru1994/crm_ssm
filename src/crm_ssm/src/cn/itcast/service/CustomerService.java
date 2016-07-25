package cn.itcast.service;

import cn.itcast.domain.Customer;
import cn.itcast.utils.Page;
import cn.itcast.vo.QueryVo;

public interface CustomerService {

	Page<Customer> queryCustomerListByCondition(QueryVo vo);

	Customer queryCustomerById(Long id);

	void updateCustomer(Customer customer);

	void delete(Long id);


}
