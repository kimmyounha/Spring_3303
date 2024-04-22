package com.example.mvc;

import org.springframework.web.bind.annotation.*;

class RequsetData{
    private String message;
    private String from;
    private String to;
    private int importance;

    public String getMessage() {return message;}public void setMessage(String massage) {this.message = massage;}public String getFrom() {return from;}public void setFrom(String from) {this.from = from;}public String getTo() {return to;}public void setTo(String to) {this.to = to;}public int getImportance() {return importance;}public void setImportance(int importance) {this.importance = importance;}
}

class ResponseData{
    private String result;
    private int code;

    public String getResult() {return result;}public void setResult(String result) {this.result = result;}public int getCode() {return code;}public void setCode(int code) {this.code = code;}
}

class Bookinfo{
    private String title;
    private String author;
    private int first_realese;
    private float rating;
    public String getTitle() {return title;}public void setTitle(String title) {this.title = title;}public String getAuthor() {return author;}public void setAuthor(String author) {this.author = author;}public int getFirst_realese() {return first_realese;}public void setFirst_realese(int first_realese) {this.first_realese = first_realese;}public float getRating() {return rating;}public void setRating(float rating) {this.rating = rating;}
}

class BookcerateResult{
    private String result;
    private String id;
    private boolean success;
    public String getResult() {return result;}public void setResult(String result) {this.result = result;}public String getId() {return id;}public void setId(String id) {this.id = id;}public boolean isSuccess() {return success;}public void setSuccess(boolean success) {this.success = success;}
}

class Hellocount{
    private String text;
    private int count;
    public String getText() {return text;}public void setText(String text) {this.text = text;}public int getCount() {return count;}public void setCount(int count) {this.count = count;}
}


@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/test1")
    @ResponseBody
    public ResponseData Test1(@RequestBody RequsetData requsetData){
        System.out.println(requsetData.getMessage());
        ResponseData responseData = new ResponseData();
        responseData.setResult("success");
        responseData.setCode(1001);
        return responseData;
    }

    @GetMapping("/test2")
    @ResponseBody
    public BookcerateResult Test2(@RequestBody Bookinfo bookinfo){
        System.out.println(bookinfo.getTitle());
        BookcerateResult result = new BookcerateResult();
        result.setResult("success");
        result.setId("a1234");
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/test3")
    @ResponseBody
    public String Test3(@RequestBody Hellocount hellocount){
        String result = "";

        for (int i = 0; i < hellocount.getCount(); i++){
            result += hellocount.getText();
        }

        return result;
    }




}
