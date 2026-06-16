import { AuthRestAddress } from "../globals";

export const Auth = {
     async Get<T>(path: string) {
          const response = await fetch(`${AuthRestAddress}${path}`);
          const json = await response.json();
          if (!response.ok) throw Error(JSON.stringify(json));
          return json as T;
     },
     Version: async () => {
          const { Version } = await Auth.Get<{ Version: string; }>("/version");
          return Version;
     }
};