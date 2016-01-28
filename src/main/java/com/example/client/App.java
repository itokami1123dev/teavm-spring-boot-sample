package com.example.client;

import com.example.client.controller.AppViewController;
import com.example.client.model.AppData;

public class App {
    public static void main(String[] args) {
        AppData data = new AppData("2", "64");
        new AppViewController(data).initialize();
    }
}
