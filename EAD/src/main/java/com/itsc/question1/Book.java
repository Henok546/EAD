package com.itsc.question1;

public class Book {
	private String title;
	private double id;
	private String author;
	private double price;
	
	
	public Book(String title, String author, double price, double id) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.id = id;}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		
		public void setAuthor(String author) {
			this.author = author;

			}
		
		
		public void setPrice(double price) {
			this.price = price;

			}
		
		public void setID(double id) {
			this.id = id;
			}
		
		
		public String getTitle() {
		return title;
		}
		
		
		public String getAuthor() {
			return author;
			}
			
		
		
		public double getPrice() {
			return price;
			}
		
		
		public double getId() {
			return id;
			}
		

}
