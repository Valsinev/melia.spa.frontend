package com.melia.spa.service.impl;

import com.melia.spa.service.GalleryService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {
	@Override
	public List<String> getImagesFromDirectory(String photosFolder) {
		List<String> imageNames = new ArrayList<>();
		File folder = new File(photosFolder.replace("file:", ""));

		if (folder.exists() && folder.isDirectory()) {
			for (File file : folder.listFiles()) {
				if (file.isFile() && isImage(file.getName())) {
					imageNames.add(file.getName());
				}
			}
		}
		return imageNames;
	}

	private boolean isImage(String name) {
		return name.matches(".*\\.(jpg|jpeg|png|gif|webp)$");
	}

}
