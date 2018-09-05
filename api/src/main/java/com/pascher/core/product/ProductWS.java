package com.pascher.core.product;

public interface ProductWS {
    public boolean add(final Product product);

    public boolean update(final Product product);
    
    public boolean update(final String name, final double price);

    public String delete(final String name);

    public String find(final String name);
}
