package org.demo.starter;
public class BookService {
    private BookPropertiesService bookPropertiesService;
    public BookService(BookPropertiesService bookPropertiesService){
        this.bookPropertiesService=bookPropertiesService;
    }
    public BookService(){
    }

    public String getName(){
        return bookPropertiesService.getName();
    }

    public String getIsbn() {
        return bookPropertiesService.getIsbn();
    }

    public String getAuthor() {
        return bookPropertiesService.getAuthor();
    }

}