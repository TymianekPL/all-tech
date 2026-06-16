import { config } from "dotenv";
import express from "express";
import { GatewayVersion } from "./globals.ts";

config();
const PORT = process.env.PORT || 3000;

const app = express();

app.get("/gateway/version", (_req, res) => {
     res.json({
          version: GatewayVersion,
          status: 200
     });
});

app.listen(PORT, () => {
     console.log(`App listening on http://localhost:${PORT}`);
});

