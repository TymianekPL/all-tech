export default function NotFound({ path }: { path: string }) {
     return <>
          <h1>Page not found</h1>
          <h2>Resource was not found: {path}</h2>
     </>;
}
