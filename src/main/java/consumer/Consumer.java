package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Dao;

import model.User;

@Component
@Service
public class Consumer {

	@Autowired
	private Dao d;

	@KafkaListener(topics = "DemoProject", groupId = "KafkaProject", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User u) {
		System.out.println("Consumed Message is: " + u);
		d.save(u);
	}

}

