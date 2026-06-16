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

let counter = 0;
app.get("/counter", (_req, res) => {
     res.json({
          counter,
     });
});
app.get("/increment", (_req, res) => {
     res.json({
          counter: ++counter,
     });
});

app.listen(PORT, () => {
     console.log(`App listening on http://localhost:${PORT}`);
});

