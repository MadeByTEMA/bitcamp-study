// 스프링 인터셉터 다루기
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c06_1")
public class Controller06_1 {

  // 테스트:
  // http://.../app2/c06_1/post
  @PostMapping("post")
  public void post() {
    System.out.println("post() 호출");
  }

  @GetMapping("get")
  public void get() {
    System.out.println("get() 호출");
  }

  // 테스트:
  // http://.../app2/c04_1/a/h2
  @GetMapping("a/h2")
  public String handler2() {
    System.out.println("c04_1.handler2() 호출");
    return "c04_1";
  }

  // 테스트:
  // http://.../app2/c04_1/b/h3
  @GetMapping("b/h3")
  public String handler3() {
    System.out.println("c04_1.handler3() 호출");
    return "c04_1";
  }

}
