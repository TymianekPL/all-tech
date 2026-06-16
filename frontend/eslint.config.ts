import js from "@eslint/js";
import globals from "globals";
import tseslint from "typescript-eslint";
import { defineConfig } from "eslint/config";

export default defineConfig([
     {
          files: ["**/*.{js,mjs,cjs,ts,mts,cts,jsx,tsx}"], plugins: { js }, extends: ["js/recommended"], languageOptions: { globals: globals.browser }, rules: {
               "indent": ["error", 5],
               "semi": ["error", "always"],
               "quotes": ["error", "double"]
          }
     },
     tseslint.configs.recommended
]);
