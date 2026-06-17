export const Logger = {
     info: (category: string, message: string) => {
          console.info(`\x1b[34m[Info ] [${category}]\x1b[0;96m ${message}\x1b[0m`);
     },
     warn: (category: string, message: string) => {
          console.warn(`\x1b[33m[Warn ] [${category}]\x1b[0;97m ${message}\x1b[0m`);
     },
     error: (category: string, message: string) => {
          console.error(`\x1b[31m[Error] [${category}]\x1b[0;95m ${message}\x1b[0m`);
     },
};