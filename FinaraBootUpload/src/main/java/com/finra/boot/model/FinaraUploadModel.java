package com.finra.boot.model;

import org.springframework.web.multipart.MultipartFile;

public class FinaraUploadModel {

		 private String extraField;

		 private MultipartFile[] files;

		public String getExtraField() {
			return extraField;
		}

		public MultipartFile[] getFiles() {
			return files;
		}

		public void setExtraField(String extraField) {
			this.extraField = extraField;
		}

		public void setFiles(MultipartFile[] files) {
			this.files = files;
		}
}
