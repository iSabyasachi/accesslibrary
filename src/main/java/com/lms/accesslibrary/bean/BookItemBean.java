package com.lms.accesslibrary.bean;

public class BookItemBean {
	long id;
	String name;
	String author;

	public BookItemBean(long id, String name, String author) {		
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return String.format("Book [id=%s, name=%s, author=%s]", id, name, author);
	}
}
