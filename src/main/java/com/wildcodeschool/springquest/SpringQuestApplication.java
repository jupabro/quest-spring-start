package com.wildcodeschool.springquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class SpringQuestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuestApplication.class, args);
	}

	private static final Map<Integer, String> doctorNames = new HashMap<>();

	static {
		doctorNames.put(1, "William Hartnell");
		doctorNames.put(10, "David Tennant");
		doctorNames.put(13, "Jodie Whittaker");
	}

	@RequestMapping("/")
	@ResponseBody
	public String listOfDocs() {
        return "<ul>" +
				"<li><a href=\"/doctor/1\">Doctor 1</a></li>" +
				"<li><a href=\"/doctor/10\">Doctor 10</a></li>" +
				"<li><a href=\"/doctor/13\">Doctor 13</a></li>" +
				"</ul>";
	}

	@RequestMapping("/doctor/{id}")
	@ResponseBody
	public String getDoctor( @PathVariable int id) {
        return doctorNames.getOrDefault(id, "Doctor not found");
	}

}
