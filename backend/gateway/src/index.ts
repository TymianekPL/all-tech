import { config } from "dotenv";
import express from "express";
import { GatewayVersion } from "./globals.ts";
import { Auth } from "./apis/auth.ts";
import AuthRoute from "./routes/auth.ts";
import { Logger } from "./utils/logger.ts";

config();
const PORT = process.env.PORT || 3000;

const app = express();

app.use(express.json());

app.get("/gateway/version", async (_req, res) => {
     res.json({
          version: GatewayVersion,
          components: {
               auth: await Auth.Version()
          }
     });
});
app.use(AuthRoute.path, AuthRoute.router);

app.use((req, res) => {
     res.status(404).json({
          message: "Not found",
          resource: req.url,
          method: req.method
     });
});

app.listen(PORT, () => {
     Logger.info("server", `App listening on http://localhost:${PORT}`);
});
