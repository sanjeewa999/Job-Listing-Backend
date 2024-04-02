package com.synerix.Joblisting.repository;

import com.synerix.Joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> searchByText (String text);
}
