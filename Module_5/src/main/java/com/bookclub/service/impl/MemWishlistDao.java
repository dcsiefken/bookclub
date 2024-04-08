package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlist;

    public MemWishlistDao() {
        ArrayList<WishlistItem> lWishlist = new ArrayList<WishlistItem>();
        lWishlist.add(new WishlistItem("978-1617297571", "Spring in Action, Sixth Edition"));
        this.wishlist = lWishlist;
    }

    @Override
    public WishlistItem find(String key) {
        for (WishlistItem item : wishlist) {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
    }

    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }
}
