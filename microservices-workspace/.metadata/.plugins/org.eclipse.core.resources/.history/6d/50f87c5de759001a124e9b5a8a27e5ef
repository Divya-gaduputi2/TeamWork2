package com.adb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adb.demo.dao.GroupRepository;
import com.adb.demo.entity.GroupEntity;
import com.adb.demo.model.GroupModel;

@RestController
@RequestMapping("/groups")
public class GroupApi {
	
	@Autowired
	private Environment env;

	@Autowired
	private GroupRepository grpRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<GroupModel> getGroupById(@PathVariable(name="id") String groupCode){
		
		ResponseEntity<GroupModel> result;
		
		GroupEntity entity=grpRepo.findById(groupCode).orElse(null);
		
		if(entity==null) {
			result=new ResponseEntity<GroupModel>(HttpStatus.NOT_FOUND);
		}else {
			GroupModel model=new GroupModel(entity, Integer.parseInt(env.getProperty("local.server.port")));
			result=new ResponseEntity<GroupModel>(model,HttpStatus.OK);
		}
		return result;
	}
}
