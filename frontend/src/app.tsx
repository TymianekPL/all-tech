import { useEffect, useState } from "preact/hooks";
import "./app.css";
import { Api } from "./api/base";

export function App() {
     const [counter, setCounter] = useState<number>(0);
     useEffect(() => {
          Api.Get<{ counter: number }>("counter").then(({ counter }) => setCounter(counter));
     }, []);
     return <>
          <h1>Counter: {counter}</h1>
          <button onClick={() => Api.Get<{ counter: number }>("increment").then(({ counter }) => setCounter(counter))}>Increment</button>
     </>;
}
