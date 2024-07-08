package CEN4010.project.wishlist.controller;

import CEN4010.project.wishlist.model.WishList;
import CEN4010.project.wishlist.model.Book;
import CEN4010.project.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping("/{userId}/add")
    public WishList addBookToWishList(@PathVariable Long userId, @RequestBody Book book) {
        return wishListService.addBookToWishList(userId, book);
    }

    @GetMapping("/{userId}")
    public List<WishList> getWishListsByUserId(@PathVariable Long userId) {
        return wishListService.getWishListsByUserId(userId);
    }

    @PutMapping("/{userId}/update")
    public WishList updateWishList(@PathVariable Long userId, @RequestBody List<Book> books) {
        return wishListService.updateWishList(userId, books);
    }

    @DeleteMapping("/{userId}/delete/{bookId}")
    public void deleteBookFromWishList(@PathVariable Long userId, @PathVariable Long bookId) {
        wishListService.deleteBookFromWishList(userId, bookId);
    }
}