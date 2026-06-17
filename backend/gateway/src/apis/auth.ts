import { AuthRestAddress } from "../globals";
export type Auth = {
     VersionResponse: {
          Version: `${number}.${number}.${number}`;
     };
     BeginLoginResponse: {
          username: string;

     };
};

export const Auth = {
     Routes: {
          version: "/version",
          beginLogin: "/begin-login",
          signup: "/signup"
     },
     async Get<T>(path: string) {
          const response = await fetch(`${AuthRestAddress}${path}`);
          const json = await response.json();
          if (!response.ok) throw Error(JSON.stringify(json));
          return json as T;
     },
     Version: async () => {
          const { Version } = await Auth.Get<Auth["VersionResponse"]>(Auth.Routes.version);
          return Version;
     }
};
