package ru.sergeev.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
    defaultValue = "world") String name) {
        return String.format("Hello %s!", name);
    }

    private List<String> arrayList = new ArrayList<>();
    private Map<Integer, String> hashMap = new HashMap<>();
    private int mapCounter = 0;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        arrayList.add(s);
        return "Добавлено в ArrayList: " + s;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        hashMap.put(++mapCounter, s);
        return "Добавлено в HashMap [" + mapCounter + "] = " + s;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap;
    }
    
    @GetMapping("/show-all-length")
    public String showAllLength() {
        return "ArrayList содержит " + arrayList.size() + " элементов, " +
                "HashMap содержит " + hashMap.size() + " элементов.";
    }
}
