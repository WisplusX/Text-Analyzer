import { extendTheme } from "@chakra-ui/react";

const theme = extendTheme({
  fonts: {
    body: "Montserrat, sans-serif",
    heading: "Montserrat, sans-serif",
  },
  fontWeights: {
    normal: 400,
    medium: 600,
    bold: 700,
    black: 900,
  },
});

export default theme;
