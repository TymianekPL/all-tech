package org.tymi.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
     @GetMapping("/version")
     public VersionResponse version()
     {
          return new VersionResponse("1.0.0");
     }
}
