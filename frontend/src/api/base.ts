export const Api = {
     ApiBase: "/api/",

     async Get<T>(path: string): Promise<T> {
          const response = await fetch(`${this.ApiBase}${path}`);
          const json = await response.json();

          if (!response.ok)
               throw new Error(json);

          return json as T;
     },
};