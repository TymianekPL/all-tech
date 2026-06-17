import { ErrorBoundary, lazy, LocationProvider, Route, Router } from "preact-iso";
import "./app.css";

const HomePage = lazy(() => import("./pages/Home"));
const NotFoundPage = lazy(() => import("./pages/404"));

export function App() {
     return <LocationProvider>
          <ErrorBoundary>
               <Router>
                    <Route path="/" component={HomePage} />
                    <Route default component={NotFoundPage} />
               </Router>
          </ErrorBoundary>
     </LocationProvider>;
}
