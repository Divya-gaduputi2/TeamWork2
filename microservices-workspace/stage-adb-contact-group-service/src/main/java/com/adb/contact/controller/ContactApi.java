package com.adb.contact.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adb.contact.dao.ContactRepository;
import com.adb.contact.model.ContactEntity;
import com.adb.contact.model.ContactModel;
import com.adb.contact.model.GroupModel;




@RestController
@RequestMapping("/contacts")
public class ContactApi {
	
	@Autowired
	private ContactRepository contactRepo;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ContactModel> getGroupById(@PathVariable(name="id") Long contactId){
		
		ResponseEntity<ContactModel> result;
		
		ContactEntity entity=contactRepo.findById(contactId).orElse(null);
		
		if(entity!=null) {
			ResponseEntity<GroupModel> responce=
					new RestTemplate().getForEntity("http://localhost:9100/groups/{id}", GroupModel.class,Collections.singletonMap("id",entity.getGroupCode()));
			
			ContactModel model=new ContactModel(entity,responce.getBody());
			result=new ResponseEntity<ContactModel>(model,HttpStatus.OK);
		}else {
			result=new ResponseEntity<ContactModel>(HttpStatus.NOT_FOUND);
		}
		return result;
	}

}
