package com.denizkpln.aop.service;

public class TransactionManagement {

    public void begin() {
        System.out.println("begin transaction");
    }

    public void commit() {
        System.out.println("commit transaction");
    }

    public void rollback() {
        System.out.println("rollback transaction");
    }

}
