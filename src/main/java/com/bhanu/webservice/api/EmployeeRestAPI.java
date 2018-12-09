package com.bhanu.webservice.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhanu.webservice.entity.Employee;
import com.bhanu.webservice.entity.Employee_Address;
import com.bhanu.webservice.entity.UserDetails;
import com.bhanu.webservice.service.DeploymentRestServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/bhanuservice")
public class EmployeeRestAPI {

	@Autowired
	private DeploymentRestServiceImpl deploymentRestServiceImpl;

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee_Address>> getEmployee() {
		List<Employee_Address> data = deploymentRestServiceImpl.getEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@RequestMapping(value = "/insertEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertUser(@RequestBody Employee employee) {

		deploymentRestServiceImpl.insertEmployee(employee);

		Map<String, Object> message = new HashMap<String, Object>();

		message.put("empName", employee.getEmpName());
		message.put("status", "Inserted successfully.");
		message.put("code", 200);
		message.put("empId", employee.getEmpId());

		Map<String, Object> json = new HashMap<String, Object>();
		json.put("success", true);
		json.put("message", message);

		String data = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.writeValueAsString(json);
		} catch (Exception e) {
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("webs_request_id", employee.getEmpId());
		return (new ResponseEntity<String>(data, headers, HttpStatus.OK));
	}

	@RequestMapping(value = "/delete_employee/{emp_id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> delete(@PathVariable String emp_id) {
		deploymentRestServiceImpl.deleteEmployee(emp_id);

		Map<String, Object> message = new HashMap<String, Object>();
		message.put("status", "Deleted successfully.");
		message.put("code", 200);
		message.put("empId", emp_id);

		Map<String, Object> json = new HashMap<String, Object>();
		json.put("success", true);
		json.put("message", message);

		String data = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.writeValueAsString(json);
		} catch (Exception e) {
		}

		return (new ResponseEntity<String>(data, HttpStatus.OK));

	}

}
