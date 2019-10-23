package com.example.listdemo.services;

public class JeopardyCategory implements Comparable<JeopardyCategory> {

	private int id;
	private String category;

	public JeopardyCategory(int id, String category) {
		this.setId(id);
		this.setCategory(category);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public int compareTo(JeopardyCategory other) {
		int result;

		if (this.getCategory() != null && other.getCategory() != null) {
			// make the comparison case insensitive
			result =  this.getCategory().toUpperCase().compareTo(other.getCategory().toUpperCase());
		
		} else if (this.getCategory() == null && other.getCategory() != null){
			result = -1;
		
		} else if (this.getCategory() != null && other.getCategory() == null){
			result = 1;
			
		} else {
			// both null, they are equal
			result = 0;
		}

		return result;
	}
}
