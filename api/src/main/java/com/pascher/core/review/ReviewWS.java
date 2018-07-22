package com.pascher.core.review;

import com.pascher.core.review.Review;

public interface ReviewWS {
    public boolean add(final Review review);

    public boolean update(final String name, final String comment);

    public boolean delete(final String name);

    public String find(final String name);
}
