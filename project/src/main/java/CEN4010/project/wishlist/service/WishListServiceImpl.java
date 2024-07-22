package CEN4010.project.wishlist.service;

import CEN4010.project.wishlist.model.WishList;
import CEN4010.project.wishlist.model.Book;
import CEN4010.project.wishlist.repository.WishListRepository;
import CEN4010.project.wishlist.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public WishList addBookToWishList(Long userId, Book book) {
        Optional<WishList> optionalWishList = wishListRepository.findById(userId);
        WishList wishList = optionalWishList.orElseGet(() -> {
            WishList newWishList = new WishList();
            newWishList.setUserId(userId);
            return newWishList;
        });

        wishList.getBooks().add(book);
        return wishListRepository.save(wishList);
    }

    @Override
    public List<WishList> getWishListsByUserId(Long userId) {
        return wishListRepository.findAll(); // You might need a custom query here
    }

    @Override
    public WishList updateWishList(Long userId, List<Book> books) {
        Optional<WishList> optionalWishList = wishListRepository.findById(userId);
        if (optionalWishList.isPresent()) {
            WishList wishList = optionalWishList.get();
            wishList.setBooks(books);
            return wishListRepository.save(wishList);
        }
        return null;
    }

    @Override
    public void deleteBookFromWishList(Long userId, Long bookId) {
        Optional<WishList> optionalWishList = wishListRepository.findById(userId);
        if (optionalWishList.isPresent()) {
            WishList wishList = optionalWishList.get();
            wishList.getBooks().removeIf(book -> book.getId().equals(bookId));
            wishListRepository.save(wishList);
        }
    }
}