import { config } from "dotenv";
import express from "express";
import { GatewayVersion } from "./globals.ts";
import { Auth } from "./apis/auth.ts";

config();
const PORT = process.env.PORT || 3000;

const app = express();

app.get("/gateway/version", async (_req, res) => {
     res.json({
          version: GatewayVersion,
          components: {
               auth: await Auth.Version()
          }
     });
});

app.listen(PORT, () => {
     console.log(`App listening on http://localhost:${PORT}`);
});

