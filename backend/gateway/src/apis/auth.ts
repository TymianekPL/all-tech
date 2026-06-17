import { AuthRestAddress } from "../globals";

export type Auth = {
     VersionResponse: {
          Version: `${number}.${number}.${number}`;
     };
     AuthMethodId: "password" | "applicaion" | "sms" | "ssh";
     AuthMethod: {
          id: Auth["AuthMethodId"];
          detail: unknown;
     };
     BeginLoginRequest: {
          username: string;
          // TODO: device identity
     };
     BeginLoginResponse: {
          authMethods: Auth["AuthMethod"][];
     };
     ContinueLoginRequest: {
          method: Auth["AuthMethodId"];
          data: unknown;
     };
     ContinueLoginResponse: {
          state: "failure" | "more" | "success";
          data: Auth["AuthMethod"][] | string | null;
     };
};

export const Auth = {
     Routes: {
          version: "/version",
          beginLogin: "/begin-login",
          continueLogin: "/continue-login"
     },
     async Get<T>(path: string) {
          const response = await fetch(`${AuthRestAddress}${path}`);
          const json = await response.json();
          if (!response.ok) throw Error(JSON.stringify(json));
          return json as T;
     },
     async Post<TResponse, TRequest>(path: string, request: TRequest) {
          const response = await fetch(`${AuthRestAddress}${path}`, {
               method: "POST",
               body: JSON.stringify(request),
               headers: {
                    "Content-Type": "appalication/json"
               }
          });
          const json = await response.json();
          if (!response.ok) throw Error(JSON.stringify(json));
          return json as TResponse;
     },
     Version: async () => {
          const { Version } = await Auth.Get<Auth["VersionResponse"]>(Auth.Routes.version);
          return Version;
     },
     async GetLoginMethods(username: string) {
          return await Auth.Post<Auth["BeginLoginResponse"], Auth["BeginLoginRequest"]>(Auth.Routes.beginLogin, {
               username
          }).then(response => response.authMethods);
     }
};
