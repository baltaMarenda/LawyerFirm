package com.solvd.lawyerFirm.functional;

@FunctionalInterface
public interface Transformer<T, R> {
    R transform(T t);
}