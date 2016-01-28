package com.example.client.controller;

import com.example.client.model.AppData;

import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLInputElement;
import org.teavm.jso.dom.xml.Text;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppViewController {
    private final AppData data;

    private HTMLDocument document = HTMLDocument.current();

    public AppViewController(AppData data) {
        this.data = data;
    }

    public void initialize() {
        setEvents();
        render(data);
    }

    public void setEvents() {
        HTMLInputElement base =
                document.getElementById("base").cast();
        base.addEventListener("change", (event) -> {
            data.setBase(new BigDecimal(base.getValue()));
            render(data);
        });

        HTMLInputElement exponent =
                document.getElementById("exponent").cast();
        exponent.addEventListener("change", (event) -> {
            data.setExponent(new BigDecimal(exponent.getValue()));
            render(data);
        });
    }

    public void render(AppData data) {
        List<Map<String, String>> infos = Arrays.asList(
                new HashMap<String, String>() {
                    {
                        put("id", "base");
                        put("data", data.getBase().toString());
                    }
                },
                new HashMap<String, String>() {
                    {
                        put("id", "exponent");
                        put("data", data.getExponent().toString());
                    }
                }
        );

        for (Map<String, String> info : infos) {
            HTMLInputElement input =
                    document.getElementById(info.get("id")).cast();
            input.setValue(info.get("data"));
        }

        HTMLElement result =
                document.getElementById("result");

        result.clear();

        BigDecimal val = data.compute();
        Text textNode = document.createTextNode(val.toString());
        result.appendChild(textNode);
    }
}
