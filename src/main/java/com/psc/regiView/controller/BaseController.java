package com.psc.regiView.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.psc.regiView.constants.Constant;

@Controller
public class BaseController {

	@Autowired
	Constant Constant;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/")
	public String imageList(ModelMap modelMap) {
		String result = restTemplate.getForObject(Constant.getImageListUrl(), String.class);
		System.out.println(result);
		JSONParser parser = new JSONParser();
		List<String> imageList = new ArrayList<String>();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(result);
			JSONArray msg = (JSONArray) jsonObject.get("repositories");
			Iterator<String> iterator = msg.iterator();
			while (iterator.hasNext()) {
				
				String image = iterator.next();
				System.out.println(image);
				imageList.add(image);
			}
			modelMap.addAttribute("result", "success");
		} catch (ParseException e) {
			e.printStackTrace();
			modelMap.addAttribute("result", "fail:" + e.toString());

		}
		modelMap.addAttribute("imageList", imageList);
		return "images";
	}
	
	@RequestMapping("/tags/{image}")
	public String tagList(@PathVariable("image") String image,   ModelMap modelMap) {
		String result = restTemplate.getForObject(Constant.getTagListUrl(image), String.class);
		System.out.println(result);
		JSONParser parser = new JSONParser();
		List<String> tagList = new ArrayList<String>();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(result);
			JSONArray msg = (JSONArray) jsonObject.get("tags");
			Iterator<String> iterator = msg.iterator();
			while (iterator.hasNext()) {
				
				String tag = iterator.next();
				System.out.println(tag);
				tagList.add(tag);
			}
			modelMap.addAttribute("result", "success");
		} catch (ParseException e) {
			e.printStackTrace();
			modelMap.addAttribute("result", "fail:" + e.toString());
		}
		modelMap.addAttribute("name", image);
		modelMap.addAttribute("tagList", tagList);
		return "tags";
	}
}
