package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.BaseDict;
import cn.itcast.domain.Customer;
import cn.itcast.service.BaseDictService;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;
import cn.itcast.vo.QueryVo;

@Controller
public class CustomerController {

	@Value("${customer.source.code}")
	private String sourceCode;

	@Value("${customer.industry.code}")
	private String industryCode;

	@Value("${customer.level.code}")
	private String levelCode;

	@Autowired
	private BaseDictService baseDictService;

	@Autowired
	private CustomerService customerService;

	//查询页面 显示分页
	@RequestMapping("/customer/list")
	public String showPage(QueryVo vo, Model model) {
		// 需要查询客户的页面 客户所属行业 客户级别
		List<BaseDict> sourceList = baseDictService.queryCustomerListByTypeCode(sourceCode);

		List<BaseDict> industryList = baseDictService.queryCustomerListByTypeCode(industryCode);

		List<BaseDict> levelList = baseDictService.queryCustomerListByTypeCode(levelCode);

		// 页面回显下拉框信息
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		// 根据查询条件，查询客户列表信息
		Page<Customer> page = customerService.queryCustomerListByCondition(vo);
		// 回显客户列表信息
		model.addAttribute("page", page);

		// 页面回显查询条件
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}

	//修改信息回显
	@RequestMapping("/customer/edit")
	public @ResponseBody Customer editCustomer(Long id) {
		Customer customer = customerService.queryCustomerById(id);
		return customer;
	}
	//更新信息
	@RequestMapping("/customer/update")
	public @ResponseBody String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		return "OK";
	}
	//删除单个信息
	@RequestMapping("/customer/delete")
	public @ResponseBody String delete(Long id){
		customerService.delete(id);
		return "OK";
	}
	//批量删除
	@RequestMapping("/customer/deleteAll")
	public @ResponseBody String deleteAll(String ids){
		
		//把ids分成数组
		String[] custIds = ids.split(",");
		//循环删除
		for (String id : custIds) {
			customerService.delete(Long.parseLong(id));
		}
		
		return "OK";
	}
	
	
}
