package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
         public double calculateTotalPrice() {
        // Thực hiện truy vấn hoặc các phương thức logic để tính tổng tiền
        return 100.0; // Giả sử tổng tiền là 100 đơn vị
    }
    public List<Book> searchByKeyword(String title) {
    return bRepo.findByTitleContainingIgnoreCase(title);
    }
         
}
