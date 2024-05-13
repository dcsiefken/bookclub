package com.bookclub.web;

import com.bookclub.service.dao.WishlistDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MongoWishlistDao;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {
    private WishlistDao wishlistDao = new MongoWishlistDao();

    @Autowired
    public void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @GetMapping
    public List<WishlistItem> showWishlist(Authentication authentication) {
        String username = authentication.getName();
        List<WishlistItem> wishlist = wishlistDao.list(username);
        return wishlist;
    }

    @GetMapping("/{id}")
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }

}
