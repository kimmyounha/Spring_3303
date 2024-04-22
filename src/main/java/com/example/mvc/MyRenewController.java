package com.example.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

// 커맨드 객체로 사용될 클래스 정의
class MyCommandObject {

    private String value1;
    private Integer value2;

    // 반드시 세터 메서드가 있어야 함
    public void setValue1(String value1) { this.value1 = value1; }
    public void setValue2(Integer value2) { this.value2 = value2; }
}

@RestController
@RequestMapping("/renew")
public class MyRenewController {
    // produces 옵션을 통해서 미디어 타입 지정 가능 (유추해서 자동으로 지정하게 할 수도 있지만 가급적 써주는 것을 권장)
    @PostMapping("/test")


// @ModelAttribute를 타입 앞에 붙여주고 메서드의 파라미터 값으로 전달되게 함
    public String commandObjectTest(@ModelAttribute MyCommandObject myCommandObject) {
        return myCommandObject.toString();
    }
    @GetMapping(value = "/echo", produces = MediaType.TEXT_PLAIN_VALUE)
// 반환한 문자열이 바로 응답 메시지의 바디 데이터에 삽입될 수 있도록 @ResponseBody 어노테이션 추가 (@RestController를 사용하면 생략 가능)
    @ResponseBody
    public String echo(@RequestBody byte[] content) {
        // 메서드 정보 접근할 필요 없음 (GET 메서드)
        // 주소 정보 접근할 필요 없음 (@PathVariable 사용)
        // 쿼리 스트링 정보 접근할 필요 없음 (@RequestParam 사용)
        // 프로토콜, HTTP 버전 정보 접근할 필요가 보통 없음
        // 헤더 정보 접근할 필요 없음 (@RequestHeader 사용)
        // 요청 메시지의 바디 데이터 접근은 @RequestBody 어노테이션을 이용해서 전달받을 수 있음
        String bytesToString = new String(content, StandardCharsets.UTF_8);
        System.out.println(bytesToString);

        // Content-Type 헤더의 경우 produces 옵션을 제공하여 미디어 타입 지정 가능
        return bytesToString;
    }

    @GetMapping(value = "/hello-html", produces = MediaType.TEXT_HTML_VALUE)
// 반환 코드도 마찬가지로 그냥 성공적으로 메서드에서 값을 반환하면 자동으로 200이 됨
    @ResponseStatus(HttpStatus.OK)
    public String helloHTML() {
        return "<h1>Hello</h1>";
    }

    @GetMapping(value = "/echo-repeat", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
// @RequestHeader 어노테이션을 통해서 X-Repeat-Count에 적힌 숫자 정보 가져오고 없으면 1로 초기화
    public String echoRepeat(@RequestParam("word") String word, @RequestHeader(value = "X-Repeat-Count", defaultValue = "1") Integer repeatCount) throws IOException {
        String result = "";
        for(int i=0;i<repeatCount;i++) {
            result += word;
        }
        return result;
    }

    @GetMapping(value = "/dog-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] dogImage() throws IOException {
        // resources 폴더의 static 폴더에 이미지 있어야 함
        File file = ResourceUtils.getFile("classpath:static/dog.jpg");
        // 파일의 바이트 데이터 모두 읽어오기
        byte[] bytes = Files.readAllBytes(file.toPath());

        return bytes;
    }

    class SigngUpForm{
        private String id;
        private String email;
        private String username;
        private int age;

        public String getId() {return id;}public void setId(String id) {this.id = id;}public String getEmail() {return email;}public void setEmail(String email) {this.email = email;}public String getUsername() {return username;}public void setUsername(String username) {this.username = username;}public int getAge() {return age;}public void setAge(int age) {this.age = age;}

        @java.lang.Override
        public java.lang.String toString() {
            return "SigngUpForm{" +
                    "id='" + id + '\'' +
                    ", email='" + email + '\'' +
                    ", username='" + username + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
