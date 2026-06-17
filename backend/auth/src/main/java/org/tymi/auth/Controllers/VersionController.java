package org.tymi.auth.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tymi.auth.HttpModels.VersionResponse;

@RestController
public class VersionController {
     @GetMapping("/version")
     public VersionResponse version()
     {
          return new VersionResponse("1.0.0");
     }
}
