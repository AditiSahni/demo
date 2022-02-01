package com.example.demo;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Dao;

import model.User;

@RestController
//@RequestMapping("kafka")
public class Controller {
	@Autowired
	public Dao dao;

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	private final String topic = "DemoProject";

	@PostMapping("/add_User")
	public String addUser(@RequestBody User u) {
		dao.save(u);
		kafkaTemplate.send(topic, u);
		return "User Saved";
	}

	@GetMapping("get_User/{id}")
	public List<User> get_User() {
		return dao.findAll();
	}

	@PutMapping("/update_User")
	public String updateUser(@PathVariable User u) {
		dao.save(u);
		kafkaTemplate.send(topic, u);
		return "Updated Successfully";
	}

}
