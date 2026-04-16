package com.solvd.lawyerFirm.functional;

@FunctionalInterface
public interface Action<T> {
    void execute(T t);
}
