package com.melia.spa.controller;

import com.melia.spa.service.GalleryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

	@Value("${constructed.pools.folder}")
	private String photosFolder;
	private final GalleryService galleryService;

	public HomeController(GalleryService galleryService) {
		this.galleryService = galleryService;
	}

	@GetMapping("/")
	public String getHomepage(Model model) {



		List<String> imageNames = galleryService.getImagesFromDirectory(photosFolder);

		model.addAttribute("imageNames", imageNames);

		return "index";
	}
}
