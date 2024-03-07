import * as React from "react";
import { ChakraProvider, Box } from "@chakra-ui/react";
import HomePage from "./components/HomePage/HomePage";

import theme from "./theme";

function App() {
  return (
    <ChakraProvider theme={theme}>
      <Box bg="gray.100" minH="100vh">
        <HomePage></HomePage>
      </Box>
    </ChakraProvider>
  );
}

export default App;
