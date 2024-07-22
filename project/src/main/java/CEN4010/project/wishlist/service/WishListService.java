package CEN4010.project.wishlist.service;

import java.util.List;

import CEN4010.project.wishlist.model.Book;
import CEN4010.project.wishlist.model.WishList;

public interface WishListService {
    WishList addBookToWishList(Long userId, Book book);
    List<WishList> getWishListsByUserId(Long userId);
    WishList updateWishList(Long userId, List<Book> books);
    void deleteBookFromWishList(Long userId, Long bookId);
}