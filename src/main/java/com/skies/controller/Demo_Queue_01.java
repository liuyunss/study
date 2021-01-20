package com.skies.controller;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Demo_Queue_01 {
    public static void main(String[] args) {
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        transferQueue.add("a");
    }
}
