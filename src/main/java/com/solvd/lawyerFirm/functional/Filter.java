package com.solvd.lawyerFirm.functional;

@FunctionalInterface
public interface Filter<T> {
    boolean apply(T t);
}
