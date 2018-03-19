package com.jensonjo;

import java.util.UUID;

public class TransactionManager {
    public static final ThreadLocal<String> context = new ThreadLocal<String>();

    public static void startTransaction() {
        context.set(UUID.randomUUID().toString());
    }

    public static String getTransactionID() {
        return context.get();
    }
    public static void endtransaction() {
        context.remove();
    }

}
