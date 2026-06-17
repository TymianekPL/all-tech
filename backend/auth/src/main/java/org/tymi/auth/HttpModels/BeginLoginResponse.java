package org.tymi.auth.HttpModels;

import java.util.List;

public record BeginLoginResponse(List<HttpAuthMethod> authMethods) {
}
