package com.melia.spa.controller;

import com.melia.spa.service.GalleryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Value("${constructed.pools.folder}")
	private String photosFolder;
	private final GalleryService galleryService;

	public GalleryController(GalleryService galleryService) {
		this.galleryService = galleryService;
	}

	@GetMapping
	public String getGalleryPage(Model model) {

		List<String> imageNames = galleryService.getImagesFromDirectory(photosFolder);

		model.addAttribute("imageNames", imageNames);

		return "gallery";
	}

}
