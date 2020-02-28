package com.adb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adb.dao.GroupRepositary;
import com.adb.model.GropModel;
import com.adb.model.GroupEntity;

@RestController
@RequestMapping("/groups")
public class GroupApi {
	
	@Autowired
	private Environment env;

	@Autowired
	private GroupRepositary grpRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<GropModel> getGroupById(@PathVariable(name="id") String groupCode){
		
		ResponseEntity<GropModel> result;
		
		GroupEntity entity=grpRepo.findById(groupCode).orElse(null);
		
		if(entity==null) {
			result=new ResponseEntity<GropModel>(HttpStatus.NOT_FOUND);
		}else {
			GropModel model=new GropModel(entity, Integer.parseInt(env.getProperty("local.server.port")));
			result=new ResponseEntity<GropModel>(model,HttpStatus.OK);
		}
		return result;
	}
}
