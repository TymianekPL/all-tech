import { Router } from "express";
import type { Route } from "./route";
import { Auth } from "../apis/auth";

const router = Router();

router.get("/version", async (_req, res) => {
     const version = await Auth.Version();
     res.json({
          version
     });
});

export default { router, path: "/auth" } satisfies Route;
